package efetuar_venda;

import bd_connection.UpdatingQuery;

public interface AceitarCatalogoFormaPagamento {
	UpdatingQuery accept (CatalogoFormaPagamentoVisitante visitante);
}
