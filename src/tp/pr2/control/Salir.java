package tp.pr2.control;

import tp.pr2.logica.*;

/**
 * Clase que implementa el comando salir
 * 
 * @version 1.0, 07/12/2015
 * @author Raul Murillo Montero
 * @author Antonio Valdivia de la Torre
 */
public class Salir extends Comando {
	public final String SALIR = "SALIR";

	public void ejecuta(Mundo mundo) {
		mundo.setSimulacionTerminadaTrue();
	}

	public String textoAyuda() {
		return ("Cierra la aplicacion");
	}

	public Comando parsea(String[] cadenaComando) {
		if (cadenaComando.length != 1)
			return null;
		else if (cadenaComando[0].equals(SALIR))
			return this;
		else
			return null;
	}
}
