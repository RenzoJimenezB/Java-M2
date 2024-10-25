package pe.edu.tecsup;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActualizarRegistroJDBC {
    public static void main(String[] args) {

        Dotenv dotenv = Dotenv.load();

        String url = dotenv.get("DB_URL");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");

        try {
            Connection con = DriverManager.getConnection(url, user, password);

            String sql = "UPDATE categorias SET descripcion=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            int id = 9;

            ps.setString(1, "updated description 9");
            ps.setInt(2, id);

            int state = ps.executeUpdate();
            if (state != 1) throw new SQLException("Error al actualizar el registro");

            System.out.printf("Se ha actualizado correctamente la categoria con ID: %d \n", id);

            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("SQL error code: " + e.getErrorCode());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("SQL error message: " + e.getMessage());
//            e.printStackTrace();
//            throw new RuntimeException(e);
        }
    }
}
