package tp.pr2.control;

import tp.pr2.logica.*;

/**
 * Clase que implementa el comando crear celula simple con atributos f, c para
 * indicar en que casilla se creará.
 * 
 * @version 1.0, 07/12/2015
 * @author Raul Murillo Montero
 * @author Antonio Valdivia de la Torre
 */
public class CrearCelulaSimple extends Comando {
	public final String CREARCELULASIMPLE = "CREARCELULASIMPLE";
	private int f;
	private int c;

	/**
	 * Constructor de la clase
	 * 
	 * @param fila
	 * @param columna
	 */
	public CrearCelulaSimple(int fila, int columna) {
		f = fila;
		c = columna;
	}

	/**
	 * Crea una celula simple en la posición (f, c) si es posible, si no muestra
	 * error.
	 * 
	 * @param mundo
	 */
	public void ejecuta(Mundo mundo) {
		if (!mundo.crearCelulaSimple(f, c)) {
			System.out.println("No se pudo crear la celula, " + "posición no válida");
		}
	}

	/**
	 * 
	 * @return Devuelve el codigo de ayuda referente a crear celula simple.
	 */
	public String textoAyuda() {
		return ("Crea una nueva celula simple en la posicion " + "(f,c) si es posible.");
	}

	public Comando parsea(String[] cadenaComando) {
		if (cadenaComando.length != 3)
			return null;
		else if (!cadenaComando[0].equals(CREARCELULASIMPLE))
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
			return new CrearCelulaSimple(f, c);
		}
	}
}
