package efetuar_venda;

public class Agencia {
	private int numero;
	private int digitoVerificador;
	private Banco banco;
	
	public Agencia(String numeroAgencia, String digitoAgencia, String codigoBanco) {
		this.numero = Integer.parseInt(numeroAgencia);
		this.digitoVerificador = Integer.parseInt(digitoAgencia);
		this.banco = new Banco(codigoBanco);
	}

	public int getNumero() {
		return numero;
	}

	public int getDigitoVerificador() {
		return digitoVerificador;
	}
	
	public Banco getBanco() {
		return this.banco;
	}
}
