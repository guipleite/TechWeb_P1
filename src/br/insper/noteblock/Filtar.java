package br.insper.noteblock;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Filtar {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DAO dao = new DAO();
		
		 Notas nota = new Notas();
		 String ini = request.getParameter("dataInicial");
		 String fin = request.getParameter("dataFinal");
		 
		
		java.util.Date dataI = null;
		java.util.Date dataF = null;

		try {
			dataI = new SimpleDateFormat("yyyy-MM-dd").parse(ini);
			dataF = new SimpleDateFormat("yyyy-MM-dd").parse(fin);

			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Calendar dataNotaI = Calendar.getInstance();
		 Calendar dataNotaF = Calendar.getInstance();

		 dataNotaI.setTime(dataI);
		 nota.setDataInicial(dataNotaI);
		 dataNotaF.setTime(dataF);
		 nota.setDataFinal(dataNotaF);

		 dao.getFilter();
		 
		 dao.close();
		response.sendRedirect("/NoteBlock/display.jsp");
		
	}
}
