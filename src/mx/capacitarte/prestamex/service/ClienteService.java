package mx.capacitarte.prestamex.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sun.java_cup.internal.runtime.Scanner;

import mx.capacitarte.prestamex.beans.ClienteBean;
import mx.capacitarte.prestamex.beans.EmpleadoBean;
import mx.capacitarte.prestamex.files.ClientesFiles;
import mx.capacitarte.prestamex.files.EmpleadosFiles;

public class ClienteService {

	
	//Agreguemos los métodos con las funcionalidades
			//Agregar clientes
			public List<ClienteBean> cargarClientes(){
				List<ClienteBean> clientesBean = new ArrayList<>();
				
				ClienteBean clienteBean1 = new ClienteBean(001, "Alicia", "Alva", "Aguilar", "10/12/1980", "F",  "ALAA801210B12", "5552347689", "alicia_alva@gmail.com", "salina cruz", true);
				ClienteBean clienteBean2 = new ClienteBean(002, "Adrian", "Martinez", "Lopez", "10/07/1985", "M", "MALA850710H34", "7771230956", "adrian_mar@gmail.com", "tehuantepec", true);
				
				clientesBean.add(clienteBean1);
				clientesBean.add(clienteBean2);
				clientesBean.add(clienteBean2);
				return clientesBean;
			}
			
			//Mostrar clientes
			public void mostrarClientes(List<ClienteBean> clientes) {
				if(clientes.isEmpty()) {
					System.out.println("No se encontraron coincidencias\n");
					return;
				}
				
				System.out.println("Los clientes son:");
				for (ClienteBean clienteBean : clientes) {
					System.out.println(clienteBean.toString());
				}
				System.out.println("=============================================");
				
			}
			
			//Buscar clientes por nombre
			public List<ClienteBean> buscarClientesPorNombre(String nombreBuscar){
				List<ClienteBean> clientesCoincidentes = new ArrayList<>();
				
				ClientesFiles clientesFiles = new ClientesFiles();
				List<ClienteBean> clientes =clientesFiles.leerArchivoClientes();

				for (ClienteBean clienteBean : clientes) {
					if(clienteBean.getNombre().toUpperCase().equals(nombreBuscar.toUpperCase())) {
						clientesCoincidentes.add(clienteBean);
					}
				}
				
				return clientesCoincidentes;
			}
			
			public List<ClienteBean> buscarCliente(Integer numeroCliente){
				List<ClienteBean> clientesCoincidentes = new ArrayList<>();

				ClientesFiles clientesFiles = new ClientesFiles();
				List<ClienteBean> clientes =clientesFiles.leerArchivoClientes();

				for (ClienteBean clienteBean : clientes) {
					if(clienteBean.getNumeroCliente().intValue() == numeroCliente.intValue()) {
						clientesCoincidentes.add(clienteBean);
					}
				}
				
				return clientesCoincidentes;
			}

			public List<ClienteBean> agregarClientes(String nombreBuscar){
				ClientesFiles clientesFiles = new ClientesFiles();
				List<ClienteBean> clientes =clientesFiles.leerArchivoClientes();

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
				
				clientes.add(clienteBean);
				
			}
}
