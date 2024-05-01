package com.acelerazg.backend.app.view.viewer

import com.acelerazg.backend.app.controller.CandidatoController
import com.acelerazg.backend.app.controller.CompetenciaController
import com.acelerazg.backend.app.model.user.Candidato
import com.acelerazg.backend.app.model.business.Competencia
import com.acelerazg.backend.app.view.utilities.Estados
import com.acelerazg.backend.app.view.utilities.LeitorTerminal

class CandidatoViewer {

    private CandidatoController controllerCandidato = new CandidatoController()
    private CompetenciaController controllerCompetencia = new CompetenciaController()

    private Candidato novoCandidato = new Candidato()
    private Competencia novaCompetencia = new Competencia()

    private boolean retornoDB

    private int opcao
    private String nomeCandidato
    private String sobreNomeCandidato
    private String cpf
    private String dataNascimento
    private String email
    private String cep
    private String descricao
    private String senha
    private String pais
    private String estado
    private int qtdCompetencias

    void listarCandidatos() {
        this.controllerCandidato.listarCandidatos()
    }

    void cadastrarCandidato() {

        List<Competencia> competenciasDB

        int idCompetencia

        println("Digite o nome do candidato:")
        this.nomeCandidato = LeitorTerminal.ler.nextLine()

        println("Digite o sobrenome do candidato:")
        this.sobreNomeCandidato = LeitorTerminal.ler.nextLine()

        println("Digite o cpf do candidato:")
        this.cpf = LeitorTerminal.ler.nextLine()

        println("Digite a data de nascimento do candidato no formato dd/mm/aaaa:")
        this.dataNascimento = LeitorTerminal.ler.nextLine()

        println("Digite o email do candidato:")
        this.email = LeitorTerminal.ler.nextLine()

        println("Digite o cep do candidato:")
        this.cep = LeitorTerminal.ler.nextLine()

        println("Faça uma descrição do candidato:")
        this.descricao = LeitorTerminal.ler.nextLine()

        println("Selecione o pais:\n1. Brasil")
        this.pais = Integer.parseInt(LeitorTerminal.ler.nextLine())

        println("Selecione o estado:")
        println(Estados.estados)
        this.estado = Integer.parseInt(LeitorTerminal.ler.nextLine())

        println("Digite uma senha:")
        this.senha = LeitorTerminal.ler.nextLine()

        this.novoCandidato.setNome(this.nomeCandidato)
        this.novoCandidato.setSobrenome(this.sobreNomeCandidato)
        this.novoCandidato.setCpf(this.cpf)
        this.novoCandidato.setDataNascimento(this.dataNascimento)
        this.novoCandidato.setEmail(this.email)
        this.novoCandidato.setCep(this.cep)
        this.novoCandidato.setDescricao(this.descricao)
        this.novoCandidato.setPais(this.pais)
        this.novoCandidato.setEstado(this.estado)
        this.novoCandidato.setSenha(this.senha)

        try {

            this.retornoDB = this.controllerCandidato.cadastrarCandidato(this.novoCandidato)

            switch (retornoDB){

                case false:
                    println("\nOcorreu um erro no cadastro")
                    break

                default:

                    println "Digite quantas competências o candidato possuí:"
                    this.qtdCompetencias = Integer.parseInt(LeitorTerminal.ler.nextLine())

                    List<Candidato> candidatos = this.controllerCandidato.candidatosCadastrados()

                    for (int i = 0; i < qtdCompetencias; i++) {

                        println "1. Utilizar competências cadastradas.\n" +
                                "2. Cadastrar nova competência"
                        this.opcao = Integer.parseInt(LeitorTerminal.ler.nextLine())

                        switch (this.opcao) {
                            case 1:
                                controllerCompetencia.listarCompetencias()
                                println "Selecione o id da competência ${i + 1}:"
                                idCompetencia = Integer.parseInt(LeitorTerminal.ler.nextLine())
                                CandidatoController.cadastrarCompetenciaCandidato(candidatos[-1].getId(), idCompetencia)
                                break
                            case 2:
                                println "Digite a competência:"
                                String competencia = LeitorTerminal.ler.nextLine()
                                competencia.capitalize()
                                this.novaCompetencia.setCompetencia(competencia)
                                this.controllerCompetencia.cadastrarCompetencia(this.novaCompetencia)
                                competenciasDB = this.controllerCompetencia.competenciasCadastradas()
                                this.controllerCandidato.cadastrarCompetenciaCandidato(candidatos[-1].getId(), competenciasDB[-1].getId())
                                break
                            default:
                                println "Opção inválida!!!"
                        }
                    }
                    println("\nCandidato cadastrado com sucesso!!!")
            }
        }catch (Exception e){
            e.printStackTrace()
        }
    }

    void alterarCandidato() {

        this.controllerCandidato.listarCandidatos()

        println("\nEscolha qual candidato você deseja alterar:")
        this.opcao = Integer.parseInt(LeitorTerminal.ler.nextLine())

        println("Altere o nome do candidato:")
        this.nomeCandidato = LeitorTerminal.ler.nextLine()

        println("Altere o sobrenome do candidato:")
        this.sobreNomeCandidato = LeitorTerminal.ler.nextLine()

        println("Altere o cpf do candidato:")
        this.cpf = LeitorTerminal.ler.nextLine()

        println("Altere a data de nascimento do candidato no formato dd/mm/aaaa:")
        this.dataNascimento = LeitorTerminal.ler.nextLine()

        println("Altere o email do candidato:")
        this.email = LeitorTerminal.ler.nextLine()

        println("Altere o cep do candidato:")
        this.cep = LeitorTerminal.ler.nextLine()

        println("Altere a descrição do candidato:")
        this.descricao = LeitorTerminal.ler.nextLine()

        println("Altere o pais:\n1. Brasil")
        this.pais = Integer.parseInt(LeitorTerminal.ler.nextLine())

        println("Altere o estado:")
        println(Estados.estados)
        this.estado = Integer.parseInt(LeitorTerminal.ler.nextLine())

        println("Altere a senha:")
        this.senha = LeitorTerminal.ler.nextLine()

        this.novoCandidato.setId(this.opcao)
        this.novoCandidato.setNome(this.nomeCandidato)
        this.novoCandidato.setSobrenome(this.sobreNomeCandidato)
        this.novoCandidato.setCpf(this.cpf)
        this.novoCandidato.setDataNascimento(this.dataNascimento)
        this.novoCandidato.setEmail(this.email)
        this.novoCandidato.setCep(this.cep)
        this.novoCandidato.setDescricao(this.descricao)
        this.novoCandidato.setPais(this.pais)
        this.novoCandidato.setEstado(this.estado)
        this.novoCandidato.setSenha(this.senha)

        this.retornoDB = this.controllerCandidato.alterarCandidato(this.novoCandidato)

        if (this.retornoDB) {
            println("\nCandidato alterado com sucesso!!!")
        } else {
            println("\nOcorreu um erro na alteração")
        }

    }

    void deletarCandidato() {

        this.controllerCandidato.listarCandidatos()

        println "\nEscolha qual candidato você deseja deletar:"
        this.opcao = Integer.parseInt(LeitorTerminal.ler.nextLine())

        this.retornoDB = this.controllerCandidato.deletarCandidato(this.opcao)

        if (this.retornoDB) {
            println("\nCandidato deletado com sucesso!!!")
        } else {
            println("\nOcorreu um erro ao tentar deletar")
        }

    }

}