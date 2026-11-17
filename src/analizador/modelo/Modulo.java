package analizador.modelo;

public class Modulo {
    // Atributos
    private String nombre;
    private String lenguaje;
    private int progreso;
    private boolean terminado;

    // Constructor
    public Modulo(String nombre, String lenguaje, int progreso, boolean terminado) {
        this.nombre = nombre;
        this.lenguaje = lenguaje;
        this.progreso = progreso;
        this.terminado = terminado;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getProgreso() {
        return progreso;
    }

    public boolean isTerminado() {
        return terminado;
    }

    // Mostrar informacion
    public String mostrarInformacion() {
        return "Modulo: " + nombre
                + "\nLenguaje: " + lenguaje
                + "\nProgreso: " + progreso + "%"
                + "\nTerminado: " + (terminado ? "Si" : "No");
    }
}
