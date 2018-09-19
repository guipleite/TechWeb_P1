package br.insper.noteblock;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Procurar
 */
@WebServlet("/Procurar")
public class Procurar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Procurar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String titulo = request.getParameter("titulo");
		 String uid = request.getParameter("uid");

		 
			request.setAttribute("titulo",titulo);
			request.setAttribute("uid",uid);
			request.getRequestDispatcher("/procura.jsp").forward(request, response);
	}



}
