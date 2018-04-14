package meu_pacote;

public class Pesquisa {
	
	public enum TipoPesquisa {
		ISBN, AUTOR, EDITORA, TITULO;
		
		private static TipoPesquisa[] values = TipoPesquisa.values();
		
		public static TipoPesquisa getFromInt (int i) {
			return values[i];
		}
	}
	
	private TipoPesquisa tipoPesquisa;
	private String palavraChave;
	
	public TipoPesquisa getTipoPesquisa() {
		return tipoPesquisa;
	}
	
	public String getPalavraChave() {
		return palavraChave;
	}
	
	public Pesquisa(int tipoPesquisa, String palavraChave) {
		this.tipoPesquisa = TipoPesquisa.getFromInt(tipoPesquisa);
		this.palavraChave = palavraChave;
	}

	@Override
	public String toString() {
		return "Pesquisa [tipoPesquisa=" + tipoPesquisa + ", palavraChave=" + palavraChave + "]";
	}
	
	public static String buildWhere (String tipoBusca, String parametro) {
		String where = " WHERE ";
		
		switch (TipoPesquisa.getFromInt(Integer.parseInt(tipoBusca) - 1)) {
			case ISBN:
				where += " l.ISBN LIKE '%"+parametro+"%'"; break;
			case TITULO:
				where += " l.titulo LIKE '%"+parametro+"%'"; break;
			case AUTOR:
				where += " l.nome_autor LIKE '%"+parametro+"%'"; break;
			case EDITORA:
				where += " l.nome_editora LIKE '%"+parametro+"%'"; break;
		}
		
		return where;
	}
	
}
