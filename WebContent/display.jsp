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
    
    <h3>Novo evento</h3>
    
    <form action="Adicionar">
       <br>
        <input type="text" name="nome"placeholder="Titulo">
        <br>
        <input type="text" name="descri" placeholder="Descrição">
        <br>
        <input type="date" id="myDate" name="data" value="Data">
        <br>
        <input type="submit" name="Save" class="form form-Save" value="Adicionar"> 
        
        <input type="button" name="edit" class="form form-Save" value="Editar" onclick="window.location='editar.jsp';">
        
        
        
        
        <h4>Filtrar</h4>
        <h6>De:</h6>
        <input type="date" id="myDate" name="dataInicial" value="Data"><br>
        <h6>Até:</h6>
        <input type="date" id="myDate" name="dataFinal" value="Data"><br>
        
        
        
        <p id="demo"></p>
        
        <script>
        function myFunction() {
            var x = document.getElementById("myDate").value;
            document.getElementById("demo").innerHTML = x;
        }
        </script>
      </form>     

  </div>
  
  
  <style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

/* Button used to open the contact form - fixed at the bottom of the page */
.open-button {
  background-color: #555;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  opacity: 0.8;
  position: fixed;
  bottom: 23px;
  right: 28px;
  width: 280px;
}

/* The popup form - hidden by default */
.form-popup {
  display: none;
  position: fixed;
  bottom: 0;
  right: 15px;
  border: 3px solid #f1f1f1;
  z-index: 9;
}

/* Add styles to the form container */
.form-container {
  max-width: 300px;
  padding: 10px;
  background-color: white;
}

/* Full-width input fields */

/* Set a style for the submit/login button */
.form-container .btn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  margin-bottom:10px;
  opacity: 0.8;
}

/* Add a red background color to the cancel button */
.form-container .cancel {
  background-color: red;
}

/* Add some hover effects to buttons */
.form-container .btn:hover, .open-button:hover {
  opacity: 1;
}
</style>
</head>
<body>

<button type="image" src="https://image.flaticon.com/icons/svg/61/61094.svg"  class="open-button" onclick="openForm()">Open Form</button>

<div class="form-popup" id="myForm">
  <form action="Config" class="form-container">
    <h1>Configurações</h1>

    <input type="button" name="edit" class="form form-Save" value="Editar" onclick="window.location='wow.jsp';">
    <input type="button" name="edit" class="form form-Save" value="Sair" onclick="window.location='login.jsp';">
    <input type="submit" name="Del" class="form form-Save" value="Apagar Conta"> 
    
    
    <button type="button" class="btn cancel" onclick="closeForm()">X</button>
  </form>
</div>

<script>
function openForm() {
    document.getElementById("myForm").style.display = "block";
}

function closeForm() {
    document.getElementById("myForm").style.display = "none";
}
</script>

</body>
  
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
                  	<h6><%=nota.getDescri()%></h6>
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