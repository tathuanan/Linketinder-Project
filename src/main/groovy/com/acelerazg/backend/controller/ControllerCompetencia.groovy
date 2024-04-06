package com.acelerazg.backend.controller

import com.acelerazg.backend.utilities.Ferramentas
import com.acelerazg.backend.model.Competencia
import com.acelerazg.backend.service.CompetenciaService

class ControllerCompetencia {

    private Competencia novaCompetencia = new Competencia()
    private int opcao
    private String nomeNovaCompetencia

    void listarCompetencias(){
        CompetenciaService.listarCompetencias()
    }

    void cadastrarCompetencia(){

        println("Digite a nova competência:")
        this.nomeNovaCompetencia = Ferramentas.ler.nextLine()

        this.novaCompetencia.setCompetencia(this.nomeNovaCompetencia)
        CompetenciaService.cadastrarCompetencia(this.novaCompetencia)

    }

    void alterarCompetencia(){

        CompetenciaService.listarCompetencias()

        println("\nEscolha qual competência você deseja alterar:")
        this.opcao = Integer.parseInt(Ferramentas.ler.nextLine())

        println("Digite a nova competência:")
        this.nomeNovaCompetencia = Ferramentas.ler.nextLine()

        this.novaCompetencia.setId(this.opcao)
        this.novaCompetencia.setCompetencia(this.nomeNovaCompetencia)

        CompetenciaService.alterarCompetencia(this.novaCompetencia)

    }

    void deletarCompetencia(){

        CompetenciaService.listarCompetencias()

        println("\nEscolha qual competência você deseja deletar:")
        this.opcao = Integer.parseInt(Ferramentas.ler.nextLine())

        CompetenciaService.deletarCompetencia(this.opcao)

    }

}
