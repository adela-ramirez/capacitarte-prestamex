package mx.capacitarte.prestamex.beans;

public class EstudianteBean {
	
	private Integer numeroMatricula;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fechaNacimiento;
    private String genero;
    private String especialidad;
    private String materia;
    private double calificacion;
	
    public EstudianteBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EstudianteBean(Integer numeroMatricula, String nombre, String apellidoPaterno, String apellidoMaterno,
			String fechaNacimiento, String genero, String especialidad, String materia, double calificacion) {
		super();
		this.numeroMatricula = numeroMatricula;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.especialidad = especialidad;
		this.materia = materia;
		this.calificacion = calificacion;
	}

	public Integer getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(Integer numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
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

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	@Override
	public String toString() {
		return "EstudianteBean [numeroMatricula=" + numeroMatricula + ", nombre=" + nombre + ", apellidoPaterno="
				+ apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", fechaNacimiento=" + fechaNacimiento
				+ ", genero=" + genero + ", especialidad=" + especialidad + ", materia=" + materia + ", calificacion="
				+ calificacion + "]";
	}
    
    
}
