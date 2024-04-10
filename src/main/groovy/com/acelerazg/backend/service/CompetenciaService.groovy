package com.acelerazg.backend.service

import com.acelerazg.backend.DAO.CompetenciaDAO
import com.acelerazg.backend.model.Competencia

class CompetenciaService {

    CompetenciaDAO competenciaDAO = new CompetenciaDAO()
    boolean retornoDB

    void listarCompetencias() {

        this.competenciaDAO.listar().each { competencia ->
            println competencia
        }
    }

    List<Competencia> competenciasCadastradas() {

        List<Competencia> listaCompetencias = this.competenciaDAO.listar()
        return listaCompetencias
    }

    boolean cadastrarCompetencia(Competencia competencia) {

        this.retornoDB = this.competenciaDAO.inserir(competencia)
        return this.retornoDB
    }

    boolean alterarCompetencia(Competencia competencia) {

        this.retornoDB = this.competenciaDAO.alterar(competencia)
        return this.retornoDB
    }

    boolean deletarCompetencia(Integer id) {

        this.retornoDB = this.competenciaDAO.remover(id)
        return this.retornoDB
    }

}