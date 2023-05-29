package proyecto;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


/**
 * Servlet implementation class caballos_clase
 */
@WebServlet("/caballos_clase")
public class caballos_clase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public caballos_clase() {
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
      String nombre;
      String name=null;
      String raza=null;
      String capa=null;
     
      ResultSet obtener;
      PrintWriter out;
		out=response.getWriter();
		datos_caballos_clase dcc=(datos_caballos_clase) new datos_caballos_clase();
   	 ArrayList<datos_caballos_clase>list=new ArrayList<datos_caballos_clase>();

		nombre=request.getParameter("1");
		JOptionPane.showMessageDialog(null, nombre);
      	try {
      		out.println("<html>");
      		out.println("<head><title>service</title></head>");
      		out.println("<body>");
  			Statement smt=conn.createStatement();
  			String select=
  					"select nombre,descripcion_raza,descripcion_capa from `caballos_clase` where nombre="?";";
		actualizar.setString(1,nombre);
  			obtener=smt.executeQuery(select);
  			while(obtener.next()) {
  				name=obtener.getString("nombre");
	  			raza=obtener.getString("descripcion_raza");
	  			JOptionPane.showMessageDialog(null, raza);
	  			capa=obtener.getString("descripcion_capa");
  			}
  			dcc.setNombre(name);
  			dcc.setCapa(capa);
	  		dcc.setRaza(raza);
	  		list.add(dcc);
	  		if(nombre.length()!=0) {
	  			request.getSession().setAttribute("list", list);
				response.sendRedirect("caballos_clase.jsp");

	  		}

      	}catch (Exception e) {
  			JOptionPane.showMessageDialog(null, "no se ha actualizado, solo se aceptan datos en formato de fecha");
			response.sendRedirect("pagina_caballos.jsp");
  			System.out.println(e);
      		}
      }
}
