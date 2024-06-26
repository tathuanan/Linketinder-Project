package com.acelerazg.backend.app.controller

import com.acelerazg.backend.app.model.user.Candidato
import com.acelerazg.backend.app.service.CandidatoService

class CandidatoController {

    private CandidatoService candidatoService = new CandidatoService()
    private boolean retornoDB

    void listarCandidatos(){

        this.candidatoService.listarCandidatos()
    }

    List<Candidato> candidatosCadastrados (){

        List<Candidato> listaCandidatos = this.candidatoService.candidatosCadastrados()
        return listaCandidatos
    }

    boolean cadastrarCandidato(Candidato candidato) {

        this.retornoDB = this.candidatoService.cadastrarCandidato(candidato)
        return this.retornoDB
    }

    boolean cadastrarCompetenciaCandidato(int candidato_id, int competencia_id) {

        this.retornoDB = this.candidatoService.cadastrarCompetenciaCandidato(candidato_id, competencia_id)
        return this.retornoDB
    }

    boolean alterarCandidato(Candidato candidato) {

        this.retornoDB = this.candidatoService.alterarCandidato(candidato)
        return this.retornoDB
    }

    boolean deletarCandidato(Integer id) {

        this.retornoDB = this.candidatoService.deletarCandidato(id)
        return this.retornoDB
    }

}