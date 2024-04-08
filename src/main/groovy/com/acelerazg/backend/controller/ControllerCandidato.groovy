package com.acelerazg.backend.controller

import com.acelerazg.backend.DAO.CandidatoDAO
import com.acelerazg.backend.model.Candidato

class ControllerCandidato {

    private boolean retornoDB

    void listarCandidatos(){

        CandidatoDAO candidatoDAO = new CandidatoDAO()

        candidatoDAO.listar().each {candidato ->
            println candidato
        }

    }

    List<Candidato> candidatosCadastrados (){

        CandidatoDAO candidatoDAO = new CandidatoDAO()

        List<Candidato> listaCandidatos = candidatoDAO.listar()

        return listaCandidatos
    }

    boolean cadastrarCandidato(Candidato candidato) {

        CandidatoDAO candidatoDAO = new CandidatoDAO()

        retornoDB = candidatoDAO.inserir(candidato)

        return retornoDB
    }

    boolean cadastrarCompetenciaCandidato(int candidato_id, int competencia_id) {

        CandidatoDAO candidatoDAO = new CandidatoDAO()

        retornoDB = candidatoDAO.inserirCompetenciaCandidato(candidato_id, competencia_id)

        return retornoDB
    }

    boolean alterarCandidato(Candidato candidato) {

        CandidatoDAO candidatoDAO = new CandidatoDAO()

        retornoDB = candidatoDAO.alterar(candidato)

        return retornoDB
    }

    boolean deletarCandidato(Integer id) {

        CandidatoDAO candidatoDAO = new CandidatoDAO()

        retornoDB = candidatoDAO.remover(id)

        return retornoDB
    }

}
