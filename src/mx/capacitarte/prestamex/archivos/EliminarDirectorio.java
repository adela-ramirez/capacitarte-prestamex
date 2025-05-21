package mx.capacitarte.prestamex.archivos;

import java.io.File;

public class EliminarDirectorio {

	final static String RUTA_ARCHIVO_GENERADO ="C:\\dev\\java\\out\\test";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File(RUTA_ARCHIVO_GENERADO);
		if (file.delete()) {
			System.out.println("se elimino la carpeta " + file.getName());
		} else {
			System.out.println("error al eliminar la carpeta");
	}
		
		
	}

}
