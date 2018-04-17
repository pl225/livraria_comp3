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

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">

<%@ include file="/WEB-INF/header.jsp" %>

<div style="width:80%; margin: auto;">

	<div class="row col-md-12 col-sm-12" style="margin-left: .5px">
		<h3>Consulta de livros</h3>
	</div>
	
	<br/>
	
	<form action="consultar_livros" method="get" id="formConsulta">

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
	  			<label class="form-check-label form-control" for="titulo">T�tulo</label>
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
	
	<table class="table" id="resultados">
		<thead>
			<tr>
				<th>ISBN</th>
				<th>T�tulo</th>
				<th>Autor</th>
				<th>Editora</th>
				<th>Estilo</th>
				<th>Pre�o (R$)</th>
				<th>A��es</th>
			</tr>
		</thead>
	
		<%@ page import="java.util.ArrayList" %>
		<%@ page import="meu_pacote.Livro" %>
		<%@ page import="java.util.Iterator" %>
		<tbody>
		<%
			if (request.getAttribute("results") != null) {
				ArrayList<?> lista = (ArrayList<?>) request.getAttribute("results");
				Iterator <?> lista_iterada = lista.listIterator();
				
				while (lista_iterada.hasNext()) {
					Object o = lista_iterada.next();
					if (o instanceof meu_pacote.Livro) {
						Livro l = (Livro) o;
						
		%>
		<tr>
			<td><%= l.getISBN() %></td>
			<td><%= l.getTitulo() %></td>
			<td><%= l.getAutor().getNome() %></td>
			<td><%= l.getEditora().getNome() %></td>
			<td><%= l.getEstilo().getNome() %></td>
			<td><%= l.getExemplar().getPrecoUnitario() %></td>
			<td>
				<a href="<%= "comprar_livro?isbn=" + l.getISBN() %>" style="color: inherit;">
					<i class="material-icons" title="Comprar">&#xE8CC;</i>
				</a>
			</td>
		</tr>
		<%
					}
				}
			}
		%>
		</tbody>
	</table>

</div>

<%@ include file="/WEB-INF/footer.jsp" %>
