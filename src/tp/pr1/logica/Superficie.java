package tp.pr1.logica;

/**
 * Esta clase representa la supercie donde transcurre la evolucion de las
 * celulas. La supercie la vamos a representar mediante una matriz de celulas,
 * cuyo tamaño queda determinado por su numero de filas y columnas.
 * 
 * @version 1.0, 07/11/2015
 * @author Raul Murillo Montero
 * @author Antonio Valdivia de la Torre
 */

public class Superficie {
	private Celula[][] superficie; // Matriz de células.
	private int filas; // Filas de la matriz superficie.
	private int columnas; // Columnas de la matriz superficie.

	/**
	 * Crea una superficie a partir de su numero de filas y columnas y con un
	 * varias celulas en posiciones aleatorias de la matriz.
	 * 
	 * @param nf
	 *            El numero de filas de la matriz. Debe ser mayor que 0.
	 * @param nc
	 *            El numero de columnas de la matriz. Debe ser mayor que 0.
	 * @param numCels
	 *            El numero de celulas con las que se iniciara.
	 */
	public Superficie(int nf, int nc, int numSimples, int numComplejas) {
		this.filas = nf;
		this.columnas = nc;
		int aleatorio[] = new int[nf * nc];
		/*
		 * Se crea un array de enteros con numSimples celulas simples y
		 * numComplejas celulas complejas, y se barajea aleatoriamente. El
		 * resultado indicará la posición de las células iniciales de la
		 * superficie.
		 */
		for (int i = 0; i < numSimples; i++) {
			aleatorio[i] = 1;
		}
		for (int i = numSimples; i < numSimples + numComplejas; i++) {
			aleatorio[i] = 2;
		}
		for (int i = numSimples + numComplejas; i < nf * nc; i++) {
			aleatorio[i] = 0;
		}
		int aux;
		int rnd;
		int i = nf * nc;
		/*
		 * Utilizamos una variante del algoritmo de Fisher-Yates para conseguir
		 * un barajado eficiente y sin desviaciones en las posibles
		 * permutaciones (todas son asi equiprobables).
		 */
		while (i > 1) {
			i--;
			rnd = (int) (Math.random() * (i + 1));
			aux = aleatorio[i];
			aleatorio[i] = aleatorio[rnd];
			aleatorio[rnd] = aux;
		}
		superficie = new Celula[nf][nc];
		// Se crean células en las posiciones indicadas.
		for (i = 0; i < nf * nc; i++) {
			Casilla cas = new Casilla(i / nc, i % nc); // Se entiende que la
														// matriz no es vacía
														// (0x0)
			if (aleatorio[i] == 1)
				crearCelulaSimple(cas);
			else if (aleatorio[i] == 2)
				crearCelulaCompleja(cas);
		}
	}

	/**
	 * Dada una casilla, crea una celula en dicha posicion.
	 * 
	 * @param casilla
	 *            destino.
	 * @return true si se ha creado la celula. false si no ha sido posible.
	 */

	/**
	 * 
	 * @return numero de filas de la superficie
	 */
	public int getFilas() {
		return filas;
	}

	/**
	 * 
	 * @return numero de columnas de la superficie
	 */
	public int getColumnas() {
		return columnas;
	}

	/**
	 * Dada una casilla crea una celula simple en dicha posicion
	 * 
	 * @param casilla
	 *            destino
	 * @return true si se ha creado, falso si no.
	 */
	public boolean crearCelulaSimple(Casilla casilla) {
		if (superficie[casilla.getX()][casilla.getY()] == null) {
			superficie[casilla.getX()][casilla.getY()] = new CelulaSimple();
			return true;
		} else
			return false;
	}

	/**
	 * Dada una casilla crea una celula compleja en dicha posicion
	 * 
	 * @param casilla
	 *            destino
	 * @return true si se ha creado, falso si no.
	 */
	public boolean crearCelulaCompleja(Casilla casilla) {
		if (superficie[casilla.getX()][casilla.getY()] == null) {
			superficie[casilla.getX()][casilla.getY()] = new CelulaCompleja();
			return true;
		} else
			return false;
	}

	/**
	 * Elimina una celula de una casilla.
	 * 
	 * @param casilla
	 *            origen
	 * @return true si eliminada
	 */
	public boolean eliminarCelula(Casilla casilla) {
		if (superficie[casilla.getX()][casilla.getY()] != null) {
			superficie[casilla.getX()][casilla.getY()] = null;
			return true;
		} else
			return false;
	}

	/**
	 * Elimina todas las celulas de la superficie (pone a null todos los
	 * elementos del array).
	 */
	public void vaciarSuperficie() {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				superficie[i][j] = null;
			}
		}
	}

	/**
	 * Dada una casilla, ejecuta un paso sobre la celula que hay en ella, si aun
	 * no se ha movido en ese turno (mover, reproducirse...)
	 * 
	 * @param origen
	 *            origen
	 */
	public Casilla evolucionarCelulaSimple(Casilla origen) {
		// Si no está vacía y no se ha movido aún.
		Casilla destino = null;
		Casilla[] libres = new Casilla[8]; // Revisar por tema dimension
		int cont = 0;
		int i = origen.getX() - 1;
		int j = origen.getY() - 1;
		int p;
		if (i < 0)
			i = 0;
		if (j < 0)
			j = 0;
		// Genera el array de casillas libres posibles.
		while (i < filas && i <= origen.getX() + 1) {
			p = j;
			while (p < columnas && p <= origen.getY() + 1) {
				if (superficie[i][p] == null) {
					libres[cont] = new Casilla(i, p);
					cont++;
				}
				p++;
			}
			i++;
		}
		if (cont != 0) {
			int aleatorio = (int) (Math.random() * cont);
			destino = new Casilla(libres[aleatorio].getX(),libres[aleatorio].getY()); 
		}
		return destino;
	}

	/*
	 * if(cont == 0){ //No se puede mover //Le toca reproducirse. destino =
	 * null; if(ini.incPasDad()){ eliminarCelula(origen);
	 * System.out.println("Muere la celula de la casilla " + origen +
	 * " por no reproducirse"); } //No le toca reproducirse. Aumentan sus pasos
	 * no dados. else if(ini.incPasNoMov()){ //Decide si debe morir
	 * eliminarCelula(origen);
	 * System.out.println("Muere la celula de la casilla " + origen +
	 * " por falta de actividad."); } } else{ //Se puede mover int aleatorio =
	 * (int)(Math.random()*cont); destino = libres[aleatorio]; //Indica la
	 * casilla a la que se mueve la célula. Celula fin =
	 * superficie[destino.getX()][destino.getY()]; fin = ini;
	 * fin.setMovidoTrue(); System.out.println("Movimiento de " + origen + " a "
	 * + destino); eliminarCelula(origen); //Le toca reproducirse.
	 * if(fin.incPasDad()){ crearCelulaSimple(origen);
	 * System.out.println("Nace nueva celula en " + origen +
	 * " cuyo padre ha sido "+destino); } //No le toca reproducirse. //No hace
	 * nada. } } return destino; }
	 */

	public Casilla evolucionarCelulaCompleja(Casilla origen) {
		int aleatorio = (int) (Math.random() * filas * columnas - 1);
		if (aleatorio >= origen.getX() * columnas + origen.getY())
			aleatorio++; /*
						 * En caso de que la casilla aleatoria esté por delante
						 * o sea la casilla donde se encuentra la célula a
						 * mover, se suma uno, para corregir la posición.
						 */
		Casilla destino = new Casilla(aleatorio / columnas, aleatorio
				% columnas);
		Celula fin = superficie[destino.getX()][destino.getY()];
		Celula ini = superficie[origen.getX()][origen.getY()];
		if (fin == null) {
			fin = ini;
			eliminarCelula(origen);
			fin.setMovidoTrue();
		} else if (fin.esComestible) {
			if (ini.comidas())
				fin = ini;
			eliminarCelula(origen);
			fin.setMovidoTrue();

		}
	}

	/**
	 * Pone a todas las celulas de las superficie su indicador de movimiento a
	 * false.
	 */
	public void setSuperficieFalse() {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (superficie[i][j] != null)
					superficie[i][j].setMovidoFalse();
			}
		}
	}

	/**
	 * Genera y devuelve un String en forma de tabla con la informacion de todas
	 * las casillas de la superficie.
	 */
	public String toString() {
		String tabla = "\n";
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (superficie[i][j] == null)
					tabla += "-";
				else
					tabla += superficie[i][j].toString();
				tabla += " ";
			}
			tabla += "\n";
		}
		return tabla;
	}
}