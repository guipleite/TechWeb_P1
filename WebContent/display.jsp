<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Criando Cards</title>
		  <link rel = "stylesheet"
			type ="text/css"
			href = "home.css"
    />
	</head>
  <body>
  
  <div class="sidenav">
    
    <h3>Nova Nota</h3>

    <form action="Adicionar">
       <br>
        <input type="text" name="nome" value="Titulo"><br>
        <br>
        <input type="text" name="data" value="Data"><br>
        <br>

		<input type="submit"  value="adicionar"><br>

     </form>

      

  </div>
  
  <div class="main">
      <section class="card-container">
      
				<%@ page import="java.util.*,br.insper.noteblock.*" %>
		<table border='1'>
		<% DAO dao = new DAO();
		 List<Notas> Notas = dao.getLista();
		 for (Notas nota : Notas ) { %>

			  <article class="card">
              	<header class="card__title">
                  	<h3><%=nota.getNome()%></h3>
                  	<h5><%=nota.getData().getTime()%></h5>
              	</header>
              
              	<main class="card__description">
                  
              	</main>
              	

              	
              	<form action="Remover">
              		<input style="display: none" type="text" name="id" value="<%=nota.getId()%>">
              		<input type="submit" value="Delete">
      			</form>
      			
      			
          		</article>
		<% } %>
		</table>

      </section>
      <button type="button" class="block" formaction="editar.jsp">Editar notas</button>
  </div>
 

</body>
</html>