package ar.edu.frsf.ia.tp2.sistemaDeProducciones;

import ar.edu.frsf.ia.tp2.utils.Frase;

public class Match {
	Regla regla;
	Frase frase;
	
	public Match(Regla regla, Frase frase){
		this.regla = regla;
		this.frase = frase;
	}

	public Regla getRegla() {
		return regla;
	}

	public void setRegla(Regla regla) {
		this.regla = regla;
	}

	public Frase getFrase() {
		return frase;
	}

	public void setFrase(Frase frase) {
		this.frase = frase;
	}

	@Override
	public String toString() {
		return "Match [regla=" + regla + "]";
	}
}
