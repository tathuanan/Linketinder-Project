package com.acelerazg.backend.model

class Vaga {

    int id
    String nome
    String descricao
    List<String> competencias
    String cidade
    String empresa

    String toString() {
        "Vaga(" +
            " id=${id}," +
            " nome=${nome}," +
            " competencias=${competencias}," +
            " descricao=${descricao}," +
            " cidade=${cidade}," +
            " empresa=${empresa} )"
    }

}
