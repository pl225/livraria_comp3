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
<%@ page import="java.util.ArrayList" %>

<div style="width:80%; margin: auto; min-height:100%; position:relative;" id="corpo">

	<div class="row col-md-12 col-sm-12" style="margin-left: .5px">
		<h3>Comprar o livro <%= ((Livro) request.getAttribute("livro")).getTitulo() %></h3>
	</div>
	
	<br/>
	
	<form action="comprar_livro?isbn=<%= ((Livro) request.getAttribute("livro")).getISBN() %>" 
	method="post" id="formCompraLivro">
	
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
	  			<label class="form-check-label form-control" for="credito">Cartão de crédito</label>
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
      			  Selecione uma das opções.
      		</div>
		</div>
		
		<div class="campos-cd" hidden>
			<div class="form-row col-md-12">
				<div class="form-group col-md-6">
					<label for="bandeira">Bandeira</label>
					<select class="custom-select form-control" name="bandeira">
						<option value="" selected>(Selecione uma bandeira)</option>
						
						<%
							if (request.getAttribute("bandeiras") != null) {
								ArrayList<String> bandeiras = (ArrayList<String>) request.getAttribute("bandeiras");
								for (String s: bandeiras) {
						%>
						
						<option value="<%= s %>"><%= s %></option>
						<%
								}
							}
						%>
					</select>
					<div class="invalid-feedback">
      			  		Selecione uma das opções.
      				</div>
				</div>
			</div>
			
			<div class="form-row col-md-12">
				<div class="form-group col-md-3">
					<label for="numCartao" >Nº cartão</label>
					<input type="text" name="numCartao"  class="form-control">
					<%@ include file="/WEB-INF/erro_campo_numerico.jsp" %>
				</div>
			</div>
			
			<div class="form-row col-md-12">
				<div class="form-group col-md-3">
					<label for="numParcelasCd">Nº parcelas</label>
					<input type="number" name="numParcelasCd" min="1" max="1" value="1"  class="form-control">
					<%@ include file="/WEB-INF/erro_campo_numerico.jsp" %>
				</div>
				<div class="form-group col-md-3">
					<label for="codSeguranca">Código de Segurança</label>
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
						<div class="invalid-feedback" id="invalid-cpf">
							Este campo é obrigatório.
						</div>
						<div class="progress" hidden="true" id="progress-cpf">
  							<div class="progress-bar progress-bar-striped progress-bar-animated" 
  							role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%; margin-top: 2%">
  						</div>
					</div>
					</div>
					
					<div class="form-group col-md-6">
						<label for="nome">Nome</label>
						<input type="text" name="nome" readonly class="form-control">
					</div>
					<div class="form-group col-md-3">
						<label for="nome">Telefone</label>
						<input type="text" name="telefone" readonly class="form-control">
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
						<label for="numero">Número</label>
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
						<label for="codigoBanco">Código do banco</label>
						<input type="text" name="codigoBanco"  class="form-control">
						<%@ include file="/WEB-INF/erro_campo_numerico.jsp" %>
					</div>
					
					<div class="form-group col-md-3">
						<label for="numeroAgencia">Número da Agência</label>
						<input type="text" name="numeroAgencia"  class="form-control">
						<%@ include file="/WEB-INF/erro_campo_numerico.jsp" %>
					</div>
					
					<div class="form-group col-md-3">
						<label for="digitoAgencia">Díg. ver. Agência</label>
						<input type="text" name="digitoAgencia"  class="form-control">
						<%@ include file="/WEB-INF/erro_campo_numerico.jsp" %>
					</div>
				</div>
				
				<div class="form-row col-md-12">
					<div class="form-group col-md-3">
						<label for="numConta">Número da conta</label>
						<input type="text" name="numConta"  class="form-control">
						<%@ include file="/WEB-INF/erro_campo_numerico.jsp" %>
					</div>
					
					<div class="form-group col-md-3">
						<label for="numeroCheque">Número do cheque</label>
						<input type="text" name="numeroCheque"  class="form-control">
						<%@ include file="/WEB-INF/erro_campo_numerico.jsp" %>
					</div>
										
					<div class="form-group col-md-3 predatado" hidden>
						<label for="numParcelasCheque">Nº parcelas</label>
						<input type="number" name="numParcelasCheque"  min="1" value="1" max="1" class="form-control">
						<div class="invalid-feedback">
							Este campo é numérico.
						</div>
					</div>
					
					<div class="form-group col-md-3 predatado" hidden>
						<label for="dataDebito">Data debt.</label>
						<input type="date" name="dataDebito"  class="form-control">
						<div class="invalid-feedback">
							Este campo é obrigatório se o nº de parcelas é maior que 1.
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
<script type="text/javascript" src="scripts/ajax_compra_livro.js" ></script>
<%@ include file="/WEB-INF/footer.jsp" %>