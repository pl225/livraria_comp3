package efetuar_venda;

import java.sql.SQLException;
import java.text.ParseException;

import meu_pacote.Cliente.ClienteNaoEncontradoException;
import meu_pacote.Livro.LivroNaoEncontradoException;

public class RegistroCompraLivro extends RegistroCompra {
	
	private int qtdExemplar;
	
	public RegistroCompraLivro(String qtdExemplar, String valorPago, String isbn) throws LivroNaoEncontradoException, SQLException {
		super(valorPago, isbn);
		this.qtdExemplar = Integer.parseInt(qtdExemplar);
		this.total = this.calcularValorTotal();
	}
	
	public RegistroCompraLivro (String qtdExemplar, String isbn, String bandeira, String numCartao, 
			String numParcelas, String codSeguranca) throws LivroNaoEncontradoException, SQLException {
		super(isbn, bandeira, numCartao, numParcelas, codSeguranca);
		this.qtdExemplar = Integer.parseInt(qtdExemplar);
		this.total = this.calcularValorTotal();
		
	}
	
	public RegistroCompraLivro(String qtdExemplar, String isbn, String codigoBanco, String numeroAgencia,
			String digitoAgencia, String numConta, String numeroCheque, String numParcelasCheque, String dataDebito,
			String cpf) throws LivroNaoEncontradoException, SQLException, ParseException, ClienteNaoEncontradoException {
		
		super(qtdExemplar, isbn, codigoBanco, numeroAgencia, digitoAgencia, numConta, numeroCheque,
				numParcelasCheque, dataDebito, cpf);
		this.qtdExemplar = Integer.parseInt(qtdExemplar);
		this.total = this.calcularValorTotal();
		
	}

	public int getQtdExemplar () {
		return this.qtdExemplar; 
	}
	
	private float calcularValorTotal () {
		return this.getQtdExemplar() * this.getLivro().getExemplar().getPrecoUnitario();
	}
	
}
