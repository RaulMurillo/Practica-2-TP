package tp.pr2.control;

import tp.pr2.logica.Mundo;

/**
 * Clase que implementa el comando eliminar celula con atributos f, c para
 * indicar de que casilla se eliminara.
 * 
 * @version 1.0, 07/12/2015
 * @author Raul Murillo Montero
 * @author Antonio Valdivia de la Torre
 */
public class EliminarCelula extends Comando {
	public final String ELIMINARCELULA = "ELIMINARCELULA";
	private int f;
	private int c;

	/**
	 * Constructor de la clase
	 * 
	 * @param fila
	 * @param columna
	 */
	public EliminarCelula(int fila, int columna) {
		f = fila;
		c = columna;
	}

	/**
	 * Elimina la celula de la casilla (f,c) si es posible, si no muestra un
	 * mensaje de error
	 * 
	 * @param mundo
	 */
	public void ejecuta(Mundo mundo) {
		if (!mundo.eliminarCelula(f, c)) {
			System.out.println("No se pudo eliminar la celula, " + "posicion no valida");
		}
	}

	/**
	 * 
	 * @return Devuelve el codigo de ayuda referente a Eliminar celula.
	 */
	public String textoAyuda() {
		return ("Elimina la celula de la casilla (f, c) si es posible.");
	}

	public Comando parsea(String[] cadenaComando) {
		if (cadenaComando.length != 3)
			return null;
		else if (!cadenaComando[0].equals(ELIMINARCELULA))
			return null;
		else {
			// Se gestionan errores tipo "eliminarcelula a 8"
			int f, c;
			try {
				f = Integer.parseInt(cadenaComando[1]);
				c = Integer.parseInt(cadenaComando[2]);
			} catch (NumberFormatException e) {
				return null;
			}
			return new EliminarCelula(f, c);
		}
	}
}
