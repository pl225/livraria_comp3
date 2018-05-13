package efetuar_venda;

import bd_connection.UpdatingQuery;

public interface CatalogoFormaPagamentoVisitante {
	UpdatingQuery visit (FormaPagamentoDinheiro fpd);
	UpdatingQuery visit (FormaPagamentoCheque fpc);
	UpdatingQuery visit (FormaPagamentoCC fpcc);
}
