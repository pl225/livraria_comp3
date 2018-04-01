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
	
	
	
}
