<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Filtro de Cards</title>
		  <link rel = "stylesheet"
			type ="text/css"
			href = "Form.css"
    />
	</head>
  <body>
  
  <div class="sidenav">
    
    <h3>Filtro</h3>
    
    <input type="button" name="edit" class="form form-Save" value="Editar" onclick="window.location='editar.jsp';">
    <input type="image" src="https://static.thenounproject.com/png/344330-200.png" width="68" height="68" class="back-button" onclick="window.location='display.jsp';"></input>
    
    
  
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

/* Button used to open the contact form - fixed at the bottom of the page */
.config-button {
  color: white;
  padding: 0px 20px;
  border: none;
  cursor: pointer;
  opacity: 0.8;
  position: fixed;
  bottom: 23px;
  left: 0%;
}

.back-button {
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  opacity: 0.8;
  position: fixed;
  bottom: 90%;
  left: -1%;
}

/* The popup form - hidden by default */
.form-popup {
  display: none;
  position: fixed;
  bottom: 0;
  left: 15px;
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


<input type="image" src="https://image.flaticon.com/icons/svg/61/61094.svg" width="68" height="68" class="config-button" onclick="openForm()"></input>

<div class="form-popup" id="myForm">
  <form action="Config" class="form-container">
    <h1>Configurações</h1>

    <input type="button" name="edit" class="form form-Save" value="Editar" onclick="window.location='wow.jsp';">
    <input type="button" name="edit" class="form form-Save" value="Sair" onclick="window.location='login.jsp';">
    <input type="submit" name="Del" class="form form-Save" value="Apagar Conta"> 
    
    <button type="button" class="btn cancel" onclick="closeForm()">X</button>
	
	<script>
	function openForm() {
	    document.getElementById("myForm").style.display = "block";
	}
	
	function closeForm() {
	    document.getElementById("myForm").style.display = "none";
	}
	</script>
  </form>
  </div>
  
  
  <br>
	


  </div>

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