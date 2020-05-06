var Utils = Utils || {};

Utils.BotaoSubmitAluno = (function() {

    function BotaoSubmitAluno() {
        this.submitBtn = $('.js-submit-btn');
        this.formulario = $('.js-formulario-principal');
    }

    BotaoSubmitAluno.prototype.iniciar = function() {
       this.submitBtn.on('click', onSubmit.bind(this));
    }

    function onSubmit(evento) {
        evento.preventDefault();

        var botaoClicado = $(evento.target);
        var acao = botaoClicado.data('acao');

        var acaoInput = $('<input>');
        acaoInput.attr('type', 'hidden');
        acaoInput.attr('name', acao);

        this.formulario.append(acaoInput);
        this.formulario.submit();
    }

    return BotaoSubmitAluno;

}());

$(function() {

    var botoes = new Utils.BotaoSubmitAluno();
    botoes.iniciar();

});