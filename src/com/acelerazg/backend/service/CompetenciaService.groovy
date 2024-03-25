package com.acelerazg.backend.service

import com.acelerazg.backend.DAO.CompetenciaDAO
import com.acelerazg.backend.model.Competencia

class CompetenciaService {

    static listarCompetencia() {

        CompetenciaDAO competenciaDAO = new CompetenciaDAO()
        competenciaDAO.listar().each { competencia ->
            println competencia.toString()
        }
    }

    static cadastrarCompetencia(Competencia competencia) {

        boolean retornoDB

        CompetenciaDAO competenciaDAO = new CompetenciaDAO()
        retornoDB = competenciaDAO.inserir(competencia)

        if (retornoDB){
            println("\nCompetência cadastrada com sucesso!!!")
        } else {
            println("\nOcorreu um erro no cadastro")
        }

    }

    static alterarCompetencia(Competencia competencia) {

        boolean retornoDB

        CompetenciaDAO competenciaDAO = new CompetenciaDAO()
        retornoDB = competenciaDAO.alterar(competencia)

        if (retornoDB){
            println("\nCompetência alterada com sucesso!!!")
        } else {
            println("\nOcorreu um erro na alteração")
        }

    }

    static deletarCompetencia(Integer id) {

        boolean retornoDB

        CompetenciaDAO competenciaDAO = new CompetenciaDAO()
        retornoDB = competenciaDAO.remover(id)

        if (retornoDB){
            println("\nCompetência deletada com sucesso!!!")
        } else {
            println("\nOcorreu um erro ao tentar deletar")
        }

    }

}