public class Cliente {

    private String nombre;
    private int dni;
    private int edad;


    public Cliente(String nombre, int dni, int edad) {

        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;

    }


    public String getNombre() {
        return nombre;
    }


    public int getDni() {
        return dni;
    }


    public int getEdad() {
        return edad;
    }
}