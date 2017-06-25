package ar.edu.frsf.ia.tp2;

import ar.edu.frsf.ia.tp2.criterios.Aleatorio;
import ar.edu.frsf.ia.tp2.criterios.Especificidad;
import ar.edu.frsf.ia.tp2.criterios.NoDuplicacion;
import ar.edu.frsf.ia.tp2.criterios.Prioridad;
import ar.edu.frsf.ia.tp2.sistemaDeProducciones.Accion;
import ar.edu.frsf.ia.tp2.sistemaDeProducciones.Regla;
import ar.edu.frsf.ia.tp2.sistemaDeProducciones.SistemaDeProduccion;

public class SistemaFactory {
	public static SistemaDeProduccion getSistema(){
		SistemaDeProduccion sistema = new SistemaDeProduccion();
		
		// Acciones
		Accion llamar911 = new Accion("Llamar al 911");
		Accion grabarAudio = new Accion("Grabar audio");
		Accion llamarBomberos = new Accion("Llamar a los bomberos");
		Accion enviarAmbulancia = new Accion("Enviar una ambulancia");
		
		// Reglas
		sistema.agregarRegla(new Regla(new String[]{"ayuda", "roban"}, llamar911));
		sistema.agregarRegla(new Regla(new String[]{"ayuda"}, grabarAudio));
		sistema.agregarRegla(new Regla(new String[]{"ayuda", "fuego"}, llamarBomberos));
		sistema.agregarRegla(new Regla(1, new String[]{"hay", "herido"}, enviarAmbulancia));

		// Criterios
		sistema.agregarCriterio(new NoDuplicacion());
		sistema.agregarCriterio(new Prioridad());
		sistema.agregarCriterio(new Especificidad());
		sistema.agregarCriterio(new Aleatorio());
		
		return sistema;
	}
}
