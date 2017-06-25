package ar.edu.frsf.ia.tp2;

public class Accion {
	String accion;
	
	public Accion(String accion){
		this.accion = accion;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	@Override
	public String toString() {
		return accion;
	}
}
