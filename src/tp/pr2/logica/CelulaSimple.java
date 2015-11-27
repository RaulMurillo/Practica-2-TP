package tp.pr2.logica;

/**
 * Esta clase representa una celula del mundo.
 * Contiene atributos privados para contabilizar
 * el numero de pasos en los que la celula no se
 * ha movido y el numero de pasos dados (tanto si se
 * ha movido como si no) realizados en el mundo.
 * @version 1.0, 07/11/2015
 * @author Raul Murillo Montero
 * @author Antonio Valdivia de la Torre
 */

public class CelulaSimple extends Celula{
	private int pasosDados;	//Contador de pasos dados en el mundo.
	private int pasosNoMovidos;	//Contador de pasos sin moverse.
	public final int MAX_PASOS_SIN_MOVER = 3;	//Nº máximo de pasos que puede estar una célula sin moverse. Si llega al límite muere.
	public final int PASOS_REPRODUCCION = 4;	//Nº de pasos que debe dar una célula para reproducirse.
	
	/**
	 * Crea una celula nueva,
	 * con todos sus contadores a 0.
	 */
	public CelulaSimple(){
		esComestible = true;
		pasosDados = 0;
		pasosNoMovidos=0;
	}
	
	/**
	 * Incrementa el nº de pasos que ha dado una celula
	 * (se haya movido o no) e indica si le toca reproducirse.
	 * @return true si le toca reproducirse.
	 */
	public boolean incPasDad(){ //Pasos reproducción
		pasosDados++;
		if(pasosDados % PASOS_REPRODUCCION == 0)return true;
		else return false;
	}
		
	/**
	 * Indica si la celula debe morir por inactividad.
	 * Si no, incrementa el numero de pasos que lleva la celula sin moverse.
	 * @return true si ha llegado al maximo permitido y la célula debe morir.
	 */
	public boolean incPasNoMov(){ 
		pasosNoMovidos++;
		return pasosNoMovidos == MAX_PASOS_SIN_MOVER;
	}
	
	/**
	 *@return X para celula simple
	 */
	public String toString(){
		return "X";
	}
	
	/**
	 * Realiza el movimiento de una celula simple colocada en la posición (f,c)
	 * @return la casilla a la que se ha movido la celula o null en caso de que no se mueva la celula.
	 */
	public Casilla ejecutaMovimiento(int f, int c, Superficie superficie){
		Casilla origen = new Casilla(f, c);
		Casilla destino = superficie.evolucionarCelulaSimple(origen);
		if(incPasDad()){
			if(destino == null){
				superficie.eliminarCelula(origen);
				//comentario
			}
			else{
				//CREAR METODO EN SUPERFICIE QUE MUEVA CELULA DE CASILLA ORIGEN A DESTINO
			}
		}
		//No le toca reproducirse. Aumentan sus pasos no dados. 
		else if(incPasNoMov()){ //Decide si debe morir
			superficie.eliminarCelula(origen);
			//comentario
		}
		
	}
	
	/**
	 * @return true para indicar que la celula es simple
	 */
	public boolean esComestible(){
		return esComestible;
	}
	
}
