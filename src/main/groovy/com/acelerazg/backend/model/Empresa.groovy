package com.acelerazg.backend.model

import groovy.transform.ToString
@ToString

class Empresa extends Pessoa {

    private String pais
    private String cnpj
    private String senha

    String getPais() {
        return pais
    }

    void setPais(String pais) {
        this.pais = pais
    }

    String getCnpj() {
        return cnpj
    }

    void setCnpj(String cnpj) {
        this.cnpj = cnpj
    }

    String getSenha() {
        return senha
    }

    void setSenha(String senha) {
        this.senha = senha
    }

    String toString() {
        "Empresa(" +
                " id=${this.id},"+
                " nome=${this.nome}," +
                " cnpj=${this.cnpj}," +
                " email=${this.email}," +
                " senha=${this.senha}," +
                " pais=${this.pais}," +
                " estado=${this.estado}," +
                " cep=${this.cep}," +
                " descricao=${this.descricao} )"

    }

}