package ar.edu.frsf.ia.tp2.criterios;

import java.util.ArrayList;

import ar.edu.frsf.ia.tp2.sistemaDeProducciones.Accion;
import ar.edu.frsf.ia.tp2.sistemaDeProducciones.Match;

public class NoDuplicacion extends Criterio {

	@Override
	public ArrayList<Match> filtrar(ArrayList<Accion> memoriaTrabajo, ArrayList<Match> activas) {
		ArrayList<Match> filtradas = new ArrayList<Match>();
		for(Match m : activas){
			if(!memoriaTrabajo.contains(m.getRegla().getAccionTomada()))
				filtradas.add(m);
		}
		return filtradas;
	}
	
	@Override
	public String toString() {
		return "No Duplicacion";
	}
}
