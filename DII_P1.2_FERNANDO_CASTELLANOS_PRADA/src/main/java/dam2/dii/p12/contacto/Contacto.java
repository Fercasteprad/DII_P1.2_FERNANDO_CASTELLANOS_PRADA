package dam2.dii.p12.contacto;

import java.util.Date;

public class Contacto {
	
	private int id;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String comentario;
	
	public Contacto() {
		
	}
	
	public Contacto(int id, String nombre, String apellido, String email, String telefono, String comentario) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.comentario = comentario;
		this.fechaCreacion = fechaInicial();
		this.fechaModificacion = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	
	public Date fechaInicial() {
		
		Date fecha = new Date();
		return fecha;
		
	}
	
	

}
