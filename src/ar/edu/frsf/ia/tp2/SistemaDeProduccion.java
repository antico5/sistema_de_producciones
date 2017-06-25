package ar.edu.frsf.ia.tp2;

import java.util.ArrayList;

import ar.edu.frsf.ia.tp2.criterios.Criterio;

public class SistemaDeProduccion {
	ArrayList<Regla> memoriaProducciones;
	ArrayList<Accion> memoriaTrabajo;
	ArrayList<Criterio> criterios;
	
	
	public SistemaDeProduccion(){
		memoriaProducciones = new ArrayList<Regla>();
		criterios = new ArrayList<Criterio>();
	}
	
	public void agregarRegla(Regla regla){
		memoriaProducciones.add(regla);
	}
	
	public void agregarCriterio(Criterio criterio){
		criterios.add(criterio);
	}

	public ArrayList<Accion> start(String fraseCompleta) {
		memoriaTrabajo = new ArrayList<Accion>();
		Frase frase = new Frase(fraseCompleta);
		int iteracion = 1;
		
		log("Frase ingresada: " + fraseCompleta);
		log("Palabras clave: " + frase.getPalabras());
			
		while(true){
			log("\nIteracion " + iteracion);
			
			ArrayList<Match> matchList = match(frase);
			
			log("\nConjunto de conflicto:");
			for(Match m : matchList)
				log(m);
			
			Match elegido = resolverConflicto(matchList);
			if(elegido == null)
				break;
			
			log("\nAgregando a memoria de trabajo:");
			log(elegido);
			
			ejecutar(elegido);
			iteracion++;
		}
		
		log("\nFin de etapa de produccion.");
		
		return memoriaTrabajo;
	}
	
	private void ejecutar(Match match){
		memoriaTrabajo.add(match.getRegla().getAccionTomada());
	}
	
	private Match resolverConflicto(ArrayList<Match> lista){
		for(Criterio criterio : criterios){
			lista = criterio.filtrar(memoriaTrabajo, lista);
			
			log("\nAplicando criterio ["+criterio+"]. Conjunto resultante:");
			log(lista);
			
			if(lista.size() <= 1)
				break;
		}
		
		return lista.size() == 1 ? lista.get(0) : null;
	}
	
	public ArrayList<Match> match(Frase frase){
		ArrayList<Match> activas = new ArrayList<Match>();
		
		for(Regla regla : memoriaProducciones){
			if(regla.esAplicable(frase)){
				activas.add(new Match(regla,frase));
			}
		}
		
		return activas;
	}
	
	private void log(Object string){
		System.out.println(string);
	}
}
