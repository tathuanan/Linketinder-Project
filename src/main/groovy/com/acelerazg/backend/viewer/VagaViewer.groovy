package com.acelerazg.backend.viewer

import com.acelerazg.backend.controller.CompetenciaController
import com.acelerazg.backend.controller.EmpresaController
import com.acelerazg.backend.controller.VagaController
import com.acelerazg.backend.model.Competencia
import com.acelerazg.backend.model.Vaga
import com.acelerazg.backend.utilities.LeitorTerminal

class VagaViewer {

    private VagaController controllerVaga = new VagaController()
    private CompetenciaController controllerCompetencia = new CompetenciaController()
    private EmpresaController controllerEmpresa = new EmpresaController()

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
        this.nomeVaga = LeitorTerminal.ler.nextLine()

        println "Faça a descrição da vaga:"
        this.descricao = LeitorTerminal.ler.nextLine()

        println "Digite a cidade da vaga:"
        this.cidade = LeitorTerminal.ler.nextLine()

        this.controllerEmpresa.listarEmpresas()
        println("\nSelecione a empresa que ofertou a vaga:")
        this.empresa = Integer.parseInt(LeitorTerminal.ler.nextLine())

        this.novaVaga.setNome(this.nomeVaga)
        this.novaVaga.setDescricao(this.descricao)
        this.novaVaga.setCidade(this.cidade)
        this.novaVaga.setEmpresa(this.empresa)

        try {
            this.retornoDB = this.controllerVaga.cadastrarVaga(this.novaVaga)

            switch (retornoDB){

                case false:
                    println("\nOcorreu um erro no cadastro")
                    break

                default:
                    println "Digite a quantidade de competências a vaga exigirá:"
                    this.qtdCompetencias = Integer.parseInt(LeitorTerminal.ler.nextLine())

                    List<Vaga> vagas = this.controllerVaga.vagasCadastradas()

                    for (int i = 0; i < qtdCompetencias; i++){

                        println "1. Utilizar competências cadastradas.\n"+
                                "2. Cadastrar nova competência"
                        this.opcao = Integer.parseInt(LeitorTerminal.ler.nextLine())

                        switch (this.opcao){
                            case 1:
                                this.controllerCompetencia.listarCompetencias()
                                println "Selecione o id da competência ${i+1}:"
                                idCompetencia = Integer.parseInt(LeitorTerminal.ler.nextLine())
                                this.controllerVaga.cadastrarCompetenciaVaga(vagas[-1].getId(), idCompetencia)
                                break
                            case 2:
                                println "Digite a competência:"
                                String competencia = LeitorTerminal.ler.nextLine()
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
                    println("\nVaga cadastrada com sucesso!!!")
            }

        } catch (Exception e){
            e.printStackTrace()
        }
    }

    void alterarVaga(){

        this.controllerVaga.listarVagas()

        println("\nEscolha qual vaga você deseja alterar:")
        this.opcao = Integer.parseInt(LeitorTerminal.ler.nextLine())

        println "Altere o nome da vaga:"
        this.nomeVaga = LeitorTerminal.ler.nextLine()

        println "Altere a descrição da vaga:"
        this.descricao = LeitorTerminal.ler.nextLine()

        println "Altere a cidade da vaga:"
        this.cidade = LeitorTerminal.ler.nextLine()

        this.controllerEmpresa.listarEmpresas()
        println("\nAltere a empresa que ofertou a vaga:")
        this.empresa = Integer.parseInt(LeitorTerminal.ler.nextLine())

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
        this.opcao = Integer.parseInt(LeitorTerminal.ler.nextLine())

        this.retornoDB = this.controllerVaga.deletarVaga(this.opcao)

        if (this.retornoDB) {
            println("\nVaga deletada com sucesso!!!")
        } else {
            println("\nOcorreu um erro ao tentar deletar")
        }

    }

}
