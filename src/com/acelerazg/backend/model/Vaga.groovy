package com.acelerazg.backend.model

class Vaga {

    int id
    String nome
    String descricao
    String cidade
    String empresa

    String toString() {
        "Vaga(" +
            " id=${id}," +
            " nome=${nome}," +
            " descricao=${descricao}," +
            " cidade=${cidade}," +
            " empresa=${empresa} )"
    }

}
