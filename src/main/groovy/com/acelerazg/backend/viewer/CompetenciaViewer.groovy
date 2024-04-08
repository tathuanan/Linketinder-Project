package com.acelerazg.backend.viewer

import com.acelerazg.backend.controller.ControllerCompetencia
import com.acelerazg.backend.model.Competencia

import com.acelerazg.backend.utilities.Ferramentas

class CompetenciaViewer {

    ControllerCompetencia controllerCompetencia = new ControllerCompetencia()

    private Competencia competencia = new Competencia()
    private int opcao
    private String nomeCompetencia
    boolean retornoDB

    void listarCompetencias() {
        controllerCompetencia.listarCompetencias()
    }

    void cadastrarCompetencia() {

        println("Digite a nova competência:")
        nomeCompetencia = Ferramentas.ler.nextLine()

        nomeCompetencia.capitalize()
        competencia.setCompetencia(nomeCompetencia)

        retornoDB = controllerCompetencia.cadastrarCompetencia(competencia)

        if (retornoDB){
            println("\nCompetência cadastrada com sucesso!!!")
        } else {
            println("\nOcorreu um erro no cadastro")
        }

    }

    void alterarCompetencia() {

        controllerCompetencia.listarCompetencias()

        println("\nEscolha qual competência você deseja alterar:")
        opcao = Integer.parseInt(Ferramentas.ler.nextLine())

        println("Digite a nova competência:")
        nomeCompetencia = Ferramentas.ler.nextLine()

        competencia.setId(opcao)
        competencia.setCompetencia(nomeCompetencia)

        retornoDB = controllerCompetencia.alterarCompetencia(competencia)

        if (retornoDB){
            println("\nCompetência alterada com sucesso!!!")
        } else {
            println("\nOcorreu um erro na alteração")
        }

    }

    void deletarCompetencia() {

        controllerCompetencia.listarCompetencias()

        println("\nEscolha qual competência você deseja deletar:")
        opcao = Integer.parseInt(Ferramentas.ler.nextLine())

        retornoDB = controllerCompetencia.deletarCompetencia(opcao)

        if (retornoDB){
            println("\nCompetência deletada com sucesso!!!")
        } else {
            println("\nOcorreu um erro ao tentar deletar")
        }

    }

}
