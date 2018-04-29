package efetuar_venda;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import meu_pacote.Cliente.ClienteNaoEncontradoException;

public class ChequePredatado extends Cheque{
	private int qtdParcelas;
	private Calendar dataDebitamento;

	public ChequePredatado(String codigoBanco, String numeroAgencia, String digitoAgencia, String numConta,
			String numeroCheque, String numParcelasCheque, String dataDebito, String cpf) throws ParseException, SQLException, ClienteNaoEncontradoException {
		super(codigoBanco, numeroAgencia, digitoAgencia, numConta, numeroCheque, cpf);
		this.qtdParcelas = Integer.parseInt(numParcelasCheque);
		this.dataDebitamento = Calendar.getInstance();
		 
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
		dataDebitamento.setTime(simpleDateFormat.parse(dataDebito));
	}
	
}
