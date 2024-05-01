package com.acelerazg.backend.app.model.user

import groovy.transform.ToString

import java.sql.Date
import java.text.SimpleDateFormat

@ToString(includeNames = true)

class Candidato extends Pessoa{

    private String sobrenome
    private String dataNascimento
    private String cpf
    private String pais
    private List<String> competencias
    private String senha

    Candidato(){

    }

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

    String getSobrenome() {
        return sobrenome
    }

    void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome
    }

    void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento
    }

    Date getDataNascimento() {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy")
        java.util.Date dataString = formatador.parse(this.dataNascimento)
        this.dataNascimento = new Date(dataString.getTime())
    }

    String getCpf() {
        return cpf
    }

    void setCpf(String cpf) {
        this.cpf = cpf
    }

    String getPais() {
        return pais
    }

    void setPais(String pais) {
        this.pais = pais
    }

    List<String> getCompetencias() {
        return competencias
    }

    void setCompetencias(List<String> competencias) {
        this.competencias = competencias
    }

    String getSenha() {
        return senha
    }

    void setSenha(String senha) {
        this.senha = senha
    }

    @Override
    String toString() {
        "Candidato(" +
                " id=${this.id}," +
                " nome=${this.nome}," +
                " sobrenome=${this.sobrenome},"+
                " cpf=${this.cpf}," +
                " dt_nascimento=${this.dataNascimento},"+
                " email=${this.email}," +
                " competencias=${this.competencias}," +
                " senha=${this.senha}," +
                " pais=${this.pais}," +
                " estado=${this.estado}," +
                " cep=${this.cep}," +
                " descricao=${this.descricao} )"
    }
}