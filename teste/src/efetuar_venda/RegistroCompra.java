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
	protected float total;
	
	public RegistroCompra (String valorPago, String isbn) throws LivroNaoEncontradoException, SQLException {
		this.data = Calendar.getInstance();
		this.formaPagamento = new FormaPagamentoDinheiro(valorPago);
		this.livro = ConexaoBanco.consultarLivro(isbn);
	}
	
	
	public RegistroCompra (String isbn, String bandeira, 
			String numCartao, String digito, String numParcelas, String codSeguranca) throws LivroNaoEncontradoException, SQLException {
		this.data = Calendar.getInstance();
		this.formaPagamento = new FormaPagamentoCC(numParcelas, numCartao, digito, codSeguranca, bandeira);
		this.livro = ConexaoBanco.consultarLivro(isbn);
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public long getTime () {
		return this.data.getTimeInMillis();
	}
	
	public float getValorTotal() {
		return this.total;
	}
	
	public FormaPagamento getFormaPagamento () {
		return this.formaPagamento;
	}
}
