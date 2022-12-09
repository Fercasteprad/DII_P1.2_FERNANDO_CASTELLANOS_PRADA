package dam2.dii.p12.DAO;

import java.util.ArrayList;

import dam2.dii.p12.contacto.Contacto;

public class ContactoDAO {
	
	private static ArrayList<Contacto> contactos = crearContactos();
	
	private static ArrayList<Contacto> crearContactos() {
		
		ArrayList<Contacto> contactos = new ArrayList<Contacto>();
		Contacto num01 = new Contacto (contactos.size()+1,"Fernando","Castellanos Prada","fercasteprad@gmail.com","667026260","inteligente");
		contactos.add(num01);
    	Contacto num02 = new Contacto (contactos.size()+1,"Alicia","Rodas Martin","ali.rodass@gmail.com","689455963","guapa");
    	contactos.add(num02);
		return contactos;
		
	}
	
	public static ArrayList<Contacto> getContactos(){
		return contactos;
	}
	
	public static void eliminarContacto(int id_num) {

		for (int i = 0; i < contactos.size(); i++) {
			if (contactos.get(i).getId() == id_num) {
				contactos.remove(i);
			}
		}

	}
	
	public static int getArrayPosition(int id_num) {

		int arrayPosition = 0;

		for (int i = 0; i < contactos.size(); i++) {
			if (contactos.get(i).getId() == id_num) {
				arrayPosition = i;
			}
		}
		return arrayPosition;
	}
	
	public static boolean mailEncontrado(String valor_email) {

		boolean mail_encontrado = false;

		for (int i = 0; i < contactos.size(); i++) {

			if (valor_email.equals(contactos.get(i).getEmail())) {
				mail_encontrado = true;

			}

		}

		return mail_encontrado;
	}
	
	public static int ultimoIdRegistrado() {
		
		int ultimoId = contactos.get(contactos.size()-1).getId();
		return ultimoId;

		
	}

}
