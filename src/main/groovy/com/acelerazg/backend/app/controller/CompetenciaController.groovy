package com.acelerazg.backend.app.controller

import com.acelerazg.backend.app.model.business.Competencia
import com.acelerazg.backend.app.service.CompetenciaService

class CompetenciaController {

    private CompetenciaService competenciaService = new CompetenciaService()
    private boolean retornoDB

    void listarCompetencias() {

        this.competenciaService.listarCompetencias()
    }

    List<Competencia> competenciasCadastradas() {

        List<Competencia> listaCompetencias = this.competenciaService.competenciasCadastradas()
        return listaCompetencias
    }

    boolean cadastrarCompetencia(Competencia competencia) {

        this.retornoDB = this.competenciaService.cadastrarCompetencia(competencia)
        return this.retornoDB
    }

    boolean alterarCompetencia(Competencia competencia) {

        this.retornoDB = this.competenciaService.alterarCompetencia(competencia)
        return this.retornoDB
    }

    boolean deletarCompetencia(Integer id) {

        this.retornoDB = this.competenciaService.deletarCompetencia(id)
        return this.retornoDB
    }
}