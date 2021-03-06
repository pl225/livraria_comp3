<%@ tag language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Livraria Faen</title>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	
	<style type="text/css">
		
		.header-right {
			float: right;
		}
		
		.header {
			padding: 15px 10px;
			background-color: #f1f1f1;
		}
		
		.header a {
			padding: 10px;
		}
		
		a.logo {
			font-size: 18px;
			color: black;
		}
		
		a.active {
			background-color: dodgerblue;
			color: white;
		}
		
		.footer {
		    position: fixed;
		    left: 0;
		    bottom: 0;
		    width: 100%;
		    background-color: #f1f1f1;
		    color: black;
		    text-align: right;
		}
		
 		p.p-footer {
			font-size: 18px;
			margin-top: 15px;
			margin-right: 20px;
		} 
			
	</style>
	
</head>

<body>

	<div class="header">
	  <a href="#default" class="logo">Livraria Faen</a>
	  <div class="header-right">
    	<a href="#">Sobre</a>
	  </div>
	</div>
	
	<br/>
	
	<div style="width:80%; margin: auto;">

		<jsp:doBody/>
		
	</div>
	
	<div class="footer">
		<p class="p-footer">Livraria Faen - 2018 - Computação III</p>		
	</div>

</body>

</html>
