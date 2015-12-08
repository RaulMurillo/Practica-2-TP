package tp.pr2.control;

import tp.pr2.logica.Mundo;

/**
 * Clase que implementa el comando iniciar
 * @version 1.0, 07/12/2015
 * @author Raul Murillo Montero
 * @author Antonio Valdivia de la Torre
 */
public class Iniciar extends Comando{
	/**
	 * Reinicia el mundo
	 * @param mundo
	 */
	public void ejecuta(Mundo mundo){ //MIRAR SI ESTA IMPLEMENTACION
		//ES VALIDA
		mundo = new Mundo();
	}
	/**
	 * 
	 * @return Devuelve el codigo de ayuda referente a iniciar.
	 */
	public String textoAyuda() {
		return ("Inicia una nueva simulación");
	}
	public Comando parsea(String[] cadenaComando){
		
	}
}
