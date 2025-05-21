/**
 * 
 */
package mx.capacitarte.prestamex.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import mx.capacitarte.prestamex.beans.EmpleadoBean;
import mx.capacitarte.prestamex.files.EmpleadosFiles;

/**
 * 
 */
public class EmpleadoService {

	//Agreguemos los métodos con las funcionalidades
		//Agregar empleados
		public List<EmpleadoBean> cargarEmpleados(){
			List<EmpleadoBean> empleadosBean = new ArrayList<>();
			
			EmpleadoBean empleadoBean1 = new EmpleadoBean(generarNumEmpleado(), "Andres", "Garcia", "Gonzalez", "10/12/1990", "Admistrativo", "Operaciones", "M", "15/04/2025", 10000, true);
			EmpleadoBean empleadoBean2 = new EmpleadoBean(generarNumEmpleado(), "Esteban", "Morales", "Martinez", "10/07/1994", "Admistrativo", "Operaciones", "M", "05/04/2025", 18000, true);
			
			empleadosBean.add(empleadoBean1);
			empleadosBean.add(empleadoBean2);
			empleadosBean.add(empleadoBean1);
			
			return empleadosBean;
			
			
		}
		
		private Integer generarNumEmpleado() {
			DecimalFormat fmtAleatorio = new DecimalFormat("0000");
			DecimalFormat fmtMes = new DecimalFormat("00");
			Calendar calendar = Calendar.getInstance();
			int annio = calendar.get(Calendar.YEAR);
			int mes = calendar.get(Calendar.MONTH) + 1;
			double numeroAleatorio=Math.random();
			int numAleatorio = (int)(numeroAleatorio*1000);//0001 - 9999
			String numEmpleado = annio  + fmtMes.format(mes) + fmtAleatorio.format(numAleatorio);
			Integer numEmpladoFinal = Integer.parseInt(numEmpleado);
			
			//Convertir String -> Integer: Integer.parseInt(variable_string);
			//Convertir Integer -> String: String.valueOf(numEmpladoFinal);
			
			return numEmpladoFinal;
		}
		
		
		//Mostrar empleados
		public void mostrarEmpleados(List<EmpleadoBean> empleados) {
			if(empleados.isEmpty()) {
				System.out.println("No se recibió lista de empleados\n");
				return;
			}
			
			System.out.println("Los estudiantes son:");
			for (EmpleadoBean empleadoBean : empleados) {
				System.out.println(empleadoBean.toString());
			}
			System.out.println("=============================================");
			
		}
		
		//Buscar empleados por nombre
		public List<EmpleadoBean> buscarEmpleadosPorNombre(String nombreBuscar){
			List<EmpleadoBean> empleadosCoincidentes = new ArrayList<>();

			EmpleadosFiles empleadosFiles = new EmpleadosFiles();
			List<EmpleadoBean> empleados =empleadosFiles.leerArchivoEmpleados();
			
			
			for (EmpleadoBean empleadoBean : empleados) {
				if(empleadoBean.getNombre().equals(nombreBuscar)) {
					empleadosCoincidentes.add(empleadoBean);
				}
			}
			
			return empleadosCoincidentes;
		}
		
		public List<EmpleadoBean> buscarEmpleado(Integer numeroEmpleado){
			List<EmpleadoBean> empleadosCoincidentes = new ArrayList<>();

			EmpleadosFiles empleadosFiles = new EmpleadosFiles();
			List<EmpleadoBean> empleados =empleadosFiles.leerArchivoEmpleados();
			
			for (EmpleadoBean empleadoBean : empleados) {
				if(empleadoBean.getNumeroEmpleado().intValue() == numeroEmpleado.intValue()) {
					empleadosCoincidentes.add(empleadoBean);
				}
			}
			
			return empleadosCoincidentes;
		}
		
		public List<EmpleadoBean> buscarEmpleado(Boolean vigencia){
			List<EmpleadoBean> empleadosCoincidentes = new ArrayList<>();

			EmpleadosFiles empleadosFiles = new EmpleadosFiles();
			List<EmpleadoBean> empleados =empleadosFiles.leerArchivoEmpleados();
			
			for (EmpleadoBean empleadoBean : empleados) {
				if(empleadoBean.getVigencia() == vigencia) {
					empleadosCoincidentes.add(empleadoBean);
				}
			}
			
			return empleadosCoincidentes;
		}
		
		public List<EmpleadoBean> buscarEmpleado(String genero){
			List<EmpleadoBean> empleadosCoincidentes = new ArrayList<>();

			EmpleadosFiles empleadosFiles = new EmpleadosFiles();
			List<EmpleadoBean> empleados =empleadosFiles.leerArchivoEmpleados();
			
			for (EmpleadoBean empleadoBean : empleados) {
				if(empleadoBean.getGenero().equals(genero)) {
					empleadosCoincidentes.add(empleadoBean);
				}
			}
			
			return empleadosCoincidentes;
		}
}
