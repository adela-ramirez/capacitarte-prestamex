package mx.capacitarte.prestamex.archivos;

import java.io.FileWriter;
import java.io.IOException;

public class EscribirEnArchivo {

	final static String RUTA_ARCHIVO_GENERADO ="C:\\dev\\java\\out\\";
	public static void main(String[] args) {
		try {
			FileWriter myWriter = new FileWriter(RUTA_ARCHIVO_GENERADO + "primerarchivo.txt");
			myWriter.write("hola .. mi primer mensaje");
			myWriter.close();
			System.out.println("se escribio correctamente");
		}catch (IOException e) {
			System.out.println("a ocurrido una excepcion");
			e.printStackTrace();
		}
	}
}
