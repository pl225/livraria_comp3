package efetuar_venda;

public class CartaoCredito {
	
	private String numero;
	private int digitoVerificador;
	private int codigoSeguranca;
	private Bandeira bandeira;
	
	public CartaoCredito (String numero, String digitoVerificador, String codigoSeguranca, 
			String bandeira) {
		this.numero = numero;
		this.digitoVerificador = Integer.parseInt(digitoVerificador);
		this.codigoSeguranca = Integer.parseInt(codigoSeguranca);
		this.bandeira = new Bandeira(bandeira);
	}
}
