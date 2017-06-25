package ar.edu.frsf.ia.tp2.criterios;

import java.util.ArrayList;
import java.util.Random;

import ar.edu.frsf.ia.tp2.Accion;
import ar.edu.frsf.ia.tp2.Match;

public class Aleatorio extends Criterio {

	@Override
	public ArrayList<Match> filtrar(ArrayList<Accion> memoriaTrabajo, ArrayList<Match> activas) {
		ArrayList<Match> filtradas = new ArrayList<Match>();
		Random r = new Random();
		int posicion = r.nextInt(activas.size());
		filtradas.add(activas.get(posicion));
		return filtradas;
	}

	@Override
	public String toString() {
		return "Aleatorio";
	}

}
