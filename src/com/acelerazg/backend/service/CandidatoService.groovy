package com.acelerazg.backend.service

import com.acelerazg.backend.DAO.CandidatoDAO
import com.acelerazg.backend.model.Candidato

class CandidatoService {

    listarCandidatos(){

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

    cadastrarCandidato(Candidato candidato) {

        boolean retornoDB

        CandidatoDAO candidatoDAO = new CandidatoDAO()
        retornoDB = candidatoDAO.inserir(candidato)

        if (retornoDB){
            println("\nCandidato cadastrada com sucesso!!!")
        } else {
            println("\nOcorreu um erro no cadastro")
        }

    }

    alterarCandidato(Candidato candidato) {

        boolean retornoDB

        CandidatoDAO candidatoDAO = new CandidatoDAO()
        retornoDB = candidatoDAO.alterar(candidato)

        if (retornoDB){
            println("\nCandidato alterado com sucesso!!!")
        } else {
            println("\nOcorreu um erro na alteração")
        }

    }

    deletarCandidato(Integer id) {

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
