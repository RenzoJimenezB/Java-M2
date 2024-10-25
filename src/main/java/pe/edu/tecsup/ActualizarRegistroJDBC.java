package pe.edu.tecsup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActualizarRegistroJDBC {
    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/almacen1", "root", "tchai1712");

            String sql = "UPDATE categorias SET nombre=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            int id = 1;

            ps.setString(1, "updated name");
            ps.setInt(2, id);

            int state = ps.executeUpdate();
            if (state != 1) throw new SQLException("Error al actualizar el registro");

            System.out.println("Se ha actualizado correctamente la categoria con ID: " + id);

            ps.close();
            con.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
