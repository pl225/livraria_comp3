package catalogos;

import bd_connection.UpdatingQuery;
import efetuar_venda.FormaPagamento;
import efetuar_venda.FormaPagamentoDinheiro;

public class CatalogoFormaPagamento {
	
	public UpdatingQuery insertFormaPagamento (FormaPagamentoDinheiro fpd, int idFormaPagamento) {
		return new UpdatingQuery("INSERT INTO livraria.formaPagamentoDinheiro "
				+ "VALUES (" + idFormaPagamento + ", " + fpd.getValorPago() + ")");
	}
	
	public UpdatingQuery insertFormaPagamento (FormaPagamento fp) {
		return new UpdatingQuery("INSERT INTO livraria.formaPagamento VALUES (DEFAULT)");		
	}
	
}