package efetuar_venda;

public class CartaoCredito {
	
	private String numero;
	private int codigoSeguranca;
	private Bandeira bandeira;
	
	public CartaoCredito (String numero, String codigoSeguranca, String bandeira) {
		this.numero = numero;
		this.codigoSeguranca = Integer.parseInt(codigoSeguranca);
		this.bandeira = new Bandeira(bandeira);
	}
}
