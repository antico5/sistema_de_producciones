package ar.edu.frsf.ia.tp2.sistemaDeProducciones;

import java.util.Arrays;

import ar.edu.frsf.ia.tp2.utils.Frase;


public class Regla {
	private static int numeroRegla = 1;
	
	String[] palabrasClave;
	Accion accionTomada;
	int prioridad;
	int especificidad;
	String identificador;
	
	public Regla(String[] strings, Accion accion){
		this.palabrasClave=strings;
		this.accionTomada = accion;
		this.especificidad = strings.length;
		this.identificador = "R"+numeroRegla;
		numeroRegla++;
	}
	
	public Regla(int prioridad, String[] strings, Accion accion){
		this(strings,accion);
		this.prioridad = prioridad;
	}
	
	public boolean esAplicable(Frase frase){
		for(String clave : palabrasClave){
			if(!frase.getPalabras().contains(clave))
				return false;
		}
		return true;
	}
	
	public int getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(int novedad) {
		this.prioridad = novedad;
	}
	public int getEspecificidad() {
		return especificidad;
	}
	public void setEspecificidad(int especificidad) {
		this.especificidad = especificidad;
	}

	public Accion getAccionTomada() {
		return accionTomada;
	}

	public void setAccionTomada(Accion accionTomada) {
		this.accionTomada = accionTomada;
	}

	@Override
	public String toString() {
		return " ("+identificador+ ")"+ ":[palabrasClave=" + Arrays.toString(palabrasClave)
				+ ", accionTomada=[" + accionTomada + "], prioridad=" + prioridad
				+ ", especificidad=" + especificidad + "]";
	}
}

