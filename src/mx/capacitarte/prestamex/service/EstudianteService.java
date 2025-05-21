package mx.capacitarte.prestamex.service;

import java.util.ArrayList;
import java.util.List;


import mx.capacitarte.prestamex.beans.EstudianteBean;

public class EstudianteService {
	
	public List<EstudianteBean> cargarEstudiantes(){
		List<EstudianteBean> estudiantesBean = new ArrayList<>();
		
		EstudianteBean estudianteBean1 = new EstudianteBean(001, "Andres", "Garcia", "Gonzalez", "10/12/1990", "M", "Informatica", "Programacion 1", 8.0);
		EstudianteBean estudianteBean2 = new EstudianteBean(002, "Esteban", "Morales", "Martinez", "10/07/1994", "F", "Informatica", "Programacion 1", 9.0);
		
		estudiantesBean.add(estudianteBean1);
		estudiantesBean.add(estudianteBean2);
		
		return estudiantesBean;
	}
	
	public void mostrarEstudiantes(List<EstudianteBean> estudiantes) {
		if(estudiantes.isEmpty()) {
			System.out.println("No se recibió lista de estudiantes\n");
			return;
		}
		
		System.out.println("Los estudiantes son:");
		for (EstudianteBean estudianteBean : estudiantes) {
			System.out.println(estudianteBean.toString());
		}
		System.out.println("=============================================");
		
	}
	

	public List<EstudianteBean> buscarEstudiantesPorNombre(List<EstudianteBean> estudiantes, String nombreBuscar){
		List<EstudianteBean> estudiantesCoincidentes = new ArrayList<>();

		for (EstudianteBean estudianteBean : estudiantes) {
			if(estudianteBean.getNombre().equals(nombreBuscar)) {
				estudiantesCoincidentes.add(estudianteBean);
			}
		}
		
		return estudiantesCoincidentes;
	}

}
