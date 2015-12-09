package tp.pr2.control;
import tp.pr2.logica.*;

public class Ayuda extends Comando {
	public final String AYUDA = "AYUDA";
	public void ejecuta(Mundo mundo){
		System.out.print(ParserComandos.AyudaComandos());
	}

	public String textoAyuda(){
		return ("Muestra esta ayuda.");	
	}
	public Comando parsea(String[] cadenaComando){
		if (cadenaComando.length != 1) return null;
		else if (cadenaComando[0].equals(AYUDA)) return this;
		else return null;
	}
}
