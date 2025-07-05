package mx.capacitarte.prestamex.beans;

public class PrestamoBean {
	
	private Integer numeroUsuario;
    private Integer numeroPrestamo;
    private Integer numeroCliente;
    private Integer numeroEmpleado;
    private double montoPrestamo;
    private Integer plazo;
    private double intereses;
    private double totalPagar;
    private double pagos;
    private String fechaSolicitud;
    private Boolean vigencia;
	public PrestamoBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PrestamoBean(Integer numeroUsuario, Integer numeroPrestamo,
			Integer numeroCliente, Integer numeroEmpleado, double montoPrestamo, Integer plazo,
			double intereses, double totalPagar, double pagos, String fechaSolicitud, Boolean vigencia) {
		super();
		this.numeroUsuario = numeroUsuario;
		this.vigencia = vigencia;
		this.numeroPrestamo = numeroPrestamo;
		this.numeroCliente = numeroCliente;
		this.numeroEmpleado = numeroEmpleado;
		this.montoPrestamo = montoPrestamo;
		this.plazo = plazo;
		this.intereses = intereses;
		this.totalPagar = totalPagar;
		this.pagos = pagos;
		this.fechaSolicitud = fechaSolicitud;
	}
	public Integer getNumeroUsuario() {
		return numeroUsuario;
	}
	public void setNumeroUsuario(Integer numeroUsuario) {
		this.numeroUsuario = numeroUsuario;
	}
	public Boolean getVigencia() {
		return vigencia;
	}
	public void setVigencia(Boolean vigencia) {
		this.vigencia = vigencia;
	}
	public Integer getNumeroPrestamo() {
		return numeroPrestamo;
	}
	public void setNumeroPrestamo(Integer numeroPrestamo) {
		this.numeroPrestamo = numeroPrestamo;
	}
	public Integer getNumeroCliente() {
		return numeroCliente;
	}
	public void setNumeroCliente(Integer numeroCliente) {
		this.numeroCliente = numeroCliente;
	}
	public Integer getNumeroEmpleado() {
		return numeroEmpleado;
	}
	public void setNumeroEmpleado(Integer numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}
	public double getMontoPrestamo() {
		return montoPrestamo;
	}
	public void setMontoPrestamo(double montoPrestamo) {
		this.montoPrestamo = montoPrestamo;
	}
	public Integer getPlazo() {
		return plazo;
	}
	public void setPlazo(Integer plazo) {
		this.plazo = plazo;
	}
	public double getIntereses() {
		return intereses;
	}
	public void setIntereses(double intereses) {
		this.intereses = intereses;
	}
	public double getTotalPagar() {
		return totalPagar;
	}
	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}
	public double getPagos() {
		return pagos;
	}
	public void setPagos(double pagos) {
		this.pagos = pagos;
	}
	public String getFechaSolicitud() {
		return fechaSolicitud;
	}
	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	@Override
	public String toString() {
		return "PrestamoBean [numeroUsuario=" + numeroUsuario + ", numeroPrestamo=" + numeroPrestamo
				+ ", numeroCliente=" + numeroCliente + ", numeroEmpleado=" + numeroEmpleado + ", montoPrestamo="
				+ montoPrestamo + ", plazo=" + plazo + ", intereses=" + intereses + ", totalPagar=" + totalPagar
				+ ", pagos=" + pagos + ", fechaSolicitud=" + fechaSolicitud + ", vigencia=" + vigencia + "]";
	}

	 public String mostraInfoPrestamo() {
	    	return 
			    "Numero de prestamo:   " + numeroPrestamo +
			    "\nNumero de usuario:    " + numeroUsuario +
			    "\nNumero de cliente:    " + numeroCliente +
			    "\nNumero de empleado:   " + numeroEmpleado +
			    "\nFecha de solicitud:   " + fechaSolicitud +
			    "\nMonto del prestamo:   " + montoPrestamo + 
			    "\nPlazo:                " + plazo + 
			    "\nIntereses:            " + intereses + 
			    "\nPagos:                " + pagos + 
			    "\nTotal a Pagar:        " + totalPagar + 
			    "\nVigencia:             " + (vigencia ? "Vigente" : "No Vigente") + 
			    "\n\n";
	    	
	    }
	    
	   
		public String salidaArchivoPlano() {
			return numeroPrestamo + "|" + numeroEmpleado + "|"  + numeroUsuario + "|"+ numeroCliente + "|"+ montoPrestamo + "|"+ plazo + "|"+ intereses + "|"+ pagos + "|"+ totalPagar + "|" + fechaSolicitud +  "|" + (vigencia ? "1" : "0") + "\n";
		}
    
    
    
}
