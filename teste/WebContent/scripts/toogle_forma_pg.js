document.getElementById("credito").addEventListener("click", function () {
	document.getElementsByClassName("campos-cd")[0].removeAttribute("hidden");
	document.getElementsByClassName("campos-cheque")[0].setAttribute("hidden", true);
	document.getElementsByClassName("campos-dinheiro")[0].setAttribute("hidden", true);
});

document.getElementById("cheque").addEventListener("click", function () {
	document.getElementsByClassName("campos-cheque")[0].removeAttribute("hidden");
	document.getElementsByClassName("campos-cd")[0].setAttribute("hidden", true);
	document.getElementsByClassName("campos-dinheiro")[0].setAttribute("hidden", true);
});

document.getElementById("dinheiro").addEventListener("click", function () {
	document.getElementsByClassName("campos-dinheiro")[0].removeAttribute("hidden");
	document.getElementsByClassName("campos-cheque")[0].setAttribute("hidden", true);
	document.getElementsByClassName("campos-cd")[0].setAttribute("hidden", true);
});

['input', 'change'].forEach(function (e) {
	var precoUnitario = document.getElementsByName("totalPagar")[0].value;
	document.getElementsByName("qtdExemplar")[0].addEventListener(e, function () {
		document.getElementsByName("totalPagar")[0].value = parseFloat(this.value * precoUnitario).toFixed(2);
	});
});

function invalidNumber (number) {
	return number === '' || isNaN(number);
}

function removeInvalidElements() {
	var inputs = document.getElementById("formCompraLivro").getElementsByTagName('input');
	for (var i = 0; i < inputs.length; i++) {
		inputs[i].classList.remove("is-invalid");
	}
	document.getElementById("validar-forma-pagamento").style.display = 'none';
}

function checkFormValid () {
	if (document.getElementById("validar-forma-pagamento").style.display == 'block') return false;
	var inputs = document.getElementById("formCompraLivro").getElementsByTagName('input');
	for (var i = 0; i < inputs.length; i++) {
		if (inputs[i].classList.contains("is-invalid")) return false;
	}
	return true;
}

document.getElementById("formCompraLivro").addEventListener('submit', function (e) {
	e.preventDefault();
	
	removeInvalidElements();
	
	var qtdExemplar = document.getElementsByName("qtdExemplar")[0];
	var validarFormaPagamento = document.getElementById("validar-forma-pagamento");
	var cheque = document.getElementById("cheque");
	var credito = document.getElementById("credito");
	var dinheiro = document.getElementById("dinheiro");
	var invalido = "is-invalid";
	
	if (invalidNumber(qtdExemplar.value))	qtdExemplar.classList.add(invalido);
	if (!(cheque.checked || dinheiro.checked || credito.checked))  validarFormaPagamento.style.display = 'block';
	
	if (dinheiro.checked) {
		var quantiaPaga = document.getElementsByName("quantiaPaga")[0];
		if (invalidNumber(quantiaPaga.value)) quantiaPaga.classList.add(invalido);
	}
	
	if (checkFormValid()) this.submit();
	
});