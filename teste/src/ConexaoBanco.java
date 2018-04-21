import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import meu_pacote.Pesquisa;
import meu_pacote.Pesquisa.TipoPesquisa;
import meu_pacote.Livro;
import meu_pacote.Livro.LivroNaoEncontradoException;

public class ConexaoBanco {
	private static final String URL = "jdbc:derby:/home/matheus/MyDB";
	private static final String USER = "pl225";
	private static final String PASSWORD = "Pl2252122*";
	
	private static Connection conn;
	
	private static void connect() throws SQLException {
		DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
		conn = DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
	public static ArrayList<Pesquisa> coletarPesquisas () throws SQLException {
		
		connect();
		ArrayList<Pesquisa> pesquisas = new ArrayList<Pesquisa>();
		Statement stmt = null;
		ResultSet results = null;
			
		stmt = conn.createStatement();
		results = stmt.executeQuery("SELECT tipo_pesquisa, palavra_chave FROM livraria.pesquisas");
		
		while (results.next()) {
			pesquisas.add(new Pesquisa(results.getInt("tipo_pesquisa"), results.getString("palavra_chave")));
		}
		
		disconnect(stmt, results);
		
		return pesquisas;
	}
	
	private static void disconnect (Statement s, ResultSet r) throws SQLException{
		if (s != null) s.close();
		if (r != null) r.close();
		if (conn != null) conn.close();
		
		try {
		DriverManager.getConnection(
			    URL + ";user=" + USER + ";password=" + PASSWORD + ";shutdown=true");
		} catch (SQLException e) {}
	}
	
	public static List<Livro> consultarLivrosHibernate (String tipoBusca, String parametro) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Livraria");
		
		EntityManager entidadesAdmin = emf.createEntityManager();
		
		EntityTransaction transacao = null;
		
		try {
			transacao = entidadesAdmin.getTransaction();
			transacao.begin();
			
			String consulta = "SELECT l FROM Livro l";
			consulta += " WHERE " + 
					Pesquisa.TipoPesquisa.getFromInt(Integer.parseInt(tipoBusca) - 1).toString().toLowerCase() 
					+ " LIKE '%" + parametro + "%'";
			System.out.println(consulta);
			List<Livro> livros = (List<Livro>) entidadesAdmin.createQuery(consulta).getResultList();
			
			transacao.commit();
			
			return livros;
			
		} catch (Exception e) {
			if (transacao != null) transacao.rollback();
			throw new Exception("Um erro ocorreu");
		} finally {
			entidadesAdmin.close();
			emf.close();
		}
	}
	
	public static ArrayList<Livro> consultarLivros (String tipoBusca, String parametro) throws SQLException {
		
		
		ArrayList<Livro> livros = new ArrayList<Livro>();
		Statement stmt = null;
		ResultSet results = null;
		
		try {
			connect();
			stmt = conn.createStatement();
			results = stmt.executeQuery("SELECT "
					+ " l.isbn AS ISBN, l.titulo, l.nome_autor, l.nome_editora, l.nome_estilo,"
					+ " e.precoUnitario, e.qtdDisponivel "
					+ " FROM livraria.livro l"
					+ " INNER JOIN livraria.exemplar e ON e.ISBN = l.isbn"
					+ Pesquisa.buildWhere(tipoBusca, parametro));
			
			while (results.next()) {
				livros.add(new Livro(results.getString("ISBN"), results.getString("titulo"),
						results.getInt("qtdDisponivel"), results.getString("nome_autor"),
						results.getString("nome_estilo"), results.getString("nome_editora"),
						results.getFloat("precoUnitario"), results.getInt("qtdDisponivel")));
			}
		} finally {
			disconnect(stmt, results);
		}
		return livros;
	}
	
	public static Livro consultarLivro (String isbn) throws LivroNaoEncontradoException, SQLException {
		
		Statement stmt = null;
		ResultSet results = null;
		Livro livro = null;
		
		try {
			connect();	
			stmt = conn.createStatement();
			results = stmt.executeQuery("SELECT "
					+ " l.isbn AS ISBN, l.titulo, l.nome_autor, l.nome_editora, l.nome_estilo,"
					+ " e.precoUnitario, e.qtdDisponivel "
					+ " FROM livraria.livro l"
					+ " INNER JOIN livraria.exemplar e ON e.ISBN = l.isbn"
					+ Pesquisa.buildWhere(TipoPesquisa.ISBN, isbn));
			
			if (results.next()) {
				livro = new Livro(results.getString("ISBN"), results.getString("titulo"),
						results.getInt("qtdDisponivel"), results.getString("nome_autor"),
						results.getString("nome_estilo"), results.getString("nome_editora"),
						results.getFloat("precoUnitario"), results.getInt("qtdDisponivel"));
			}
		} finally {
			disconnect(stmt, results);
		}
		
		if (livro != null) return livro;
		else throw new Livro.LivroNaoEncontradoException();
	}
	
	public static ArrayList<String> consultarBandeiras () throws SQLException {
		
		Statement stmt = null;
		ResultSet results = null;
		ArrayList<String> bandeiras = new ArrayList<String>();
		
		try {
			connect();
				
			stmt = conn.createStatement();
			results = stmt.executeQuery("SELECT *"
					+ " FROM livraria.bandeira");
			
			while (results.next()) {
				bandeiras.add(results.getString(1));
			}
			
			return bandeiras;
			
		} finally {
			disconnect(stmt, results);	
		}
	}
}
