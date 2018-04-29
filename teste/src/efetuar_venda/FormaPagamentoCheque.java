package efetuar_venda;

import java.sql.SQLException;
import java.text.ParseException;

import meu_pacote.Cliente.ClienteNaoEncontradoException;

public class FormaPagamentoCheque extends FormaPagamento {
	
	private Cheque cheque;

	public FormaPagamentoCheque(String codigoBanco, String numeroAgencia, String digitoAgencia, String numConta,
			String numeroCheque, String numParcelasCheque, String dataDebito, String cpf) throws ParseException, SQLException, ClienteNaoEncontradoException {
		
		if (Integer.parseInt(numParcelasCheque) == 1)
			this.cheque = new Cheque(codigoBanco, numeroAgencia, digitoAgencia, numConta,
					numeroCheque, cpf);
		else
			this.cheque = new ChequePredatado(codigoBanco, numeroAgencia, digitoAgencia, numConta,
					numeroCheque, numParcelasCheque, dataDebito, cpf);
	}
	
	public Cheque getCheque () {
		return this.cheque;
	}

}
