package com.freedom.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.freedom.model.FormaPagamento;
import com.freedom.model.ItemPedido;
import com.freedom.model.Molhos;
import com.freedom.model.Pedido;
import com.freedom.model.SimNao;
import com.freedom.model.Saladas;
import com.freedom.model.Temperos;
import com.freedom.model.TipoAdicional;
import com.freedom.repository.Adicionais;
import com.freedom.repository.Lanches;
import com.freedom.service.PedidoService;
import com.freedom.session.LanchoneteSession;

@Controller
@RequestMapping("/")
public class LanchoneteController {
	
	@Autowired
	private Adicionais tiposAdicionais;

	@Autowired
    private Lanches tiposLanches;

	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private LanchoneteSession session;

	@GetMapping({"/novo", "/"})
	public ModelAndView novo(ItemPedido itemPedido){
		ModelAndView mv = new ModelAndView("lanchonete/CadastroPedido");
		mv.addObject("tipoSalada", Saladas.values());
		mv.addObject("tipoMolho", Molhos.values());
		mv.addObject("tipoTempero", Temperos.values());
		mv.addObject("queijos", tiposAdicionais.findByTipo(TipoAdicional.TIPO_QUEIJO));
		mv.addObject("recheios", tiposAdicionais.findByTipo(TipoAdicional.TIPO_RECHEIO));
		mv.addObject("tiposPaes", tiposAdicionais.findByTipo(TipoAdicional.TIPO_PAO));
        mv.addObject("lanches", tiposLanches.findAll());
        mv.addObject("lanchesPedido", session.getItensPedidos());
		return mv;
	}

	@PostMapping(value = { "/novo", "{\\d+}" }, params = "salvar")
	public ModelAndView salvar(@Valid ItemPedido itemPedido, BindingResult result, Model model, RedirectAttributes attributes) {
		ModelAndView mv = novo(itemPedido);
		if (result.hasErrors())
			return mv;
		session.addItem(itemPedido);
		
		mv.addObject("itemPedido", new ItemPedido());
		attributes.addFlashAttribute("mensagem", "Lanche salvo e adicionado com sucesso!");
		return mv;
	}
	
	@PostMapping(value = { "/novo", "{\\d+}" }, params = "finalizar")
	public ModelAndView finalizar(@Valid ItemPedido itemPedido, BindingResult result, Model model, RedirectAttributes attributes) {
		Pedido pedido = pedidoService.salvar(session.getPedido());
		attributes.addFlashAttribute("mensagem", "Pedido salvo com sucesso!");
		return new ModelAndView("redirect:/resumo/" + pedido.getCodigo());
	}
	
	@GetMapping("/resumo/{pedido}")
	public ModelAndView resumo(@PathVariable("pedido") Pedido pedido){
		ModelAndView mv = new ModelAndView("lanchonete/ResumoPedido");
		mv.addObject("formaPagamento", FormaPagamento.values());
		mv.addObject("simNao", SimNao.values());
		return mv;
	}
	
	@PostMapping(value = "/pagamento")
	public ModelAndView pagamento(Pedido pedido, BindingResult result, Model model, RedirectAttributes attributes) {
		pedido = pedidoService.salvar(pedido);
		session.clear();
		attributes.addFlashAttribute("mensagem", "Pedido finalizado com sucesso!");
		return new ModelAndView("redirect:/novo");
	}
	
}
