package pe.edu.tecsup.lab01;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class Consulta {
    public static void main(String[] args) {

        Dotenv dotenv = Dotenv.load();

        String url = dotenv.get("DB_URL");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");

        List<Categoria> categorias = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection(url, user, password);

            String sql = """
                    SELECT id, nombre, descripcion, orden
                    FROM categorias
                    """;
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setNombre(rs.getString("nombre"));
                categoria.setDescripcion(rs.getString("descripcion"));
                categoria.setOrden(rs.getInt("orden"));

                categorias.add(categoria);
            }

            rs.close();
            stmt.close();
            con.close();

            for (Categoria categoria : categorias) {
                System.out.println(categoria);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
//            e.printStackTrace();
        }
    }
}