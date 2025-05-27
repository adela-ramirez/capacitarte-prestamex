package mx.capacitarte.prestamex.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mx.capacitarte.prestamex.beans.ClienteBean;
import mx.capacitarte.prestamex.beans.EmpleadoBean;
import mx.capacitarte.prestamex.service.ClienteService;
import mx.capacitarte.prestamex.service.EmpleadoService;

public class ClientesMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Inicia programa");

		System.out.println("Cargando clientes...");
		ClienteService clienteService = new ClienteService();
		//List<ClienteBean> clientesCargados = new ArrayList<>(); //clienteService.cargarClientes();
		System.out.println("Termina carga de clientes");
		
		
		// se invoca el metodo para mostrar el menu
		mostrarMenu();
		
		/*clienteService.mostrarClientes(clientesCargados);
		
		String nombreBuscar = "Alicia";
		System.out.println("\nBuscando cliente: " + nombreBuscar);
		List<ClienteBean> clientesEncontrados = clienteService.buscarClientesPorNombre(clientesCargados, nombreBuscar);
		clienteService.mostrarClientes(clientesEncontrados);
		System.out.println("");
		*/
		System.out.println("Termina programa");

	}
	
	
	private static void mostrarMenu() {
		ClienteService clienteService = new ClienteService();
		System.out.println("*****  Menu *****");
		System.out.println("1.- Buscar por nombre");
		System.out.println("2.- Buscar por número de cliente");
		System.out.println("3.- Agregar cliente");
		System.out.println("4.- Salir");
		Scanner scanner = new Scanner(System.in);
		int opcionElegida = scanner.nextInt();
		List<ClienteBean> clientesEncontrados = new ArrayList<>();
		
		switch (opcionElegida) {
		case 1: 
			System.out.println("Nombre buscar:");
			String nombreBuscar = scanner.next();
			System.out.println("Iniciando busqueda del nombre: " + nombreBuscar);
			clientesEncontrados = clienteService.buscarClientesPorNombre(nombreBuscar);
			clienteService.mostrarClientes(clientesEncontrados);
			break;	
		case 2:
			System.out.println("Número de cliente:\n");
			Integer numeroCliente = 0;
            try {
                numeroCliente = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Ocurrió una excepcion");
            }
			clientesEncontrados = clienteService.buscarCliente(numeroCliente);
			clienteService.mostrarClientes(clientesEncontrados);
			break;
		case 3:
			System.out.println("ingrese el número del cliente");
			Integer numCliente = scanner.nextInt();
			System.out.println("ingrese el nombre del cliente");
			String nombre = scanner.next();
			System.out.println("ingrese apellido paterno");
			String apellidoPaterno = scanner.next();
			System.out.println("ingrese apellido materno");
			String apellidoMaterno = scanner.next();
			System.out.println("ingrese fecha de nacimiento");
			String fechaNacimiento = scanner.next();
			System.out.println("ingrese genero");
			String genero = scanner.next();
			System.out.println("ingrese rfc");
			String rfc = scanner.next();
			System.out.println("ingrese telefono");
			String telefono = scanner.next();
			System.out.println("ingrese correo electronico");
			String correoElectronico = scanner.next();
			System.out.println("domicilio");
			String domiclio = scanner.next();
			System.out.println("vigencia");
			String vigencia = scanner.next();
			
			ClienteBean clienteAgregar = new ClienteBean();
			clienteAgregar.setNumeroCliente(numCliente);
			clienteAgregar.setNombre(nombre);
			clienteAgregar.setApellidoPaterno(apellidoPaterno);
			clienteAgregar.setApellidoMaterno(apellidoMaterno);
			clienteAgregar.setFechaNacimiento(fechaNacimiento);
			clienteAgregar.setGenero(genero);
			clienteAgregar.setRfc(rfc);
			clienteAgregar.setTelefono(telefono);
			clienteAgregar.setCorreoElectronico(correoElectronico);
			clienteAgregar.setDomicilio(domiclio);
			clienteAgregar.setVigencia(vigencia.equals("1") ? true : false);
			
			Boolean respuesta = clienteService.agregarClientes(clienteAgregar);
			System.out.println(respuesta ? "El cliente fue agregado correctamente" : "Ocurrió un error al agregar al cliente");
			
			break;
		case 4:
			System.out.println("Termina programa");
			System.exit(0);
		default:
			System.out.println("Opcion invalida");
		}
		
		// se invoca el metodo para mostrar el menu
		mostrarMenu();
	}

}
