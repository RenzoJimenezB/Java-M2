package pe.edu.tecsup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ConsultarRegistrosJDBC {
    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/almacen1", "root", "tchai1712");

            String sql = "SELECT id, nombre, descripcion FROM categorias";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");

                System.out.printf(">>> id = %d , nombre=%s, descripcion=%s %n", id, nombre, descripcion);
                System.out.println(">>> id = " + id + ", nombre=" + nombre + ", descripcion=" + descripcion);
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