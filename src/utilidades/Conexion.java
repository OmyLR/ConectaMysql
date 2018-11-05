package utilidades;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.Statement;

import modelos.Libro;

public class Conexion {
	private String host;
	private String bd;
	private String usr;
	private String clave;
	private static Connection conexion;

	public static Connection conectar(String host, String bd, String usr, String clave) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://" + host +"/"+ bd+"?useSSL=false";
			conexion = DriverManager.getConnection(url, usr, clave);
		} catch (SQLException e) {
			System.out.println("Error sql -> " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Error carga del driver -> " + e.getMessage());
		}

		return conexion;
	}
	
	public static ArrayList<Libro> getLibros() {
		conexion = conectar("localhost:3306", "tienda", "root", "");
		Statement stmt;
		ArrayList<Libro> libros = new ArrayList<Libro>();
		try {
			stmt = conexion.createStatement();
			String query = "Select * from books";
			ResultSet result = stmt.executeQuery(query);
			while(result.next()) {
				Libro libro = new Libro();
				libro.setAuthor(result.getString("author"));
				libro.setBook_id(result.getInt("book_id"));
				libro.setCategory(result.getInt("category_id"));
				libro.setPrice(result.getDouble("price"));
				libro.setTitle(result.getString("title"));
				libros.add(libro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return libros;
	}

}
