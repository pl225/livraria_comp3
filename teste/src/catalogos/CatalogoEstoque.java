package catalogos;

import java.sql.SQLException;

import bd_connection.BDConnection;
import bd_connection.UpdatingQuery;
import efetuar_venda.FormaPagamento;
import efetuar_venda.FormaPagamentoCC;
import efetuar_venda.FormaPagamentoDinheiro;
import efetuar_venda.LivroIndisponivelException;
import efetuar_venda.RegistroCompra;
import efetuar_venda.RegistroCompraLivro;

public class CatalogoEstoque {
	
	private BDConnection conexaoBD;
	
	public void registrarCompra (RegistroCompraLivro registroCompra) throws SQLException, LivroIndisponivelException {
		
		try {
			
			this.conexaoBD = new BDConnection(true);
			
			int afetadas = this.conexaoBD.execute(new UpdatingQuery("UPDATE livraria.exemplar"
					+ " SET qtdDisponivel = qtdDisponivel - "
					+ String.valueOf(registroCompra.getQtdExemplar()) + " WHERE isbn = '" 
					+ registroCompra.getLivro().getISBN() + "' AND"
					+ " qtdDisponivel - " + String.valueOf(registroCompra.getQtdExemplar()) + " >= 0"));
			
			if (afetadas <= 0) throw new LivroIndisponivelException();
			
			int idFormaPagamento = this.registrarFormaPagamento(registroCompra.getFormaPagamento());
			
			this.registrarCompraLivro(registroCompra, idFormaPagamento);
			
			this.conexaoBD.commit();
		} catch (SQLException | LivroIndisponivelException e ) {
			if (this.conexaoBD != null) this.conexaoBD.rollback();
			throw e;
		} finally {
			if (this.conexaoBD != null) this.conexaoBD.desconectar();
		}
	}
	
	private int registrarFormaPagamento (FormaPagamento fp) throws SQLException {
		CatalogoFormaPagamento cfp = new CatalogoFormaPagamento();
		int idFormaPagamento =  this.conexaoBD.execute(cfp.insertFormaPagamento(fp), "ID");
		if (fp instanceof FormaPagamentoDinheiro)
			this.registrarFormaPagamento((FormaPagamentoDinheiro) fp, idFormaPagamento);
		else if (fp instanceof FormaPagamentoCC)
			this.registrarFormaPagamento((FormaPagamentoCC) fp, idFormaPagamento);
		return idFormaPagamento;
	}
	
	private void registrarFormaPagamento (FormaPagamentoDinheiro fpd, int idFormaPagamento) throws SQLException {
		CatalogoFormaPagamento cfp = new CatalogoFormaPagamento();
		this.conexaoBD.execute(cfp.insertFormaPagamento(fpd, idFormaPagamento));
	}
	
	private void registrarFormaPagamento (FormaPagamentoCC fpcc, int idFormaPagamento) throws SQLException {
		CatalogoFormaPagamento cfp = new CatalogoFormaPagamento();
		this.conexaoBD.execute(cfp.insertFormaPagamento(fpcc, idFormaPagamento));
	}
	
	private void registrarCompraLivro (RegistroCompraLivro rcl, int idFormaPagamento) throws SQLException {
		CatalogoRegistroCompra crc = new CatalogoRegistroCompra();
		int idRegistroCompra =  this.conexaoBD.execute(crc.insert((RegistroCompra) rcl, idFormaPagamento), "ID");
		this.conexaoBD.execute(crc.insert(rcl, idRegistroCompra));
	}
}
