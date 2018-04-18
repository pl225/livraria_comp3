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

document.getElementById("formCompraLivro").addEventListener('submit', function (e) {
	e.preventDefault();
	
	var qtdExemplar = document.getElementsByName("qtdExemplar")[0];
	var formaPagamento = document.getElementsByName("forma_pagamento");
	var invalido = "is-invalid";
	
	if (qtdExemplar.value === '') {
		qtdExemplar.classList.add(invalido);
		//return;
	}
});