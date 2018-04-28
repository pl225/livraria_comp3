package catalogos;

import java.sql.SQLException;
import java.sql.Timestamp;

import bd_connection.BDConnection;
import bd_connection.UpdatingQuery;
import efetuar_venda.RegistroCompra;
import efetuar_venda.RegistroCompraLivro;

public class CatalogoRegistroCompra {
	
	private CatalogoRegistroCompra () {}
	private static CatalogoRegistroCompra catalogoRegistroCompra;
	
	public static CatalogoRegistroCompra getInstance () {
		if (catalogoRegistroCompra == null) catalogoRegistroCompra = new CatalogoRegistroCompra();
		return catalogoRegistroCompra;
	}
	
	private UpdatingQuery insert (RegistroCompra rc, int idFormaPagamento) {
		return new UpdatingQuery("INSERT INTO livraria.registroCompra "
				+ "VALUES (DEFAULT, " + rc.getValorTotal() + ", '" + new Timestamp(rc.getTime()) + "', '"
				+ rc.getLivro().getISBN() + "', " + idFormaPagamento + ")");
	}
	
	private UpdatingQuery insert (RegistroCompraLivro rcl, int idRegistroCompra) {
		return new UpdatingQuery("INSERT INTO livraria.registroCompraLivro "
				+ "VALUES(" + idRegistroCompra + ", " + rcl.getQtdExemplar() + ")");
	}
	
	public void registrarCompra (RegistroCompraLivro registroCompraLivro, BDConnection bdConnection) throws SQLException {
		
		int idFormaPagamento = CatalogoFormaPagamento.getInstance().registrarFormaPagamento(registroCompraLivro.getFormaPagamento(), bdConnection);
		
		int idRegistroCompra =  bdConnection.execute(this.insert((RegistroCompra) registroCompraLivro, idFormaPagamento), "ID");
		
		bdConnection.execute(this.insert(registroCompraLivro, idRegistroCompra));
		
	}
}
