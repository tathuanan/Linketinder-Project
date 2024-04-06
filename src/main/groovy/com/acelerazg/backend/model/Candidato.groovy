package com.acelerazg.backend.model

import groovy.transform.ToString

import java.sql.Date
import java.text.SimpleDateFormat

@ToString(includeNames = true)

class Candidato extends Pessoa{

    String sobrenome
    String dataNascimento
    String cpf
    String pais
    List<String> competencias
    String senha

    Candidato(
            int id,
            String nome,
            String sobrenome,
            String dataNascimento,
            String cpf,
            String email,
            String estado,
            String descricao,
            String cep,
            String pais,
            List<String> competencias,
            String senha
    ){
        this.id = id
        this.nome = nome
        this.sobrenome = sobrenome
        this.dataNascimento = dataNascimento
        this.cpf = cpf
        this.email = email
        this.estado = estado
        this.descricao = descricao
        this.cep = cep
        this.pais = pais
        this.competencias = competencias
        this.senha = senha
    }

    Date getDataNascimento() {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy")
        java.util.Date dataString = formatador.parse(this.dataNascimento)
        this.dataNascimento = new Date(dataString.getTime())
    }

    @Override
    String toString() {
        "Candidato(" +
                " id=${id}," +
                " nome=${nome}," +
                " sobrenome=${sobrenome},"+
                " cpf=${cpf}," +
                " dt_nascimento=${dataNascimento},"+
                " email=${email}," +
                " competencias=${competencias}," +
                " senha=${senha}," +
                " pais=${pais}," +
                " estado=${estado}," +
                " cep=${cep}," +
                " descricao=${descricao} )"
    }
}