<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Criando Cards</title>
		  <link rel = "stylesheet"
			type ="text/css"
			href = "Form.css"
    />
	</head>
  <body>
  
  <div class="sidenav">
    
    <h3>Nova Nota</h3>
    
    <form action="Adicionar">
       <br>
        <input type="text" name="nome"placeholder="Titulo"><br>
        <br>
        <input type="text" name="desc" placeholder="Descrição"><br>
        <br>
        <input type="date" id="myDate" name="data" value="Data"><br>
        <br>
        <input type="submit" name="Save" class="form form-Save" value="Adicionar"> <br>
        <br>
        <input type="button" name="edit" class="form form-Save" value="Editar" onclick="window.location='editar.jsp';">
        
        
        <p id="demo"></p>
        
        <script>
        function myFunction() {
            var x = document.getElementById("myDate").value;
            document.getElementById("demo").innerHTML = x;
        }
        </script>
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
  </div>
 

</body>
</html>