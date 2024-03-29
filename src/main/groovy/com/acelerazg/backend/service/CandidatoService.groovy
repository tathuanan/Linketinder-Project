package com.acelerazg.backend.service

import com.acelerazg.backend.DAO.CandidatoDAO
import com.acelerazg.backend.model.Candidato

class CandidatoService {

    static listarCandidatos(){

        CandidatoDAO candidatoDAO = new CandidatoDAO()
        candidatoDAO.listar().each {candidato ->
            println candidato
        }

    }

    List<Candidato> candidatosCadastrados (){

        List<Candidato> listaCandidatos
        CandidatoDAO candidatoDAO = new CandidatoDAO()

        listaCandidatos = candidatoDAO.listar()
        return listaCandidatos

    }

    static cadastrarCandidato(Candidato candidato) {

        boolean retornoDB

        CandidatoDAO candidatoDAO = new CandidatoDAO()
        retornoDB = candidatoDAO.inserir(candidato)

        if (retornoDB){
            println("\nCandidato cadastrada com sucesso!!!")
        } else {
            println("\nOcorreu um erro no cadastro")
        }

    }

    static cadastrarCompetenciaCandidato(int candidato_id, int competencia_id) {

        boolean retornoDB

        CandidatoDAO candidatoDAO = new CandidatoDAO()
        retornoDB = candidatoDAO.inserirCompetenciaCandidato(candidato_id, competencia_id)

        if (retornoDB){
            println("\nCompetência cadastrada com sucesso!!!")
        } else {
            println("\nOcorreu um erro no cadastro")
        }

    }

    static alterarCandidato(Candidato candidato) {

        boolean retornoDB

        CandidatoDAO candidatoDAO = new CandidatoDAO()
        retornoDB = candidatoDAO.alterar(candidato)

        if (retornoDB){
            println("\nCandidato alterado com sucesso!!!")
        } else {
            println("\nOcorreu um erro na alteração")
        }

    }

    static deletarCandidato(Integer id) {

        boolean retornoDB

        CandidatoDAO candidatoDAO = new CandidatoDAO()
        retornoDB = candidatoDAO.remover(id)

        if (retornoDB){
            println("\nCandidato deletado com sucesso!!!")
        } else {
            println("\nOcorreu um erro ao tentar deletar")
        }

    }
    
}
