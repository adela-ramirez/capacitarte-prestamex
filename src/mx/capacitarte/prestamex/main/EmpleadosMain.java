package mx.capacitarte.prestamex.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mx.capacitarte.prestamex.beans.EmpleadoBean;
import mx.capacitarte.prestamex.service.EmpleadoService;

public class EmpleadosMain {

	public static void main(String[] args) {
		System.out.println("Inicia programa");

		System.out.println("Cargando empleados...");
		EmpleadoService empleadoService = new EmpleadoService();
		List<EmpleadoBean> empleadosCargados = new ArrayList<>();//empleadoService.cargarEmpleados();
		System.out.println("Termina carga de empleados");
		
		mostrarMenu(empleadosCargados);
		
		/*empleadoService.mostrarEmpleados(empleadosCargados);
		
		String nombreBuscar = "Andres";
		System.out.println("\nBuscando empleado: " + nombreBuscar);
		List<EmpleadoBean> empleadosEncontrados = empleadoService.buscarEmpleadosPorNombre(empleadosCargados, nombreBuscar);
		empleadoService.mostrarEmpleados(empleadosEncontrados);
		System.out.println("");
		*/
		
		System.out.println("Termina programa");
	}

	private static void mostrarMenu(List<EmpleadoBean> empleadosCargados) {
		EmpleadoService empleadoService = new EmpleadoService();
		System.out.println("*****  Menu *****");
		System.out.println("1.- Buscar por nombre");
		System.out.println("2.- Buscar por número de empleado");
		System.out.println("3.- Buscar por genero");
		System.out.println("4.- Buscar por vigencia");
		System.out.println("5.- Salir");
		Scanner scanner = new Scanner(System.in);
		int opcionElegida = scanner.nextInt();
		List<EmpleadoBean> empleadosEncontrados = new ArrayList<>();
		
		switch (opcionElegida) {
		case 1: 
			System.out.println("Nombre buscar:");
			String nombreBuscar = scanner.next();
			System.out.println("Iniciando busqueda del nombre: " + nombreBuscar);
			empleadosEncontrados = empleadoService.buscarEmpleadosPorNombre(nombreBuscar);
			empleadoService.mostrarEmpleados(empleadosEncontrados);
			break;
			
		case 2:
			System.out.println("Número de empleado:\n");
			Integer numeroEmpleado = scanner.nextInt();
			empleadosEncontrados = empleadoService.buscarEmpleado(numeroEmpleado);
			empleadoService.mostrarEmpleados(empleadosEncontrados);
			break;
			
		case 3:
			System.out.println("Genero buscar:\n");
			String genero = scanner.next();
			empleadosEncontrados = empleadoService.buscarEmpleado(genero);
			empleadoService.mostrarEmpleados(empleadosEncontrados);
			break;
			
		case 4:
			System.out.println("Vigencia: 1-Activo : 2-Inactivo\n");
			Integer vigencia = scanner.nextInt();
			Boolean esVigente = vigencia.intValue() == 1 ? true : false;
			empleadosEncontrados = empleadoService.buscarEmpleado(esVigente);
			empleadoService.mostrarEmpleados(empleadosEncontrados);
			break;
			
		case 5:
			System.out.println("Termina programa");
			System.exit(0);
		default:
			System.out.println("Opcion invalida");
		}
		
		mostrarMenu(empleadosCargados);
	}
}
