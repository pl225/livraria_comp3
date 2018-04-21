package efetuar_venda;

import java.sql.SQLException;

import meu_pacote.Livro.LivroNaoEncontradoException;

public class RegistroCompraLivro extends RegistroCompra {
	public RegistroCompraLivro(String total, String valorPago, String isbn) throws LivroNaoEncontradoException, SQLException {
		super(total, valorPago, isbn);
	}
}
