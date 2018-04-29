package catalogos;

import java.sql.SQLException;
import java.util.ArrayList;

import bd_connection.BDConnection;
import bd_connection.ConsultingQuery;
import meu_pacote.Cliente;
import meu_pacote.Cliente.ClienteNaoEncontradoException;


public class CatalogoCliente {
	
	private CatalogoCliente() {}
	private static CatalogoCliente catalogoCliente;
	
	public static CatalogoCliente getInstance() {
		if (catalogoCliente == null) catalogoCliente = new CatalogoCliente();
		return catalogoCliente;
	}
	
	public Cliente getCliente (String cpf) throws SQLException, ClienteNaoEncontradoException {
		
		BDConnection bdConnection = null;
		
		try {
		
			bdConnection = new BDConnection(false);
			
			bdConnection.execute(new ConsultingQuery("SELECT c.nome, c.cpf AS cpfCliente, "
					+ "t.cpf AS cpfTelefoneCliente, e.cpf AS cpfEnderecoCliente, "
					+ "t.numero AS numeroTelefone, e.rua, e.numero AS numeroRua, "
					+ "e.cep, e.cidade, e.bairro  FROM livraria.cliente c "
					+ "INNER JOIN livraria.endereco e ON e.cpf = c.cpf "
					+ "INNER JOIN livraria.telefone t ON t.cpf = c.cpf "
					+ "WHERE c.cpf = '" + cpf + "'"));
			
			if (bdConnection.proximo()) {
				String nome = bdConnection.getDado("nome", String.class);
				String nomeRua = bdConnection.getDado("rua", String.class);
				int numeroRua = bdConnection.getDado("numeroRua", Integer.class);
				String cep = bdConnection.getDado("cep", String.class);
				String cidade = bdConnection.getDado("cidade", String.class);
				String bairro = bdConnection.getDado("bairro", String.class);
				
				ArrayList<String> telefones = new ArrayList<>();
				
				do {
					telefones.add(bdConnection.getDado("numeroTelefone", String.class));
				} while (bdConnection.proximo());
				
				return new Cliente (cpf, nome, nomeRua, numeroRua, cep, cidade, bairro, telefones);
			
			} else {
				throw new ClienteNaoEncontradoException();
			}
		} finally {
			if (bdConnection != null) bdConnection.desconectar();
		}
	}
}
