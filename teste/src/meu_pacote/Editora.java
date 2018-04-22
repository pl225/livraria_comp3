package meu_pacote;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "editora")
public class Editora {
	
	@Id
	private String nome;

	public Editora(String editora) {
		this.nome = editora;
	}
	
	public Editora () {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
