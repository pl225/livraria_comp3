package meu_pacote;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Cliente {
	
	private String cpf;
	private String nome;
	private Set<Telefone> telefones;
	private Endereco endereco;
	
	public Cliente(String cpf, String nome, String nomeRua, int numeroRua, String cep, String cidade, String bairro,
			ArrayList<String> telefones) {
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = new Endereco(nomeRua, numeroRua, bairro, cidade, cep);
		this.telefones = new HashSet<>();
		for (String s : telefones) this.telefones.add(new Telefone(s));
			
	}

	public static class ClienteNaoEncontradoException extends Exception {
		private static final long serialVersionUID = 1L;

		public ClienteNaoEncontradoException () {
			super("Cliente não encontrado.");
		}
	}
	
	public String getNome() {
		return this.nome;
	}

	public String toJSON() {
		return "{"
				+ "\"nome\":\"" + this.nome + "\","
				+ "\"logradouro\":\"" + this.endereco.getRua() + "\","
				+ "\"numero\":" + this.endereco.getNumero() + ","
				+ "\"cep\":\"" + this.endereco.getCep() + "\","
				+ "\"bairro\":\"" + this.endereco.getBairro() + "\","
				+ "\"cidade\":\"" + this.endereco.getCidade() + "\","
				+ "\"telefone\":\"" + this.telefones.iterator().next().getNumero() + "\""
				+ "}";
	}
}
