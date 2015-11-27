package tp.pr2.logica;

/**
 * Esta clase contiene a la superficie. Tambien contiene constantes con la
 * dimension de la superficie y las celulas iniciales.
 * 
 * @version 1.0, 07/11/2015
 * @author Raul Murillo Montero
 * @author Antonio Valdivia de la Torre
 */

public class Mundo {
	private Superficie superficie;
	public final int NUMSIMPLES = 3; // nº de células simples con las que se
										// inicia la superficie.
	public final int NUMCOMPLEJAS = 2; // nº de células simples con las que se
										// inicia la superficie.
	public final int FILAS = 3; // nº de filas de la superficie.
	public final int COLUMNAS = 3; // nº de columnas de la superficie.

	/**
	 * Inicializa la supercie colocando un numero de celulas en posiciones
	 * aleatorias de esta.
	 */
	public Mundo() {
		this.superficie = new Superficie(FILAS, COLUMNAS, NUMSIMPLES, NUMCOMPLEJAS);
	}

	/**
	 * Dadas unas coordenadas, crea una celula en dicha posicion de la
	 * superficie.
	 * 
	 * @param f
	 *            coordenada fila
	 * @param c
	 *            coordenada columna
	 * @return true si se ha creado la celula.
	 */
	public boolean crearCelula(int f, int c) {
		if (!(f >= 0 && f < superficie.getFilas() && c >= 0 && c < superficie.getColumnas()))
			return false;
		else {
			Casilla cas = new Casilla(f, c);
			return superficie.crearCelula(cas);
		}
	}

	/**
	 * Dadas unas coordenadas, elimina una celula en dicha posicion de la
	 * superficie.
	 * 
	 * @param f
	 *            coordenada fila
	 * @param c
	 *            coordenada columna
	 * @return true si se ha eliminado la celula.
	 */
	public boolean eliminarCelula(int f, int c) {
		if (!(f >= 0 && f < superficie.getFilas() && c >= 0 && c < superficie.getColumnas()))
			return false;
		else {
			Casilla cas = new Casilla(f, c);
			return superficie.eliminarCelula(cas);
		}
	}

	/**
	 * Vacia la superficie.
	 */
	public void vaciarMundo() {
		superficie.vaciarSuperficie();
	}

	/**
	 * Para cada celula de la super cie ejecuta un paso de acuerdo a las reglas
	 * descritas.
	 */
	public void evoluciona() {
		superficie.setSuperficieFalse();
		for (int i = 0; i < superficie.getFilas(); i++) {
			for (int j = 0; j < superficie.getColumnas(); j++) {
				Casilla cas = new Casilla(i, j);
				superficie.evolucionarCelula(cas);
			}
		}
	}

	/**
	 * Devuelve un String con toda la superficie.
	 */
	public String toString() {
		return superficie.toString();
	}
}
