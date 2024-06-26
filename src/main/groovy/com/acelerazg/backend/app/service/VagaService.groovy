package com.acelerazg.backend.app.service

import com.acelerazg.backend.app.model.DAO.VagaDAO
import com.acelerazg.backend.app.model.business.Vaga

class VagaService {

    private VagaDAO vagaDAO = new VagaDAO()
    boolean retornoDB

    void listarVagas(){

        this.vagaDAO.listar().each { vaga ->
            println vaga.toString()
        }
    }

    List<Vaga> vagasCadastradas(){

        List<Vaga> listaVagas = this.vagaDAO.listar()
        return listaVagas
    }

    boolean cadastrarVaga(Vaga vaga) {

        this.retornoDB = this.vagaDAO.inserir(vaga)
        return this.retornoDB
    }

    boolean cadastrarCompetenciaVaga(int vaga_id, int competencia_id) {

        this.retornoDB = this.vagaDAO.inserirCompetenciaVaga(vaga_id, competencia_id)
        return this.retornoDB
    }

    boolean alterarVaga(Vaga vaga) {

        this.retornoDB = this.vagaDAO.alterar(vaga)
        return this.retornoDB
    }

    boolean deletarVaga(Integer id) {

        this.retornoDB = this.vagaDAO.deletar(id)
        return this.retornoDB
    }

}
