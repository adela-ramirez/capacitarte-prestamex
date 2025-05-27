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
import mx.capacitarte.prestamex.commons.Constantes;

public class ClientesFiles {

	// leer archivo clientes
		public List<ClienteBean> leerArchivoClientes() {
			List<ClienteBean> clientes = new ArrayList<>();

			File file = new File(Constantes.RUTA_ARCHIVO_PRESTAMEX_CLIENTES);

			if (!file.exists()) {
				System.out.println("El archivo " + Constantes.RUTA_ARCHIVO_PRESTAMEX_CLIENTES + " no existe");
				return clientes;
			}

			try {
				Scanner scanner = new Scanner(file);

				while (scanner.hasNextLine()) {
					String valores = scanner.nextLine();
					// System.out.println(valores);

					String[] datos = valores.split(Pattern.quote("|"));

					ClienteBean clienteBean = new ClienteBean();
					clienteBean.setNumeroCliente(Integer.parseInt(datos[0]));
					clienteBean.setNombre(datos[1]);
					clienteBean.setApellidoPaterno(datos[2]);
					clienteBean.setApellidoMaterno(datos[3]);
					clienteBean.setFechaNacimiento(datos[4]);
					clienteBean.setGenero(datos[5]);
					clienteBean.setRfc(datos[6]);
					clienteBean.setTelefono(datos[7]);
					clienteBean.setCorreoElectronico(datos[8]);
					clienteBean.setDomicilio(datos[9]);
					clienteBean.setVigencia(datos[10].equals("1") ? true : false);

					clientes.add(clienteBean);
				}

				scanner.close();

			} catch (FileNotFoundException e) {
				System.out.println("Ocurrió una excepcion");
				e.printStackTrace();
			}

			return clientes;
		}

		// agregar cliente a archivo clientes
		// Boolean: true o false
		public Boolean agregarCliente(ClienteBean clienteNuevoBean) {
			//Recuperar a todos los clientes actuales en el archivo: 1
			System.out.println("Recuperando a todos los clientes actuales en el archivo");
			List<ClienteBean> clientesActuales = leerArchivoClientes();
			
			//Agregar cliente nuevo a la lista de clientes actuales: 2
			System.out.println("Agregando cliente nuevo a la lista");
			clientesActuales.add(clienteNuevoBean);
			
			//Escribir en el archivo
			try {
				FileWriter myWriter = new FileWriter(Constantes.RUTA_ARCHIVO_PRESTAMEX_CLIENTES);
				
				for (ClienteBean clienteBean : clientesActuales) {
					System.out.println(":::: Agregando cliente");
					myWriter.write(clienteBean.salidaArchivoPlano());
				}
				System.out.println("Terminó de agregar cliente al archivo");
				myWriter.close();
			}catch (IOException e) {
				System.out.println("a ocurrido una excepcion");
				e.printStackTrace();
				return false;
			}
			
			return true;
		}
		
}
