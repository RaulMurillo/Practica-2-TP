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
	public final String CREARCELULACOMPLEJA = "CREARCELULACOMPLEJA";
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
			System.out.println("No se pudo crear la celula, " + "posición no válida");
		}
	}

	/**
	 * 
	 * @return Devuelve el codigo de ayuda referente a crear celula compleja.
	 */
	public String textoAyuda() {
		return ("Crea una nueva celula compleja en la posicion " + "(f,c) si es posible.");
	}

	public Comando parsea(String[] cadenaComando) {
		if (cadenaComando.length != 3)
			return null;
		else if (!cadenaComando[0].equals(CREARCELULACOMPLEJA))
			return null;
		else {
			// Se gestionan errores tipo "crearcelula a 8"
			int f, c;
			try {
				f = Integer.parseInt(cadenaComando[1]);
				c = Integer.parseInt(cadenaComando[2]);
			} catch (NumberFormatException e) {
				return null;
			}
			return new CrearCelulaCompleja(f, c);
		}
	}
}