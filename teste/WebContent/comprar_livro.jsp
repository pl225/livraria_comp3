<style type="text/css">
	
	label.form-control {
		border: none;
		padding: 0px;
	}

	.form-check-inline {
   		display: inline-block;
   	 	margin-right: .0rem;
   	 	max-width: fit-content !important;
    	margin-right: 1% !important;
	}
</style>

<%@ include file="/WEB-INF/header.jsp" %>
<%@ page import="meu_pacote.Livro" %>

<div style="width:80%; margin: auto;">

	<div class="row col-md-12 col-sm-12" style="margin-left: .5px">
		<h3>Comprar o livro <%-- <%= ((Livro) request.getAttribute("livro")).getTitulo() %> --%></h3>
	</div>
	
	<br/>
	
	<form action="comprar_livro" method="post" id="formCompraLivro">
	
		<div class="row form-group col-md-12">
			<label for="qtdExemplar" class="col-md-2">Quantidade de livros</label>
			<input type="number" name="qtdExemplar" min="1" required class="form-control col-md-2">
		</div>
		
		<div class="row form-group col-md-12">
			<label for="totalPagar" class="col-md-2">Valor total a pagar</label>
			<input type="text" name="totalPagar" readonly class="form-control col-md-2">
		</div>

		<div class="row form-group col-md-12 col-sm-12">
		
			
			<label class="col-md-3" for="forma_pagamento" style="max-width: fit-content; padding-right: 4.666%">Forma de pagamento</label>
			
			<div class="form-check form-check-inline col-md-3 col-sm-12">
	  			<input type="radio" id="credito" name="forma_pagamento" required="true" class="form-check-input" value="0">
	  			<label class="form-check-label form-control" for="credito">Cartão de crédito</label>
			</div>
	
			<div class="form-check form-check-inline col-md-3 col-sm-12">
	  			<input type="radio" id="cheque" name="forma_pagamento" required="true" class="form-check-input" value="1">
	  			<label class="form-check-label form-control" for="cheque">Cheque</label>
			</div>
			<div class="form-check form-check-inline col-md-3 col-sm-12">
	  			<input type="radio" id="dinheiro" name="forma_pagamento" required="true" class="form-check-input" value="2">
	  			<label class="form-check-label form-control" for="dinheiro">Dinheiro</label>
			</div>
		</div>
	
	
		<div class="row form-group col-md-12">		
            <button class="btn btn-success col-md-2" type="submit" style="margin-left: 15px">Comprar</button>
		</div>
	
	</form>

</div>


<%@ include file="/WEB-INF/footer.jsp" %>