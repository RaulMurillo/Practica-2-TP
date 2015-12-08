package tp.pr2.control;

import tp.pr2.logica.*;

/**
 * Clase que implementa el comando crear celula compleja con atributos f, c para
 * indicar en que casilla se creará.
 * 
 * @version 1.0, 07/12/2015
 * @author Raul Murillo Montero
 * @author Antonio Valdivia de la Torre
 */
public class CrearCelulaCompleja extends Comando {
	private int f;
	private int c;

	/**
	 * Constructor de la clase
	 * 
	 * @param fila
	 * @param columna
	 */
	public CrearCelulaCompleja(int fila, int columna) {
		f = fila;
		c = columna;
	}

	/**
	 * Crea una celula compleja en la posición (f, c) si es posible, si no
	 * muestra error.
	 * 
	 * @param mundo
	 */
	public void ejecuta(Mundo mundo) {
		if (!mundo.crearCelulaCompleja(f, c)) {
			System.out.println("No se pudo crear la celula, "
					+ "posición no válida");
		}
	}
	/**
	 * 
	 * @return Devuelve el codigo de ayuda referente a crear celula
	 * compleja.
	 */
	public String textoAyuda() {
		return ("Crea una nueva celula compleja en la posicion "
				+ "(f,c) si es posible.");
	}
	public Comando parsea(String[] cadenaComando){
		
	}
}
