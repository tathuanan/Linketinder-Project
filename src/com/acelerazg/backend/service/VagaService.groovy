package com.acelerazg.backend.service

import com.acelerazg.backend.DAO.VagaDAO
import com.acelerazg.backend.model.Vaga

class VagaService {

    static listarVagas(){

        VagaDAO vagaDAO = new VagaDAO()
        vagaDAO.listar().each { vaga ->
            println vaga.toString()
        }

    }

    List<Vaga> vagasCadastradas(){

        List<Vaga> listaVagas
        VagaDAO vagaDAO = new VagaDAO()

        listaVagas = vagaDAO.listar()
        return listaVagas
    }

    static cadastrarVaga(Vaga vaga) {

        boolean retornoDB

        VagaDAO vagaDAO = new VagaDAO()
        retornoDB = vagaDAO.inserir(vaga)

        if (retornoDB){
            println("\nVaga cadastrada com sucesso!!!")
        } else {
            println("\nOcorreu um erro no cadastro")
        }

    }

    static cadastrarCompetenciaVaga(int vaga_id, int competencia_id) {

        boolean retornoDB

        VagaDAO vagaDAO = new VagaDAO()
        retornoDB = vagaDAO.inserirCompetenciaVaga(vaga_id, competencia_id)

        if (retornoDB){
            println("\nCompetência cadastrada com sucesso!!!")
        } else {
            println("\nOcorreu um erro no cadastro")
        }

    }

    static alterarVaga(Vaga vaga) {

        boolean retornoDB

        VagaDAO vagaDAO = new VagaDAO()
        retornoDB = vagaDAO.alterar(vaga)

        if (retornoDB){
            println("\nVaga alterada com sucesso!!!")
        } else {
            println("\nOcorreu um erro na alteração")
        }

    }

    static deletarVaga(Integer id) {

        boolean retornoDB

        VagaDAO vagaDAO = new VagaDAO()
        retornoDB = vagaDAO.remover(id)

        if (retornoDB){
            println("\nVaga deletada com sucesso!!!")
        } else {
            println("\nOcorreu um erro ao tentar deletar")
        }

    }

}
