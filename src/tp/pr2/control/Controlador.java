package tp.pr2.control;

import tp.pr2.logica.*;

import java.util.Scanner;

/**
 * Esta clase contiene el interprete de los posibles comandos que se pueden
 * ejecutar en consola.
 * 
 * @version 1.0, 07/11/2015
 * @author Raul Murillo Montero
 * @author Antonio Valdivia de la Torre
 */

public class Controlador {
	private Mundo mundo; // Mundo sobre el que ejecutar los comandos.
	private Scanner in; // Scanner para realizar las operaciones de lectura.

	/**
	 * Inicializa los atributos.
	 * 
	 * @param mundo
	 *            sobre el que se ejecutaran los comandos.
	 * @param in
	 *            Scanner para realizar las operaciones de lectura.
	 */
	public Controlador(Mundo mundo, Scanner in) {
		this.mundo = mundo;
		this.in = in;
	}

	/**
	 * Consiste en bucle en el que se pide un comando al usuario y se ejecuta
	 * dicho comando.
	 */
	public void realizarSimulacion() {
		String cadena;
		do {
			mostrar();
			System.out.print("Comando > ");
			cadena = in.nextLine();
			/*
			 * Convierto todo a mayúsculas
			 * (http://www.forosdelweb.com/f13/validar-palabra-sin-importar-
			 * mayuscula-minuscula-511492/)
			 */
			cadena = cadena.toUpperCase();
			String [] array = cadena.split("\\s+");
			Comando comando = ParserComandos.parseaComando(array);
			if (comando != null) {
				comando.ejecuta(mundo);
			} else
				System.out.println("Comando no válido.");
		} while (!mundo.getSimulacionTerminada()); // El bucle termina cuando el
													// usuario teclea el comando
													// SALIR, que pone el
													// booleano a true.
		System.out.println("Fin de la simulación...");
	}

	/**
	 * Muestra por pantalla el mundo.
	 */
	public void mostrar() {
		System.out.println(mundo);
	}
}
