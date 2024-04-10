package com.acelerazg.backend.service

import com.acelerazg.backend.DAO.CandidatoDAO
import com.acelerazg.backend.model.Candidato

class CandidatoService {

    CandidatoDAO candidatoDAO = new CandidatoDAO()
    boolean retornoDB

    void listarCandidatos(){

        this.candidatoDAO.listar().each {candidato ->
            println candidato
        }
    }

    List<Candidato> candidatosCadastrados (){

        List<Candidato> listaCandidatos = this.candidatoDAO.listar()
        return listaCandidatos
    }

    boolean cadastrarCandidato(Candidato candidato) {

        this.retornoDB = this.candidatoDAO.inserir(candidato)
        return this.retornoDB
    }

    boolean cadastrarCompetenciaCandidato(int candidato_id, int competencia_id) {

        this.retornoDB = this.candidatoDAO.inserirCompetenciaCandidato(candidato_id, competencia_id)
        return this.retornoDB
    }

    boolean alterarCandidato(Candidato candidato) {

        this.retornoDB = this.candidatoDAO.alterar(candidato)
        return this.retornoDB
    }

    boolean deletarCandidato(Integer id) {

        this.retornoDB = this.candidatoDAO.remover(id)
        return this.retornoDB
    }
    
}
