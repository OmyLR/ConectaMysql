package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelos.Usuario;
import utilidades.Conexion;

public class DAOUsuarios {
	
	private Connection conex;
	private String sql;
	private ResultSet rs;
	private Statement stmt;
	
	public DAOUsuarios( ) {
		this.conex = Conexion.conectar("localhost:3306", "tienda", "root", "");
	}
	
	public Usuario getUser(int id) {
		sql = "Select * from usuarios where id = "+id;
		try {
			execSql(sql);
			if(rs.next()) {
				Usuario user = new Usuario();
				user.setClave(rs.getString("clave"));
				user.setId(rs.getInt("id"));
				user.setUsuario(rs.getString("usuario"));
				cleanResultSet();
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Usuario getUserLogin(String user, String pass) {
		sql = "Select * from usuarios where usuario = "+user+" && clave= "+pass;
		try {
			execSql(sql);
			if(rs.next()) {
				Usuario gUser = new Usuario();
				gUser.setClave(rs.getString("clave"));
				gUser.setId(rs.getInt("id"));
				gUser.setUsuario(rs.getString("usuario"));
				cleanResultSet();
				return gUser;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Usuario> getAllUsers() {
		sql = "Select * from usuarios";
		try {
			execSql(sql);
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			while(rs.next()) {
				Usuario user = new Usuario();
				user.setClave(rs.getString("clave"));
				user.setId(rs.getInt("id"));
				user.setUsuario(rs.getString("usuario"));
				usuarios.add(user);
			}
			cleanResultSet();
			return usuarios;
		}catch(SQLException e) {
			
		}
		return null;
	}
	public void editUser(Usuario usuario) {
		sql = "Update usuarios "
				+ "set clave = "+usuario.getClave()
				+ "set usuario = "+usuario.getUsuario()
				+" where id = "+usuario.getId();
		try {
			execSql(sql);
			System.out.println("Ejecutado!!");
		}catch(SQLException e) {
			
		}
	}
	public void deleteUser(int id) {}
	public void insertUser(Usuario usuario) {}
	
	
	private void execSql(String sql) throws SQLException {
		stmt = conex.createStatement();
		rs = stmt.executeQuery(sql);
	}
	
	private void cleanResultSet() {
		rs = null;
	}
}
