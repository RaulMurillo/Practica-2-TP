package tp.pr2.control;

import tp.pr2.logica.*;

/**
 * Clase que implementa el comando salir
 * 
 * @version 1.0, 07/12/2015
 * @author Raul Murillo Montero
 * @author Antonio Valdivia de la Torre
 */
public class Vaciar extends Comando {
	public final String VACIAR = "VACIAR";

	/**
	 * Vacia la superficie del mundo de celulas
	 */
	public void ejecuta(Mundo mundo) {
		mundo.vaciarMundo();
	}

	public String textoAyuda() {
		return ("VACIAR: Crea un mundo vacio");
	}

	/**
	 * @return el comando Vaciar si el array de strings se corresponde con este,
	 *         null en otro caso
	 */
	public Comando parsea(String[] cadenaComando) {
		if (cadenaComando.length != 1)
			return null;
		else if (cadenaComando[0].equals(VACIAR))
			return this;
		else
			return null;
	}
}
