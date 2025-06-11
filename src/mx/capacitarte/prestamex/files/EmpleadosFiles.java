package mx.capacitarte.prestamex.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import mx.capacitarte.prestamex.beans.ClienteBean;
import mx.capacitarte.prestamex.beans.EmpleadoBean;
import mx.capacitarte.prestamex.commons.Constantes;

public class EmpleadosFiles {

	// leer archivo empleados
	public List<EmpleadoBean> leerArchivoEmpleados() {
		List<EmpleadoBean> empleados = new ArrayList<>();

		File file = new File(Constantes.RUTA_ARCHIVO_PRESTAMEX_EMPLEADOS);

		if (!file.exists()) {
			System.out.println("El archivo " + Constantes.RUTA_ARCHIVO_PRESTAMEX_EMPLEADOS + " no existe");
			return empleados;
		}

		try {
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String valores = scanner.nextLine();
				// System.out.println(valores);

				String[] datos = valores.split(Pattern.quote("|"));

				EmpleadoBean empleadoBean = new EmpleadoBean();
				empleadoBean.setNumeroEmpleado(Integer.parseInt(datos[0]));
				empleadoBean.setNombre(datos[1]);
				empleadoBean.setApellidoPaterno(datos[2]);
				empleadoBean.setApellidoMaterno(datos[3]);
				empleadoBean.setFechaNacimiento(datos[4]);
				empleadoBean.setPuesto(datos[5]);
				empleadoBean.setDepartamento(datos[6]);
				empleadoBean.setGenero(datos[7]);
				empleadoBean.setFechaIngreso(datos[8]);
				empleadoBean.setSueldo(Double.parseDouble(datos[9]));
				empleadoBean.setVigencia(datos[10].equals("1") ? true : false);

				empleados.add(empleadoBean);
			}

			scanner.close();

		} catch (FileNotFoundException e) {
			System.out.println("Ocurrió una excepcion");
			e.printStackTrace();
		}

		return empleados;
	}

	public Boolean agregarEmpleado(EmpleadoBean empleadoNuevoBean) {
	System.out.println("Recuperando a todos los empleados actuales en el archivo");
	List<EmpleadoBean> empleadosActuales = leerArchivoEmpleados();
	
	//Agregar cliente nuevo a la lista de clientes actuales: 2
	System.out.println("Agregando empleado nuevo a la lista");
	empleadosActuales.add(empleadoNuevoBean);
	
	//Escribir en el archivo
	try {
		FileWriter myWriter = new FileWriter(Constantes.RUTA_ARCHIVO_PRESTAMEX_EMPLEADOS);
		
		for (EmpleadoBean empleadoBean : empleadosActuales) {
			System.out.println(":::: Agregando empleado");
			myWriter.write(empleadoBean.salidaArchivoPlano());
		}
		System.out.println("Terminó de agregar empleado al archivo");
		myWriter.close();
	}catch (IOException e) {
		System.out.println("a ocurrido una excepcion");
		e.printStackTrace();
		return false;
	}
	
	return true;
}

}
