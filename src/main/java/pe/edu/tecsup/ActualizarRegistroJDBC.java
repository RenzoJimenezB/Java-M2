package pe.edu.tecsup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActualizarRegistroJDBC {
    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                    DatabaseConfig.getUrl(),
                    DatabaseConfig.getUser(),
                    DatabaseConfig.getPassword()
            );

            String sql = """
                    UPDATE productos
                    SET nombre=?
                    WHERE id=?
                    """;
            PreparedStatement ps = con.prepareStatement(sql);

            int id = 6;

            ps.setString(1, "producto 6");
            ps.setInt(2, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected != 1) throw new SQLException("Error al actualizar el registro");

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
