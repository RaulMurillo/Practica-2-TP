package tp.pr2.control;
import tp.pr2.logica.*;

/**
 * Clase que implementa el comando paso
 * @version 1.0, 07/12/2015
 * @author Raul Murillo Montero
 * @author Antonio Valdivia de la Torre
 */
public class Paso extends Comando{
	/**
	 * Ejecuta un paso sobre el mundo
	 * @param mundo
	 */
	public void ejecuta(Mundo mundo){
		mundo.evoluciona();
	}
	/**
	 * 
	 * @return Devuelve el codigo de ayuda referente a un paso.
	 */
	public String textoAyuda() {
		return ("Realiza un paso en la simulacion.");
	}
	public Comando parsea(String[] cadenaComando){
		
	}
}
