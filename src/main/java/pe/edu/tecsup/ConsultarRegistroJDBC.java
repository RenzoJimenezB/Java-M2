package pe.edu.tecsup;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ConsultarRegistroJDBC {
    public static void main(String[] args) {

        Dotenv dotenv = Dotenv.load();

        String url = dotenv.get("DB_URL");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");

        try {
            Connection con = DriverManager.getConnection(url, user, password);

            String sql = "SELECT id, nombre, descripcion, precio, stock, categorias_id FROM productos";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");
                int categoriasId = rs.getInt("categorias_id");

                System.out.printf(">>> id = %d , nombre=%s, descripcion=%s, precio=%.2f, stock=%d, categorias_id=%d %n", id, nombre, descripcion, precio, stock, categoriasId);
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
//            e.printStackTrace();
        }
    }
}