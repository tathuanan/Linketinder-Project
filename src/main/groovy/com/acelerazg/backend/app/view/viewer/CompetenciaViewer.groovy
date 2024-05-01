package com.acelerazg.backend.app.view.viewer

import com.acelerazg.backend.app.controller.CompetenciaController
import com.acelerazg.backend.app.model.business.Competencia

import com.acelerazg.backend.app.view.utilities.LeitorTerminal

class CompetenciaViewer {

    private CompetenciaController controllerCompetencia = new CompetenciaController()

    private Competencia competencia = new Competencia()

    boolean retornoDB

    private int opcao
    private String nomeCompetencia

    void listarCompetencias() {
        this.controllerCompetencia.listarCompetencias()
    }

    void cadastrarCompetencia() {

        println("Digite a nova competência:")
        this.nomeCompetencia = LeitorTerminal.ler.nextLine()

        this.nomeCompetencia.capitalize()
        this.competencia.setCompetencia(this.nomeCompetencia)

        this.retornoDB = this.controllerCompetencia.cadastrarCompetencia(this.competencia)

        if (this.retornoDB){
            println("\nCompetência cadastrada com sucesso!!!")
        } else {
            println("\nOcorreu um erro no cadastro")
        }

    }

    void alterarCompetencia() {

        this.controllerCompetencia.listarCompetencias()

        println("\nEscolha qual competência você deseja alterar:")
        this.opcao = Integer.parseInt(LeitorTerminal.ler.nextLine())

        println("Digite a nova competência:")
        this.nomeCompetencia = LeitorTerminal.ler.nextLine()

        this.competencia.setId(this.opcao)
        this.competencia.setCompetencia(this.nomeCompetencia)

        this.retornoDB = this.controllerCompetencia.alterarCompetencia(this.competencia)

        if (this.retornoDB){
            println("\nCompetência alterada com sucesso!!!")
        } else {
            println("\nOcorreu um erro na alteração")
        }

    }

    void deletarCompetencia() {

        this.controllerCompetencia.listarCompetencias()

        println("\nEscolha qual competência você deseja deletar:")
        this.opcao = Integer.parseInt(LeitorTerminal.ler.nextLine())

        this.retornoDB = this.controllerCompetencia.deletarCompetencia(this.opcao)

        if (this.retornoDB){
            println("\nCompetência deletada com sucesso!!!")
        } else {
            println("\nOcorreu um erro ao tentar deletar")
        }

    }

}
