package dam2.dii.p12.service;

import java.util.ArrayList;

import dam2.dii.p12.DAO.ContactoDAO;
import dam2.dii.p12.contacto.Contacto;

public class ContactoService {

	public static int getArrayPosition(int id_num) {

		int arrayPosition = ContactoDAO.getArrayPosition(id_num);

		return arrayPosition;
	}

	public static void eliminarContacto(int id_num) {

		ContactoDAO.eliminarContacto(id_num);

	}
	
	public static ArrayList<Contacto> getContactos(){
		return ContactoDAO.getContactos();
	}

	public static boolean mailEncontrado(String valor_email) {

		boolean mail_encontrado = ContactoDAO.mailEncontrado(valor_email);

		return mail_encontrado;
	}

	
	public boolean contieneDatos (String nombre, String apellido, String email, String telefono) {
		
		boolean datos = false;
		
		if ((nombre != null && !(nombre.equals("")))
				&& (apellido != null && !(apellido.equals("")))
				&& (email != null && !(email.equals("")))
				&& (telefono != null && !(telefono.equals("")))) {
			
			datos = true;
			
		}
		
		else {
			datos = false;
		}
		
		return datos;
		
	}
	
	public static int idContactoNuevo() {
		
		int ultimoId = ContactoDAO.ultimoIdRegistrado()+1;
		return ultimoId;
		
	}
	
}
