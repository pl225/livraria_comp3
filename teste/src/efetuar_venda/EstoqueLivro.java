package efetuar_venda;

import java.sql.SQLException;

import bd_connection.ConexaoBanco;

public class EstoqueLivro {
	
	public static void registrarCompra (RegistroCompraLivro registroCompra) throws SQLException, LivroIndisponivelException {
		ConexaoBanco.updateExemplar(registroCompra);
	}
}
