package efetuar_venda;

public class FormaPagamentoDinheiro extends FormaPagamento {
	private float valorPago;
	
	public FormaPagamentoDinheiro(String valorPago) {
		this.valorPago = Float.parseFloat(valorPago);
	}
	
	public float getValorPago () {
		return this.valorPago;
	}
	
}
