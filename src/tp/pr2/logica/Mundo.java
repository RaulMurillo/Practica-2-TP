package tp.pr2.logica;

/**
 * Esta clase contiene a la superficie. Tambien contiene constantes con la
 * dimension de la superficie y las celulas iniciales y un atributo que indica
 * si se ha terminado o no la simulacion.
 * 
 * @version 2.2, 11/12/2015
 * @author Raul Murillo Montero
 * @author Antonio Valdivia de la Torre
 */

public class Mundo {
	private Superficie superficie;
	// nº de células simples con las que se inicia la superficie.
	public final int NUMSIMPLES = 5;
	// nº de células simples con las que se inicia la superficie.
	public final int NUMCOMPLEJAS = 2;
	// nº de filas de la superficie.
	public final int FILAS = 3;
	// nº de columnas de la superficie.
	public final int COLUMNAS = 3;
	// controla cuando termina la simulacion.
	private boolean simulacionTerminada;

	/**
	 * Inicializa la supercie colocando un numero de celulas en posiciones
	 * aleatorias de esta.
	 */
	public Mundo() {
		this.superficie = new Superficie(FILAS, COLUMNAS, NUMSIMPLES, NUMCOMPLEJAS);
		this.simulacionTerminada = false;
	}

	/**
	 * Reinicia un mundo.
	 */
	public void iniciarMundo() {
		this.superficie = new Superficie(FILAS, COLUMNAS, NUMSIMPLES, NUMCOMPLEJAS);
	}

	/**
	 * Dadas unas coordenadas, crea una celula simple en dicha posicion de la
	 * superficie.
	 * 
	 * @param f
	 *            coordenada fila.
	 * @param c
	 *            coordenada columna.
	 * @return true si se ha creado la celula.
	 */
	public boolean crearCelulaSimple(int f, int c) {
		if (!(f >= 0 && f < superficie.getFilas() && c >= 0 && c < superficie.getColumnas()))
			return false;
		else {
			Casilla cas = new Casilla(f, c);
			return superficie.crearCelulaSimple(cas);
		}
	}

	/**
	 * Dadas unas coordenadas, crea una celula compleja en dicha posicion de la
	 * superficie.
	 * 
	 * @param f
	 *            coordenada fila.
	 * @param c
	 *            coordenada columna.
	 * @return true si se ha creado la celula.
	 */
	public boolean crearCelulaCompleja(int f, int c) {
		if (!(f >= 0 && f < superficie.getFilas() && c >= 0 && c < superficie.getColumnas()))
			return false;
		else {
			Casilla cas = new Casilla(f, c);
			return superficie.crearCelulaCompleja(cas);
		}
	}

	/**
	 * Dadas unas coordenadas, elimina una celula en dicha posicion de la
	 * superficie.
	 * 
	 * @param f
	 *            coordenada fila.
	 * @param c
	 *            coordenada columna.
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
	 * Para cada celula de la superficie ejecuta un paso de acuerdo a las reglas
	 * descritas.
	 */
	public void evoluciona() {
		Casilla casilla;
		boolean[][] movido = new boolean[superficie.getFilas()][superficie.getColumnas()];
		for (int i = 0; i < superficie.getFilas(); i++) {
			for (int j = 0; j < superficie.getColumnas(); j++) {
				if (movido[i][j] == false) {
					casilla = superficie.ejecutaMovimiento(i, j);
					if (casilla != null) {
						movido[casilla.getX()][casilla.getY()] = true;
					}
				}

			}
		}
	}

	/**
	 * Devuelve un String con toda la superficie.
	 */
	public String toString() {
		return superficie.toString();
	}

	/**
	 * Indica si la simulacion ha terminado.
	 * 
	 * @return true si la simulacion ha terminado.
	 */
	public boolean getSimulacionTerminada() {
		return this.simulacionTerminada;
	}

	/**
	 * Cambia el valor del booleano de simulación a true.
	 */
	public void setSimulacionTerminadaTrue() {
		this.simulacionTerminada = true;
	}
}
