package proyecto;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import java.sql.Statement;
import java.util.ArrayList;


/**
 * Servlet implementation class compra
 */
@WebServlet("/compra")
public class compra extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public compra() {
    super();
    // TODO Auto-generated constructor stub
  }

  Connection conn = null;
  String user = "root";
  String driver = "com.mysql.cj.jdbc.Driver";
  String pwd = "";
  String url = "jdbc:mysql://localhost:3306/caballos?serverTimezone=UTC";

  public void init(ServletConfig config) throws ServletException {
    try{
      Class.forName(driver);
      conn = DriverManager.getConnection(url, user, pwd);

      JOptionPane.showMessageDialog(null, "hemos conectado");

    }catch (ClassNotFoundException e1) {
      //Error si no puedo leer el driver de Oracle 
      JOptionPane.showMessageDialog(null, "ERROR:No encuentro el driver de la BD: " +
        e1.getMessage());
    }catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String producto;
    String amount;
    String id = null;
    String productos = null;
    int cantidad = 0;
    int price = 0;
    String precio = null;
    ArrayList < datos_compra > lista = new ArrayList < datos_compra > ();

    ResultSet obtenerDatos = null;
    ResultSet obtenerCantidad = null;
    PreparedStatement insertarNuevaCantidad;

    try{
      PrintWriter out;
      out = response.getWriter();
      producto = request.getParameter("producto");
      amount = (request.getParameter("cantidad"));
      String regex = "^[0-9]+$";
      if(amount.matches(regex)) {
        out.println("<html>");
        out.println("<head><title>service</title></head>");
        out.println("<body>");
        Statement smt = conn.createStatement();
        String cantidades_producto =
          "select cantidad,precio from `compra` where producto='" + producto + "';";
        obtenerCantidad = smt.executeQuery(cantidades_producto);
        JOptionPane.showMessageDialog(null, obtenerCantidad);
        while(obtenerCantidad.next()) {
          cantidad = obtenerCantidad.getInt("cantidad");
          price = obtenerCantidad.getInt("precio");
        }
        if (cantidad == 0) {
          JOptionPane.showMessageDialog(null, "Lo siento actualmente el producto: " + producto + " no se encuentra disponible");
          response.sendRedirect("pagina_compra.jsp");
        }else {
          int restantes = cantidad - Integer.parseInt(amount);
          if (restantes < 0) {
            JOptionPane.showMessageDialog(null, "Lo siento no hay sufiente stock del producto: " + producto + " ,actualmente solo quedan: " + cantidad + " unidades del producto");
            response.sendRedirect("pagina_compra.jsp");
          }else {
            int final_price = Integer.parseInt(amount) * price;
            insertarNuevaCantidad = conn.prepareStatement(
              "update `compra` set cantidad="?" where producto="?";");
          insertarNuevaCantidad.setString(1,restantes);
          insertarNuevaCantidad.setString(2,producto);
            insertarNuevaCantidad.executeUpdate();
            String datos_compras =
              "select id,producto,cantidad,precio from `compra` where producto="?";";
                  insertarNuevaCantidad.setString(1,producto);
            obtenerDatos = smt.executeQuery(datos_compras);
            while (obtenerDatos.next()) {
              id = obtenerDatos.getString("id");
              JOptionPane.showMessageDialog(null, id);
              productos = obtenerDatos.getString("producto");
              JOptionPane.showMessageDialog(null, productos);
              cantidad = obtenerDatos.getInt("cantidad");
              JOptionPane.showMessageDialog(null, cantidad);
              precio = obtenerDatos.getString("precio");
              JOptionPane.showMessageDialog(null, precio);
            }
            datos_compra d = new datos_compra();
            d.setId(id);
            d.setProductos(productos);
            d.setCantidad(cantidad);
            d.setPrecio(precio);
            d.setPrecio_final(final_price);
            lista.add(d);
            request.getSession().setAttribute("lista", lista);
            JOptionPane.showMessageDialog(null, lista + "es la lista");

            if (lista.size() != 0) {
              response.sendRedirect("resultado_compra.jsp");
            }
          }
        }
      }else {
        JOptionPane.showMessageDialog(null, "solo se permiten valores númericos por favor inserte un valor númerico");
        response.sendRedirect("pagina_compra.jsp");
      }
    }catch (Exception e) {
      JOptionPane.showMessageDialog(null, "no recive todos los datos");
    }
  }
}
