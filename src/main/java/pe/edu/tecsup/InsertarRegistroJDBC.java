package pe.edu.tecsup;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class InsertarRegistroJDBC {
    public static void main(String[] args) {

        Dotenv dotenv = Dotenv.load();

        String url = dotenv.get("DB_URL");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");

        try {
            Connection con = DriverManager.getConnection(url, user, password);

            String sql = "INSERT INTO categorias (nombre, descripcion, orden) values (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "categoria 5");
            ps.setString(2, "descripcion 5");
            ps.setInt(3, 5);

            int state = ps.executeUpdate();
            if (state != 1) throw new SQLException("No se pudo insertar la categoria");

            int categoryId = 0;

            sql = "SELECT LAST_INSERT_ID()";
            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
                categoryId = rs.getInt(1);

            System.out.printf("Se ha insertado correctamente la categoría con ID: %d", categoryId);

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            System.err.println("SQL error code: " + e.getErrorCode());
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("SQL error message: " + e.getMessage());
//            e.printStackTrace();
//            throw new RuntimeException(e);
        }
    }
}
