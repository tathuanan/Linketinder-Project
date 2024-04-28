package com.acelerazg.backend.model

class Vaga {

    private int id
    private String nome
    private String descricao
    private List<String> competencias
    private String cidade
    private String empresa

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

    String getDescricao() {
        return descricao
    }

    void setDescricao(String descricao) {
        this.descricao = descricao
    }

    List<String> getCompetencias() {
        return competencias
    }

    void setCompetencias(List<String> competencias) {
        this.competencias = competencias
    }

    String getCidade() {
        return cidade
    }

    void setCidade(String cidade) {
        this.cidade = cidade
    }

    String getEmpresa() {
        return empresa
    }

    void setEmpresa(String empresa) {
        this.empresa = empresa
    }

    String toString() {
        "Vaga(" +
            " id=${this.id}," +
            " nome=${this.nome}," +
            " competencias=${this.competencias}," +
            " descricao=${this.descricao}," +
            " cidade=${this.cidade}," +
            " empresa=${this.empresa} )"
    }

}
