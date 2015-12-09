package tp.pr2.control;

import tp.pr2.logica.Mundo;

/**
 * Clase que implementa el comando iniciar
 * 
 * @version 1.0, 07/12/2015
 * @author Raul Murillo Montero
 * @author Antonio Valdivia de la Torre
 */
public class Iniciar extends Comando {
	public final String INICIAR = "INICIAR";

	/**
	 * Reinicia el mundo
	 * 
	 * @param mundo
	 */
	public void ejecuta(Mundo mundo) {
		mundo.iniciarMundo();
	}

	/**
	 * 
	 * @return Devuelve el codigo de ayuda referente a iniciar.
	 */
	public String textoAyuda() {
		return ("Inicia una nueva simulación");
	}

	public Comando parsea(String[] cadenaComando) {
		if (cadenaComando.length != 1)
			return null;
		else if (cadenaComando[0].equals(INICIAR))
			return this;
		else
			return null;
	}
}
