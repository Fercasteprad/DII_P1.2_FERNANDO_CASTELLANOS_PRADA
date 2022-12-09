Inicialmente entra en a través de la ruta http://localhost:8080/DII_P1.2_FERNANDO_CASTELLANOS_PRADA

En esta vista podemos añadir un contacto a través del formulario y ver la lista de contactos que hay en la actualidad, 
podemos hacer operaciones tipo eliminar contacto, editar o ver contacto.

Al añadir el contacto comprueba que el correo no existe en la base de datos y que ningun campo esté vacío, esto lo hace el controlador.
en el caso de dejar algún campo vacío o que el correo electrónico exista, devuelve los datos que han sido introducidos para poder
modificarlos.

En cuanto a la parte de lista de contactos:

- Eliminar: a través del método get pasa varios atributos, en el caso que los atributos, editar y ver contacto esten en false
elimina el contacto a través de la id.
- Editar: a través del get pasa un id del contacto con el atributo editar en true y el ver contacto en false, en ese caso
se abre un formulario para editar el contacto, a través de requerided no deja que los campos estén vacios.
- Ver contacto: Recoge la información del id y si editar esta en false y ver contacto en true, abre la información del contacto.

Se han creado diferentes paquetes:
- dam2.dii.p12.contacto
	- Contacto: Es la clase POJO de contacto.
- dam2.dii.p12.controlador
	- Está alojado el servlet controlador para gestionar las peticiones.
- dam2.dii.12.DAO
	- Es la clase donde se gestiona la información, en ella crea los contactos iniciales y realiza varias operaciones.
- dam2.dii.p12.service
	- En la clase realiza todas las operaciones con la base de datos haciendo peticiones a la clase DAO.