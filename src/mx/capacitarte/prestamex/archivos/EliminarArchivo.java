package mx.capacitarte.prestamex.archivos;

import java.io.File;

public class EliminarArchivo {

	final static String RUTA_ARCHIVO_GENERADO ="C:\\dev\\java\\out\\";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File(RUTA_ARCHIVO_GENERADO + "primerarchivo.txt");
		if (file.delete()) {
			System.out.println("se elimino el archivo " + file.getName());
		} else {
			System.out.println("error al eliminar el archivo");
	}
	}
}
