package mx.capacitarte.prestamex.archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LeerArchivo {

	final static String RUTA_ARCHIVO_GENERADO ="C:\\dev\\java\\out\\";
	public static void main(String[] args) {
		try {
			File file = new File(RUTA_ARCHIVO_GENERADO + "primerarchivo.txt");
			Scanner leer = new Scanner (file);
			while (leer.hasNextLine()) {
				String data = leer.nextLine();
				System.out.println(data);
			}
		}catch (FileNotFoundException e) {
			System.out.println("a ocurrido una excepcion");
			e.printStackTrace();
		}
	}
}
