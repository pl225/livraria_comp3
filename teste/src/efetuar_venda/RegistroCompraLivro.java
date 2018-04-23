package efetuar_venda;

import java.sql.SQLException;

import meu_pacote.Livro.LivroNaoEncontradoException;

public class RegistroCompraLivro extends RegistroCompra {
	
	private int qtdExemplar;
	
	public RegistroCompraLivro(String qtdExemplar, String valorPago, String isbn) throws LivroNaoEncontradoException, SQLException {
		super(valorPago, isbn);
		this.qtdExemplar = Integer.parseInt(qtdExemplar);
		this.total = this.calcularValorTotal();
	}
	
	public RegistroCompraLivro (String qtdExemplar, String isbn, String bandeira, 
			String numCartao, String digito, String numParcelas, String codSeguranca) throws LivroNaoEncontradoException, SQLException {
		super(isbn, bandeira, numCartao, digito, numParcelas, codSeguranca);
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
