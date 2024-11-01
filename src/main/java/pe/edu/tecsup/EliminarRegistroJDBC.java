package pe.edu.tecsup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EliminarRegistroJDBC {
    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                    DatabaseConfig.getUrl(),
                    DatabaseConfig.getUser(),
                    DatabaseConfig.getPassword()
            );

            String sql = """
                    DELETE FROM categorias
                    WHERE id=?
                    """;
            PreparedStatement ps = con.prepareStatement(sql);

            int id = 8;

            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected != 1) throw new SQLException("Error al eliminar el registro");

            System.out.printf("Se ha eliminado la categoria con ID: %d \n", id);

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
