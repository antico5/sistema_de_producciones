package ar.edu.frsf.ia.tp2;

import java.util.Arrays;


public class Regla {
	String[] palabrasClave;
	Accion accionTomada;
	int prioridad;
	int especificidad;
	
	public Regla(String[] strings, Accion accion){
		this.palabrasClave=strings;
		this.accionTomada = accion;
		this.especificidad = strings.length;
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
		return "[palabrasClave=" + Arrays.toString(palabrasClave)
				+ ", accionTomada=[" + accionTomada + "], prioridad=" + prioridad
				+ ", especificidad=" + especificidad + "]";
	}
}

