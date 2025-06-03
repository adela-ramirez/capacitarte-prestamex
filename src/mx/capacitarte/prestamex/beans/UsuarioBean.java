package mx.capacitarte.prestamex.beans;

public class UsuarioBean {

	private Integer numeroUsuario;
    private String usuario;
    private String password;
    private Boolean vigencia;
    private String perfil;
	public UsuarioBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UsuarioBean(Integer numeroUsuario, String usuario, String password, Boolean vigencia, String perfil) {
		super();
		this.numeroUsuario = numeroUsuario;
		this.usuario = usuario;
		this.password = password;
		this.vigencia = vigencia;
		this.perfil = perfil;
	}
	
	public Integer getNumeroUsuario() {
		return numeroUsuario;
	}
	public void setNumeroUsuario(Integer numeroUsuario) {
		this.numeroUsuario = numeroUsuario;
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
		return "UsuarioBean [numeroEmpleado=" + numeroUsuario + ", usuario=" + usuario + ", password=" + password
				+ ", vigencia=" + vigencia + ", perfil=" + perfil + "]";
	}
	
	public String salidaArchivoPlano() {
		return numeroUsuario + "|" + usuario + "|" + password + "|" + (vigencia ? "1" : "0") + "|" +
				perfil +  "\n";
	}
}
