package util;

/**
 *
 * @author Pablo
 */
public enum Tabelas {

    ALUNO("ALUNO"),
    ATENDENTE("ATENDENTE"),
    ATENDIMENTO("ATENDIMENTO"),
    ENFERMIDADE("ENFERMIDADE"),
    ESTOQUE("ESTOQUE"),
    CURSO("CURSO"),
    SALA("SALA"),
    MEDICAMENTO("MEDICAMENTO"),
    LOGIN("LOGIN");

    private String value;

    Tabelas(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

}
