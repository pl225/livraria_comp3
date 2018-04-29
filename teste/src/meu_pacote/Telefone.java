package meu_pacote;

public class Telefone {
	
	private String numero;
	
	public Telefone(String numero) {
		this.numero = numero;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Telefone && ((Telefone) obj).numero.equals(this.numero);
	}	
}
