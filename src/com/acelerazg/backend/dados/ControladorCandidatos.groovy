package com.acelerazg.backend.dados

import com.acelerazg.backend.aplicacao.Ferramentas
import com.acelerazg.backend.model.Candidato

class ControladorCandidatos implements IControladorCandidatos{

    static listarCandidatos(){

        ListaPessoa.candidatos.each { candidato ->
            println candidato.toString()
        }

    }

    static void cadastrarCandidato() {

        def candidato = new Candidato()

        candidato.competencias = []
        int qtdCompetencias

        println "Digite o nome do Candidato"
        candidato.nome = Ferramentas.ler.nextLine()

        println "Digite o email do Candidato"
        candidato.email = Ferramentas.ler.nextLine()

        println "Digite o estado do Candidato"
        candidato.estado = Ferramentas.ler.nextLine()

        println "Digite a descrição do Candidato"
        candidato.descricao = Ferramentas.ler.nextLine()

        println "Digite a quantidade de competências que serão atribuidas ao Candidato"
        qtdCompetencias = Integer.parseInt(Ferramentas.ler.nextLine())

        for(int numero = 1; numero <= qtdCompetencias; numero++){
            println "Digite a compentência que será atribuida ao Candidato"
            String competencia = Ferramentas.ler.nextLine()
            candidato.competencias.add(competencia)
        }

        println "Digite o cep do Candidato"
        candidato.cep = Ferramentas.ler.nextLine()

        println "Digite o cpf do Candidato"
        candidato.cpf = Ferramentas.ler.nextLine()

        println "Digite a idade do Candidato"
        candidato.idade = Integer.parseInt(Ferramentas.ler.nextLine())

        ListaPessoa.candidatos.add(candidato)

        println "Candidato cadastrado com sucesso!!!"
    }

    @Override
    def iCadastrarCandidato(Object candidato) {
        return null
    }
}

