package tp.pr2.control;

import tp.pr2.logica.*;

/**
 * Clase abstracta de la que heredan todos los comandos de la practica
 * @version 2.0, 04/12/2015
 * @author Raul Murillo Montero
 * @author Antonio Valdivia de la Torre
 */
public abstract class Comando {
	/**
	 * ejecuta el comando correspondiente sobre el mundo
	 * 
	 * @param mundo
	 */
	public abstract void ejecuta(Mundo mundo);

	/**
	 * recibe un array de String , que debe procesar devolviendo el comando que
	 * representa el string.
	 * 
	 * @param cadenaComando
	 * @return
	 */
	public abstract Comando parsea(String[] cadenaComando);

	/**
	 * devuelve un String con la información de ayuda que se quiera mostrar sobre
	 * el comando.
	 * 
	 * @return
	 */
	public abstract String textoAyuda();
}
