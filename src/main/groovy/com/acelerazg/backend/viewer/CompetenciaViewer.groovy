package com.acelerazg.backend.viewer

import com.acelerazg.backend.controller.ControllerCompetencia
import com.acelerazg.backend.model.Competencia

import com.acelerazg.backend.utilities.Ferramentas

class CompetenciaViewer {

    private ControllerCompetencia controllerCompetencia = new ControllerCompetencia()

    private Competencia competencia = new Competencia()

    boolean retornoDB

    private int opcao
    private String nomeCompetencia

    void listarCompetencias() {
        this.controllerCompetencia.listarCompetencias()
    }

    void cadastrarCompetencia() {

        println("Digite a nova competência:")
        this.nomeCompetencia = Ferramentas.ler.nextLine()

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
        this.opcao = Integer.parseInt(Ferramentas.ler.nextLine())

        println("Digite a nova competência:")
        this.nomeCompetencia = Ferramentas.ler.nextLine()

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
        this.opcao = Integer.parseInt(Ferramentas.ler.nextLine())

        this.retornoDB = this.controllerCompetencia.deletarCompetencia(this.opcao)

        if (this.retornoDB){
            println("\nCompetência deletada com sucesso!!!")
        } else {
            println("\nOcorreu um erro ao tentar deletar")
        }

    }

}
