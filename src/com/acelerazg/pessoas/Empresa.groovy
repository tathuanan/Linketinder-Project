package com.acelerazg.pessoas

import groovy.transform.ToString
@ToString

class Empresa extends Pessoa {

    String pais
    String cnpj

    String toString() {
        "Empresa(" +
                "nome=${nome}," +
                " email=${email}," +
                " estado=${estado}," +
                " descricao=${descricao}," +
                " competencias=${competencias}," +
                " cep=${cep}," +
                " pais=${pais}," +
                " cnpj=${cnpj})"
    }

}