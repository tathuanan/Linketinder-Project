package com.acelerazg.backend.controller

import com.acelerazg.backend.DAO.CompetenciaDAO
import com.acelerazg.backend.model.Competencia

class ControllerCompetencia {

    boolean retornoDB

    void listarCompetencias() {

        CompetenciaDAO competenciaDAO = new CompetenciaDAO()

        competenciaDAO.listar().each { competencia ->
            println competencia
        }
    }

    List<Competencia> competenciasCadastradas() {

        CompetenciaDAO competenciaDAO = new CompetenciaDAO()

        List<Competencia> listaCompetencias = competenciaDAO.listar()

        return listaCompetencias
    }

    boolean cadastrarCompetencia(Competencia competencia) {

        CompetenciaDAO competenciaDAO = new CompetenciaDAO()

        retornoDB = competenciaDAO.inserir(competencia)

        return retornoDB
    }

    boolean alterarCompetencia(Competencia competencia) {

        CompetenciaDAO competenciaDAO = new CompetenciaDAO()

        retornoDB = competenciaDAO.alterar(competencia)

        return retornoDB
    }

    boolean deletarCompetencia(Integer id) {

        CompetenciaDAO competenciaDAO = new CompetenciaDAO()

        retornoDB = competenciaDAO.remover(id)

        return retornoDB
    }
}