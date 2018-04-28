package catalogos;

import java.sql.SQLException;

import bd_connection.BDConnection;
import bd_connection.UpdatingQuery;
import efetuar_venda.LivroIndisponivelException;
import efetuar_venda.RegistroCompraLivro;

public class CatalogoEstoque {
	
	private static CatalogoEstoque catalogoEstoque;
	
	private CatalogoEstoque () {}
	
	public static CatalogoEstoque getInstance() {
		if (catalogoEstoque == null) catalogoEstoque = new CatalogoEstoque();
		return catalogoEstoque;
	}
	
	public void registrarCompra (RegistroCompraLivro registroCompra) throws SQLException, LivroIndisponivelException {
		
		BDConnection conexaoBD = null;
		try {
			
			conexaoBD = new BDConnection(true);
			
			int afetadas = conexaoBD.execute(new UpdatingQuery("UPDATE livraria.exemplar"
					+ " SET qtdDisponivel = qtdDisponivel - "
					+ String.valueOf(registroCompra.getQtdExemplar()) + " WHERE isbn = '" 
					+ registroCompra.getLivro().getISBN() + "' AND"
					+ " qtdDisponivel - " + String.valueOf(registroCompra.getQtdExemplar()) + " >= 0"));
			
			if (afetadas <= 0) throw new LivroIndisponivelException();
			
			CatalogoRegistroCompra.getInstance().registrarCompra(registroCompra, conexaoBD);
			
			conexaoBD.commit();
		} catch (SQLException | LivroIndisponivelException e ) {
			if (conexaoBD != null) conexaoBD.rollback();
			throw e;
		} finally {
			if (conexaoBD != null) conexaoBD.desconectar();
		}
	}
	
}
