package tp.pr2.control;

import tp.pr2.logica.Mundo;

/**
 * Clase que implementa el comando eliminar celula con atributos f, c para
 * indicar de que casilla se eliminara.
 * @version 1.0, 07/12/2015
 * @author Raul Murillo Montero
 * @author Antonio Valdivia de la Torre
 */
public class EliminarCelula extends Comando{
	private int f;
	private int c;
	/**
	 * Constructor de la clase
	 * @param fila
	 * @param columna
	 */
	public EliminarCelula(int fila, int columna){
		f=fila;
		c=columna;
	}
	/**
	 * Elimina la celula de la casilla (f,c) si es posible,
	 * si no muestra un mensaje de error
	 * @param mundo
	 */
	public void ejecuta(Mundo mundo){
		if(!mundo.eliminarCelula(f, c)){
			System.out.println("No se pudo eliminar la celula, "
					+ "posicion no valida");
		}
	}
	/**
	 * 
	 * @return Devuelve el codigo de ayuda referente a Eliminar celula.
	 */
	public String textoAyuda() {
		return ("Elimina la celula de la casilla (f, c) si es posible.");
	}
	public Comando parsea(String[] cadenaComando){
		
	}
}
