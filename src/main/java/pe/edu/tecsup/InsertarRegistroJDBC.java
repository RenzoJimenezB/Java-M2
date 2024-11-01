package pe.edu.tecsup;

import java.sql.*;

public class InsertarRegistroJDBC {
    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                    DatabaseConfig.getUrl(),
                    DatabaseConfig.getUser(),
                    DatabaseConfig.getPassword()
            );

            String sql = """
                    INSERT INTO productos (nombre, descripcion, precio, stock, categorias_id)
                    VALUES (?, ?, ?, ?, ?)
                    """;
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "producto 5");
            ps.setString(2, "descripcion producto 5");
            ps.setDouble(3, 13.13);
            ps.setInt(4, 1000);
            ps.setInt(5, 3);


            int rowsAffected = ps.executeUpdate();
            if (rowsAffected != 1) throw new SQLException("No se pudo insertar la categoria");

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
            e.printStackTrace();
//            throw new RuntimeException(e);
        }
    }
}
