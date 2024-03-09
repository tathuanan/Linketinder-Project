package com.acelerazg.backend.pessoas

import groovy.transform.ToString
@ToString(includeNames = true)

class Pessoa {

    String nome
    String email
    String estado
    String descricao
    List<String> competencias
    def cep

    @Override
    String toString() {
        return super.toString()
    }
}
