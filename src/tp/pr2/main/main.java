package tp.pr2.main;

import tp.pr2.control.*;
import tp.pr2.logica.*;

import java.util.Scanner;

/**
 * Es la clase que contiene el metodo main de la practica.
 * 
 * @version 1.0, 07/11/2015
 * @author Raul Murillo Montero
 * @author Antonio Valdivia de la Torre
 */
public class main {

	/**
	 * Crea el mundo, el controlador y realiza la simulacion.
	 * 
	 * @param args
	 *            .
	 */
	public static void main(String[] args) {
		Mundo mundo = new Mundo();
		Scanner in = new Scanner(System.in);
		Controlador controlador = new Controlador(mundo, in);
		controlador.realizarSimulacion();
	}
}
