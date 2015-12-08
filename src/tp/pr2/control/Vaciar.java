package tp.pr2.control;
import tp.pr2.logica.*;
/**
 * Clase que implementa el comando salir
 * @version 1.0, 07/12/2015
 * @author Raul Murillo Montero
 * @author Antonio Valdivia de la Torre
 */
public class Vaciar extends Comando {
	/**
	 * Vacia la superficie del mundo de celulas
	 */
	public void ejecuta(Mundo mundo){
		mundo.vaciarMundo();
	}
	public String TextoAyuda(){
		return("Crea un mundo vacio");
	}
	public Comando parsea(String[] cadenaComando){
		
	}
}
