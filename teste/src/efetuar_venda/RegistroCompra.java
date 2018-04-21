package efetuar_venda;

import java.sql.SQLException;
import java.util.Calendar;

import bd_connection.ConexaoBanco;
import meu_pacote.Livro;
import meu_pacote.Livro.LivroNaoEncontradoException;

public abstract class RegistroCompra {
	
	protected Calendar data;
	protected Livro livro;
	protected FormaPagamento formaPagamento;
	protected int qtdExemplar;
	
	public RegistroCompra (String qtdExemplar, String valorPago, String isbn) throws LivroNaoEncontradoException, SQLException {
		this.qtdExemplar = Integer.parseInt(qtdExemplar);
		this.data = Calendar.getInstance();
		this.formaPagamento = new FormaPagamentoDinheiro(valorPago);
		this.livro = ConexaoBanco.consultarLivro(isbn);
	}
	
	protected float calcularTotalCompra () {
		return this.qtdExemplar * this.livro.getExemplar().getPrecoUnitario();
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public int getQtdExemplar () {
		return this.qtdExemplar;
	}
}
