package model;

import java.util.ArrayList;

/**
 * Clase controladora del sistema MagicWorld.
 * Administra la lista de atracciones y centraliza
 * las operaciones principales del sistema.
 */
public class Parque {

    private String nombre;
    private ArrayList<Atraccion> atracciones;

    /**
     * Constructor del parque.
     * @param nombre nombre del parque
     */
    public Parque(String nombre) {

        this.nombre = nombre;
        this.atracciones = new ArrayList<>();
    }

    /**
     * Retorna la lista de atracciones registradas.
     * @return lista de atracciones
     */
    public ArrayList<Atraccion> getAtracciones() {
        return atracciones;
    }

    // ---------------------------------------------------------------
    // REGISTRO DE ATRACCIONES
    // ---------------------------------------------------------------

    /**
     * Registra un simulador de realidad virtual.
     * El simulador queda agregado a la lista de atracciones.
     */
    public void agregarSimuladorVR(String nombre,
                                   String zonaUbicacion,
                                   int capacidadMaxima,
                                   int edadMinimaAnios,
                                   double precioEntrada,
                                   int numeroEstaciones,
                                   boolean requiereAnteojos) {

        SimuladorVR simulador = new SimuladorVR(
                nombre,
                zonaUbicacion,
                capacidadMaxima,
                edadMinimaAnios,
                0,
                precioEntrada,
                numeroEstaciones,
                requiereAnteojos);

        atracciones.add(simulador);
    }

    /**
     * Registra un juego infantil.
     *
     * post: El juego infantil queda agregado a la lista de atracciones.
     */
    public void agregarJuegoInfantil(String nombre,
                                     String zonaUbicacion,
                                     int capacidadMaxima,
                                     int edadMinimaAnios,
                                     double precioEntrada,
                                     int edadMaxima,
                                     boolean supervisionPermanente) {

        JuegoInfantil juego = new JuegoInfantil(
                nombre,
                zonaUbicacion,
                capacidadMaxima,
                edadMinimaAnios,
                0,
                precioEntrada,
                edadMaxima,
                supervisionPermanente);

        atracciones.add(juego);
    }

    /**
     * Registra un espectáculo pirotécnico.
     *
     * post: El espectáculo queda agregado a la lista de atracciones.
     */
    public void agregarEspectaculoPirotecnico(String nombre,
                                              String zonaUbicacion,
                                              int capacidadMaxima,
                                              int edadMinimaAnios,
                                              double precioEntrada,
                                              int duracionMinutos,
                                              boolean materialPeligroso) {

        EspectaculoPirotecnico espectaculo =
                new EspectaculoPirotecnico(
                        nombre,
                        zonaUbicacion,
                        capacidadMaxima,
                        edadMinimaAnios,
                        0,
                        precioEntrada,
                        duracionMinutos,
                        materialPeligroso);

        atracciones.add(espectaculo);
    }

    // ---------------------------------------------------------------
    // VISITANTES
    // ---------------------------------------------------------------

    /**
     * Busca una atracción y registra sus visitantes del día.
     *
     * @param nombreAtraccion nombre de la atracción
     * @param visitantesPorDia visitantes registrados
     */
    public void registrarVisitantes(String nombreAtraccion,
                                    int visitantesPorDia) {

        Atraccion atraccionEncontrada =
                buscarAtraccionPorNombre(nombreAtraccion);

        if (atraccionEncontrada == null) {

            System.out.println(
                    "No se encontró una atracción con el nombre: "
                            + nombreAtraccion);

        } else {

            atraccionEncontrada.setVisitantesPorDia(
                    visitantesPorDia);
        }
    }

    /**
     * Busca una atracción por nombre.
     *
     * @param nombreAtraccion nombre de la atracción buscada
     * @return atracción encontrada o null si no existe
     */
    public Atraccion buscarAtraccionPorNombre(
            String nombreAtraccion) {

        for (Atraccion atraccion : atracciones) {

            if (atraccion.getNombre()
                    .equalsIgnoreCase(nombreAtraccion)) {

                return atraccion;
            }
        }

        return null;
    }

    // ---------------------------------------------------------------
    // CÁLCULOS Y REPORTES
    // ---------------------------------------------------------------

    /**
     * Calcula el ingreso total diario del parque.
     * @return ingreso total diario
     */
    public double calcularIngresoTotalDiario() {

        double total = 0;

        for (Atraccion atraccion : atracciones) {

            total += atraccion.calcularIngresoDiario();
        }

        return total;
    }

    /**
     * Muestra los ingresos diarios de cada atracción.
     */
    public void mostrarIngresosDiarios() {

        for (Atraccion atraccion : atracciones) {

            System.out.println(
                    atraccion.getNombre() +
                            " -> $" +
                            String.format("%,.2f",
                                    atraccion.calcularIngresoDiario()));
        }
    }

    /**
     * Genera el reporte general de operaciones.
     */
    public void generarReporteOperaciones() {

        for (Atraccion atraccion : atracciones) {

            System.out.println(atraccion);

            System.out.println(
                    "Requiere mantenimiento: "
                            + atraccion.requiereMantenimiento());

            System.out.println();
        }
    }

    /**
     * Muestra las atracciones que tienen clasificación de riesgo.
     * Se muestran únicamente las atracciones que implementan la interfaz Riesgo.
     */
    public void mostrarAtraccionesClasifRiesgo() {

        for (Atraccion atraccion : atracciones) {

            if (atraccion instanceof Riesgo) {

                Riesgo riesgo = (Riesgo) atraccion;

                System.out.println(
                        atraccion.getNombre() +
                                " -> Riesgo: " +
                                riesgo.calcularNivelRiesgo());
            }
        }
    }

    /**
     * Genera el reporte de alertas de capacidad.
     */
    public void generarReporteAlertasCapacidad() {

        for (Atraccion atraccion : atracciones) {

            String alerta =
                    atraccion.generarAlertaCapacidad();

            if (!alerta.equals("")) {

                System.out.println(alerta);
                System.out.println();
            }
        }
    }
}
