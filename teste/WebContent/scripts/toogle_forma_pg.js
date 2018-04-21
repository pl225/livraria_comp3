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
		var totalPagar = document.getElementsByName("totalPagar")[0];
		var numParcelasCd = document.getElementsByName("numParcelasCd")[0];
		var numParcelasCheque = document.getElementsByName("numParcelasCheque")[0];
		totalPagar.value = parseFloat(this.value * precoUnitario).toFixed(2);
		
		if (totalPagar.value > 200.00) { // RN1
			numParcelasCd.max = '';
			numParcelasCheque.max = '';
		} else {
			numParcelasCd.max = 1;
			numParcelasCd.value = 1;
			numParcelasCheque.max = 1;
			numParcelasCheque.value = 1;
		}
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
	document.getElementsByName("bandeira")[0].classList.remove("is-invalid");
}

function checkFormValid () {
	if (document.getElementById("validar-forma-pagamento").style.display == 'block') return false;
	if (document.getElementsByName("bandeira")[0].constains("is-invalid")) return false;
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
	} else if (credito.checked) {
		var bandeira = document.getElementsByName("bandeira")[0];
		var numCartao = document.getElementsByName("numCartao")[0];
		var digitoVerificador = document.getElementsByName("digitoVerificador")[0];
		var numParcelasCd = document.getElementsByName("numParcelasCd")[0];
		var codSeguranca = document.getElementsByName("codSeguranca")[0];
		
		if (invalidNumber(numCartao.value))	numCartao.classList.add(invalido);
		if (invalidNumber(digitoVerificador.value))	digitoVerificador.classList.add(invalido);
		if (invalidNumber(numParcelasCd.value))	numParcelasCd.classList.add(invalido);
		if (invalidNumber(codSeguranca.value))	codSeguranca.classList.add(invalido);
		if (bandeira.options[bandeira.selectedIndex].value == '') bandeira.classList.add(invalido);
	} else if (cheque.checked) {
		var cpf = document.getElementsByName("cpf")[0];
		var codigoBanco = document.getElementsByName("codigoBanco")[0];
		var numeroAgencia = document.getElementsByName("numeroAgencia")[0];
		var digitoAgencia = document.getElementsByName("digitoAgencia")[0];
		var numConta = document.getElementsByName("numConta")[0];
		var numeroCheque = document.getElementsByName("numeroCheque")[0];
		
		if (invalidNumber(cpf.value))	cpf.classList.add(invalido);
		if (invalidNumber(codigoBanco.value))	codigoBanco.classList.add(invalido);
		if (invalidNumber(numeroAgencia.value))	numeroAgencia.classList.add(invalido);
		if (invalidNumber(digitoAgencia.value))	digitoAgencia.classList.add(invalido);
		if (invalidNumber(numConta.value))	numConta.classList.add(invalido);
		if (invalidNumber(numeroCheque.value))	numeroCheque.classList.add(invalido);
	}
	
	if (checkFormValid()) this.submit();
	
});