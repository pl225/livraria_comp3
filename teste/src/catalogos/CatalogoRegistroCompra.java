package catalogos;

import java.sql.Timestamp;

import bd_connection.UpdatingQuery;
import efetuar_venda.RegistroCompra;
import efetuar_venda.RegistroCompraLivro;

public class CatalogoRegistroCompra {
	
	public UpdatingQuery insert (RegistroCompra rc, int idFormaPagamento) {
		return new UpdatingQuery("INSERT INTO livraria.registroCompra "
				+ "VALUES (DEFAULT, " + rc.getValorTotal() + ", '" + new Timestamp(rc.getTime()) + "', '"
				+ rc.getLivro().getISBN() + "', " + idFormaPagamento + ")");
	}
	
	public UpdatingQuery insert (RegistroCompraLivro rcl, int idRegistroCompra) {
		return new UpdatingQuery("INSERT INTO livraria.registroCompraLivro "
				+ "VALUES(" + idRegistroCompra + ", " + rcl.getQtdExemplar() + ")");
	}
}
