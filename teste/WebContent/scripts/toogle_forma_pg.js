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