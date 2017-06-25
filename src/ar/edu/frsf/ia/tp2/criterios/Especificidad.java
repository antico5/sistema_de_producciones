package ar.edu.frsf.ia.tp2.criterios;

import java.util.ArrayList;

import ar.edu.frsf.ia.tp2.sistemaDeProducciones.Accion;
import ar.edu.frsf.ia.tp2.sistemaDeProducciones.Match;
import ar.edu.frsf.ia.tp2.sistemaDeProducciones.Regla;

public class Especificidad extends Criterio {

	@Override
	public ArrayList<Match> filtrar(ArrayList<Accion> memoriaTrabajo, ArrayList<Match> activas) {
		ArrayList<Match> filtradas = new ArrayList<Match>();
		int maxEspecificidad = 0;
		for(Match m : activas){
			Regla regla = m.getRegla();
			if(regla.getEspecificidad() > maxEspecificidad){
				maxEspecificidad = regla.getEspecificidad();
				filtradas.clear();
				filtradas.add(m);
			}
			else if(regla.getEspecificidad() == maxEspecificidad){
				filtradas.add(m);
			}
		}
		return filtradas;
	}
	
	@Override
	public String toString() {
		return "Especificidad";
	}

}
