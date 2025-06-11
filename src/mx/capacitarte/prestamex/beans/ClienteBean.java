package mx.capacitarte.prestamex.beans;

public class ClienteBean {

	private Integer numeroCliente;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fechaNacimiento;
    private String genero;
    private String rfc;
    private String telefono;
    private String correoElectronico;
    private String domicilio;
    private Boolean vigencia;
	public ClienteBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClienteBean(Integer numeroCliente, String nombre, String apellidoPaterno, String apellidoMaterno,
			String fechaNacimiento, String genero, String rfc, String telefono, String correoElectronico,
			String domicilio, Boolean vigencia) {
		super();
		this.numeroCliente = numeroCliente;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.rfc = rfc;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.domicilio = domicilio;
		this.vigencia = vigencia;
	}
	public Integer getNumeroCliente() {
		return numeroCliente;
	}
	public void setNumeroCliente(Integer numeroCliente) {
		this.numeroCliente = numeroCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public Boolean getVigencia() {
		return vigencia;
	}
	public void setVigencia(Boolean vigencia) {
		this.vigencia = vigencia;
	}
	@Override
	public String toString() {
		return "ClienteBean [numeroCliente=" + numeroCliente + ", nombre=" + nombre + ", apellidoPaterno="
				+ apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", fechaNacimiento=" + fechaNacimiento
				+ ", genero=" + genero + ", rfc=" + rfc + ", telefono=" + telefono + ", correoElectronico="
				+ correoElectronico + ", domicilio=" + domicilio + ", vigencia=" + vigencia + "]";
	}
	
	public String mostraInfoCliente() {
    	return 
		    "Numero de cliente: " + numeroCliente +
		    "\nNombre cliente:    " + nombre + " " + apellidoPaterno + " " + apellidoMaterno +
		    "\nFecha de nacimiento: " + fechaNacimiento +
		    "\nGenero:             " + (genero.equals("F") ? "FEMENINO" : genero.equals("M") ? "MASCULINO" : " ") + 
		    "\nRfc:             " + rfc + 
		    "\nTelefono:             " + telefono + 
		    "\nCorreo electronico:   " + correoElectronico +
		    "\nDomicilio:     " + domicilio +
		    "\nVigencia:           " + (vigencia ? "Vigente" : "No Vigente") + 
		    "\n\n";
    	
    }
	public String salidaArchivoPlano() {
		return numeroCliente + "|" + nombre + "|" + apellidoPaterno + "|"+ apellidoMaterno + "|"+ fechaNacimiento + "|"+ genero + "|"+ rfc + "|"+ telefono + "|"+ correoElectronico + "|"+ domicilio + "|" + (vigencia ? "1" : "0") + "\n";
	}
	
}
