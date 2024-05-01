package com.acelerazg.backend.app.model.business

class Competencia {

    private int id
    private String competencia

    int getId() {
        return id
    }

    void setId(int id) {
        this.id = id
    }

    String getCompetencia() {
        return competencia
    }

    void setCompetencia(String competencia) {
        this.competencia = competencia
    }

    String toString() {
        "Competencia(" +
                " id=${this.id},"+
                " competencia=${this.competencia} )"
    }

}
