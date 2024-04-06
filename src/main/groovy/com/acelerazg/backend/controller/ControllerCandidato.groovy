package com.acelerazg.backend.controller

import com.acelerazg.backend.utilities.Ferramentas
import com.acelerazg.backend.model.Competencia
import com.acelerazg.backend.model.Candidato
import com.acelerazg.backend.service.CompetenciaService
import com.acelerazg.backend.service.CandidatoService


class ControllerCandidato {

    private Candidato novoCandidato = new Candidato()
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

    void listarCandidatos(){
        CandidatoService.listarCandidatos()
    }

    void cadastrarCandidato(){

        CompetenciaService competenciaService = new CompetenciaService()
        CandidatoService candidatoService = new CandidatoService()
        List<Competencia> competenciasDB
        Competencia novaCompetencia = new Competencia()
        int idCompetencia

        println("Digite o nome do candidato:")
        this.nomeCandidato = Ferramentas.ler.nextLine()

        println("Digite o sobrenome do candidato:")
        this.sobreNomeCandidato = Ferramentas.ler.nextLine()

        println("Digite o cpf do candidato:")
        this.cpf = Ferramentas.ler.nextLine()

        println("Digite a data de nascimento do candidato no formato dd/mm/aaaa:")
        this.dataNascimento = Ferramentas.ler.nextLine()

        println("Digite o email do candidato:")
        this.email = Ferramentas.ler.nextLine()

        println("Digite o cep do candidato:")
        this.cep = Ferramentas.ler.nextLine()

        println("Faça uma descrição do candidato:")
        this.descricao = Ferramentas.ler.nextLine()

        println("Selecione o pais:\n1. Brasil")
        this.pais = Integer.parseInt(Ferramentas.ler.nextLine())

        println("Selecione o estado:")
        println(Ferramentas.estados)
        this.estado = Integer.parseInt(Ferramentas.ler.nextLine())

        println("Digite uma senha:")
        this.senha = Ferramentas.ler.nextLine()

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

        CandidatoService.cadastrarCandidato(this.novoCandidato)

        println "Digite quantas competências o candidato possuí:"
        this.qtdCompetencias = Integer.parseInt(Ferramentas.ler.nextLine())

        List<Candidato> candidatos = candidatoService.candidatosCadastrados()

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
                    CandidatoService.cadastrarCompetenciaCandidato(candidatos[-1].getId(), idCompetencia)
                    break
                case 2:
                    println "Digite a competência:"
                    String competencia = Ferramentas.ler.nextLine()
                    competencia.capitalize()
                    novaCompetencia.setCompetencia(competencia)
                    competenciaService.cadastrarCompetencia(novaCompetencia)
                    competenciasDB = competenciaService.competenciasCadastradas()
                    CandidatoService.cadastrarCompetenciaCandidato(candidatos[-1].getId(), competenciasDB[-1].getId())
                    break
                default:
                    println "Opção inválida!!!"

            }
        }

    }

    void alterarCandidato(){

        CandidatoService.listarCandidatos()

        println ("\nEscolha qual candidato você deseja alterar:")
        this.opcao = Integer.parseInt(Ferramentas.ler.nextLine())

        println("Altere o nome do candidato:")
        this.nomeCandidato = Ferramentas.ler.nextLine()

        println("Altere o sobrenome do candidato:")
        this.sobreNomeCandidato = Ferramentas.ler.nextLine()

        println("Altere o cpf do candidato:")
        this.cpf = Ferramentas.ler.nextLine()

        println("Altere a data de nascimento do candidato no formato dd/mm/aaaa:")
        this.dataNascimento = Ferramentas.ler.nextLine()

        println("Altere o email do candidato:")
        this.email = Ferramentas.ler.nextLine()

        println("Altere o cep do candidato:")
        this.cep = Ferramentas.ler.nextLine()

        println("Altere a descrição do candidato:")
        this.descricao = Ferramentas.ler.nextLine()

        println("Altere o pais:\n1. Brasil")
        this.pais = Integer.parseInt(Ferramentas.ler.nextLine())

        println("Altere o estado:")
        println(Ferramentas.estados)
        this.estado = Integer.parseInt(Ferramentas.ler.nextLine())

        println("Altere a senha:")
        this.senha = Ferramentas.ler.nextLine()

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

        CandidatoService.alterarCandidato(this.novoCandidato)

    }

    void deletarCandidato(){

        CandidatoService.listarCandidatos()

        println "\nEscolha qual candidato você deseja deletar:"
        this.opcao = Integer.parseInt(Ferramentas.ler.nextLine())

        CandidatoService.deletarCandidato(this.opcao)

    }

}
