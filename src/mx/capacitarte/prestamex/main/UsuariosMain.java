package mx.capacitarte.prestamex.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mx.capacitarte.prestamex.beans.ClienteBean;
import mx.capacitarte.prestamex.beans.UsuarioBean;
import mx.capacitarte.prestamex.service.ClienteService;
import mx.capacitarte.prestamex.service.UsuarioService;

public class UsuariosMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Inicia programa");

		System.out.println("Cargando usuarios...");
		UsuarioService usuarioService = new UsuarioService();
		List<UsuarioBean> usuariosCargados = usuarioService.cargarUsuarios();
		System.out.println("Termina carga de usuarios");
		
		
		
		mostrarMenu(usuariosCargados);
		
		/*clienteService.mostrarClientes(clientesCargados);
		
		String nombreBuscar = "Alicia";
		System.out.println("\nBuscando cliente: " + nombreBuscar);
		List<ClienteBean> clientesEncontrados = clienteService.buscarClientesPorNombre(clientesCargados, nombreBuscar);
		clienteService.mostrarClientes(clientesEncontrados);
		System.out.println("");
		*/
		System.out.println("Termina programa");

	}
	
	
	private static void mostrarMenu(List<UsuarioBean> usuariosCargados) {
		UsuarioService usuarioService = new UsuarioService();
		System.out.println("*****  Menu *****");
		System.out.println("1.- Buscar por nombre");
		System.out.println("2.- Buscar por número de usuario");
		System.out.println("3.- Validar Usuario y contraseña");
		System.out.println("4.- Salir");
		Scanner scanner = new Scanner(System.in);
		int opcionElegida = scanner.nextInt();
		List<UsuarioBean> usuariosEncontrados = new ArrayList<>();
		
		switch (opcionElegida) {
		case 1: 
			System.out.println("Nombre buscar:");
			String nombreBuscar = scanner.next();
			System.out.println("Iniciando busqueda del nombre: " + nombreBuscar);
			usuariosEncontrados = usuarioService.buscarUsuariosPorNombre(usuariosCargados, nombreBuscar);
			usuarioService.mostrarUsuarios(usuariosEncontrados);
			break;	
		case 2:
			System.out.println("Número de usuario:\n");
			Integer numeroUsuario = 0;
            try {
                numeroUsuario = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Ocurrió una excepcion");
            }
			usuariosEncontrados = usuarioService.buscarUsuario(usuariosCargados, numeroUsuario);
			usuarioService.mostrarUsuarios(usuariosEncontrados);
			break;
		case 3:
			System.out.println("ingresa nombre de usuario:");
			String nombreUsuarioBuscar = scanner.next();
			System.out.println("ingresa password:");
			String passwordBuscar = scanner.next();
			usuariosEncontrados = usuarioService.validarUsuario(usuariosCargados, nombreUsuarioBuscar, passwordBuscar);
			usuarioService.mostrarUsuarios(usuariosEncontrados);
			break;	
		case 4:
			System.out.println("Termina programa");
			System.exit(0);
		default:
			System.out.println("Opcion invalida");
		}
		
		mostrarMenu(usuariosCargados);
	}

}
