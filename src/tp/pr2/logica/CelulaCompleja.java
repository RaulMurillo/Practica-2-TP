package tp.pr2.logica;

public class CelulaCompleja extends Celula {
	public final int MAX_COMER = 3;
	private int comidas;

	/**
	 * Crea una celula compleja.
	 */
	public CelulaCompleja() {
		esComestible = false;
		comidas = 0;
	}

	/**
	 * Incrementa el contador de celulas comidas.
	 * 
	 * @return true si se ha comido el máximo de celulas posibles
	 */
	public boolean comidas() {
		comidas++;
		return comidas == MAX_COMER;
	}

	/**
	 * Realiza el movimiento de una celula compleja colocada en la posición
	 * (f,c).
	 * 
	 * @return la casilla a la que se ha movido la celula o null en caso de que
	 *         no se mueva la celula.
	 */
	public Casilla ejecutaMovimiento(int f, int c, Superficie superficie) {
		Casilla origen = new Casilla(f, c);
		Casilla destino = superficie.evolucionarCelulaCompleja(origen);
		if (destino != null) {
			System.out.print("Celula compleja en " + origen + " se mueve a " + destino);
			if (superficie.esComestible(destino)) {
				System.out.print(" --COME--" + '\n');
				if (comidas())
					System.out.println("Explota la celula compleja en" + destino);
			} else /* if (destino esta libre) */ 
				System.out.print(" --NO COME--" + '\n');
			superficie.moverA(origen, destino);
			superficie.eliminarCelula(origen);
		}
		return destino;
	}

	/**
	 * Indica que la celula es compleja.
	 * 
	 * @return false
	 */
	public boolean esComestible() {
		return esComestible;
	}

	/**
	 * Muestra una celula compleja.
	 * 
	 * @return * (celula compleja)
	 */
	public String toString() {
		return "*";
	}
}
