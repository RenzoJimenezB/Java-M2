package pe.edu.tecsup.lab01.servicios;

import pe.edu.tecsup.lab01.repositorios.CategoriaRepositorio;
import pe.edu.tecsup.lab01.entidades.Categoria;

import java.util.List;

public class CategoriaServicio {
    public static void main(String[] args) {

        CategoriaRepositorio consulta = new CategoriaRepositorio();

        List<Categoria> categorias = consulta.getCategories();

        for (Categoria categoria : categorias) {
            System.out.println(categoria);
        }
    }
}
