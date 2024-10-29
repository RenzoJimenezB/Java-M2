package pe.edu.tecsup;

import java.sql.*;

public class ConsultarRegistroConParametrosJDBC {
    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                    ConnectionParamsJDBC.getUrl(),
                    ConnectionParamsJDBC.getUser(),
                    ConnectionParamsJDBC.getPassword());

            String sql = """
                    SELECT id, nombre, descripcion
                    FROM categorias
                    WHERE id=? AND nombre LIKE ?
                    """;
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, 1);
            ps.setString(2, "%name%");

            ResultSet rs = ps.executeQuery();

//            while (rs.next()) {
            if (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");

                System.out.printf("id=%d, nombre=%s, descripcion=%s %n", id, nombre, descripcion);
            }

            rs.close();
            ps.close();
            con.close();


        } catch (SQLException e) {
            System.out.println("SQL error code: " + e.getErrorCode());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("SQL error message: " + e.getMessage());
        }
    }
}
