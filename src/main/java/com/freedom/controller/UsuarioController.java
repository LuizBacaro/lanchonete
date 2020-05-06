package com.freedom.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.freedom.model.Usuario;
import com.freedom.repository.Grupos;
import com.freedom.repository.Usuarios;
import com.freedom.service.StatusUsuario;
import com.freedom.service.UsuarioService;
import com.freedom.service.exception.SenhaObrigatoriaUsuarioException;
import com.freedom.service.exception.UsuarioCadastradoException;


@RequestMapping("/usuario")
@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private Grupos grupos;

	@Autowired
	private Usuarios usuarios;

	@RequestMapping("/novo")
	public ModelAndView novo(Usuario usuario) {

		ModelAndView mv = new ModelAndView("usuario/CadastroUsuario");
		mv.addObject("grupos", grupos.findAll());

		return mv;
	}

	@PostMapping({ "/novo", "{\\+d}" })
	public ModelAndView cadastrar(@Valid Usuario usuario, BindingResult result, Model model, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			return novo(usuario);
		}

		try {
			usuarioService.cadastro(usuario);
		} catch (UsuarioCadastradoException e) {
			result.rejectValue("nome", e.getMessage(), e.getMessage());
			return novo(usuario);
		}catch (SenhaObrigatoriaUsuarioException e) {
			result.rejectValue("senha", e.getMessage(), e.getMessage());
			return novo(usuario);
		}

		attributes.addFlashAttribute("mensagem", "Usuario cadastrado com sucesso!.");

		return new ModelAndView("redirect:/usuario/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar() {
		ModelAndView mv = new ModelAndView("/usuario/PesquisaUsuarios");
		mv.addObject("usuarios", usuarios.findAll());
		return mv;
	}
	
	@PutMapping("/status")
	@ResponseStatus(HttpStatus.OK)
	public void atualizarStatus(@RequestParam("codigos[]") Long[] codigos, @RequestParam("status") StatusUsuario statusUsuario) {
		usuarioService.alterarStatus(codigos, statusUsuario);
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable Long codigo) {
		Usuario usuario = usuarios.buscarComGrupos(codigo);
		ModelAndView mv = novo(usuario);
		mv.addObject(usuario);
		return mv;
	}

}
