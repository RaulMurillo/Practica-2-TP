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
	// Posibles comandos:
	public final String PASO = "PASO";
	public final String INICIAR = "INICIAR";
	public final String CREARCELULA = "CREARCELULA";
	public final String ELIMINARCELULA = "ELIMINARCELULA";
	public final String AYUDA = "AYUDA";
	public final String VACIAR = "VACIAR";
	public final String SALIR = "SALIR";

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
		String comando;
		do {
			mostrar();
			System.out.print("Comando > ");
			comando = in.next();
			/*
			 * Convierto todo a mayúsculas
			 * (http://www.forosdelweb.com/f13/validar-palabra-sin-importar-
			 * mayuscula-minuscula-511492/)
			 */
			comando = comando.toUpperCase();
			if (comando.equals(PASO)) {
				mundo.evoluciona();
			} else if (comando.equals(INICIAR)) {
				mundo = new Mundo();
				System.out.println("Iniciando la superficie...");
			} else if (comando.equals(CREARCELULA)) {
				int x = in.nextInt();
				int y = in.nextInt();
				if (!mundo.crearCelula/*Simple*/(x, y))
					System.out.println("Imposible crear celula, posición no válida.");
				else
					System.out.println("Creamos nueva celula en la posición: (" + x + "," + y + ")");
			} else if (comando.equals(ELIMINARCELULA)) {
				int x = in.nextInt();
				int y = in.nextInt();
				if (!mundo.eliminarCelula(x, y))
					System.out.println("Imposible eliminar celula, posición no válida.");
				else
					System.out.println("Se ha eliminado la célula de la posición: (" + x + "," + y + ")");
			} else if (comando.equals(AYUDA)) {
				System.out.println("POSIBLES COMANDOS: \n" + "  PASO: realiza un paso en la simulacion \n"
						+ "  AYUDA: muestra esta ayuda \n" + "  SALIR: cierra la aplicación \n"
						+ "  INICIAR: inicia una nueva simulación \n" + "  VACIAR: crea un mundo vacío \n"
						+ "  CREARCELULA F C: crea una nueva celula en la posición (f,c) si es posible \n"
						+ "  ELIMINARCELULA F C: elimina una celula de la posición (f,c) si es posible \n");
			} else if (comando.equals(VACIAR)) {
				mundo.vaciarMundo();
				System.out.println("Vaciando la superficie...");
			} else if (!comando.equals(SALIR)) { // Si el comando es incorrecto
													// se muestra un mensaje de
													// error.
				System.out.println("Comando no válido.");
			}
		} while (!comando.equals(SALIR)); // El bucle termina cuando el usuario
											// teclea el comando SALIR.
		System.out.println("Fin de la simulación...");
	}

	/**
	 * Muestra por pantalla el mundo.
	 */
	public void mostrar() {
		System.out.println(mundo);
	}
}
