package com.acelerazg.backend.model

import groovy.transform.ToString
@ToString(includeNames = true)

class Candidato extends Pessoa{

    String sobrenome
    String dt_nascimento
    String cpf
    String pais
    List<String> competencias
    String senha

    @Override
    String toString() {
        "Candidato(" +
                " id=${id}," +
                " nome=${nome}," +
                " sobrenome=${sobrenome},"+
                " cpf=${cpf}," +
                " dt_nascimento=${dt_nascimento},"+
                " email=${email}," +
                " competencias=${competencias}," +
                " senha=${senha}," +
                " pais=${pais}," +
                " estado=${estado}," +
                " cep=${cep}," +
                " descricao=${descricao} )"
    }
}