package efetuar_venda;

public class FormaPagamentoCC extends FormaPagamento {
	private int qtdParcelas;
	private CartaoCredito cartaoCredito;
	
	public FormaPagamentoCC(String qtdParcelas, String numCartao, String digito, String codSeguranca,
			String bandeira) {
		this.qtdParcelas = Integer.parseInt(qtdParcelas);
		this.cartaoCredito = new CartaoCredito(numCartao, digito, codSeguranca, bandeira);
	}
}
