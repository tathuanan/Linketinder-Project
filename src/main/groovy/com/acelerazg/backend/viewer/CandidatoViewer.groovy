package com.acelerazg.backend.viewer

import com.acelerazg.backend.controller.ControllerCandidato
import com.acelerazg.backend.controller.ControllerCompetencia
import com.acelerazg.backend.model.Candidato
import com.acelerazg.backend.model.Competencia
import com.acelerazg.backend.utilities.Ferramentas

class CandidatoViewer {

    private ControllerCandidato controllerCandidato = new ControllerCandidato()
    private ControllerCompetencia controllerCompetencia = new ControllerCompetencia()

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
        controllerCandidato.listarCandidatos()
    }

    void cadastrarCandidato() {

        List<Competencia> competenciasDB

        int idCompetencia

        println("Digite o nome do candidato:")
        nomeCandidato = Ferramentas.ler.nextLine()

        println("Digite o sobrenome do candidato:")
        sobreNomeCandidato = Ferramentas.ler.nextLine()

        println("Digite o cpf do candidato:")
        cpf = Ferramentas.ler.nextLine()

        println("Digite a data de nascimento do candidato no formato dd/mm/aaaa:")
        dataNascimento = Ferramentas.ler.nextLine()

        println("Digite o email do candidato:")
        email = Ferramentas.ler.nextLine()

        println("Digite o cep do candidato:")
        cep = Ferramentas.ler.nextLine()

        println("Faça uma descrição do candidato:")
        descricao = Ferramentas.ler.nextLine()

        println("Selecione o pais:\n1. Brasil")
        pais = Integer.parseInt(Ferramentas.ler.nextLine())

        println("Selecione o estado:")
        println(Ferramentas.estados)
        estado = Integer.parseInt(Ferramentas.ler.nextLine())

        println("Digite uma senha:")
        senha = Ferramentas.ler.nextLine()

        novoCandidato.setNome(nomeCandidato)
        novoCandidato.setSobrenome(sobreNomeCandidato)
        novoCandidato.setCpf(cpf)
        novoCandidato.setDataNascimento(dataNascimento)
        novoCandidato.setEmail(email)
        novoCandidato.setCep(cep)
        novoCandidato.setDescricao(descricao)
        novoCandidato.setPais(pais)
        novoCandidato.setEstado(estado)
        novoCandidato.setSenha(senha)

        retornoDB = controllerCandidato.cadastrarCandidato(novoCandidato)

        if (retornoDB) {
            println("\nCandidato cadastrada com sucesso!!!")
        } else {
            println("\nOcorreu um erro no cadastro")
        }

        println "Digite quantas competências o candidato possuí:"
        this.qtdCompetencias = Integer.parseInt(Ferramentas.ler.nextLine())

        List<Candidato> candidatos = controllerCandidato.candidatosCadastrados()

        for (int i = 0; i < qtdCompetencias; i++) {

            println "1. Utilizar competências cadastradas.\n" +
                    "2. Cadastrar nova competência"
            this.opcao = Integer.parseInt(Ferramentas.ler.nextLine())

            switch (opcao) {
                case 1:
                    controllerCompetencia.listarCompetencias()
                    println "Selecione o id da competência ${i + 1}:"
                    idCompetencia = Integer.parseInt(Ferramentas.ler.nextLine())
                    ControllerCandidato.cadastrarCompetenciaCandidato(candidatos[-1].getId(), idCompetencia)
                    break
                case 2:
                    println "Digite a competência:"
                    String competencia = Ferramentas.ler.nextLine()
                    competencia.capitalize()
                    novaCompetencia.setCompetencia(competencia)
                    controllerCompetencia.cadastrarCompetencia(novaCompetencia)
                    competenciasDB = controllerCompetencia.competenciasCadastradas()
                    controllerCandidato.cadastrarCompetenciaCandidato(candidatos[-1].getId(), competenciasDB[-1].getId())
                    break
                default:
                    println "Opção inválida!!!"

            }
        }

    }

    void alterarCandidato() {

        controllerCandidato.listarCandidatos()

        println("\nEscolha qual candidato você deseja alterar:")
        opcao = Integer.parseInt(Ferramentas.ler.nextLine())

        println("Altere o nome do candidato:")
        nomeCandidato = Ferramentas.ler.nextLine()

        println("Altere o sobrenome do candidato:")
        sobreNomeCandidato = Ferramentas.ler.nextLine()

        println("Altere o cpf do candidato:")
        cpf = Ferramentas.ler.nextLine()

        println("Altere a data de nascimento do candidato no formato dd/mm/aaaa:")
        dataNascimento = Ferramentas.ler.nextLine()

        println("Altere o email do candidato:")
        email = Ferramentas.ler.nextLine()

        println("Altere o cep do candidato:")
        cep = Ferramentas.ler.nextLine()

        println("Altere a descrição do candidato:")
        descricao = Ferramentas.ler.nextLine()

        println("Altere o pais:\n1. Brasil")
        pais = Integer.parseInt(Ferramentas.ler.nextLine())

        println("Altere o estado:")
        println(Ferramentas.estados)
        estado = Integer.parseInt(Ferramentas.ler.nextLine())

        println("Altere a senha:")
        senha = Ferramentas.ler.nextLine()

        novoCandidato.setId(opcao)
        novoCandidato.setNome(nomeCandidato)
        novoCandidato.setSobrenome(sobreNomeCandidato)
        novoCandidato.setCpf(cpf)
        novoCandidato.setDataNascimento(dataNascimento)
        novoCandidato.setEmail(email)
        novoCandidato.setCep(cep)
        novoCandidato.setDescricao(descricao)
        novoCandidato.setPais(pais)
        novoCandidato.setEstado(estado)
        novoCandidato.setSenha(senha)

        retornoDB = controllerCandidato.alterarCandidato(novoCandidato)

        if (retornoDB) {
            println("\nCandidato alterado com sucesso!!!")
        } else {
            println("\nOcorreu um erro na alteração")
        }

    }

    void deletarCandidato() {

        controllerCandidato.listarCandidatos()

        println "\nEscolha qual candidato você deseja deletar:"
        opcao = Integer.parseInt(Ferramentas.ler.nextLine())

        retornoDB = controllerCandidato.deletarCandidato(opcao)

        if (retornoDB) {
            println("\nCandidato deletado com sucesso!!!")
        } else {
            println("\nOcorreu um erro ao tentar deletar")
        }

    }

}