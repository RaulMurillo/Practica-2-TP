package tp.pr2.control;

/**
 * Esta clase es la encargada de parsear un array de String y construir el
 * comando al que hace referencia dicho String
 * 
 * @version 1.0, 09/12/2015
 * @author Raul Murillo Montero
 * @author Antonio Valdivia de la Torre
 */
public class ParserComandos {
	// Array con todos los comandos
	private static Comando[] comandos = { new Paso(), new EliminarCelula(0, 0),
			new CrearCelulaSimple(0, 0), new CrearCelulaCompleja(0, 0),
			new Iniciar(), new Vaciar(), new Salir(), new Ayuda() };

	/**
	 * 
	 * @return el string con el texto de ayuda que se muestra al seleccionar el
	 *         comando ayuda
	 */
	static public String AyudaComandos() {
		String cadena = "";
		for (Comando i : comandos) {
			cadena += i.textoAyuda() + "\n";
		}
		return cadena;
	}

	/**
	 * 
	 * @param cadenas
	 * @return el comando resultante de parsear el array de strings cadena o
	 *         null en caso de que no se corresponda con ningun comando
	 */
	static public Comando parseaComando(String[] cadenas) {
		int i = 0;
		Comando comando = null;
		while (i < comandos.length && comando == null) {
			comando = comandos[i].parsea(cadenas);
			i++;
		}
		return comando;
	}
}
