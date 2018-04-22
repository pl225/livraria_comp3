package meu_pacote;

public class Exemplar {

	private String ISBN;
	private float precoUnitario;
	private int qtdDisponivel;
	
	public Exemplar(String iSBN, float precoUnitario, int qtdDisponivel) {
		this.ISBN = iSBN;
		this.precoUnitario = precoUnitario;
		this.qtdDisponivel = qtdDisponivel;
	}
	
	public String getISBN() {
		return ISBN;
	}
	public float getPrecoUnitario() {
		return precoUnitario;
	}
	public int getQtdDisponivel() {
		return qtdDisponivel;
	}
	
	
}
