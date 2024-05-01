package com.acelerazg.backend.app.model.user

import groovy.transform.ToString
@ToString(includeNames = true)

class Pessoa {

    private int id
    private String nome
    private String email
    private String estado
    private String descricao
    private String cep

    int getId() {
        return id
    }

    void setId(int id) {
        this.id = id
    }

    String getNome() {
        return nome
    }

    void setNome(String nome) {
        this.nome = nome
    }

    String getEmail() {
        return email
    }

    void setEmail(String email) {
        this.email = email
    }

    String getEstado() {
        return estado
    }

    void setEstado(String estado) {
        this.estado = estado
    }

    String getDescricao() {
        return descricao
    }

    void setDescricao(String descricao) {
        this.descricao = descricao
    }

    String getCep() {
        return cep
    }

    void setCep(String cep) {
        this.cep = cep
    }

    @Override
    String toString() {
        return super.toString()
    }
}
