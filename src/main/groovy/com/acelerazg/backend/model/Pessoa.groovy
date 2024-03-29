package com.acelerazg.backend.model

import groovy.transform.ToString
@ToString(includeNames = true)

class Pessoa {

    int id
    String nome
    String email
    String estado
    String descricao
    String cep

    @Override
    String toString() {
        return super.toString()
    }
}
