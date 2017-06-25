package ar.edu.frsf.ia.tp2.criterios;

import java.util.ArrayList;

import ar.edu.frsf.ia.tp2.Accion;
import ar.edu.frsf.ia.tp2.Match;
import ar.edu.frsf.ia.tp2.Regla;

public class Prioridad extends Criterio {

	@Override
	public ArrayList<Match> filtrar(ArrayList<Accion> memoriaTrabajo, ArrayList<Match> activas) {
		ArrayList<Match> filtradas = new ArrayList<Match>();
		int maxPrioridad = 0;
		for(Match m : activas){
			Regla regla = m.getRegla();
			if(regla.getPrioridad() > maxPrioridad){
				maxPrioridad = regla.getPrioridad();
				filtradas.clear();
				filtradas.add(m);
			}
			else if(regla.getPrioridad() == maxPrioridad){
				filtradas.add(m);
			}
		}
		return filtradas;
	}

	@Override
	public String toString() {
		return "Prioridad";
	}
}
