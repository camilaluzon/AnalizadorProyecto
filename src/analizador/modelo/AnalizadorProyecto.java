package analizador.modelo;

public class AnalizadorProyecto {
    // Atributo
    private Modulo[] modulos;

    // Constructor
    public AnalizadorProyecto(Modulo[] modulos) {
        this.modulos = modulos;
    }

    // Listar todos los modulos
    public String listarModulos() {
        String resultado = "";

        for (int i = 0; i < modulos.length; i++) {
            if (modulos[i] != null) {
                resultado += modulos[i].mostrarInformacion() + "\n";
            }
        }

        return resultado;
    }

    // Contar modulos terminados
    public int contarTerminados() {
        int contador = 0;

        for (int i = 0; i < modulos.length; i++) {
            if (modulos[i] != null && modulos[i].isTerminado()) {
                contador++;
            }
        }

        return contador;
    }

    // Calcular progreso promedio
    public double calcularProgresoPromedio() {
        int suma = 0;
        int contador = 0;

        for (int i = 0; i < modulos.length; i++) {
            if (modulos[i] != null) {
                suma += modulos[i].getProgreso();
                contador++;
            }
        }

        if (contador == 0) {
            return 0;
        }

        return (double) suma / contador;
    }

    // Buscar modulo por nombre
    public Modulo buscarModulo(String nombre) {

        for (int i = 0; i < modulos.length; i++) {
            if (modulos[i] != null
                    && modulos[i].getNombre().equals(nombre)) {
                return modulos[i];
            }
        }

        return null;
    }

    // Obtener modulo con menor progreso (reto adicional)
    public Modulo obtenerMenorProgreso() {
        Modulo menor = null;

        for (int i = 0; i < modulos.length; i++) {
            if (modulos[i] != null) {
                if (menor == null
                        || modulos[i].getProgreso() < menor.getProgreso()) {
                    menor = modulos[i];
                }
            }
        }

        return menor;
    }
}
