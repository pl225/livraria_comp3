package catalogos;

import java.sql.SQLException;

import bd_connection.BDConnection;
import bd_connection.UpdatingQuery;
import efetuar_venda.FormaPagamento;
import efetuar_venda.FormaPagamentoCC;
import efetuar_venda.FormaPagamentoCheque;
import efetuar_venda.FormaPagamentoDinheiro;

public class CatalogoFormaPagamento implements CatalogoFormaPagamentoVisitante{
	
	private static CatalogoFormaPagamento catalogoFormaPagamento;
	private CatalogoFormaPagamento () {}
	
	public static CatalogoFormaPagamento getInstance () {
		if (catalogoFormaPagamento == null) catalogoFormaPagamento = new CatalogoFormaPagamento();
		return catalogoFormaPagamento;
	}
	
	private UpdatingQuery insertFormaPagamento (FormaPagamento fp) {
		return new UpdatingQuery("INSERT INTO livraria.formaPagamento VALUES (DEFAULT)");		
	}
	
	public int registrarFormaPagamento (FormaPagamento fp, BDConnection bd) throws SQLException {
		int idFormaPagamento = bd.execute(this.insertFormaPagamento(fp), "ID");
		fp.setId(idFormaPagamento);
		
		bd.execute(fp.accept(this));
		
		return idFormaPagamento;
	}

	@Override
	public UpdatingQuery visit(FormaPagamentoDinheiro fpd) {
		return new UpdatingQuery("INSERT INTO livraria.formaPagamentoDinheiro "
				+ "VALUES (" + fpd.getId() + ", " + fpd.getValorPago() + ")");
	}

	@Override
	public UpdatingQuery visit(FormaPagamentoCheque fpc) {
		return new UpdatingQuery("INSERT INTO livraria.formaPagamentoCheque (ID) "
				+ "VALUES(" + fpc.getId() + ")");
	}

	@Override
	public UpdatingQuery visit(FormaPagamentoCC fpcc) {
		return new UpdatingQuery("INSERT INTO livraria.formaPagamentoCC (ID, qtdParcelas) "
				+ "VALUES(" + fpcc.getId() + ", " + fpcc.getQtdParcelas() + ")");
	}
}
