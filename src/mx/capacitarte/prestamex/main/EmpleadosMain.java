package mx.capacitarte.prestamex.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mx.capacitarte.prestamex.beans.ClienteBean;
import mx.capacitarte.prestamex.beans.EmpleadoBean;
import mx.capacitarte.prestamex.service.EmpleadoService;

public class EmpleadosMain {

	public static void main(String[] args) {
		System.out.println("Inicia programa");

		System.out.println("Cargando empleados...");
		EmpleadoService empleadoService = new EmpleadoService();
		//List<EmpleadoBean> empleadosCargados = new ArrayList<>();//empleadoService.cargarEmpleados();
		System.out.println("Termina carga de empleados");
		
		mostrarMenu();
		
		/*empleadoService.mostrarEmpleados(empleadosCargados);
		
		String nombreBuscar = "Andres";
		System.out.println("\nBuscando empleado: " + nombreBuscar);
		List<EmpleadoBean> empleadosEncontrados = empleadoService.buscarEmpleadosPorNombre(empleadosCargados, nombreBuscar);
		empleadoService.mostrarEmpleados(empleadosEncontrados);
		System.out.println("");
		*/
		
		System.out.println("Termina programa");
	}

	private static void mostrarMenu() {
		EmpleadoService empleadoService = new EmpleadoService();
		System.out.println("*****  Menu *****");
		System.out.println("1.- Buscar por nombre");
		System.out.println("2.- Buscar por número de empleado");
		System.out.println("3.- Buscar por genero");
		System.out.println("4.- Buscar por vigencia");
		System.out.println("5.- Agregar empleado");
		System.out.println("6.- Salir");
		System.out.print("\n Que desea hacer: ");
		Scanner scanner = new Scanner(System.in);
		int opcionElegida = scanner.nextInt();
		List<EmpleadoBean> empleadosEncontrados = new ArrayList<>();
		
		switch (opcionElegida) {
		case 1: 
			System.out.print("Nombre buscar: ");
			String nombreBuscar = scanner.next();
			System.out.println("Iniciando busqueda del nombre: " + nombreBuscar);
			empleadosEncontrados = empleadoService.buscarEmpleadosPorNombre(nombreBuscar);
			empleadoService.mostrarEmpleados(empleadosEncontrados);
			break;
			
		case 2:
			System.out.print("Número de empleado: ");
			Integer numeroEmpleado = scanner.nextInt();
			empleadosEncontrados = empleadoService.buscarEmpleado(numeroEmpleado);
			empleadoService.mostrarEmpleados(empleadosEncontrados);
			break;
			
		case 3:
			System.out.print("Genero buscar: ");
			String genero = scanner.next();
			empleadosEncontrados = empleadoService.buscarEmpleado(genero);
			empleadoService.mostrarEmpleados(empleadosEncontrados);
			break;
			
		case 4:
			System.out.print("Vigencia: 1-Activo : 2-Inactivo: ");
			Integer vigencia = scanner.nextInt();
			Boolean esVigente = vigencia.intValue() == 1 ? true : false;
			empleadosEncontrados = empleadoService.buscarEmpleado(esVigente);
			empleadoService.mostrarEmpleados(empleadosEncontrados);
			break;
		case 5:
			System.out.print("ingrese el número del empleado: ");
			Integer numEmpleado = scanner.nextInt();
			System.out.print("ingrese el nombre del empleado: ");
			String nombre = scanner.next();
			System.out.print("ingrese apellido paterno: ");
			String apellidoPaterno = scanner.next();
			System.out.print("ingrese apellido materno: ");
			String apellidoMaterno = scanner.next();
			System.out.print("ingrese fecha de nacimiento: ");
			String fechaNacimiento = scanner.next();
			System.out.print("ingrese puesto: ");
			String puesto = scanner.next();
			System.out.print("ingrese departamento: ");
			String departamento = scanner.next();
			System.out.print("ingrese genero: ");
			String empleadoGenero = scanner.next();
			System.out.print("ingrese fecha de ingreso: ");
			String fechaIngreso = scanner.next();
			System.out.print("ingrese sueldo: ");
			double sueldo = scanner.nextInt();
			System.out.print("vigencia: ");
			String empleadoVigencia = scanner.next();
			
			EmpleadoBean empleadoAgregar = new EmpleadoBean();
			empleadoAgregar.setNumeroEmpleado(numEmpleado);
			empleadoAgregar.setNombre(nombre);
			empleadoAgregar.setApellidoPaterno(apellidoPaterno);
			empleadoAgregar.setApellidoMaterno(apellidoMaterno);
			empleadoAgregar.setFechaNacimiento(fechaNacimiento);
			empleadoAgregar.setPuesto(puesto);
			empleadoAgregar.setDepartamento(departamento);
			empleadoAgregar.setGenero(empleadoGenero);
			empleadoAgregar.setFechaIngreso(fechaIngreso);
			empleadoAgregar.setSueldo(sueldo);
			empleadoAgregar.setVigencia(empleadoVigencia.equals("1") ? true : false);
			
			Boolean respuesta = empleadoService.agregarEmpleados(empleadoAgregar);
			System.out.println(respuesta ? "El empleado fue agregado correctamente" : "Ocurrió un error al agregar al cliente");
			
			break;
		case 6:
			System.out.println("Termina programa");
			System.exit(0);
		default:
			System.out.println("Opcion invalida");
		}
		
		mostrarMenu();
	}
}
