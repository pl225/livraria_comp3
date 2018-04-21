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
	
	.campos-cliente, .dados-cheque {
		border-width: .2rem;
		border: solid #f7f7f9;
		padding-top: 8px;
		margin-left: 15px;
		margin-bottom: 5px;
	}
	
	#corpo:after {
		content: ' ';
    	display: block;
    	clear: both;
	}
	
</style>

<%@ include file="/WEB-INF/header.jsp" %>
<%@ page import="meu_pacote.Livro" %>

<div style="width:80%; margin: auto; min-height:100%; position:relative;" id="corpo">

	<div class="row col-md-12 col-sm-12" style="margin-left: .5px">
		<h3>Comprar o livro <%= ((Livro) request.getAttribute("livro")).getTitulo() %></h3>
	</div>
	
	<br/>
	
	<form action="comprar_livro" method="post" id="formCompraLivro">
	
		<div class="form-row col-md-12">
			<div class="form-group col-md-3">
				<label for="qtdExemplar">Quantidade de livros</label>
				<input type="number" name="qtdExemplar" min="1" value="1" required class="form-control">
				<%@ include file="/WEB-INF/erro_campo_numerico.jsp" %>
			</div>
			
			<div class="form-group col-md-3">
				<label for="totalPagar">Valor total a pagar (R$)</label>
				<input type="text" name="totalPagar" readonly value="<%= ((Livro) request.getAttribute("livro")).getExemplar().getPrecoUnitario() %>" class="form-control">
			</div>
			
		</div>
		

		<div class="row form-group col-md-12 col-sm-12">
		
			
			<label class="col-md-3" for="forma_pagamento" style="max-width: fit-content; padding-right: 4.666%">Forma de pagamento</label>
			
			<div class="form-check form-check-inline col-md-3 col-sm-12">
	  			<input type="radio" id="credito" name="forma_pagamento" required 
	  			class="form-check-input" value="0">
	  			<label class="form-check-label form-control" for="credito">Cart�o de cr�dito</label>
			</div>
	
			<div class="form-check form-check-inline col-md-3 col-sm-12">
	  			<input type="radio" id="cheque" name="forma_pagamento" required 
	  			class="form-check-input" value="1">
	  			<label class="form-check-label form-control" for="cheque">Cheque</label>
			</div>
			<div class="form-check form-check-inline col-md-3 col-sm-12">
	  			<input type="radio" id="dinheiro" name="forma_pagamento" required 
	  			class="form-check-input" value="2">
	  			<label class="form-check-label form-control" for="dinheiro">Dinheiro</label>
			</div>
			<div class="invalid-feedback" id="validar-forma-pagamento">
      			  Selecione uma das op��es.
      		</div>
		</div>
		
		<div class="campos-cd" hidden>
			<div class="form-row col-md-12">
				<div class="form-group col-md-6">
					<label for="bandeira">Bandeira</label>
					<select class="custom-select form-control" name="bandeira">
						<option value="" selected>(Selecione uma bandeira)</option>
					</select>
					<div class="invalid-feedback">
      			  		Selecione uma das op��es.
      				</div>
				</div>
			</div>
			
			<div class="form-row col-md-12">
				<div class="form-group col-md-3">
					<label for="numCartao" >N� cart�o</label>
					<input type="text" name="numCartao"  class="form-control">
					<%@ include file="/WEB-INF/erro_campo_numerico.jsp" %>
				</div>
				
				<div class="form-group col-md-3">
					<label for="digitoVerificador">D�gito Verificador</label>
					<input type="text" name="digitoVerificador"  class="form-control">
					<%@ include file="/WEB-INF/erro_campo_numerico.jsp" %>
				</div>
			</div>
			
			<div class="form-row col-md-12">
				<div class="form-group col-md-3">
					<label for="numParcelasCd">N� parcelas</label>
					<input type="number" name="numParcelasCd" min="1" max="1" value="1"  class="form-control">
					<%@ include file="/WEB-INF/erro_campo_numerico.jsp" %>
				</div>
				<div class="form-group col-md-3">
					<label for="codSeguranca">C�digo de Seguran�a</label>
					<input type="text" name="codSeguranca"  class="form-control">
					<%@ include file="/WEB-INF/erro_campo_numerico.jsp" %>
				</div>
			</div>
		</div>
				
		<div class="campos-dinheiro" hidden>
			<div class="form-row col-md-12">
				<div class="form-group col-md-3">
					<label for="quantiaPaga">Valor pago</label>
					<input type="text" name="quantiaPaga"  class="form-control">
					<%@ include file="/WEB-INF/erro_campo_numerico.jsp" %>
				</div>
				
				<div class="form-group col-md-3">
					<label for="troco">Troco</label>
					<input type="text" name="troco" readonly class="form-control">
				</div>
				
			</div>
		</div>
		
		<div class="campos-cheque" hidden>
		
			<div class="campos-cliente">
				<h5 class="col-md-12">Dados do cliente</h5>
				<div class="form-row col-md-12">
					<div class="form-group col-md-3">
						<label for="cpf">CPF do cliente</label>
						<input type="text" name="cpf" class="form-control">
						<%@ include file="/WEB-INF/erro_campo_numerico.jsp" %>
					</div>
					
					<div class="form-group col-md-6">
						<label for="nome">Nome</label>
						<input type="text" name="nome" readonly class="form-control">
					</div>
				</div>
				
				<div class="form-row col-md-12">
				</div>
				
				<div class="form-row col-md-12">
					<div class="form-group col-md-3">
						<label for="logradouro">Logradouro</label>
						<input type="text" name="logradouro" readonly class="form-control">
					</div>
					
					<div class="form-group col-md-1">
						<label for="numero">N�mero</label>
						<input type="text" name="numero" readonly class="form-control">
					</div>
					
					<div class="form-group col-md-2">
						<label for="cep">CEP</label>
						<input type="text" name="cep" readonly class="form-control">
					</div>
					
					<div class="form-group col-md-3">
						<label for="bairro">Bairro</label>
						<input type="text" name="bairro" readonly class="form-control">
					</div>
					
					<div class="form-group col-md-3">
						<label for="cidade">Cidade</label>
						<input type="text" name="cidade" readonly class="form-control">
					</div>
				</div>
			</div>
			
			<div class="dados-cheque">
				<h5 class="col-md-12">Dados do cheque</h5>
				<div class="form-row col-md-12">
					<div class="form-group col-md-3">
						<label for="codigoBanco">C�digo do banco</label>
						<input type="text" name="codigoBanco"  class="form-control">
						<%@ include file="/WEB-INF/erro_campo_numerico.jsp" %>
					</div>
					
					<div class="form-group col-md-3">
						<label for="numeroAgencia">N�mero da Ag�ncia</label>
						<input type="text" name="numeroAgencia"  class="form-control">
						<%@ include file="/WEB-INF/erro_campo_numerico.jsp" %>
					</div>
					
					<div class="form-group col-md-3">
						<label for="digitoAgencia">D�g. ver. Ag�ncia</label>
						<input type="text" name="digitoAgencia"  class="form-control">
						<%@ include file="/WEB-INF/erro_campo_numerico.jsp" %>
					</div>
				</div>
				
				<div class="form-row col-md-12">
					<div class="form-group col-md-3">
						<label for="numConta">N�mero da conta</label>
						<input type="text" name="numConta"  class="form-control">
						<%@ include file="/WEB-INF/erro_campo_numerico.jsp" %>
					</div>
					
					<div class="form-group col-md-3">
						<label for="numeroCheque">N�mero do cheque</label>
						<input type="text" name="numeroCheque"  class="form-control">
						<%@ include file="/WEB-INF/erro_campo_numerico.jsp" %>
					</div>
										
					<div class="form-group col-md-3 predatado" hidden>
						<label for="numParcelasCheque">N� parcelas</label>
						<input type="number" name="numParcelasCheque"  min="1" value="1" max="1" class="form-control">
						<div class="invalid-feedback">
							Este campo � num�rico.
						</div>
					</div>
					
					<div class="form-group col-md-3 predatado" hidden>
						<label for="dataDebito">Data debt.</label>
						<input type="date" name="dataDebito"  class="form-control">
						<div class="invalid-feedback">
							Este campo � obrigat�rio se o n� de parcelas � maior que 1.
						</div>
					</div>
					
				</div>
			</div>
		</div>
	
		<div class="row form-group col-md-12">		
            <button class="btn btn-success col-md-2" type="submit" style="margin-left: 15px">Comprar</button>
		</div>
	
	</form>

</div>

<script type="text/javascript" src="scripts/toogle_forma_pg.js" ></script>
<%@ include file="/WEB-INF/footer.jsp" %>