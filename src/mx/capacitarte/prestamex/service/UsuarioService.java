package mx.capacitarte.prestamex.service;

import java.util.ArrayList;
import java.util.List;

import mx.capacitarte.prestamex.beans.ClienteBean;
import mx.capacitarte.prestamex.beans.UsuarioBean;

public class UsuarioService {
	
	public List<UsuarioBean> cargarUsuarios(){
		List<UsuarioBean> usuariosBean = new ArrayList<>();
		
		UsuarioBean usuarioBean1 = new UsuarioBean(001, "Alicia", "Alva80", true , "vigente");
		UsuarioBean usuarioBean2 = new UsuarioBean(002, "Adrian", "Martinez85", true , "vigente");
		
		usuariosBean.add(usuarioBean1);
		usuariosBean.add(usuarioBean2);
		usuariosBean.add(usuarioBean2);
		return usuariosBean;
	}
	
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
	
	public List<UsuarioBean> buscarUsuariosPorNombre(List<UsuarioBean> usuarios, String nombreBuscar){
		List<UsuarioBean> usuariosCoincidentes = new ArrayList<>();

		for (UsuarioBean usuarioBean : usuarios) {
			if(usuarioBean.getUsuario().toUpperCase().equals(nombreBuscar.toUpperCase())) {
				usuariosCoincidentes.add(usuarioBean);
			}
		}
		
		return usuariosCoincidentes;
	}
	
	
	public List<UsuarioBean> buscarUsuario(List<UsuarioBean> usuarios, Integer numeroEmpleado){
		List<UsuarioBean> usuariosCoincidentes = new ArrayList<>();

		for (UsuarioBean usuarioBean : usuarios) {
			if(usuarioBean.getNumeroEmpleado().intValue() == numeroEmpleado.intValue()) {
				usuariosCoincidentes.add(usuarioBean);
			}
		}
		
		return usuariosCoincidentes;
	}
	public List<UsuarioBean> validarUsuario(List<UsuarioBean> usuarios, String usuario, String password){
		List<UsuarioBean> usuariosCoincidentes = new ArrayList<>();

		for (UsuarioBean usuarioBean : usuarios) {
			if(usuarioBean.getUsuario().equals(usuario) && usuarioBean.getPassword().equals(password)) {
				usuariosCoincidentes.add(usuarioBean);
					
			}
			
		}
		
		return usuariosCoincidentes;
	}
	
	

}
