package ar.edu.frsf.ia.tp2.criterios;

import java.util.ArrayList;

import ar.edu.frsf.ia.tp2.sistemaDeProducciones.Accion;
import ar.edu.frsf.ia.tp2.sistemaDeProducciones.Match;

public abstract class Criterio {

	public abstract ArrayList<Match> filtrar(ArrayList<Accion> memoriaTrabajo, ArrayList<Match> activas);

}
