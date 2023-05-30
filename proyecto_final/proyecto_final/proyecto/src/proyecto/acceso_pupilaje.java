package proyecto;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
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

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.sql.Statement;

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

  Connection conn = null;
  String user = "root";
  String driver = "com.mysql.cj.jdbc.Driver";
  String pwd = "";
  String url = "jdbc:mysql://localhost:3306/caballos?serverTimezone=UTC";

  public void init(ServletConfig config) throws ServletException {
    try {
      Class.forName(driver);
      conn = DriverManager.getConnection(url, user, pwd);

      JOptionPane.showMessageDialog(null, "hemos conectado");

    } catch (ClassNotFoundException e1) {
      //Error si no puedo leer el driver de Oracle 
      JOptionPane.showMessageDialog(null, "ERROR:No encuentro el driver de la BD: " +
        e1.getMessage());
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String user;
    String password;
    String obtenerPassword = null;
    String obtenerUsuario = null;

    PreparedStatement insertarContraseña;
    PreparedStatement eliminarContrasena;
    ResultSet obtenerUser = null;
    ResultSet comprobarUser = null;

    PrintWriter out;
    out = response.getWriter();
    user = request.getParameter("user");
    if (request.getParameter("eliminar") != null) {
      if (user.length() == 0) {
        JOptionPane.showMessageDialog(null, "por favor inserte el nombre de su usuario");
        response.sendRedirect("acceso_pupilaje.jsp");
      } else {
        try {
          int fecha = Integer.parseInt(JOptionPane.showInputDialog("cuando nació tu caballo"));
          if (fecha == 2) {
            eliminarContrasena = conn.prepareStatement(
              "update `pupilaje` set password = 0 where user='" + user + "';");
            eliminarContrasena.executeUpdate();
            JOptionPane.showMessageDialog(null, "contraseña eliminada por favor inserte su nueva contraseña");
            response.sendRedirect("acceso_pupilaje.jsp");
          } else {
            JOptionPane.showMessageDialog(null, "lo siento no es correcto");
            response.sendRedirect("pagina_principal.jsp");
          }
        } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
          System.out.println(e);
        }
      }
    } else {
      try {
        password = request.getParameter("password");
        JOptionPane.showMessageDialog(null, password);
        byte[] claveEnBytes = password.getBytes("UTF-8");
        SecretKeySpec secretKey = new SecretKeySpec(claveEnBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] passwordEncriptada = cipher.doFinal(claveEnBytes);
        String passwordEncriptadaBase64 = Base64.getEncoder().encodeToString(passwordEncriptada);
        JOptionPane.showMessageDialog(null, "3" + passwordEncriptadaBase64);
        out.println("<html>");
        out.println("<head><title>service</title></head>");
        out.println("<body>");
        Statement smt = conn.createStatement();
        String seleccionUser =
          "select password from `pupilaje` where user='" + user + "';";
        obtenerUser = smt.executeQuery(seleccionUser);
        while (obtenerUser.next()) {
          obtenerPassword = obtenerUser.getString(1);
          if (obtenerPassword.length() == 0 || obtenerPassword.equals("0")) {
            insertarContraseña = conn.prepareStatement(
              "update `pupilaje` set password='" + passwordEncriptadaBase64 + "' where user='" + user + "';");
            insertarContraseña.executeUpdate();
          }
          if (obtenerPassword.length() != 0 && !obtenerPassword.equals("0")) {
            if (!obtenerPassword.equals(passwordEncriptadaBase64)) {
              JOptionPane.showMessageDialog(null, "lo siento no ha escrito bien su contraseña");
              RequestDispatcher rd =
                request.getRequestDispatcher("acceso_pupilaje.jsp");
              rd.forward(request, response);
            }
          }
        }
        String obtainUser =
          "select user from `pupilaje` where user='" + user + "';";
        comprobarUser = smt.executeQuery(obtainUser);
        while (comprobarUser.next()) {
          nombreC c = new nombreC();
          obtenerUsuario = comprobarUser.getString(1);
          if (obtenerUsuario.length() != 0) {
            if (obtenerUsuario.equals("Esther")) {
              response.sendRedirect("Seleccion_esther.jsp");
              String nombre = c.setNombre("caballos");
              c.getNombre(nombre);
            } else if (obtenerUsuario.equals("Marina")) {
              response.sendRedirect("relampago.jsp");
              String nombre = c.setNombre("relampago");
              c.getNombre(nombre);
            } else if (obtenerUsuario.equals("Hector")) {
              response.sendRedirect("caballo_seleccion.jsp");
            } else if (!obtenerUsuario.equals("Hector") || !obtenerUsuario.equals("Marina") || !obtenerUsuario.equals("Esther")) {
              JOptionPane.showMessageDialog(null, "no está registrado en la base de datos ");
              response.sendRedirect("acceso_pupilaje.jsp");
            }
          }
        }
      } catch (NoSuchAlgorithmException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
        System.out.println(e1);
        response.sendRedirect("acceso_pupilaje.jsp");
      } catch (NoSuchPaddingException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
        System.out.println(e1);
        response.sendRedirect("acceso_pupilaje.jsp");
      } catch (Exception e) {
        System.out.println(e);
        response.sendRedirect("acceso_pupilaje.jsp");
        // TODO: handle exception
      }
    }
  }
}
