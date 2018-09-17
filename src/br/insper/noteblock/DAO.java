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
			nota.setDescri(rs.getString("descri"));
			data.setTime(rs.getDate("data"));
			nota.setData(data);
			notas.add(nota);
		
		}

	rs.close();
	stmt.close();
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	return notas;
}
	
	public List<Notas> getFilter(){
		
		String sql = "SELECT * FROM Notas WHERE data <= ? and data >= ? ";
		//String sql = "SELECT * FROM Notas WHERE data <= '1998-05-30' and data >= '1998-05-03'";

		String date1 ="1998-05-30";//request.getParameter("dataInicial");

		String date2 ="1998-05-03" ;//request.getParameter("dataFinal");


		
		
		List<Notas> notas = new ArrayList<Notas>();
		try {
		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setString(1,date1);
		stmt.setString(2,date2);
		
		ResultSet rs = stmt.executeQuery();

		
		//stmt.setDate(1 ,nota.setDataInicial("dataInicial"));
		//stmt.setDate(2, nota.setDataFinal("dataFinal"));
		while (rs.next()) {
			Notas note = new Notas();
			note.setId(rs.getInt("id"));
			note.setNome(rs.getString("nome"));
			Calendar data = Calendar.getInstance();
			note.setDescri(rs.getString("descri"));
			data.setTime(rs.getDate("data"));
			note.setData(data);
			notas.add(note);
		}

	rs.close();
	stmt.close();
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	return notas;
}
	
	
	
	public void adiciona(Notas nota) {
		String sql = "INSERT INTO Notas" +
		"(nome,data,descri) values(?,?,?)";
		try {
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,nota.getNome());
		stmt.setDate(2, new java.sql.Date(
				nota.getData().getTimeInMillis()));
		stmt.setString(3,nota.getDescri());
		stmt.execute();
		stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		}
	
	public void addUser(Usuario usuario) {
		String sql = "INSERT INTO Usuarios" +
		"(user,senha) values(?,?)";
		try {
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,usuario.getUser());
		stmt.setString(2,usuario.getSenha());
		stmt.execute();
		stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		}
	

	
	
	public void altera(Notas nota) {
		String sql = "UPDATE Notas SET " +
		 "nome=?, data=? ,descri=? WHERE id=?";
		try {
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, nota.getNome());
		stmt.setDate(2, new Date(nota.getData()
				.getTimeInMillis()));
		stmt.setString(3,nota.getDescri());
		stmt.setInt(4, nota.getId());
		stmt.execute();
		stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		}
	
	
	public void altUser(Usuario usuario) {
		String sql = "UPDATE Usuarios SET " +
		 "user=?, senha=? WHERE id=?";
		try {
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, usuario.getUser());
		stmt.setString(2,usuario.getSenha());
		stmt.setInt(3, usuario.getId());
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
	
	
	public void remUser(Integer id) {
		try {
		PreparedStatement stmt = connection
		 .prepareStatement("DELETE FROM Usuarios WHERE id=?");
		stmt.setLong(1, id);
		stmt.execute();
		stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		}
	

	public boolean login(Usuario usuario) {
		boolean pass = false;
		String sql = "SELECT user, senha FROM Usuarios WHERE user = ? AND senha = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getUser());
			stmt.setString(2,usuario.getSenha());
			stmt.execute();
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				  String username = rs.getString("user");
				  String usersenha = rs.getString("senha");
			if (usuario.getUser().equals(username) && usuario.getSenha().equals(usersenha)){
				pass = true;}
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		
		return pass;
		}
	
	public Usuario showUser(Integer id) {
		Usuario usuario = new Usuario();
		String sql = "SELECT user, senha FROM Usuarios iduser=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.execute();
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				usuario.setUser(rs.getString("user"));
				usuario.setSenha(rs.getString("senha"));
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		
		return usuario ;
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