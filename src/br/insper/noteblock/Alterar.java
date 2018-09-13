package br.insper.noteblock;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Alterar
 */
@WebServlet("/Alterar")
public class Alterar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Alterar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		
		 Notas nota = new Notas();
		 nota.setId(Integer.parseInt(request.getParameter("id")));
		 nota.setNome(request.getParameter("nome"));
		 nota.setDescri(request.getParameter("descri"));
		 String tempo = request.getParameter("data");
		 java.util.Date data = null;
		try {
			data = new SimpleDateFormat("yyyy-MM-dd").parse(tempo);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Calendar dataNota = Calendar.getInstance();
		 dataNota.setTime(data);
		 nota.setData(dataNota);
		
		 

		 dao.altera(nota);
		 
		 dao.close();
		response.sendRedirect("/NoteBlock/display.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}