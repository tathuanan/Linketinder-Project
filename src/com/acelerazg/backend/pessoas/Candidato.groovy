package com.acelerazg.backend.pessoas

import groovy.transform.ToString
@ToString(includeNames = true)

class Candidato extends Pessoa{

    String cpf
    int idade

    @Override
    String toString() {
        "Candidato(" +
                " nome=${nome}," +
                " email=${email}," +
                " estado=${estado}," +
                " descricao=${descricao}," +
                " competencias=${competencias}," +
                " cep=${cep}," +
                " cpf=${cpf}," +
                " idade=${idade})"
    }
}