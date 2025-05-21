package mx.capacitarte.prestamex.archivos;

import java.io.File;
import java.io.IOException;

public class CrearArchivo {
	
	final static String RUTA_ARCHIVO_GENERADO ="C:\\dev\\java\\out\\";
	
	public static void main(String[] args) {
		try {
			File file = new File(RUTA_ARCHIVO_GENERADO + "primerarchivo.txt");
			if (file.createNewFile()) {
				System.out.println("archivo creado" + file.getName());
			}else {
				System.out.println("el archivo ya existe");
			}
		} catch (IOException e) {
			System.out.println("a ocurrido una excepcion");
			e.printStackTrace();
		}
	}
}
