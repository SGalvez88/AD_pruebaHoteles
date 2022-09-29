
package lecturapruebas.classes;

public class Hotel {
    private int id;
    private String nombre;
    private String direccion;
    private float precioNoche;
    
    public Hotel(int id, String nombre, String direccion, float precioNoche) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.precioNoche = precioNoche;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public float getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(float precioNoche) {
        this.precioNoche = precioNoche;
    }   
    
    @Override
    public String toString() {
        return "id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", precioNoche=" + precioNoche;
    }
}
