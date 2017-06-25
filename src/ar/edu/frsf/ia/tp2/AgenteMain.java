package ar.edu.frsf.ia.tp2;

import java.util.ArrayList;

import ar.edu.frsf.ia.tp2.criterios.Aleatorio;
import ar.edu.frsf.ia.tp2.criterios.Especificidad;
import ar.edu.frsf.ia.tp2.criterios.NoDuplicacion;
import ar.edu.frsf.ia.tp2.criterios.Prioridad;
import ar.edu.frsf.ia.tp2.interfaz.MainFrame;
import ar.edu.frsf.ia.tp2.sistemaDeProducciones.Accion;
import ar.edu.frsf.ia.tp2.sistemaDeProducciones.Regla;
import ar.edu.frsf.ia.tp2.sistemaDeProducciones.SistemaDeProduccion;

public class AgenteMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SistemaDeProduccion sistema = SistemaFactory.getSistema();

		new MainFrame(sistema);
	}

}
