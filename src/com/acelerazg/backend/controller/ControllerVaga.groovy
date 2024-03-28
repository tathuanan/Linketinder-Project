package com.acelerazg.backend.controller

import com.acelerazg.backend.DAO.VagaDAO
import com.acelerazg.backend.aplicacao.Ferramentas
import com.acelerazg.backend.model.Competencia
import com.acelerazg.backend.model.Vaga
import com.acelerazg.backend.service.CompetenciaService
import com.acelerazg.backend.service.EmpresaService
import com.acelerazg.backend.service.VagaService

class ControllerVaga {

    private Vaga novaVaga = new Vaga()
    private int opcao
    private String nomeVaga
    private String descricao
    private String cidade
    private String empresa
    private int qtdCompetencias

    void listarVagas(){
        VagaService.listarVagas()
    }

    void cadastrarVaga(){

        CompetenciaService competenciaService = new CompetenciaService()
        VagaService vagaService = new VagaService()
        List<Competencia> competenciasDB
        Competencia novaCompetencia = new Competencia()
        int idCompetencia

        println "Digite o nome da vaga:"
        this.nomeVaga = Ferramentas.ler.nextLine()

        println "Faça a descrição da vaga:"
        this.descricao = Ferramentas.ler.nextLine()

        println "Digite a cidade da vaga:"
        this.cidade = Ferramentas.ler.nextLine()

        EmpresaService.listarEmpresas()
        println("\nSelecione a empresa que ofertou a vaga:")
        this.empresa = Integer.parseInt(Ferramentas.ler.nextLine())

        this.novaVaga.setNome(this.nomeVaga)
        this.novaVaga.setDescricao(this.descricao)
        this.novaVaga.setCidade(this.cidade)
        this.novaVaga.setEmpresa(this.empresa)

        VagaService.cadastrarVaga(this.novaVaga)

        println "Digite a quantidade de competências a vaga exigirá:"
        this.qtdCompetencias = Integer.parseInt(Ferramentas.ler.nextLine())

        List<Vaga> vagas = vagaService.vagasCadastradas()

        for (int i = 0; i < qtdCompetencias; i++){

            competenciasDB = competenciaService.competenciasCadastradas()

            println "1. Utilizar competências cadastradas.\n"+
                    "2. Cadastrar nova competência"
            this.opcao = Integer.parseInt(Ferramentas.ler.nextLine())

            switch (opcao){
                case 1:
                    competenciaService.listarCompetencias()
                    println "Selecione o id da competência ${i+1}:"
                    idCompetencia = Integer.parseInt(Ferramentas.ler.nextLine())
                    VagaService.cadastrarCompetenciaVaga(vagas[-1].getId(), idCompetencia)
                    break
                case 2:
                    println "Digite a competência:"
                    String competencia = Ferramentas.ler.nextLine()
                    competencia.capitalize()
                    novaCompetencia.setCompetencia(competencia)
                    competenciaService.cadastrarCompetencia(novaCompetencia)
                    competenciasDB = competenciaService.competenciasCadastradas()
                    VagaService.cadastrarCompetenciaVaga(vagas[-1].getId(), competenciasDB[-1].getId())
                    break
                default:
                    println "Opção inválida!!!"

            }
        }
    }

    void alterarVaga(){

        VagaService.listarVagas()

        println("\nEscolha qual vaga você deseja alterar:")
        this.opcao = Integer.parseInt(Ferramentas.ler.nextLine())

        println "Altere o nome da vaga:"
        this.nomeVaga = Ferramentas.ler.nextLine()

        println "Altere a descrição da vaga:"
        this.descricao = Ferramentas.ler.nextLine()

        println "Altere a cidade da vaga:"
        this.cidade = Ferramentas.ler.nextLine()

        EmpresaService.listarEmpresas()
        println("\nAltere a empresa que ofertou a vaga:")
        this.empresa = Integer.parseInt(Ferramentas.ler.nextLine())

        this.novaVaga.setNome(this.nomeVaga)
        this.novaVaga.setDescricao(this.descricao)
        this.novaVaga.setCidade(this.cidade)
        this.novaVaga.setEmpresa(this.empresa)

        VagaService.alterarVaga(this.novaVaga)

    }

    void deletarVaga(){

        VagaService.listarVagas()

        println("\nEscolha qual competência você deseja deletar:")
        this.opcao = Integer.parseInt(Ferramentas.ler.nextLine())

        VagaService.deletarVaga(this.opcao)

    }


}
