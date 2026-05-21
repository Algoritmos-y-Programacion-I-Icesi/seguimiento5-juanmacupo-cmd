package model;

/**
 * Clase abstracta que representa una atracción del parque.
 */
public abstract class Atraccion {

    protected String nombre;
    protected String zonaUbicacion;
    protected int capacidadMaxima;
    protected int edadMinimaAnios;
    protected int visitantesPorDia;
    protected double precioEntrada;

    /**
     * Constructor de la clase Atraccion.
     *
     * @param nombre nombre de la atracción
     * @param zonaUbicacion zona donde se encuentra ubicada
     * @param capacidadMaxima capacidad máxima permitida
     * @param edadMinimaAnios edad mínima requerida
     * @param visitantesPorDia visitantes registrados en el día
     * @param precioEntrada precio de entrada de la atracción
     */
    public Atraccion(String nombre, String zonaUbicacion, int capacidadMaxima,
                     int edadMinimaAnios, int visitantesPorDia, double precioEntrada) {

        this.nombre = nombre;
        this.zonaUbicacion = zonaUbicacion;
        this.capacidadMaxima = capacidadMaxima;
        this.edadMinimaAnios = edadMinimaAnios;
        this.visitantesPorDia = visitantesPorDia;
        this.precioEntrada = precioEntrada;
    }

    /**
     * Calcula el ingreso diario generado por la atracción.
     * @return ingreso diario de la atracción
     */
    public abstract double calcularIngresoDiario();

    /**
     * Determina si la atracción requiere mantenimiento.
     * Retorna true si requiere mantenimiento y false en caso contrario.
     * @return estado de mantenimiento de la atracción
     */
    public abstract boolean requiereMantenimiento();

    /**
     * Genera una alerta si la atracción supera la capacidad máxima.
     * @return mensaje de alerta o cadena vacía si no hay sobreocupación
     */
    public String generarAlertaCapacidad() {

        if (visitantesPorDia > capacidadMaxima) {

            int exceso = visitantesPorDia - capacidadMaxima;

            double porcentaje =
                    (exceso * 100.0) / capacidadMaxima;

            return "ALERTA: La atracción " + nombre +
                    " supera la capacidad máxima.\n" +
                    "Exceso de visitantes: " + exceso +
                    "\nPorcentaje de sobreocupación: " +
                    String.format("%.2f", porcentaje) + "%";
        }

        return "";
    }

    /**
     * Retorna una representación en texto de la información de la atracción.
     * @return información general de la atracción
     */
    @Override
    public String toString() {

        return "--------------------------------------------" +
                "\nNombre         : " + nombre +
                "\nZona           : " + zonaUbicacion +
                "\nCapacidad max  : " + capacidadMaxima + " personas" +
                "\nEdad minima    : " + edadMinimaAnios + " años" +
                "\nVisitantes hoy : " + visitantesPorDia +
                "\nPrecio entrada : $" +
                String.format("%,.2f", precioEntrada) +
                "\nIngreso diario : $" +
                String.format("%,.2f", calcularIngresoDiario());
    }

    // Setter
    public void setVisitantesPorDia(int visitantes) {
        this.visitantesPorDia = visitantes;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }
    public String getZonaUbicacion() {
        return zonaUbicacion;
    }
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
    public int getEdadMinimaAnios() {
        return edadMinimaAnios;
    }
    public int getVisitantesPorDia() {
        return visitantesPorDia;
    }
    public double getPrecioEntrada() {
        return precioEntrada;
    }
}
