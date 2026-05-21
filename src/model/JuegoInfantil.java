package model;

/**
 * Representa un juego infantil.
 */
public class JuegoInfantil extends Atraccion {

    private int edadMaxima;
    private boolean supervisionPermanente;

    /**
     * Constructor del juego infantil.
     */
    public JuegoInfantil(String nombre,
                         String zonaUbicacion,
                         int capacidadMaxima,
                         int edadMinimaAnios,
                         int visitantesPorDia,
                         double precioEntrada,
                         int edadMaxima,
                         boolean supervisionPermanente) {

        super(nombre,
                zonaUbicacion,
                capacidadMaxima,
                edadMinimaAnios,
                visitantesPorDia,
                precioEntrada);

        this.edadMaxima = edadMaxima;
        this.supervisionPermanente = supervisionPermanente;
    }

    /**
     * Calcula el ingreso diario.
     */
    @Override
    public double calcularIngresoDiario() {

        double ingreso =
                visitantesPorDia * precioEntrada;

        if (supervisionPermanente) {

            ingreso += visitantesPorDia * 50000;
        }

        return ingreso;
    }

    /**
     * Determina si requiere mantenimiento.
     */
    @Override
    public boolean requiereMantenimiento() {

        return !supervisionPermanente ||
                visitantesPorDia > capacidadMaxima;
    }

    @Override
    public String toString() {

        return super.toString() +
                "\nEdad máxima           : " + edadMaxima +
                "\nSupervisión permanente: " +
                supervisionPermanente;
    }
}
