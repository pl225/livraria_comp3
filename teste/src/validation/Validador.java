package validation;

import java.util.ArrayList;
import java.util.Map;

public abstract class Validador {
	protected ArrayList<String> erros;
	
	public abstract void make (Map<String, String[]> parametros);
	
	public Validador () {
		this.erros = new ArrayList<String>();
	}
	
	protected static boolean isNaN (String f) {
		try {
			Double.parseDouble(f);
			return false;
		} catch (NumberFormatException e) {
			return true;
		}
	}
	
	protected static boolean isNumeroPreenchido (String s) {
		try {
			return Double.parseDouble(s) > 0;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	protected static boolean isEmpty (String s) {
		return s == null || s.isEmpty();
	}
	
	public ArrayList<String> erros() {
		return this.erros;
	}
	
	public boolean fails () {
		return !this.erros.isEmpty();
	}
}