<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Editor de notas</title>
		  <link rel = "stylesheet"
			type ="text/css"
			href = "Form.css"
    		/>
	</head>
 
 <div class="sidenav">
    
    <h3>Editar</h3>
    
    <form action="AttributePasser">
          <input style="display: none" type="text" name="uid" value="<%=request.getAttribute("uid")%>">
          <input style="display: none" type="text" name="local" value="/display.jsp">
    	  <input type="image" src="https://static.thenounproject.com/png/344330-200.png" width="68" height="68" class="back-button" ></input>
      </form>
 </div>
        
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}
</style> 
<body>	

<div class="main">
      <section class="card-container">
      
	 <%@ page import="java.util.*,br.insper.noteblock.*" %>
		<table border='1'>
		<% DAO dao = new DAO();
		 List<Notas> Notas = dao.getLista();
		 for (Notas nota : Notas ) {
			 if(nota.getIduser()==Integer.parseInt(request.getParameter("uid"))){
				 String cor = "erro-tipo não existente";
				 if (nota.getTipo().equals("urg")){
				 	cor = "background-color:red";}
				 if (nota.getTipo().equals("emd")){
					 	cor = "background-color:green";}
				 if (nota.getTipo().equals("atr")){
					 	cor = "background-color:yellow";}%>
			<form action="Alterar">
			  <article class="card" style=<%=cor%>>
              	<header class="card__title">
              		<input type="text" name="nome" placeholder="<%=nota.getNome()%>"><br>
              		<input type="date" name="data" placeholder="<%=nota.getData()%>"><br>
              		<input type="text" name="descri" placeholder="<%=nota.getDescri()%>"><br>
              		<select name="tipo">
					  <option value="urg">Urgente</option>
					  <option value="emd">Em data</option>
					  <option value="atr">Atrasado</option>
					</select>
        			<br>
              	</header>
              
              	<main class="card__description">
                  
              	</main>
	
					<input style="display: none" type="text" name="uid" value="<%=request.getAttribute("uid")%>">              	
              		<input style="display: none" type="text" name="id" value="<%=nota.getId()%>">
              		<input type="submit" value="Concluir">
      			</form>
      			
      			
          		</article>
		<% }} %>
		</table>

      </section>
  </div>
	</body>
</html>