package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOUsuarios;
import modelos.Libro;
import modelos.Usuario;
import utilidades.Conexion;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/conecta")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controlador() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opcion = request.getParameter("opcion");
		Connection cnx;
		String ruta = "";
		if (opcion != null) {
			switch(opcion) {
				case "1": 
					opcion1(request);
					ruta = "mensaje.jsp";
					break;
				case "2":
					ruta = "listado.jsp";
					opcion2(request);
					break;
				case "3":
					ruta = "login.jsp";
					break;
				case "4":
					opcion4();
					break;
			}
			
			request.getRequestDispatcher("jsp/"+ruta).forward(request, response);
	
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void opcion1(HttpServletRequest request) {
		Connection cnx = Conexion.conectar("localhost:3306", "tienda", "root", "");
		String mensaje = "Error de conexión...";
		request.setAttribute("mensaje", mensaje);
	}
	
	private void opcion2(HttpServletRequest request) {
		ArrayList<Libro> libros =  Conexion.getLibros();
		request.getSession().setAttribute("libros", libros);
	}
	
	private void opcion4() {
		DAOUsuarios controller = new DAOUsuarios();
		Usuario user = new Usuario();
		user.setClave("admin2");
		user.setId(1);
		user.setUsuario("admin");
		controller.editUser(user);
	}

}
