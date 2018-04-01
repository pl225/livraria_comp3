import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import meu_pacote.Pesquisa;

public class ConexaoBanco {
	private static final String URL = "jdbc:derby:/home/matheus/MyDB";
	private static final String USER = "pl225";
	private static final String PASSWORD = "Pl2252122*";
	
	private static Connection conn;
	
	private static void connect() {
		try {
			DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Pesquisa> coletarPesquisas () {
		
		connect();
		ArrayList<Pesquisa> pesquisas = new ArrayList<Pesquisa>();
		Statement stmt = null;
		ResultSet results = null;
		
		try {
			
			stmt = conn.createStatement();
			results = stmt.executeQuery("SELECT tipo_pesquisa, palavra_chave FROM livraria.pesquisas");
			
			while (results.next()) {
				pesquisas.add(new Pesquisa(results.getInt("tipo_pesquisa"), results.getString("palavra_chave")));
			}
			
			disconnect(stmt, results);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pesquisas;
	}
	
	private static void disconnect (Statement s, ResultSet r) throws SQLException{
		if (s != null) s.close();
		if (r != null) r.close();
		if (conn != null) conn.close();
	}
	
}
