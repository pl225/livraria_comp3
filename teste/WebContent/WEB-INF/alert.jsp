<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	if (request.getAttribute("sucesso") != null) {
%>

	<div class="alert alert-success alert-dismissible fade show" role="alert">
  		<%= request.getAttribute("sucesso") %>
  		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
    		<span aria-hidden="true">&times;</span>
  		</button>
	</div>
<% 
	} else if (request.getAttribute("erro") != null) {
%>

	<div class="alert alert-danger alert-dismissible fade show" role="alert">
  		<%= request.getAttribute("erro") %>
  		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
    		<span aria-hidden="true">&times;</span>
  		</button>
	</div>
	
<%
	}
%>