package efetuar_venda;

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
}
