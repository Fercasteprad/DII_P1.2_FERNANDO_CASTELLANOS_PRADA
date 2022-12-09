package dam2.dii.p12.controlador;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dam2.dii.p12.DAO.ContactoDAO;
import dam2.dii.p12.contacto.Contacto;
import dam2.dii.p12.service.ContactoService;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("")
public class ContactoControler extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContactoControler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Por el metodo get se envían dos atributos el id del contacto a editar y un String que es true o false, en el caso de ser verdadero es porque el contacto
		// se va a editar, en el caso de que la edición este a falso es porque ese contacto se va a eliminar.
		
		String edit = request.getParameter("edit");
		boolean edit_bool = false;
		if (edit != null) {
			edit_bool = Boolean.valueOf(edit);
		}
		String id = request.getParameter("id");
		
		int id_num = -1;
		if (id != null) {
			id_num = Integer.parseInt(id);
		}
		
		String ver = request.getParameter("ver");
		boolean ver_bool = false;
		if (ver != null) {
			ver_bool = Boolean.valueOf(ver);
		}

		
		//si el campo recogido por el Get es verdadero recoge los campos completados y los modifica.
		if (edit_bool) {
			// Crear contacto e ir extrayendo los atributos Contacto contactoEdit = 
			int identificacion_idArray = ContactoService.getArrayPosition(id_num);
			Contacto contactoEdit = ContactoDAO.getContactos().get(identificacion_idArray);
			request.setAttribute("nombre_edit", contactoEdit.getNombre());
			request.setAttribute("apellidos_edit", contactoEdit.getApellido());
			request.setAttribute("email_edit", contactoEdit.getEmail());
			request.setAttribute("telefono_edit", contactoEdit.getTelefono());
			request.setAttribute("comentario_edit", contactoEdit.getComentario());
			request.setAttribute("id", String.valueOf(contactoEdit.getId()));
			request.setAttribute("edicion", "true");

		}
		
		else if ((!edit_bool) && (!ver_bool)) {
			
			ContactoService.eliminarContacto(id_num);
			
		}
		
		else {
			int identificacion_idArray = ContactoService.getArrayPosition(id_num);
			Contacto contactoEdit = ContactoDAO.getContactos().get(identificacion_idArray);
			request.setAttribute("nombre_edit", contactoEdit.getNombre());
			request.setAttribute("apellidos_edit", contactoEdit.getApellido());
			request.setAttribute("email_edit", contactoEdit.getEmail());
			request.setAttribute("telefono_edit", contactoEdit.getTelefono());
			request.setAttribute("comentario_edit", contactoEdit.getComentario());
			request.setAttribute("id", String.valueOf(contactoEdit.getId()));
			request.setAttribute("edicion", "false");
			request.setAttribute("ver", "true");
		}


		request.setAttribute("contactos", ContactoService.getContactos());
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String valor_nombre = request.getParameter("nombre");
		String valor_apellido = request.getParameter("apellidos");
		String valor_email = request.getParameter("email");
		String valor_telefono = request.getParameter("telefono");
		String valor_comentario = request.getParameter("comentarios");
		//Este campo solo se rellena cuando envía el formulario de edición
		String id_edicion = request.getParameter("idEdit");
		
		//Comprueba si contiene algún dato
		boolean contieneDatos = new ContactoService().contieneDatos(valor_nombre, valor_apellido, valor_email, valor_telefono); 

		//Si el envio de información contiene datos
		if (contieneDatos) {
			
			//Comprueba si el email está registrado en otro usuario
			boolean mail_encontrado = ContactoService.mailEncontrado(valor_email);
			
			//Si hay un mail igual manda mensaje de error
			if (mail_encontrado) {

				request.setAttribute("nombre", valor_nombre);
				request.setAttribute("apellidos", valor_apellido);
				request.setAttribute("email", valor_email);
				request.setAttribute("telefono", valor_telefono);
				request.setAttribute("comentario", valor_comentario);
				request.setAttribute("error", "Ese correo ya está registrado");
				request.setAttribute("contactos", ContactoService.getContactos());
				request.getRequestDispatcher("index.jsp").forward(request, response);

			}
			
			//Si no crea el contacto y devuelve los campos vacios.
			else {

				Contacto nuevo_contacto = new Contacto(ContactoService.idContactoNuevo(), valor_nombre, valor_apellido, valor_email,
						valor_telefono, valor_comentario);
				ContactoService.getContactos().add(nuevo_contacto);
				request.setAttribute("nombre", null);
				request.setAttribute("apellidos", null);
				request.setAttribute("email", null);
				request.setAttribute("telefono", null);
				request.setAttribute("comentario", null);
				request.setAttribute("error", "El contacto se ha dado de alta correctamente");
				request.setAttribute("contactos", ContactoService.getContactos());
				request.getRequestDispatcher("index.jsp").forward(request, response);

			}

		}
		
		//Si el campo de id del formulario de edición es diferente de null recoge los datos del formulario y los guarda en el contacto correspondiente
		else if (id_edicion != null) {

			String nombre_edit = request.getParameter("nombreEdit");
			String apellido_edit = request.getParameter("apellidoEdit");
			String email_edit = request.getParameter("emailEdit");
			String telefono_edit = request.getParameter("telefonoEdit");
			String comentario_edit = request.getParameter("comentarioEdit");
			int id = Integer.parseInt(id_edicion);

			int idArrayPosition = ContactoService.getArrayPosition(id);

			Date fecha = new Date();
			ContactoService.getContactos().get(idArrayPosition).setNombre(nombre_edit);
			ContactoService.getContactos().get(idArrayPosition).setApellido(apellido_edit);
			ContactoService.getContactos().get(idArrayPosition).setTelefono(telefono_edit);
			ContactoService.getContactos().get(idArrayPosition).setEmail(email_edit);
			ContactoService.getContactos().get(idArrayPosition).setComentario(comentario_edit);
			ContactoService.getContactos().get(idArrayPosition).setFechaModificacion(fecha);
			
			//Se envía el arraylist para poder imprimir todos los contactos.
			request.setAttribute("contactos", ContactoService.getContactos());
			request.getRequestDispatcher("index.jsp").forward(request, response);

		}

		//En el caso de que algún campo no esté completo devuelve los datos que se han introducido y hace referencia a que no se dejen campos vacíos.
		else {
			request.setAttribute("nombre", valor_nombre);
			request.setAttribute("apellidos", valor_apellido);
			request.setAttribute("email", valor_email);
			request.setAttribute("telefono", valor_telefono);
			request.setAttribute("comentario", valor_comentario);
			request.setAttribute("error", "No se ha podido crear el contacto, revisa que los campos no estén vacíos");
			request.setAttribute("contactos", ContactoService.getContactos());
			request.getRequestDispatcher("index.jsp").forward(request, response);

		}

	}

}
