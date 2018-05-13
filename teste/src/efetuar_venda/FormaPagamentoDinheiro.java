package efetuar_venda;

import bd_connection.UpdatingQuery;
import catalogos.CatalogoFormaPagamentoVisitante;

public class FormaPagamentoDinheiro extends FormaPagamento {
	private float valorPago;
	
	public FormaPagamentoDinheiro(String valorPago) {
		this.valorPago = Float.parseFloat(valorPago);
	}
	
	public float getValorPago () {
		return this.valorPago;
	}

	@Override
	public UpdatingQuery accept(CatalogoFormaPagamentoVisitante visitante) {
		return visitante.visit(this);
	}
	
}
