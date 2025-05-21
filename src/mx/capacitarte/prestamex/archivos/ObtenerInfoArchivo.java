package mx.capacitarte.prestamex.archivos;

import java.io.File;

public class ObtenerInfoArchivo {

	final static String RUTA_ARCHIVO_GENERADO ="C:\\dev\\java\\out\\";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File(RUTA_ARCHIVO_GENERADO + "primerarchivo.txt");
		if (file.exists()) {
			System.out.println("nombre de archivo " + file.getName());
			System.out.println("ruta completa " + file.getAbsolutePath());
			System.out.println("permiso de escritura " + file.canWrite());
			System.out.println("permiso de lectura " + file.canRead());
			System.out.println("tamaño de archivo en bytes " + file.length());
		} else {
			System.out.println("el archivo no existe");
		}
		
		
	}

}
