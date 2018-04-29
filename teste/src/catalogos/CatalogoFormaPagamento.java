package catalogos;

import java.sql.SQLException;

import bd_connection.BDConnection;
import bd_connection.UpdatingQuery;
import efetuar_venda.FormaPagamento;
import efetuar_venda.FormaPagamentoCC;
import efetuar_venda.FormaPagamentoCheque;
import efetuar_venda.FormaPagamentoDinheiro;

public class CatalogoFormaPagamento {
	
	private static CatalogoFormaPagamento catalogoFormaPagamento;
	private CatalogoFormaPagamento () {}
	
	public static CatalogoFormaPagamento getInstance () {
		if (catalogoFormaPagamento == null) catalogoFormaPagamento = new CatalogoFormaPagamento();
		return catalogoFormaPagamento;
	}
	
	private UpdatingQuery insertFormaPagamento (FormaPagamentoDinheiro fpd, int idFormaPagamento) {
		return new UpdatingQuery("INSERT INTO livraria.formaPagamentoDinheiro "
				+ "VALUES (" + idFormaPagamento + ", " + fpd.getValorPago() + ")");
	}
	
	private UpdatingQuery insertFormaPagamento (FormaPagamento fp) {
		return new UpdatingQuery("INSERT INTO livraria.formaPagamento VALUES (DEFAULT)");		
	}
	
	private UpdatingQuery insertFormaPagamento (FormaPagamentoCC fpcc, int idFormaPagamento) {
		return new UpdatingQuery("INSERT INTO livraria.formaPagamentoCC (ID, qtdParcelas) "
				+ "VALUES(" + idFormaPagamento + ", " + fpcc.getQtdParcelas() + ")");
	}
	
	private UpdatingQuery insertFormaPagamento(FormaPagamentoCheque fp, int idFormaPagamento) {
		return new UpdatingQuery("INSERT INTO livraria.formaPagamentoCheque (ID) "
				+ "VALUES(" + idFormaPagamento + ")");
	}
	
	public int registrarFormaPagamento (FormaPagamento fp, BDConnection bd) throws SQLException {
		int idFormaPagamento = bd.execute(this.insertFormaPagamento(fp), "ID");
		
		if (fp instanceof FormaPagamentoDinheiro)
			bd.execute(this.insertFormaPagamento((FormaPagamentoDinheiro) fp, idFormaPagamento));
		else if (fp instanceof FormaPagamentoCC)
			bd.execute(this.insertFormaPagamento((FormaPagamentoCC) fp, idFormaPagamento));
		else 
			bd.execute(this.insertFormaPagamento((FormaPagamentoCheque) fp, idFormaPagamento));
		
		return idFormaPagamento;
	}
	
}
