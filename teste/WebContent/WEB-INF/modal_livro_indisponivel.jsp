<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal fade" id="livroIndisponivel" tabindex="-1" role="dialog" aria-labelledby="titulo" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="titulo">Livro indisponível</h5>
      </div>
      <div class="modal-body">
        <p>Infelizmente, não há exemplares suficientes deste livro para que a compra seja realizada.
        <p>Você pode iniciar uma reserva ou tentar novamente com uma quantidade menor de exemplares.
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal" 
        onclick="document.getElementsByName('qtdExemplar')[0].value = 1">Tentar novamente</button>
        <button type="button" class="btn btn-primary">Reservar livro</button>
      </div>
    </div>
  </div>
</div>