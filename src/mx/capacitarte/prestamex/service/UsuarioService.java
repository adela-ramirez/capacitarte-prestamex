package mx.capacitarte.prestamex.service;

import java.util.ArrayList;
import java.util.List;

import mx.capacitarte.prestamex.beans.ClienteBean;
import mx.capacitarte.prestamex.beans.EmpleadoBean;
import mx.capacitarte.prestamex.beans.UsuarioBean;
import mx.capacitarte.prestamex.files.ClientesFiles;
import mx.capacitarte.prestamex.files.EmpleadosFiles;
import mx.capacitarte.prestamex.files.UsuariosFile;

public class UsuarioService {
	
	
	//Mostrar usuarios
	public void mostrarUsuarios(List<UsuarioBean> usuarios) {
		if(usuarios.isEmpty()) {
			System.out.println("No se encontraron coincidencias\n");
			return;
		}
		
		System.out.println("Los usuarios son:");
		for (UsuarioBean usuarioBean : usuarios) {
			System.out.println(usuarioBean.toString());
		}
		System.out.println("=============================================");
		
	}
	
	public List<UsuarioBean> buscarUsuariosPorNombre(String nombreBuscar){
		List<UsuarioBean> usuariosCoincidentes = new ArrayList<>();

		// aqui se debe invovar el metodo de leer los usuarios del archivo
		UsuariosFile usuariosFiles = new UsuariosFile();
		List<UsuarioBean> usuarios =usuariosFiles.leerArchivoUsuarios();
		
		for (UsuarioBean usuarioBean : usuarios) {
			if(usuarioBean.getUsuario().toUpperCase().equals(nombreBuscar.toUpperCase())) {
				usuariosCoincidentes.add(usuarioBean);
			}
		}
		
		return usuariosCoincidentes;
	}
	
	
	public List<UsuarioBean> buscarUsuario(Integer numeroUsuario){
		List<UsuarioBean> usuariosCoincidentes = new ArrayList<>();
		
// aqui se debe invovar el metodo de leer los usuarios del archivo
		UsuariosFile usuariosFiles = new UsuariosFile();
		List<UsuarioBean> usuarios =usuariosFiles.leerArchivoUsuarios();
		
		for (UsuarioBean usuarioBean : usuarios) {
			if(usuarioBean.getNumeroUsuario().intValue() == numeroUsuario.intValue()) {
				usuariosCoincidentes.add(usuarioBean);
			}
		}
		
		return usuariosCoincidentes;
	}
	public List<UsuarioBean> validarUsuario(String usuario, String password){
		List<UsuarioBean> usuariosCoincidentes = new ArrayList<>();

	// aqui se debe invovar el metodo de leer los usuarios del archivo
		UsuariosFile usuariosFiles = new UsuariosFile();
		List<UsuarioBean> usuarios =usuariosFiles.leerArchivoUsuarios();
		
		for (UsuarioBean usuarioBean : usuarios) {
			if(usuarioBean.getUsuario().equals(usuario) && usuarioBean.getPassword().equals(password)) {
				usuariosCoincidentes.add(usuarioBean);
					
			}
			
		}
		
		return usuariosCoincidentes;
	}
	
	public Boolean agregarUsuarios (UsuarioBean usuarioBean){
		UsuariosFile usuariosFile = new UsuariosFile();
		Boolean resultadoAgregarUsuario = usuariosFile.agregarUsuario(usuarioBean);

		System.out.println("El resultado de agregar usuario fue: " + resultadoAgregarUsuario);

		return resultadoAgregarUsuario;

	}

}
