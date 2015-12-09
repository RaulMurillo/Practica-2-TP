package tp.pr2.control;

public class ParserComandos {
	public/**/ static Comando[] comandos = { new Ayuda(), new Paso(), new EliminarCelula(0, 0),
			new CrearCelulaSimple(0, 0), new CrearCelulaCompleja(0, 0), new Iniciar(), new Salir(), new Vaciar() };

	static public String AyudaComandos() {
		String cadena = "";
		for (Comando i : comandos) {
			cadena += i.textoAyuda() + "\n";
		}
		return cadena;
	}

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
