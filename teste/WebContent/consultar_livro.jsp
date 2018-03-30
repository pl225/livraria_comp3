<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<style type="text/css">
	
	label.form-control {
		border: none;
		padding: 0px;
	}

	.form-check-inline {
   		display: inline-block;
   	 	margin-right: .0rem;
	}
</style>

<tags:master>

	<div class="row col-md-12 col-sm-12" style="margin-left: .5px">
		<h3>Consulta de livros</h3>
	</div>
	
	<br/>
	
	<form action="consultar_livro" method="get">

		<div class="row form-group col-md-12 col-sm-12">
		
			<div class="col-md-2 col-sm-3">
				<label class="form-control" for="tipo_busca">Buscar por:</label>
			</div>
			
			<div class="form-check form-check-inline col-md-2 col-sm-3">
	  			<input type="radio" id="isbn" name="tipo_busca" required="true" class="form-check-input" value="1">
	  			<label class="form-check-label form-control" for="isbn">ISBN</label>
			</div>
			
			<div class="form-check form-check-inline col-md-2 col-sm-3">
	  			<input type="radio" id="autor" name="tipo_busca" required="true" class="form-check-input" value="2">
	  			<label class="form-check-label form-control" for="autor">Autor</label>
			</div>
	
			<div class="form-check form-check-inline col-md-2 col-sm-3">
	  			<input type="radio" id="editora" name="tipo_busca" required="true" class="form-check-input" value="3">
	  			<label class="form-check-label form-control" for="editora">Editora</label>
			</div>
			<div class="form-check form-check-inline col-md-2 col-sm-3">
	  			<input type="radio" id="titulo" name="tipo_busca" required="true" class="form-check-input" value="4">
	  			<label class="form-check-label form-control" for="titulo">Título</label>
			</div>
		</div>
	
	
		<div class="row form-group col-md-12">
			<div class="col-md-2">
				<label class="form-control">Palavra-chave</label>
			</div>
	
			<div class="input-group mb-2 col-md-4">
		  		<input type="text" class="form-control" required="true" name="pesquisa">
		  			
	  			<span class="input-group-btn">
                       <button class="btn btn-default" type="submit">
                           <i class="fa fa-search"></i>
                       </button>
                </span>
		  			
	   		</div>
		</div>
	
	</form>

</tags:master>
