package efetuar_venda;

public class FormaPagamentoCC extends FormaPagamento {
	private int qtdParcelas;
	private CartaoCredito cartaoCredito;
	
	public FormaPagamentoCC(String qtdParcelas) {
		this.qtdParcelas = Integer.parseInt(qtdParcelas);
	}
}
