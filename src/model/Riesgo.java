package model;

/**
 * Interfaz para las atracciones que poseen clasificación de riesgo.
 */
public interface Riesgo {

    /**
     * Calcula el nivel de riesgo de la atracción.
     *
     * @return nivel de riesgo
     */
    public String calcularNivelRiesgo();
}
