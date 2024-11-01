package pe.edu.tecsup.lab01;

public class Categoria {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer orden;

//    public Categoria(int id, String nombre, String descripcion, Integer orden) {
//        this.id = id;
//        this.nombre = nombre;
//        this.descripcion = descripcion;
//        this.orden = orden;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", orden=" + orden +
                '}';
    }
}
