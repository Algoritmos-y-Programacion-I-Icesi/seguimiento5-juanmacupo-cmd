package model;

/**
 * Representa un simulador de realidad virtual.
 */
public class SimuladorVR extends Atraccion implements Riesgo {

    private int numeroEstaciones;
    private boolean requiereAnteojos;

    /**
     * Constructor del simulador VR.
     */
    public SimuladorVR(String nombre,
                       String zonaUbicacion,
                       int capacidadMaxima,
                       int edadMinimaAnios,
                       int visitantesPorDia,
                       double precioEntrada,
                       int numeroEstaciones,
                       boolean requiereAnteojos) {

        super(nombre,
                zonaUbicacion,
                capacidadMaxima,
                edadMinimaAnios,
                visitantesPorDia,
                precioEntrada);

        this.numeroEstaciones = numeroEstaciones;
        this.requiereAnteojos = requiereAnteojos;
    }

    /**
     * Calcula el ingreso diario del simulador.
     */
    @Override
    public double calcularIngresoDiario() {

        double ingreso =
                visitantesPorDia * precioEntrada;

        if (!requiereAnteojos) {

            ingreso = ingreso * 0.90;
        }

        return ingreso;
    }

    /**
     * Determina si requiere mantenimiento.
     */
    @Override
    public boolean requiereMantenimiento() {

        return numeroEstaciones > 20 ||
                visitantesPorDia > capacidadMaxima;
    }

    /**
     * Calcula el nivel de riesgo.
     */
    @Override
    public String calcularNivelRiesgo() {

        if (requiereAnteojos &&
                numeroEstaciones > 20) {

            return "ALTO";
        }

        if (requiereAnteojos ||
                numeroEstaciones > 20) {

            return "MEDIO";
        }

        return "BAJO";
    }

    @Override
    public String toString() {

        return super.toString() +
                "\nNúmero estaciones : " + numeroEstaciones +
                "\nRequiere anteojos : " + requiereAnteojos;
    }
}
