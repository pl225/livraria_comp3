package validation;

import java.util.Map;

import efetuar_venda.FormaPagamento;

public class ValidarCompraLivros extends Validador {

	@Override
	public void make(Map<String, String[]> parametros) {
		
		if (!Validador.isNumeroPreenchido(parametros.get("qtdExemplar")[0]))
			this.erros.add("qtdExemplar");
		
		if (Validador.isEmpty(parametros.get("forma_pagamento")[0])) {
			this.erros.add("forma_pagamento");
		} else {
			int formaPagamento = Integer.parseInt(parametros.get("forma_pagamento")[0]);
			
			if (formaPagamento == FormaPagamento.ModoPagamento.DINHEIRO.ordinal()) {
				if (!Validador.isNumeroPreenchido(parametros.get("quantiaPaga")[0])) {
					this.erros.add("quantiaPaga");
				} else {
					double pago = Double.parseDouble(parametros.get("quantiaPaga")[0]);
					if (Validador.isNaN(parametros.get("totalPagar")[0])) {
						this.erros.add("totalPagar");
					} else if (pago < Double.parseDouble(parametros.get("totalPagar")[0])) {
						this.erros.add("totalPagar");
					}
				}
			}
		}
	}

}