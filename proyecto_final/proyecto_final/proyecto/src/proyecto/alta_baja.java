package proyecto;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class alta_baja
 */
@WebServlet("/alta_baja")
public class alta_baja extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public alta_baja() {
        super();
        // TODO Auto-generated constructor stub
    }

    Connection conn=null;
  	String user="root";
  	String driver="com.mysql.cj.jdbc.Driver";
  	String pwd="";
  	String url="jdbc:mysql://localhost:3306/caballos?serverTimezone=UTC";
  	
      public void init(ServletConfig config) throws ServletException{
  		try {
  		    Class.forName(driver);
  			conn=DriverManager.getConnection(url,user,pwd);
  			JOptionPane.showMessageDialog(null,"hemos conectado");
  		} 
  		catch (ClassNotFoundException e1) {
  		            //Error si no puedo leer el driver de Oracle 
  			JOptionPane.showMessageDialog(null, "ERROR:No encuentro el driver de la BD: "+
  					e1.getMessage());
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
      }
      protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      String estado;
      String name=null;
      String nombre=null;
      String raza=null;
      String capa=null;
      PreparedStatement insert;
     
      PrintWriter out;
		out=response.getWriter();

		estado=request.getParameter("1");
		
		JOptionPane.showMessageDialog(null, estado);
      	try {
      		out.println("<html>");
      		out.println("<head><title>service</title></head>");
      		out.println("<body>");
  			Statement smt=conn.createStatement();
      		if(estado.equals("baja")) {
      			name=request.getParameter("user");
      			String delete=
      					"delete from `caballos_clase` where nombre='"+name+"';";
      			smt.executeUpdate(delete);
      			JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
      		}else if(estado.equals("alta")) {
      			nombre=request.getParameter("name");
      			raza=request.getParameter("raza");
      			capa=request.getParameter("capa");
      			insert=conn.prepareStatement(
      					"insert into `caballos_clase`(nombre,descripcion_raza,descripcion_capa) values(?,?,?);");
      					insert.setString(1, nombre);
      					insert.setString(2, raza);
      					insert.setString(3, capa);
      					insert.executeUpdate();
      			JOptionPane.showMessageDialog(null, "se ha insertado un caballo nuevo");
      		}
      	}catch (Exception e) {
  			JOptionPane.showMessageDialog(null, "no se ha actualizado, solo se aceptan datos en formato de fecha");
			response.sendRedirect("pagina_caballos.jsp");
  			System.out.println(e);
      		}
      }
}