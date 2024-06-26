package com.acelerazg.backend.app.service


import com.acelerazg.backend.app.model.DAO.CompetenciaDAO
import com.acelerazg.backend.app.model.business.Competencia

class CompetenciaService {

    private CompetenciaDAO competenciaDAO = new CompetenciaDAO()
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

        this.retornoDB = this.competenciaDAO.deletar(id)
        return this.retornoDB
    }

}