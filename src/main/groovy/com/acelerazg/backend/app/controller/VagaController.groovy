package com.acelerazg.backend.app.controller

import com.acelerazg.backend.app.model.business.Vaga
import com.acelerazg.backend.app.service.VagaService

class VagaController {

    private VagaService vagaService = new VagaService()
    private boolean retornoDB

    void listarVagas(){
        this.vagaService.listarVagas()
    }

    List<Vaga> vagasCadastradas (){

        List<Vaga> listaVagas = this.vagaService.vagasCadastradas()
        return listaVagas
    }

    boolean cadastrarVaga(Vaga vaga){

        this.retornoDB = this.vagaService.cadastrarVaga(vaga)
        return retornoDB
    }

    boolean cadastrarCompetenciaVaga(int vaga_id, int competencia_id) {

        this.retornoDB = this.vagaService.cadastrarCompetenciaVaga(vaga_id, competencia_id)
        return this.retornoDB
    }

    boolean alterarVaga(Vaga vaga){

        this.retornoDB = this.vagaService.alterarVaga(vaga)
        return this.retornoDB
    }

    boolean deletarVaga(Integer id){

        this.retornoDB = this.vagaService.deletarVaga(id)
        return retornoDB
    }

}
