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
 <header class="Upp">
        <form action="AttributePasser">
          <input style="display: none" type="text" name="uid" value="<%=request.getAttribute("uid")%>">
          <input style="display: none" type="text" name="local" value="/display.jsp">
	      <input type="submit" class="form form-Save" value="Voltar">
      </form>
 	 
  </header>
<body>	

<div class="main">
      <section class="card-container">
      
				<%@ page import="java.util.*,br.insper.noteblock.*" %>
		<table border='1'>
		<% DAO dao = new DAO();
		 List<Notas> Notas = dao.getLista();
		 for (Notas nota : Notas ) {
			 if(nota.getIduser()==Integer.parseInt(request.getParameter("uid"))){%>
			<form action="Alterar">
			  <article class="card">
              	<header class="card__title">
              		<input type="text" name="nome" placeholder="<%=nota.getNome()%>"><br>
              		<input type="date" name="data" placeholder="<%=nota.getData()%>"><br>
              		<input type="text" name="descri" placeholder="<%=nota.getDescri()%>"><br>
              		
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