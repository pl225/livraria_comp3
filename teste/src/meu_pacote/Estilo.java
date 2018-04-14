package meu_pacote;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estilo")
public class Estilo {
	
	@Id
	private String nome;

	public Estilo(String estilo) {
		this.nome = estilo;
	}
	
	public Estilo () {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
