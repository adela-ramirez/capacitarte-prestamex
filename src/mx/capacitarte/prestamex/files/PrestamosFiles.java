package mx.capacitarte.prestamex.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import mx.capacitarte.prestamex.beans.PrestamoBean;
import mx.capacitarte.prestamex.commons.Constantes;

public class PrestamosFiles {
	
	public List<PrestamoBean> leerArchivoPrestamos() {
		List<PrestamoBean> prestamos = new ArrayList<>();

		File file = new File(Constantes.RUTA_ARCHIVO_PRESTAMEX_PRESTAMOS);

		if (!file.exists()) {
			System.out.println("El archivo " + Constantes.RUTA_ARCHIVO_PRESTAMEX_PRESTAMOS + " no existe");
			return prestamos;
		}

		try {
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String valores = scanner.nextLine();
				// System.out.println(valores);

				String[] datos = valores.split(Pattern.quote("|"));

				PrestamoBean prestamoBean = new PrestamoBean();
				prestamoBean.setNumeroPrestamo(Integer.parseInt(datos[0]));
				prestamoBean.setNumeroEmpleado(Integer.parseInt(datos[1]));
				prestamoBean.setNumeroUsuario(Integer.parseInt(datos[2]));
				prestamoBean.setNumeroCliente(Integer.parseInt(datos[3]));
				prestamoBean.setMontoPrestamo(Double.parseDouble(datos[4]));
				prestamoBean.setPlazo(Integer.parseInt(datos[5]));
				prestamoBean.setIntereses(Double.parseDouble(datos[6]));
				prestamoBean.setPagos(Double.parseDouble(datos[7]));
				prestamoBean.setTotalPagar(Double.parseDouble(datos[8]));
				prestamoBean.setFechaSolicitud(datos[9]);
				prestamoBean.setVigencia(datos[10].equals("1") ? true : false);
	


				prestamos.add(prestamoBean);
			}

			scanner.close();

		} catch (FileNotFoundException e) {
			System.out.println("Ocurrió una excepcion");
			e.printStackTrace();
		}

		return prestamos;
	}


	public Boolean agregarPrestamo(PrestamoBean prestamoNuevoBean) {
	
		System.out.println("Recuperando a todos los prestamos actuales en el archivo");
		List<PrestamoBean> prestamosActuales = leerArchivoPrestamos();
		
		//Agregar prestamo nuevo a la lista de prestamos actuales: 2
		System.out.println("Agregando prestamo nuevo a la lista");
		prestamosActuales.add(prestamoNuevoBean);
		
		//Escribir en el archivo
		try {
			FileWriter myWriter = new FileWriter(Constantes.RUTA_ARCHIVO_PRESTAMEX_PRESTAMOS);
			
			for (PrestamoBean prestamoBean : prestamosActuales) {
				System.out.println(":::: Agregando prestamo");
				myWriter.write(prestamoBean.salidaArchivoPlano());
			}
			System.out.println("Terminó de agregar presstamo al archivo");
			myWriter.close();
		}catch (IOException e) {
			System.out.println("a ocurrido una excepcion");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
