package mx.capacitarte.prestamex.beans;

public class UsuarioBean {

	private Integer numeroEmpleado;
    private String usuario;
    private String password;
    private Boolean vigencia;
    private String perfil;
	public UsuarioBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UsuarioBean(Integer numeroEmpleado, String usuario, String password, Boolean vigencia, String perfil) {
		super();
		this.numeroEmpleado = numeroEmpleado;
		this.usuario = usuario;
		this.password = password;
		this.vigencia = vigencia;
		this.perfil = perfil;
	}
	
	public Integer getNumeroEmpleado() {
		return numeroEmpleado;
	}
	public void setNumeroUsuario(Integer numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getVigencia() {
		return vigencia;
	}
	public void setVigencia(Boolean vigencia) {
		this.vigencia = vigencia;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	@Override
	public String toString() {
		return "UsuarioBean [numeroEmpleado=" + numeroEmpleado + ", usuario=" + usuario + ", password=" + password
				+ ", vigencia=" + vigencia + ", perfil=" + perfil + "]";
	}
	
	
}
