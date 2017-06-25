package ar.edu.frsf.ia.tp2;

import java.util.ArrayList;

import ar.edu.frsf.ia.tp2.criterios.Aleatorio;
import ar.edu.frsf.ia.tp2.criterios.Especificidad;
import ar.edu.frsf.ia.tp2.criterios.NoDuplicacion;
import ar.edu.frsf.ia.tp2.criterios.Prioridad;

public class AgenteMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SistemaDeProduccion sistema = new SistemaDeProduccion();
		
		Accion llamar911 = new Accion("Llamar al 911");
		Accion grabarAudio = new Accion("Grabar audio");
		Accion llamarBomberos = new Accion("Llamar a los bomberos");
		Accion enviarAmbulancia = new Accion("Enviar una ambulancia");
		

		sistema.agregarRegla(new Regla(new String[]{"ayuda", "roban"}, llamar911));
		sistema.agregarRegla(new Regla(new String[]{"ayuda"}, grabarAudio));
		sistema.agregarRegla(new Regla(new String[]{"ayuda", "fuego"}, llamarBomberos));
		sistema.agregarRegla(new Regla(1, new String[]{"hay", "herido"}, enviarAmbulancia));

		sistema.agregarCriterio(new NoDuplicacion());
		sistema.agregarCriterio(new Prioridad());
		sistema.agregarCriterio(new Especificidad());
		sistema.agregarCriterio(new Aleatorio());

		ArrayList<Accion> respuesta = sistema.start("Ayuda, mi casa se prende fuego! hay un herido");
		
		System.out.println("\n\n Acciones Tomadas: \n" + respuesta);
	}

}
