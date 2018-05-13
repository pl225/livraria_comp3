package catalogos;

import bd_connection.UpdatingQuery;
import efetuar_venda.FormaPagamentoCC;
import efetuar_venda.FormaPagamentoCheque;
import efetuar_venda.FormaPagamentoDinheiro;

public interface CatalogoFormaPagamentoVisitante {
	UpdatingQuery visit (FormaPagamentoDinheiro fpd);
	UpdatingQuery visit (FormaPagamentoCheque fpc);
	UpdatingQuery visit (FormaPagamentoCC fpcc);
}
