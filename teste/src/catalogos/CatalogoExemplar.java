package catalogos;

import java.sql.SQLException;

import bd_connection.BDConnection;
import bd_connection.ConsultingQuery;

public class CatalogoExemplar {
	private CatalogoExemplar () {}
	private static CatalogoExemplar catalogoExemplar;
	
	public static CatalogoExemplar getInstance () {
		if (catalogoExemplar == null) catalogoExemplar = new CatalogoExemplar();
		return catalogoExemplar;
	}
	
	public boolean verificaDisponibilidade (String isbn, int qtd) throws SQLException {
		BDConnection bdConnection = null;
		
		try {
			bdConnection = new BDConnection(false);
			
			bdConnection.execute(new ConsultingQuery("SELECT qtdDisponivel FROM livraria.exemplar "
					+ "WHERE isbn='" + isbn + "'"));
			bdConnection.proximo();
			return qtd <= bdConnection.getDado("qtdDisponivel", Integer.class);
			
		} finally {
			if (bdConnection != null) bdConnection.desconectar();
		}
	}
	
}
