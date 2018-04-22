<%@ include file="/WEB-INF/header.jsp" %>

<div style="width:80%; margin: auto;">

	<div class="row col-md-12 col-sm-12" style="margin-left: .5px">
		<h3>Atualizar dados pessoais</h3>
	</div>
	
	<br/>
	
	<form action="atualizar_dados_cliente" method="post">
	
	
		<div class="row form-group col-md-12">
			<label for="cpf" class="col-md-1">CPF</label>
			<input type="text" name="cpf" required class="form-control col-md-3">
		</div>
		
		<div class="row form-group col-md-12">
			<label for="cpf" class="col-md-1">Nome</label>
			<input type="text" name="nome" required class="form-control col-md-3">
		</div>
		
		<div class="row form-group col-md-12">
			
			<label for="logradouro" class="col-md-1">Logradouro</label>
			<input type="text" name="logradouro" required class="form-control col-md-5">
			
			<label for="bairro" class="col-md-1" style="max-width: 4.333%">Nº</label>
			<input type="text" name="numero" style="margin-left: 4%" class="form-control col-md-2">
		</div>
		
		<div class="row form-group col-md-12">
			
			<label for="logradouro" class="col-md-1">Bairro</label>
			<input type="text" name="bairro" required class="form-control col-md-5">
			
			<label for="bairro" class="col-md-1">Cidade</label>
			<input type="text" required name="cidade" class="form-control col-md-5">
		</div>
		
		<div class="row form-group col-md-12">
			
			<label for="celular" class="col-md-1">Celular</label>
			<input type="text" name="celular" required class="form-control col-md-5">
			
			<label for="tel_fixo" class="col-md-1">Tel. Fixo</label>
			<input type="text" name="tel_fixo" class="form-control col-md-5">
		</div>
		
		<div class="row form-group" style="padding-left: 15px">
			<div class="col-md-12">
				<button type="submit" class="btn btn-primary">Enviar</button>
				<button type="button" class="btn btn-default">Cancelar</button>
			</div>
		</div>
	
	</form>

</div>

<%@ include file="/WEB-INF/footer.jsp" %>