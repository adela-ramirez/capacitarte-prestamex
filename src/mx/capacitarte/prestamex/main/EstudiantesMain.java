package mx.capacitarte.prestamex.main;

import java.util.List;

import mx.capacitarte.prestamex.beans.EstudianteBean;
import mx.capacitarte.prestamex.service.EstudianteService;

public class EstudiantesMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("Inicia programa");

		System.out.println("Cargando estudiantes...");
		EstudianteService estudianteService = new EstudianteService();
		List<EstudianteBean> estudiantesCargados = estudianteService.cargarEstudiantes();
		System.out.println("Termina carga de estudiantes");
		System.out.println("********************************\n");
		
		estudianteService.mostrarEstudiantes(estudiantesCargados);
		
		String nombreBuscar = "Andres";
		System.out.println("\nBuscando empleado: " + nombreBuscar);
		List<EstudianteBean> estudiantesEncontrados = estudianteService.buscarEstudiantesPorNombre(estudiantesCargados, nombreBuscar);
		estudianteService.mostrarEstudiantes(estudiantesEncontrados);
		System.out.println("");
		System.out.println("Termina programa");
	}

}
