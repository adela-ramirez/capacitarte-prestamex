package mx.capacitarte.prestamex.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mx.capacitarte.prestamex.beans.ClienteBean;
import mx.capacitarte.prestamex.beans.EmpleadoBean;
import mx.capacitarte.prestamex.beans.UsuarioBean;
import mx.capacitarte.prestamex.service.ClienteService;
import mx.capacitarte.prestamex.service.UsuarioService;

public class UsuariosMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Inicia programa");
		List<UsuarioBean> usuariosCargados = new ArrayList<>();//empleadoService.cargarEmpleados();
		
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
		System.out.println("4.- Agregar Usuario");
		System.out.println("5.- Salir");
		Scanner scanner = new Scanner(System.in);
		int opcionElegida = scanner.nextInt();
		List<UsuarioBean> usuariosEncontrados = new ArrayList<>();
		
		switch (opcionElegida) {
		case 1: 
			System.out.println("Nombre buscar:");
			String nombreBuscar = scanner.next();
			System.out.println("Iniciando busqueda del nombre: " + nombreBuscar);
			usuariosEncontrados = usuarioService.buscarUsuariosPorNombre(nombreBuscar);
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
			usuariosEncontrados = usuarioService.buscarUsuario(numeroUsuario);
			usuarioService.mostrarUsuarios(usuariosEncontrados);
			break;
		case 3:
			System.out.println("ingresa nombre de usuario:");
			String nombreUsuarioBuscar = scanner.next();
			System.out.println("ingresa password:");
			String passwordBuscar = scanner.next();
			usuariosEncontrados = usuarioService.validarUsuario(nombreUsuarioBuscar, passwordBuscar);
			usuarioService.mostrarUsuarios(usuariosEncontrados);
			break;	
		case 4:
			System.out.println("ingrese el número de Usuario");
			Integer numUsuario = scanner.nextInt();
			System.out.println("ingrese el nombre del usuario");
			String usuario = scanner.next();
			System.out.println("ingrese password");
			String password = scanner.next();
			System.out.println("vigencia");
			String vigencia = scanner.next();
			System.out.println("ingrese perfil");
			String perfil = scanner.next();
			
			UsuarioBean usuarioAgregar = new UsuarioBean();
			usuarioAgregar.setNumeroUsuario(numUsuario);
			usuarioAgregar.setUsuario(usuario);
			usuarioAgregar.setPassword(password);
			usuarioAgregar.setVigencia(vigencia.equals("1") ? true : false);
			usuarioAgregar.setPerfil(perfil);
			
			Boolean respuesta = usuarioService.agregarUsuarios(usuarioAgregar);
			System.out.println(respuesta ? "El usuario fue agregado correctamente" : "Ocurrió un error al agregar al cliente");
			
			break;
		case 5:
			System.out.println("Termina programa");
			System.exit(0);
		default:
			System.out.println("Opcion invalida");
		}
		
		mostrarMenu(usuariosCargados);
	}

}
