package validation;

import java.util.Map;

import efetuar_venda.FormaPagamento;

public class ValidarCompraLivros extends Validador {

	@Override
	public void make(Map<String, String[]> parametros) {
		
		if (!Validador.isNumeroPreenchido(parametros.get("qtdExemplar")[0]))
			this.erros.add("qtdExemplar");
		
		double totalPagar = 0;
		if (!Validador.isNumeroPreenchido(parametros.get("totalPagar")[0]))
			this.erros.add("totalPagar");
		else
			totalPagar = Double.parseDouble(parametros.get("totalPagar")[0]);
			
		
		if (Validador.isEmpty(parametros.get("forma_pagamento")[0])) {
			this.erros.add("forma_pagamento");
		} else {
			int formaPagamento = Integer.parseInt(parametros.get("forma_pagamento")[0]);
			
			if (formaPagamento == FormaPagamento.ModoPagamento.DINHEIRO.ordinal()) {
				if (!Validador.isNumeroPreenchido(parametros.get("quantiaPaga")[0])) {
					this.erros.add("quantiaPaga");
				} else {
					double pago = Double.parseDouble(parametros.get("quantiaPaga")[0]);
					if (pago < totalPagar) {
						this.erros.add("quantiaPaga");
					}
				}
			} else if (formaPagamento == FormaPagamento.ModoPagamento.CREDITO.ordinal()) {
				if (Validador.isEmpty(parametros.get("bandeira")[0]))
					this.erros.add("bandeira");
				if (!Validador.isNumeroPreenchido(parametros.get("numCartao")[0]))
					this.erros.add("numCartao");
				if (!Validador.isNumeroPreenchido(parametros.get("numParcelasCd")[0]))
					this.erros.add("numParcelasCd");
				if (!Validador.isNumeroPreenchido(parametros.get("codSeguranca")[0]))
					this.erros.add("codSeguranca");
				
				if (!this.erros.contains("numParcelasCd") && totalPagar <= 200) {
					if (Integer.parseInt(parametros.get("numParcelasCd")[0]) > 1)
						this.erros.add("numParcelasCd");
				}
			} else {
				if (Validador.isEmpty(parametros.get("cpf")[0]))
					this.erros.add("cpf");
				if (!Validador.isNumeroPreenchido(parametros.get("codigoBanco")[0]))
					this.erros.add("codigoBanco");
				if (!Validador.isNumeroPreenchido(parametros.get("numeroAgencia")[0]))
					this.erros.add("numeroAgencia");
				if (!Validador.isNumeroPreenchido("digitoAgencia"))
					this.erros.add("digitoAgencia");
				if (!Validador.isNumeroPreenchido(parametros.get("numConta")[0]))
					this.erros.add("numConta");
				if (!Validador.isNumeroPreenchido(parametros.get("numeroCheque")[0]))
					this.erros.add("numeroCheque");
				if (!Validador.isNumeroPreenchido(parametros.get("numParcelasCheque")[0]))
					this.erros.add("numParcelasCheque");
				if (!this.erros.contains("numParcelasCheque")) {
					if (totalPagar <= 200 && Integer.parseInt(parametros.get("numParcelasCheque")[0]) > 1)
						this.erros.add("numParcelasCheque");
					else if (totalPagar > 200 && Integer.parseInt(parametros.get("numParcelasCheque")[0]) > 1)
						if (Validador.isEmpty(parametros.get("dataDebito")[0]))
							this.erros.add("dataDebito");
				}
					
			}
		}
	}

}