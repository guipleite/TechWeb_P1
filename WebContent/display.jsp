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
    
    <h3>Novo Evento</h3>

    <form action="Testar">
       <br>
        <input type="text" value="Title"><br>
        <br>
        <input type="text" name="Email" value="Descrition"><br>
        <br>
        <input type="date" id="myDate" value="YYYY/MM/DD"><br>
        <br>
        <button onclick="myFunction()">Save</button>
        

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
              	<a href="#" class="button">Botão</a>
      
          		</article>
		<% } %>
		</table>

      </section>
  </div>
 

</body>
</html>