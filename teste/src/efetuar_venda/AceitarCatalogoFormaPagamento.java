package efetuar_venda;

import bd_connection.UpdatingQuery;
import catalogos.CatalogoFormaPagamentoVisitante;

public interface AceitarCatalogoFormaPagamento {
	UpdatingQuery accept (CatalogoFormaPagamentoVisitante visitante);
}
