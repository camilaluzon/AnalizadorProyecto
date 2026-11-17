package analizador.interfaz;

import analizador.modelo.Modulo;
import analizador.modelo.AnalizadorProyecto;
import analizador.utilitario.Validar;

public class MainAnalizadorProyecto {
    static void main() {
        // Crear arreglo de cinco modulos
        Modulo[] modulos = new Modulo[5];

        // Ingresar informacion de los modulos
        for (int i = 0; i < modulos.length; i++) {

            System.out.println("\n--- INGRESO DEL MODULO " + (i + 1) + " ---");

            String nombre = Validar.leerString("Ingrese el nombre del modulo");

            String lenguaje = Validar.leerString("Ingrese el lenguaje");

            int progreso = Validar.leerEntero("Ingrese el progreso (0-100)", 0);

            while (progreso > 100) {
                System.out.println("El progreso no puede superar 100");
                progreso = Validar.leerEntero("Ingrese nuevamente el progreso (0-100)", 0);
            }

            String respuesta = Validar.leerString("¿El modulo esta terminado? (S/N)");

            while (!respuesta.equalsIgnoreCase("S")
                    && !respuesta.equalsIgnoreCase("N")) {
                System.out.println("Respuesta incorrecta. Ingrese S o N");
                respuesta = Validar.leerString("¿El modulo esta terminado? (S/N)");
            }

            boolean terminado = respuesta.equalsIgnoreCase("S");

            modulos[i] = new Modulo(nombre, lenguaje, progreso, terminado);
        }

        // Crear analizador asociado al arreglo
        AnalizadorProyecto analizador = new AnalizadorProyecto(modulos);

        // Listar modulos
        System.out.println("\n========== LISTADO DE MODULOS ==========");
        System.out.println(analizador.listarModulos());

        // Contar modulos terminados
        System.out.println("Modulos terminados: " + analizador.contarTerminados());

        // Calcular progreso promedio
        System.out.println("Progreso promedio: "
                + analizador.calcularProgresoPromedio() + "%");

        // Buscar modulo existente
        System.out.println("\n========== BUSQUEDA DE MODULO ==========");

        String nombreBuscar = Validar.leerString("Ingrese el nombre del modulo que desea buscar");

        Modulo encontrado = analizador.buscarModulo(nombreBuscar);

        if (encontrado != null) {
            System.out.println("Modulo encontrado:");
            System.out.println(encontrado.mostrarInformacion());
        } else {
            System.out.println("No se encontro el modulo solicitado");
        }

        // Buscar modulo inexistente
        System.out.println("\n========== PRUEBA DE BUSQUEDA INEXISTENTE ==========");

        Modulo inexistente = analizador.buscarModulo("ModuloInexistente");

        if (inexistente == null) {
            System.out.println("La busqueda retorno null correctamente");
        }

        // Reto adicional
        System.out.println("\n========== MODULO CON MENOR PROGRESO ==========");

        Modulo menor = analizador.obtenerMenorProgreso();

        if (menor != null) {
            System.out.println(menor.mostrarInformacion());
        }
    }
}
