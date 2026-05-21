package model;

/**
 * Representa un espectáculo pirotécnico.
 */
public class EspectaculoPirotecnico extends Atraccion
        implements Riesgo {

    private int duracionMinutos;
    private boolean materialPeligroso;

    /**
     * Constructor del espectáculo pirotécnico.
     */
    public EspectaculoPirotecnico(String nombre,
                                  String zonaUbicacion,
                                  int capacidadMaxima,
                                  int edadMinimaAnios,
                                  int visitantesPorDia,
                                  double precioEntrada,
                                  int duracionMinutos,
                                  boolean materialPeligroso) {

        super(nombre,
                zonaUbicacion,
                capacidadMaxima,
                edadMinimaAnios,
                visitantesPorDia,
                precioEntrada);

        this.duracionMinutos = duracionMinutos;
        this.materialPeligroso = materialPeligroso;
    }

    /**
     * Calcula el ingreso diario.
     */
    @Override
    public double calcularIngresoDiario() {

        double ingreso =
                visitantesPorDia * precioEntrada;

        if (materialPeligroso) {

            ingreso += ingreso * 0.20;
        }

        return ingreso;
    }

    /**
     * Determina si requiere mantenimiento.
     */
    @Override
    public boolean requiereMantenimiento() {

        return materialPeligroso ||
                duracionMinutos > 60;
    }

    /**
     * Calcula el nivel de riesgo.
     */
    @Override
    public String calcularNivelRiesgo() {

        if (materialPeligroso) {

            return "ALTO";
        }

        if (duracionMinutos > 60) {

            return "MEDIO";
        }

        return "BAJO";
    }

    @Override
    public String toString() {

        return super.toString() +
                "\nDuración minutos  : " + duracionMinutos +
                "\nMaterial peligroso: " +
                materialPeligroso;
    }
}
