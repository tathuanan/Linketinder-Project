package com.acelerazg.backend.app.service


import com.acelerazg.backend.app.model.DAO.CandidatoDAO

class CandidatoService {

    private CandidatoDAO candidatoDAO = new CandidatoDAO()
    boolean retornoDB

    void listarCandidatos(){

        this.candidatoDAO.listar().each {candidato ->
            println candidato
        }
    }

    List<com.acelerazg.backend.app.model.user.Candidato> candidatosCadastrados (){

        List<com.acelerazg.backend.app.model.user.Candidato> listaCandidatos = this.candidatoDAO.listar()
        return listaCandidatos
    }

    boolean cadastrarCandidato(com.acelerazg.backend.app.model.user.Candidato candidato) {

        this.retornoDB = this.candidatoDAO.inserir(candidato)
        return this.retornoDB
    }

    boolean cadastrarCompetenciaCandidato(int candidato_id, int competencia_id) {

        this.retornoDB = this.candidatoDAO.inserirCompetenciaCandidato(candidato_id, competencia_id)
        return this.retornoDB
    }

    boolean alterarCandidato(com.acelerazg.backend.app.model.user.Candidato candidato) {

        this.retornoDB = this.candidatoDAO.alterar(candidato)
        return this.retornoDB
    }

    boolean deletarCandidato(Integer id) {

        this.retornoDB = this.candidatoDAO.deletar(id)
        return this.retornoDB
    }
    
}
