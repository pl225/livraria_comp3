package efetuar_venda;

import bd_connection.UpdatingQuery;
import catalogos.CatalogoFormaPagamentoVisitante;

public class FormaPagamentoCC extends FormaPagamento {
	private int qtdParcelas;
	private CartaoCredito cartaoCredito;
	
	public FormaPagamentoCC(String qtdParcelas, String numCartao, String codSeguranca, 
			String bandeira) {
		this.qtdParcelas = Integer.parseInt(qtdParcelas);
		this.cartaoCredito = new CartaoCredito(numCartao, codSeguranca, bandeira);
	}
	
	public int getQtdParcelas () {
		return this.qtdParcelas;
	}

	@Override
	public UpdatingQuery accept(CatalogoFormaPagamentoVisitante visitante) {
		return visitante.visit(this);
	}
}
