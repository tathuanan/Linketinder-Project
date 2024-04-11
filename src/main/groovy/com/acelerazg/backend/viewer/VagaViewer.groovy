package com.acelerazg.backend.viewer

import com.acelerazg.backend.controller.ControllerCompetencia
import com.acelerazg.backend.controller.ControllerEmpresa
import com.acelerazg.backend.controller.ControllerVaga
import com.acelerazg.backend.model.Competencia
import com.acelerazg.backend.model.Vaga
import com.acelerazg.backend.utilities.Ferramentas

class VagaViewer {

    private ControllerVaga controllerVaga = new ControllerVaga()
    private ControllerCompetencia controllerCompetencia = new ControllerCompetencia()
    private ControllerEmpresa controllerEmpresa = new ControllerEmpresa()

    private Vaga novaVaga = new Vaga()
    private Competencia novaCompetencia = new Competencia()

    private boolean retornoDB

    private int opcao
    private String nomeVaga
    private String descricao
    private String cidade
    private String empresa
    private int qtdCompetencias

    void listarVagas(){
        this.controllerVaga.listarVagas()
    }

    void cadastrarVaga(){

        List<Competencia> competenciasDB

        int idCompetencia

        println "Digite o nome da vaga:"
        this.nomeVaga = Ferramentas.ler.nextLine()

        println "Faça a descrição da vaga:"
        this.descricao = Ferramentas.ler.nextLine()

        println "Digite a cidade da vaga:"
        this.cidade = Ferramentas.ler.nextLine()

        this.controllerEmpresa.listarEmpresas()
        println("\nSelecione a empresa que ofertou a vaga:")
        this.empresa = Integer.parseInt(Ferramentas.ler.nextLine())

        this.novaVaga.setNome(this.nomeVaga)
        this.novaVaga.setDescricao(this.descricao)
        this.novaVaga.setCidade(this.cidade)
        this.novaVaga.setEmpresa(this.empresa)

        this.retornoDB = this.controllerVaga.cadastrarVaga(this.novaVaga)

        if (this.retornoDB) {
            println("\nVaga cadastrada com sucesso!!!")
        } else {
            println("\nOcorreu um erro no cadastro")
        }

        println "Digite a quantidade de competências a vaga exigirá:"
        this.qtdCompetencias = Integer.parseInt(Ferramentas.ler.nextLine())

        List<Vaga> vagas = this.controllerVaga.vagasCadastradas()

        for (int i = 0; i < qtdCompetencias; i++){

            println "1. Utilizar competências cadastradas.\n"+
                    "2. Cadastrar nova competência"
            this.opcao = Integer.parseInt(Ferramentas.ler.nextLine())

            switch (this.opcao){
                case 1:
                    this.controllerCompetencia.listarCompetencias()
                    println "Selecione o id da competência ${i+1}:"
                    idCompetencia = Integer.parseInt(Ferramentas.ler.nextLine())
                    this.controllerVaga.cadastrarCompetenciaVaga(vagas[-1].getId(), idCompetencia)
                    break
                case 2:
                    println "Digite a competência:"
                    String competencia = Ferramentas.ler.nextLine()
                    competencia.capitalize()
                    novaCompetencia.setCompetencia(competencia)
                    controllerCompetencia.cadastrarCompetencia(novaCompetencia)
                    competenciasDB = controllerCompetencia.competenciasCadastradas()
                    this.controllerVaga.cadastrarCompetenciaVaga(vagas[-1].getId(), competenciasDB[-1].getId())
                    break
                default:
                    println "Opção inválida!!!"

            }
        }
    }

    void alterarVaga(){

        this.controllerVaga.listarVagas()

        println("\nEscolha qual vaga você deseja alterar:")
        this.opcao = Integer.parseInt(Ferramentas.ler.nextLine())

        println "Altere o nome da vaga:"
        this.nomeVaga = Ferramentas.ler.nextLine()

        println "Altere a descrição da vaga:"
        this.descricao = Ferramentas.ler.nextLine()

        println "Altere a cidade da vaga:"
        this.cidade = Ferramentas.ler.nextLine()

        this.controllerEmpresa.listarEmpresas()
        println("\nAltere a empresa que ofertou a vaga:")
        this.empresa = Integer.parseInt(Ferramentas.ler.nextLine())

        this.novaVaga.setId(opcao)
        this.novaVaga.setNome(this.nomeVaga)
        this.novaVaga.setDescricao(this.descricao)
        this.novaVaga.setCidade(this.cidade)
        this.novaVaga.setEmpresa(this.empresa)

        this.retornoDB = this.controllerVaga.alterarVaga(this.novaVaga)

        if (this.retornoDB) {
            println("\nVaga alterada com sucesso!!!")
        } else {
            println("\nOcorreu um erro na alteração")
        }

    }

    void deletarVaga(){

        this.controllerVaga.listarVagas()

        println("\nEscolha qual competência você deseja deletar:")
        this.opcao = Integer.parseInt(Ferramentas.ler.nextLine())

        this.retornoDB = this.controllerVaga.deletarVaga(this.opcao)

        if (this.retornoDB) {
            println("\nVaga deletada com sucesso!!!")
        } else {
            println("\nOcorreu um erro ao tentar deletar")
        }

    }

}
