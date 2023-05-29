package proyecto;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class prueba2
 */
@WebServlet("/prueba2")
public class prueba2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public prueba2() {
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
      byte[] foto=null;
      PreparedStatement insert;
     File file= new File("C:\\Users\\LENOVO\\Documents\\proyecto_final\\proyecto\\WebContent\\img\\IMG-20210821-WA0038.jpg");
     BufferedImage img=ImageIO.read(file);
     ByteArrayOutputStream bye= new ByteArrayOutputStream();
     ImageIO.write(img,"jpg",bye);
     byte[] photobyte=bye.toByteArray();
     name="paco";
      PrintWriter out;
		out=response.getWriter();
		

		estado=request.getParameter("1");
		
		JOptionPane.showMessageDialog(null, estado);
      	try {
      		out.println("<html>");
      		out.println("<head><title>service</title></head>");
      		out.println("<body>");
      		 if(estado.equals("alta")) {
      			insert=conn.prepareStatement(
      					"insert into `prueba`(nombre,img) values(?,?);");
      					insert.setString(1, name);
      					insert.setBytes(2, photobyte);
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
