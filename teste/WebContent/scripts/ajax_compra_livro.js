function atualizarInfoCliente (nome, logradouro, numero, cep, bairro, cidade, telefone) {
	document.getElementsByName("nome")[0].value = nome;
	document.getElementsByName("logradouro")[0].value = logradouro;
	document.getElementsByName("numero")[0].value = numero;
	document.getElementsByName("cep")[0].value = cep;
	document.getElementsByName("cidade")[0].value = cidade;
	document.getElementsByName("bairro")[0].value = bairro;
	document.getElementsByName("telefone")[0].value = telefone;
}

document.getElementsByName("cpf")[0].addEventListener('focusout', function (e) {
	
	var xmlhttp = new XMLHttpRequest();
	var url = "consultar_cliente?cpf=" + this.value;
	var progressBar = document.getElementById("progress-cpf");
	var invalido = "is-invalid";
	var inputCpf = this;
	
	xmlhttp.onreadystatechange = function() {
	    if (this.readyState == 4) {
	    	progressBar.setAttribute("hidden", true);
	    	if (this.status == 200) {
	    		var json = JSON.parse(this.responseText);
	    		atualizarInfoCliente(json.nome, json.logradouro, json.numero, json.cep, 
	    				json.bairro, json.cidade, json.telefone);
	    	} else if (this.readyState == 4 && this.status == 404) {
	    		inputCpf.classList.add(invalido);
	    		inputCpf.value = "";
	    		document.getElementById("invalid-cpf").innerHTML = "Cliente não encontrado.";
	    		atualizarInfoCliente("", "", "", "", "", "", "");
	    	}
	    }
	};
	
	progressBar.removeAttribute("hidden");
	xmlhttp.open("GET", url, true);
	xmlhttp.send();
});