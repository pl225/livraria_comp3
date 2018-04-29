package efetuar_venda;

import java.sql.SQLException;

import meu_pacote.Cliente.ClienteNaoEncontradoException;

public class Cheque {
	private int numero;
	private Conta conta;
	
	public Cheque(String codigoBanco, String numeroAgencia, String digitoAgencia, String numConta, 
			String numeroCheque, String cpf) throws SQLException, ClienteNaoEncontradoException {
		this.numero = Integer.parseInt(numeroCheque);
		this.conta = new Conta(codigoBanco, numeroAgencia, digitoAgencia, numConta, cpf);
	}

	public int getNumeroCheque () {
		return this.numero;
	}
	
	public Conta getConta() {
		return this.conta;
	}
}
