package proyecto;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.mysql.cj.jdbc.Blob;

/**
 * Servlet implementation class prueba
 */
@WebServlet("/prueba")
public class prueba extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public prueba() {
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
      String imageBase64=null;
      Blob imagenBlob = null;
      InputStream enviar = null;
    ResultSet obtenerUser=null;
    byte[] imagenBytes=null;
      PreparedStatement insert;
   //  File file= new File("C:\\Users\\LENOVO\\Documents\\proyecto_final\\proyecto\\WebContent\\img\\IMG-20210821-WA0038.jpg");
     //FileInputStream is = new FileInputStream("C:/Users/LENOVO/Documents/proyecto_final/proyecto/WebContent/img/IMG-20210821-WA0038.jpg");
     //BufferedImage img=ImageIO.read(file);
     //ByteArrayOutputStream bye= new ByteArrayOutputStream();
     //ImageIO.write(img,"jpg",bye);
     //byte[] photobyte=bye.toByteArray();
      String rutaImagen = "C:/Users/LENOVO/Documents/proyecto_final/proyecto/WebContent/img/IMG-20210821-WA0038.jpg";
      Path path = Paths.get(rutaImagen);
      byte[] imageData = Files.readAllBytes(path);
      SerialBlob blob = null;
	try {
		blob = new javax.sql.rowset.serial.SerialBlob(imageData);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}


     name="los";
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
      	//				insert.setBytes(2, photobyte);
      					//insert.setBlob(2, is);
      					insert.setBlob(2, blob);
      					insert.executeUpdate();
      			JOptionPane.showMessageDialog(null, "se ha insertado un caballo nuevo");
      		
    			java.sql.Statement smt=conn.createStatement();
      			String seleccionUser=
    					"select nombre,img from `prueba`;";
    			obtenerUser=smt.executeQuery(seleccionUser);
    			List<datos>dat= new ArrayList<>();
    			datos d=(datos) new datos();

    			if(obtenerUser.next()) {
    				nombre= obtenerUser.getString("nombre");
    				Blob blob1 = (Blob) obtenerUser.getBlob("img");

    			    // Obtener el contenido del Blob en un arreglo de bytes
    			    byte[] imageDatas = blob.getBytes(1, (int) blob.length());

    			    // Codificar el arreglo de bytes en base64 para usarlo en el JSP
    			    String encodedImage = Base64.getEncoder().encodeToString(imageData);
    			    if(nombre.length()!=0) {
    	    			//request.getSession().setAttribute("dat", dat);
    			    	request.setAttribute("encodedImage", encodedImage);
    	    			response.sendRedirect("prueba2.jsp");
    	    			}
    			    // Pasar el contenido codificado como atributo en la respuesta del JSP
    			    
    			}
    				
      		}
    			JOptionPane.showMessageDialog(null, imagenBlob);
    			JOptionPane.showMessageDialog(null, enviar);
    			JOptionPane.showMessageDialog(null, imagenBytes);
    			//JOptionPane.showMessageDialog(null, imageBase64);
    			//d.setNombre(nombre);
    			//d.setUrl( imageBase64);
    			//d.setImg(imagenBytes);
    			
    			//dat.add(d);
    			
      		 
      	}catch (Exception e) {
  			JOptionPane.showMessageDialog(null, "no se ha actualizado, solo se aceptan datos en formato de fecha");
  			System.out.println(e);
      		}
      }
}