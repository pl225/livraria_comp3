package bd_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BDConnection {
	private static final String URL = "jdbc:derby:/home/matheus/MyDB";
	private static final String USER = "pl225";
	private static final String PASSWORD = "Pl2252122*";
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private boolean transacao;
	
	public BDConnection (boolean transacao) throws SQLException {
		DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
		this.conn = DriverManager.getConnection(URL, USER, PASSWORD);
		this.transacao = transacao;
		if (this.transacao) this.conn.setAutoCommit(false);
	}
	
	public void desconectar () throws SQLException{
		
		try {
			if (this.stmt != null) this.stmt.close();
			if (this.rs != null) this.rs.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {
			throw e;
		} finally {
			try {
				DriverManager.getConnection(
					    URL + ";user=" + USER + ";password=" + PASSWORD + ";shutdown=true");
			} catch (SQLException e) {}
		}
	}
	
	public int execute (UpdatingQuery uq) throws SQLException {
		if (this.stmt != null) this.stmt.close();
		this.stmt = this.conn.createStatement();
		return this.stmt.executeUpdate(uq.toString());
	}
	
	public int execute (UpdatingQuery uq, String coluna) throws SQLException {
		if (this.stmt != null) this.stmt.close();
		this.stmt = this.conn.createStatement();
		int afetadas = this.stmt.executeUpdate(uq.toString(), new String [] {coluna});
		if (afetadas <= 0) throw new SQLException();
		
		try (ResultSet ids = this.stmt.getGeneratedKeys()) {
			if (ids.next()) return ids.getInt(1);
			else throw new SQLException();
		}
		
	}
	
	public void execute (ConsultingQuery cq) throws SQLException {
		if (this.rs != null) this.rs.close();
		if (this.stmt != null) this.stmt.close();
		this.stmt = this.conn.createStatement();
		this.rs = this.stmt.executeQuery(cq.toString());
	}
	
	public boolean proximo () throws SQLException {
		return this.rs != null && this.rs.next();
	}
	
	public <T> T getDado (String nome, Class<T> tipo) throws SQLException {
		return tipo.cast(this.rs.getObject(nome));
	}
	
	public <T> T getDado (int coluna, Class<T> tipo) throws SQLException {
		return tipo.cast(this.rs.getObject(coluna));
	}
	
	public void commit () throws SQLException {
		if (this.transacao) this.conn.commit();
	}
	
	public void rollback () throws SQLException {
		if (this.transacao) this.conn.rollback();
	}
}
