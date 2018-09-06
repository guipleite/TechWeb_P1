<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Editor de notas</title>
		  <link rel = "stylesheet"
			type ="text/css"
			href = "home.css"
    		/>
	</head>
	<body>
	
<a href="editar.jsp" class="previous round">&#8249;</a>
<div class="main">
      <section class="card-container">
      
				<%@ page import="java.util.*,br.insper.noteblock.*" %>
		<table border='1'>
		<% DAO dao = new DAO();
		 List<Notas> Notas = dao.getLista();
		 for (Notas nota : Notas ) { %>
			<form action="Alterar">
			  <article class="card">
              	<header class="card__title">
              		<input type="text" name="nome" value="<%=nota.getNome()%>"><br>
              		<input type="text" name="data" value="<%=nota.getData()%>"><br>
        			<br>
              	</header>
              
              	<main class="card__description">
                  
              	</main>
	
              	
              		<input style="display: none" type="text" name="id" value="<%=nota.getId()%>">
              		<input type="submit" value="Concluir">
      			</form>
      			
      			
          		</article>
		<% } %>
		</table>

      </section>
  </div>
	</body>
</html>