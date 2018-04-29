package efetuar_venda;

import java.sql.SQLException;

import catalogos.CatalogoCliente;
import meu_pacote.Cliente;
import meu_pacote.Cliente.ClienteNaoEncontradoException;

public class Conta {
	private int numero;
	private Agencia agencia;
	private Cliente cliente;
	
	public Conta(String codigoBanco, String numeroAgencia, String digitoAgencia, String numConta, 
			String cpf) throws SQLException, ClienteNaoEncontradoException {
		this.numero = Integer.parseInt(numConta);
		this.agencia = new Agencia(numeroAgencia, digitoAgencia, codigoBanco);
		this.cliente = CatalogoCliente.getInstance().getCliente(cpf);
	}

	public int getNumero() {
		return numero;
	}
	public Agencia getAgencia() {
		return agencia;
	}
	public Cliente getCliente() {
		return cliente;
	}
}
