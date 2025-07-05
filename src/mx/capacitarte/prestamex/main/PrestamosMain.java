package mx.capacitarte.prestamex.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mx.capacitarte.prestamex.beans.PrestamoBean;
import mx.capacitarte.prestamex.service.PrestamoService;

public class PrestamosMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Inicia programa");

		mostrarMenu();

		System.out.println("Termina programa");

	}

	private static void mostrarMenu() {
		PrestamoService prestamoService = new PrestamoService();
		System.out.println("*****  Menu *****");
		System.out.println("1.- Buscar por numero usuario");
		System.out.println("2.- Buscar por número de prestamo");
		System.out.println("3.- Buscar por número de cliente");
		System.out.println("4.- Agregar prestamo");
		System.out.println("5.- Salir");
		Scanner scanner = new Scanner(System.in);
		int opcionElegida = scanner.nextInt();
		List<PrestamoBean> prestamosEncontrados = new ArrayList<>();

		switch (opcionElegida) {
		case 1:
			System.out.println("Numero de usuario:");
			Integer numeroUsuario = scanner.nextInt();
			System.out.println("Iniciando busqueda del numero de usuario: " + numeroUsuario);
			prestamosEncontrados = prestamoService.buscarPrestamosPorUsuario(numeroUsuario);
			prestamoService.mostrarPrestamos(prestamosEncontrados);
			break;
		case 2:
			System.out.println("Número de prestamo:\n");
			Integer numeroPrestamo = 0;
			try {
				numeroPrestamo = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("Ocurrió una excepcion");
			}
			prestamosEncontrados = prestamoService.buscarPrestamo(numeroPrestamo);
			prestamoService.mostrarPrestamos(prestamosEncontrados);
			break;
		case 3:
			System.out.println("Numero de cliente:");
			Integer numeroCliente = scanner.nextInt();
			System.out.println("Iniciando busqueda del numero de cliente: " + numeroCliente);
			prestamosEncontrados = prestamoService.buscarPrestamoPorCliente(numeroCliente);
			prestamoService.mostrarPrestamos(prestamosEncontrados);
			break;
		case 4:
			System.out.println("ingrese el número del prestamo");
			Integer numPrestamo = scanner.nextInt();
			System.out.println("ingrese el número del usuario");
			Integer _numeroUsuario = scanner.nextInt();
			System.out.println("ingrese el número del cliente");
			Integer numCliente = scanner.nextInt();
			System.out.println("ingrese el nuero de empleado");
			Integer numeroEmpleado = scanner.nextInt();
			System.out.print("ingrese monto del prestamo: ");
			double montoPrestamo = scanner.nextInt();
			System.out.println("ingrese plazo");
			Integer plazo = scanner.nextInt();
			System.out.println("ingrese fecha de solicitud");
			String fechaSolicitud = scanner.next();

			PrestamoBean prestamoAgregar = new PrestamoBean();
			prestamoAgregar.setNumeroPrestamo(numPrestamo);
			prestamoAgregar.setNumeroUsuario(_numeroUsuario);
			prestamoAgregar.setNumeroCliente(numCliente);
			prestamoAgregar.setNumeroEmpleado(numeroEmpleado);
			prestamoAgregar.setMontoPrestamo(montoPrestamo);
			prestamoAgregar.setPlazo(plazo);
			prestamoAgregar.setFechaSolicitud(fechaSolicitud);
			prestamoAgregar.setVigencia(true);

			Boolean respuesta = prestamoService.agregarPrestamos(prestamoAgregar);
			System.out.println(
					respuesta ? "El prestamo fue agregado correctamente" : "Ocurrió un error al agregar al prestamo");

			break;
		case 5:
			System.out.println("Termina programa");
			System.exit(0);
		default:
			System.out.println("Opcion invalida");
		}

		// se invoca el metodo para mostrar el menu
		mostrarMenu();
	}

}
