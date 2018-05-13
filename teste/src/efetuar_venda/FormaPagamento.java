package efetuar_venda;

public abstract class FormaPagamento implements AceitarCatalogoFormaPagamento{
	public enum ModoPagamento {
		CREDITO, CHEQUE, DINHEIRO
	}	
	
	protected int id;
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId () {
		return this.id;
	}
}
