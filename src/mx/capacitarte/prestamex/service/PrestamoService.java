package mx.capacitarte.prestamex.service;

import java.util.ArrayList;
import java.util.List;

import mx.capacitarte.prestamex.beans.EmpleadoBean;
import mx.capacitarte.prestamex.beans.PrestamoBean;
import mx.capacitarte.prestamex.commons.Constantes;
import mx.capacitarte.prestamex.files.ClientesFiles;
import mx.capacitarte.prestamex.files.EmpleadosFiles;
import mx.capacitarte.prestamex.files.PrestamosFiles;


public class PrestamoService {
	
	//Mostrar prestamos
			public void mostrarPrestamos(List<PrestamoBean> prestamos) {
				if(prestamos.isEmpty()) {
					System.out.println("No se recibió lista de prestamos\n");
					return;
				}
				
				System.out.println(prestamos.size() == 1 ? "\nEl prestamo encontrado es:" : "\nLos prestamos encontrados son:");
				for (PrestamoBean prestamoBean : prestamos) {
					System.out.println(prestamoBean.mostraInfoPrestamo());
				}
				System.out.println("=============================================");
				
			}
			
			//Buscar prestamos por nombre
			public List<PrestamoBean> buscarPrestamosPorUsuario(Integer numeroUsuario){
				List<PrestamoBean> prestamosCoincidentes = new ArrayList<>();

				PrestamosFiles prestamosFiles = new PrestamosFiles();
				List<PrestamoBean> prestamos =prestamosFiles.leerArchivoPrestamos();
				
				
				for (PrestamoBean prestamoBean : prestamos) {
					if(prestamoBean.getNumeroUsuario().intValue() == numeroUsuario.intValue()) {
						prestamosCoincidentes.add(prestamoBean);
					}
				}
				
				return prestamosCoincidentes;
			}
			
			public List<PrestamoBean> buscarPrestamo(Integer numeroPrestamo){
				List<PrestamoBean> prestamosCoincidentes = new ArrayList<>();

				PrestamosFiles prestamosFiles = new PrestamosFiles();
				List<PrestamoBean> prestamos =prestamosFiles.leerArchivoPrestamos();
				
				for (PrestamoBean prestamoBean : prestamos) {
					if(prestamoBean.getNumeroPrestamo().intValue() == numeroPrestamo.intValue()) {
						prestamosCoincidentes.add(prestamoBean);
					}
				}
				
				return prestamosCoincidentes;
			}
			
			public List<PrestamoBean> buscarPrestamoPorCliente(Integer numeroCliente){
				List<PrestamoBean> prestamosCoincidentes = new ArrayList<>();

				PrestamosFiles prestamosFiles = new PrestamosFiles();
				List<PrestamoBean> prestamos =prestamosFiles.leerArchivoPrestamos();
				
				for (PrestamoBean prestamoBean : prestamos) {
					if(prestamoBean.getNumeroCliente().intValue() == numeroCliente.intValue()) {
						prestamosCoincidentes.add(prestamoBean);
					}
				}
				
				return prestamosCoincidentes;
			}
			
			public List<PrestamoBean> buscarPrestamo(Boolean vigencia){
				List<PrestamoBean> prestamosCoincidentes = new ArrayList<>();

				PrestamosFiles prestamosFiles = new PrestamosFiles();
				List<PrestamoBean> prestamos =prestamosFiles.leerArchivoPrestamos();
				
				for (PrestamoBean prestamoBean : prestamos) {
					if(prestamoBean.getVigencia() == vigencia) {
						prestamosCoincidentes.add(prestamoBean);
					}
				}
				
				return prestamosCoincidentes;
			}
			
			
			
			public Boolean agregarPrestamos(PrestamoBean prestamoBean) {
				PrestamosFiles prestamosFiles = new PrestamosFiles();
				prestamoBean.setIntereses(Constantes.INTERESES_INICIAL);
				prestamoBean.setTotalPagar(prestamoBean.getMontoPrestamo() + (prestamoBean.getMontoPrestamo() * (prestamoBean.getIntereses()/100)));
				prestamoBean.setPagos(prestamoBean.getTotalPagar()/prestamoBean.getPlazo());
				Boolean resultadoAgregarPrestamo = prestamosFiles.agregarPrestamo(prestamoBean);

				System.out.println("El resultado de agregar prestamo fue: " + resultadoAgregarPrestamo);

				return resultadoAgregarPrestamo;

			}
}
