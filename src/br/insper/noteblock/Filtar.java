package br.insper.noteblock;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Filtar extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DAO dao = new DAO();
		
		 
		 String ini = request.getParameter("dataInicial");
		 String fin = request.getParameter("dataFinal");
		 
		

		 
		 dao.close();
		request.setAttribute("ini",ini);
		request.setAttribute("fin",fin);
		request.getRequestDispatcher("/filtro.jsp").forward(request, response);
		
	}
}
