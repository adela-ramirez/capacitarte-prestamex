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
import mx.capacitarte.prestamex.beans.UsuarioBean;
import mx.capacitarte.prestamex.commons.Constantes;

public class UsuariosFile {
	public List<UsuarioBean> leerArchivoUsuarios() {
		List<UsuarioBean> usuarios = new ArrayList<>();

		File file = new File(Constantes.RUTA_ARCHIVO_PRESTAMEX_USUARIOS);

		if (!file.exists()) {
			System.out.println("El archivo " + Constantes.RUTA_ARCHIVO_PRESTAMEX_USUARIOS + " no existe");
			return usuarios;
		}

		try {
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String valores = scanner.nextLine();
				// System.out.println(valores);

				String[] datos = valores.split(Pattern.quote("|"));

				UsuarioBean usuarioBean = new UsuarioBean();
				usuarioBean.setNumeroUsuario(Integer.parseInt(datos[0]));
				usuarioBean.setUsuario(datos[1]);
				usuarioBean.setPassword(datos[2]);
				usuarioBean.setVigencia(datos[3].equals("1") ? true : false);
				usuarioBean.setPerfil(datos[4]);

				usuarios.add(usuarioBean);
			}

			scanner.close();

		} catch (FileNotFoundException e) {
			System.out.println("Ocurrió una excepcion");
			e.printStackTrace();
		}

		return usuarios;
	}
	
	public Boolean agregarUsuario(UsuarioBean usuarioNuevoBean) {
		//Recuperar a todos los usuarios actuales en el archivo: 1
		System.out.println("Recuperando a todos los usuarios actuales en el archivo");
		List<UsuarioBean> usuariosActuales = leerArchivoUsuarios();
		
		//Agregar cliente nuevo a la lista de clientes actuales: 2
		System.out.println("Agregando cliente nuevo a la lista");
		usuariosActuales.add(usuarioNuevoBean);
		
		//Escribir en el archivo
		try {
			FileWriter myWriter = new FileWriter(Constantes.RUTA_ARCHIVO_PRESTAMEX_USUARIOS);
			
			for (UsuarioBean usuarioBean : usuariosActuales) {
				System.out.println(":::: Agregando usuario");
				myWriter.write(usuarioBean.salidaArchivoPlano());
			}
			System.out.println("Terminó de agregar usuario al archivo");
			myWriter.close();
		}catch (IOException e) {
			System.out.println("a ocurrido una excepcion");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}


}
