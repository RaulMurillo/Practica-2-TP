package tp.pr2.control;
import tp.pr2.logica.*;

/**
 * Clase que implementa el comando ayuda
 * 
 * @version 1.1, 09/12/2015
 * @author Raul Murillo Montero
 * @author Antonio Valdivia de la Torre
 */
public class Ayuda extends Comando {
	public final String AYUDA = "AYUDA";
	/**
	 * Metodo que ejecuta el comando ayuda mostrando las lineas de ayuda.
	 */
	public void ejecuta(Mundo mundo){
		System.out.print(ParserComandos.AyudaComandos());
	}
	/**
	 * @return devuelve el texto correspondiente al comando ayuda
	 */
	public String textoAyuda(){
		return ("AYUDA: Muestra esta ayuda");	
	}
	/**
	 * @return el comando Ayuda si el array de strings se corresponde
	 * con este, null en otro caso
	 */
	public Comando parsea(String[] cadenaComando){
		if (cadenaComando.length != 1) return null;
		else if (cadenaComando[0].equals(AYUDA)) return this;
		else return null;
	}
}
