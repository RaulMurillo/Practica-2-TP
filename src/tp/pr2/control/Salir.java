package tp.pr2.control;
import tp.pr2.logica.*;
/**
 * Clase que implementa el comando salir
 * @version 1.0, 07/12/2015
 * @author Raul Murillo Montero
 * @author Antonio Valdivia de la Torre
 */
public class Salir extends Comando{
	public void ejecuta(Mundo mundo){
		
	}
	public String TextoAyuda(){
		return("Cierra la aplicacion");
	}
	public Comando parsea(String[] cadenaComando){
		
	}
}
