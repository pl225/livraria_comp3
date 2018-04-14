package meu_pacote;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "livro")
public class Livro {
	
	public Livro () {}
	
	public Livro(String iSBN, String titulo, int qtdIdealExemplar, String autor, String estilo, String editora,
			float precoUnitario, int qtdDisponivel) {
		
		ISBN = iSBN;
		this.titulo = titulo;
		this.qtdIdealExemplar = qtdIdealExemplar;
		this.autor = new Autor(autor);
		this.estilo = new Estilo(estilo);
		this.editora = new Editora(editora);
		this.exemplar = new Exemplar(iSBN, precoUnitario, qtdDisponivel);
	}

	@Id
	private String ISBN;
	
	private String titulo;
	
	@Column(name = "qtd_ideal_exemplar")
	private int qtdIdealExemplar;
	
	@OneToOne
	@JoinColumn(name = "nome_autor")
	private Autor autor;
	
	@OneToOne
	@JoinColumn(name = "nome_estilo")
	private Estilo estilo;
	
	@OneToOne
	@JoinColumn(name = "nome_editora")
	private Editora editora;
	
	private Exemplar exemplar;

	public Exemplar getExemplar() {
		return exemplar;
	}

	public void setExemplar(Exemplar exemplar) {
		this.exemplar = exemplar;
	}

	public String getISBN() {
		return ISBN;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getQtdIdealExemplar() {
		return qtdIdealExemplar;
	}

	public Autor getAutor() {
		return autor;
	}

	public Estilo getEstilo() {
		return estilo;
	}

	public Editora getEditora() {
		return editora;
	}	
	
	
}
