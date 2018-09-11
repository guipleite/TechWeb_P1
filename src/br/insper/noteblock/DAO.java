package br.insper.noteblock;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DAO {
	
private Connection connection = null;

public DAO() {
	
	 try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 try {
		connection = DriverManager.getConnection(
		"jdbc:mysql://localhost/testelista", "root", "116319");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	public List<Notas> getLista() {
		List<Notas> notas = new ArrayList<Notas>();
		try {
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Notas");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Notas nota = new Notas();
			nota.setId(rs.getInt("id"));
			nota.setNome(rs.getString("nome"));
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("data"));
			nota.setData(data);
			notas.add(nota);
		
		}
		//System.out.println(notas);
	rs.close();
	stmt.close();
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	return notas;
}
	
//	public Notas getNota() {
//		Notas nota = new Notas();
//		try {
//		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Notas");
//		ResultSet rs = stmt.executeQuery();
//		while (rs.next()) {
//			Notas nota = new Notas();
//			nota.setId(rs.getInt("id"));
//			nota.setNome(rs.getString("nome"));
//			Calendar data = Calendar.getInstance();
//			data.setTime(rs.getDate("data"));
//			nota.setData(data);
//			notas.add(nota);
//		
//		}
//		//System.out.println(notas);
//	rs.close();
//	stmt.close();
//	} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//	}
//	return nota;
//}	

	
	public void adiciona(Notas nota) {
		String sql = "INSERT INTO Notas" +
		"(nome,data) values(?,?)";
		try {
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,nota.getNome());
		stmt.setDate(2, new java.sql.Date(
				nota.getData().getTimeInMillis()));
		stmt.execute();
		stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		}
	

	
	
	public void altera(Notas nota) {
		String sql = "UPDATE Notas SET " +
		 "nome=?, data=? WHERE id=?";
		try {
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, nota.getNome());
		stmt.setDate(2, new Date(nota.getData()
				.getTimeInMillis()));
		stmt.setInt(3, nota.getId());
		stmt.execute();
		stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		}
	
	public void remove(Integer id) {
		try {
		PreparedStatement stmt = connection
		 .prepareStatement("DELETE FROM Notas WHERE id=?");
		stmt.setLong(1, id);
		stmt.execute();
		stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		}
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

}