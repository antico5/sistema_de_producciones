package ar.edu.frsf.ia.tp2;

import java.util.ArrayList;

public class Frase {
	String fraseCompleta;
	ArrayList<String> palabras;
	
	public Frase(String frase){
		this.fraseCompleta = frase;
		this.palabras = procesar(frase);
	}
	
	private ArrayList<String> procesar(String frase){
		return ProcesadorFrases.getPalabrasClaves(frase);
	}

	public ArrayList<String> getPalabras() {
		return palabras;
	}

	@Override
	public String toString() {
		return "Frase [fraseCompleta=" + fraseCompleta + ", palabras="
				+ palabras + "]";
	}
	
}
