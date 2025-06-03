package mx.capacitarte.prestamex.beans;

public class EmpleadoBean {
	
	private Integer numeroEmpleado;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fechaNacimiento;
    private String puesto;
    private String departamento;
    private String genero;
    private String fechaIngreso;
    private double sueldo;
    private Boolean vigencia;
	
    public EmpleadoBean() {
				super();
		// TODO Auto-generated constructor stub
	}

	public EmpleadoBean(Integer numeroEmpleado, String nombre, String apellidoPaterno, String apellidoMaterno,
			String fechaNacimiento, String puesto, String departamento, String genero, String fechaIngreso,
			double sueldo, Boolean vigencia) {
		super();
		this.numeroEmpleado = numeroEmpleado;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.fechaNacimiento = fechaNacimiento;
		this.puesto = puesto;
		this.departamento = departamento;
		this.genero = genero;
		this.fechaIngreso = fechaIngreso;
		this.sueldo = sueldo;
		this.vigencia = vigencia;
	}

	public Integer getNumeroEmpleado() {
		return numeroEmpleado;
	}

	public void setNumeroEmpleado(Integer numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
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

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public Boolean getVigencia() {
		return vigencia;
	}

	public void setVigencia(Boolean vigencia) {
		this.vigencia = vigencia;
	}

	@Override
	public String toString() {
		return "EmpleadoBean [numeroEmpleado=" + numeroEmpleado + ", nombre=" + nombre + ", apellidoPaterno="
				+ apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", fechaNacimiento=" + fechaNacimiento
				+ ", puesto=" + puesto + ", departamento=" + departamento + ", genero=" + genero + ", fechaIngreso="
				+ fechaIngreso + ", sueldo=" + sueldo + ", vigencia=" + vigencia + "]";
	}
    
    public String mostraInfoEmpleado() {
    	return 
		    "Numero de empleado: " + numeroEmpleado +
		    "\nNombre empleado:    " + nombre + " " + apellidoPaterno + " " + apellidoMaterno +
		    "\nFecha de nacimiento: " + fechaNacimiento +
		    "\nDepartamente:       " + departamento + 
		    "\nPuesto:             " + puesto + 
		    "\nGenero:             " + (genero.equals("F") ? "FEMENINO" : genero.equals("M") ? "MASCULINO" : " ") + 
		    "\nFecha de ingreso:   " + fechaIngreso +
		    "\nSueldo mensual:     " + sueldo +
		    "\nVigencia:           " + (vigencia ? "Vigente" : "No Vigente") + 
		    "\n\n";
    	
    }

}
