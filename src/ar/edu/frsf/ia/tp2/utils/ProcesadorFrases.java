package ar.edu.frsf.ia.tp2.utils;

import java.util.ArrayList;

public class ProcesadorFrases {
	public static ArrayList<String> getPalabrasClaves(String frase){
		String fraseLimpia = filtrarCaracteres(frase);
		ArrayList<String> palabras = new ArrayList<String>();
		for(String palabra : fraseLimpia.split(" "))
			palabras.add(palabra);
		return palabras;
	}
	
	// Eliminar caracteres extranyos
	private static String filtrarCaracteres(String frase){
		return frase.replaceAll("[^A-Za-z0-9 ]", "").toLowerCase();
	}
}
