package tp.pr2.logica;

/**
 * Es una clase abstracta de la que heredan las clases concretas
 * celula compleja y celula simple
 * 
 * @version 1.0, 07/11/2015
 * @author Raul Murillo Montero
 * @author Antonio Valdivia de la Torre
 */

abstract public class Celula {
	/*
	 * Indicador de movimiento por turno. true si se ha movido en ese turno
	 */
	private boolean movido;
	/* Indica si una celula es simple(comestible)o no(compleja). */
	protected boolean esComestible;

	/**
	 * Crea una celula nueva, con movido a true.
	 */
	public Celula() {
		movido = false;
	}

	/**
	 * Indica si una celula se ha movido en ese turno.
	 * 
	 * @return true si la celula ya se ha movido en ese turno.
	 */
	public boolean getMovido() {
		return this.movido;
	}

	/**
	 * Pone a true el indicador de movimiento de la celula.
	 */
	public void setMovidoTrue() {
		movido = true;
	}

	/**
	 * Pone a false el indicador de movimiento de la celula. Al inici
	 * o de cada turno debe realizarse sobre cada celula.
	 */
	public void setMovidoFalse() {
		movido = false;
	}

	/**
	 * Realiza el movimiento de una celula colocada en la posicion 
	 * (f, c) de la superficie.
	 * @param f coordenada fila
	 * @param c coordenada columna
	 * @param superficie superficie donde se encuentra la celula
	 * @return casilla a la que se ha movido la celula, null en
	 *  caso contrario
	 */
	public abstract Casilla ejecutaMovimiento(int f, int c,
			Superficie superficie);

	/**
	 * Indica si la celula es comestible o no.
	 * 
	 * @return true si la célula es simple, false si es compleja
	 */
	public abstract boolean esComestible();

}
