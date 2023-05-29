package proyecto;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


/**
 * Servlet implementation class acceso_pupilaje
 */
@WebServlet("/acceso_pupilaje")
public class acceso_pupilaje extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public acceso_pupilaje() {
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
    	  String user;
    	  String password;
    	  String obtenerPassword=null;
    	  String obtenerUsuario=null;

        	PreparedStatement insertarContraseña;
      	ResultSet obtenerUser=null;
      	ResultSet comprobarUser=null;


    	  
    	  PrintWriter out;
  		out=response.getWriter();		
  		user=request.getParameter("user");
  		password=request.getParameter("password");
  		
  		try {
  			out.println("<html>");
    		out.println("<head><title>service</title></head>");
    		out.println("<body>");
			java.sql.Statement smt=conn.createStatement();
			
			String seleccionUser=
					"select password from `pupilaje` where user='"+user+"';";
			obtenerUser=smt.executeQuery(seleccionUser);
			while(obtenerUser.next()) {
				 obtenerPassword= obtenerUser.getString(1);
				if(obtenerPassword.length()==0) {
				insertarContraseña=conn.prepareStatement(
						"update `pupilaje` set password='"+password+"' where user='"+user+"';");
				insertarContraseña.executeUpdate();
				}			
				 if(obtenerPassword.length()!=0){
					 if(!obtenerPassword.equals(password)){
					JOptionPane.showMessageDialog(null, "lo siento no ha escrito bien su contraseña");
					RequestDispatcher rd=
							request.getRequestDispatcher("acceso_pupilaje.jsp");
					rd.forward(request, response);
					 }
				}	 
				 }
			 String obtainUser=
					 "select user from `pupilaje` where user='"+user+"';";
			 comprobarUser=smt.executeQuery(obtainUser);
			 while(comprobarUser.next()) {
				 nombreC c= new nombreC();
				 obtenerUsuario= comprobarUser.getString(1);
				 if(obtenerUsuario.length()!=0){
				 if(obtenerUsuario.equals("Esther")) {
					 response.sendRedirect("Seleccion_esther.jsp");
					 String nombre=c.setNombre("caballos");
					 c.getNombre(nombre);
				 }
				 else if(obtenerUsuario.equals("Marinera")) {
					 response.sendRedirect("relampago.jsp");
					 String nombre=c.setNombre("relampago");
					 c.getNombre(nombre);
				 }
				 else if(obtenerUsuario.equals("hectorino")) {
					 response.sendRedirect("caballo_seleccion.jsp");
				 }
				 else if(!obtenerUsuario.equals("hectorino")||!obtenerUsuario.equals("Marinera")||!obtenerUsuario.equals("Esther")) {
					 JOptionPane.showMessageDialog(null, "no está registrado en la base de datos ");
				 }
				 }
			 }
			
			
				}
  				catch (Exception e) {
  		  			System.out.println(e);
			// TODO: handle exception
		}
  		
      }

}
