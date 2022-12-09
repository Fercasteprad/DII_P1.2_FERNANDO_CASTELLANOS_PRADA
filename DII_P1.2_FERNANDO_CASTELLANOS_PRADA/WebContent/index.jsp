<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dam2.dii.p12.contacto.Contacto"%>
<%@ page import="java.util.ArrayList"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
<title>Agenda</title>
</head>
<body>
    <div class="centrar">
    <h1> Agenda de contactos</h1>
    </div>
	<div class="centrar">
		<form action="<%=request.getContextPath()%>/" method="post">

			<input class="barras" type="text" name="nombre" placeholder="Introduce nombre"
				<%String name = (String) request.getAttribute("nombre");
if (name == null) {

}

else {
	out.print("value='" + name + "'");
}%>><br>
			<input class="barras" type="text" name="apellidos" placeholder="Introduce apellidos"
				<%String lastname = (String) request.getAttribute("apellidos");
if (lastname == null) {

}

else {
	out.print("value='" + lastname + "'");
}%>><br>
			<input class="barras" type="email" name="email" placeholder="Introduce email"
				<%String mail = (String) request.getAttribute("email");
if (mail == null) {

}

else {
	out.print("value='" + mail + "'");
}%>><br>
			<input class="barras" type="number" name="telefono" placeholder="Introduce teléfono"
				<%String phone = (String) request.getAttribute("telefono");
if (phone == null) {

}

else {
	out.print("value='" + phone + "'");
}%>><br>
			<input class="barras" type="text" name="comentarios" placeholder="Comentarios"
				<%String coment = (String) request.getAttribute("comentario");
if (coment == null) {

}

else {
	out.print("value='" + coment + "'");
}%>><br>    
            <div class="centrar">
			<input id="boton" type="submit" name="boton" value="Crear usuario"><br>
			</div>
			<div class="centrar">
			  <%
                String error = (String) request.getAttribute("error");
                if (error != null && !error.equals("")) {
                    out.println("<p id='mensaje_error'>" + error + "</p>");

                }
                %>  
             </div>        
		</form>

	</div>
	<div class="centrar">
        <h1>Lista de contactos</h1><br>
    </div>
    <div class ="centrar">
    <div class ="centrarenBloque">
		<%
		ArrayList<Contacto> contactos = new ArrayList<Contacto>();
		contactos = (ArrayList<Contacto>) request.getAttribute("contactos");

		String edicion_set = (String) request.getAttribute("edicion");
		String edicion = "";
		
		String ver_set = (String) request.getAttribute("ver");
		String ver = "";

		if (edicion_set != null) {
			edicion = edicion_set;
		}

		String id_set = (String) request.getAttribute("id");
		int id_edicion = -1;

		if (id_set != null) {
			id_edicion = Integer.parseInt(id_set);
		}
		
		if (ver_set != null) {
			ver = ver_set;
		}

		if (contactos == null) {
		%>
		<br>
		<form action="<%=request.getContextPath()%>/" method="get">
			<input type="submit" value="Mostrar contactos">
		</form>
		
		<%
		}

		else {
		for (int i = 0; i < contactos.size(); i++) {
			Contacto mostrar = contactos.get(i);
		%>
		<div class="centrarBloque">
		<div class="container">
		<div class ="item">
			<p><%=mostrar.getNombre()%></p>
		</div>
		<div class ="item">
			<p><a href="<%=request.getContextPath()%>/?id=<%=mostrar.getId()%>&edit=false&ver=false">Eliminar</a><p>
		</div>
		<div class ="item">
			<p><a href="<%=request.getContextPath()%>/?id=<%=mostrar.getId()%>&edit=true&ver=false">Editar</a><p>
		</div>
		      <div class ="item">
            <p><a href="<%=request.getContextPath()%>/?id=<%=mostrar.getId()%>&edit=false&ver=true">Ver contacto</a><p>
        </div>
		
        

		<%
		if (edicion.equals("true") && (mostrar.getId() == id_edicion)) {
		%>
		</div>
		<div class="centrarBloque">
		      <div class="containerFormulario">
                <h3>Edición de contacto</h3>
            </div>
		    <div class="containerFormulario">
			   <form action="<%=request.getContextPath()%>/" method="post">
				    <input type="text" required name="nombreEdit" placeholder="Nombre" value="<%=mostrar.getNombre()%>" > 
				    <input type="text" required name="apellidoEdit" placeholder="Apellido" value="<%=mostrar.getApellido()%>">
				    <input type="email" required name="emailEdit" placeholder="email" value="<%=mostrar.getEmail()%>"> 
				    <input type="number"required name="telefonoEdit" placeholder="telefono" value="<%=mostrar.getTelefono()%>">
				    <input type="text" name="comentarioEdit" placeholder="Comentario" value="<%=mostrar.getComentario()%>"> 
				    <input type="text" hidden="true" name="idEdit" value="<%=mostrar.getId()%>"> 
				    <input type="submit" name="boton2" value="Editar">
			     </form>
		    </div>
		</div>
        </div>
		<%
		}
		
		else if (ver.equals("true") && (mostrar.getId() == id_edicion)){
			%>
	    </div>
        <div class="centrarBloque">
              <div class="containerFormulario">
                <h3>Información de contacto</h3>
            </div>
            <div class="centrarBloque">
                <div class="centrarInformacion"><p><strong>Nombre:</strong> <%=mostrar.getNombre()%></p></div>
                <div class="centrarInformacion"><p><strong>Apellidos:</strong> <%=mostrar.getApellido()%></p></div>
                <div class="centrarInformacion"><p><strong>e-mail:</strong> <%=mostrar.getEmail()%></p></div>
                <div class="centrarInformacion"><p><strong>Telefono:</strong> <%=mostrar.getTelefono()%></p></div>
                <div class="centrarInformacion"><p><strong>Comentario:</strong> <%=mostrar.getComentario()%></p></div>
            </div>
        </div>
        </div>
        <%
		}
		
		else{
			%>
			</div>
			</div>
			<% 
		}
		}
		}
		%>
		</div>
		</div>
</body>
</html>