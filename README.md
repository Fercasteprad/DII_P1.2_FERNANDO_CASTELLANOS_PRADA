# DII_P1.2_FERNANDO_CASTELLANOS_PRADA
Desarrolla una aplicación web en Java , siguiendo el patrón MVC, que simule una agenda
de contactos:
1. Al cargar la url base del proyecto se mostrará un formulario con los campos
correspondientes para almacenar un contacto:
● Nombre [input-texto]
● Apellidos [input-texto]
● Email [input-email]
● Teléfono [input-numérico]
● Comentarios [textarea]
Además contará con un botón para el envío de los datos al Servlet.
Los datos serán validados en el servidor, por lo que si algún campo se deja sin
rellenar (vacío) no se creará el contacto y se informará de ello al usuario mediante
un mensaje en la misma vista dónde se encuentra el formulario (index.jsp).
2. Crea la clase POJO Contacto, con los atributos necesarios para almacenar los
datos con sus correspondientes métodos de acceso (set y get), para poder operar
con ellos posteriormente. Además, se añadirá un primer campo entero id, que será
añadido de manera automática al objeto Contacto en el momento de la creación y
que será autoincremental, es decir, no se repetirá y se irá incrementando a medida
que se crean nuevos contactos.
3. Los datos recogidos del formulario se mapean con la clase Contacto y se
almacenan en una lista en memoria, por ejemplo un ArrayList de elementos
Contacto.
4. Crea una función para comprobar que el email del contacto introducido a través
del formulario no existe ya en el listado de contactos. De ser así, el contacto se
almacenará en el listado, en caso contrario, no se almacenará, informando al
usuario con un mensaje en la vista.
5. Una vez almacenados los datos del nuevo contacto, mostrar en una vista, el
listado de contactos almacenados en la lista en memoria.
6. Modifica el programa para que el listado de contactos aparezca en la misma vista
dónde se encuentra el formulario (index.jsp).
7. Usa CSS para mostrar al usuario un mensaje en rojo informando en la vista si se
ha podido almacenar o no el contacto.
8. Implementa la funcionalidad de borrado de un contacto desde la vista del listado.
Una vez eliminado el contacto, vuelve a la misma vista, actualizando el listado.
9. De igual forma, implementa la funcionalidad de edición de un contacto desde la
vista del listado. Una vez editado el contacto, vuelve a la misma vista,
actualizando el listado.
Las dos funcionalidades anteriores, borrado y edición, estarán disponibles a través del
enlace correspondiente a cada operación en el listado de contactos, asociadas a cada
uno de los contactos (ten en cuenta el id del contacto a eliminar/editar). A modo de
ejemplo, en la siguiente imagen se muestra un listado con las dos operaciones
disponibles a ejecutar para cada usuario del listado:
Se aconseja crear datos de prueba que se carguen al inicio de la aplicación y así no tener
que crear nuevos contactos cada vez que se inicie la aplicación.
Como ampliación, usa CSS en el diseño de la web e implementa alguna funcionalidad
adicional a la solicitada de forma correcta y conveniente, siendo su uso coherente en el
contexto de la aplicación (detallar en el fichero README.txt que debe acompañar a la
aplicación).
