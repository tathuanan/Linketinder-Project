package com.acelerazg.dados

import com.acelerazg.aplicacao.Ferramentas
import com.acelerazg.pessoas.Empresa

class ControladorEmpresas {

    static listarEmpresas() {

        ListaPessoa.empresas.each { empresa ->
            println empresa.toString()
        }

    }

    static void cadastrarEmpresa() {

        def empresa = new Empresa();

        empresa.competencias = []
        int qtdCompetencias

        println "Digite o nome da Empresa"
        empresa.nome = Ferramentas.ler.nextLine()

        println "Digite o email da Empresa"
        empresa.email = Ferramentas.ler.nextLine()

        println "Digite o estado da Empresa"
        empresa.estado = Ferramentas.ler.nextLine()

        println "Digite a descrição da Empresa"
        empresa.descricao = Ferramentas.ler.nextLine()

        println "Digite a quantidade de competências que serão atribuidas a Empresa"
        qtdCompetencias = Integer.parseInt(Ferramentas.ler.nextLine())

        for (int numero = 1; numero <= qtdCompetencias; numero++) {
            println "Digite a compentência que será atribuida ao Candidato"
            String competencia = Ferramentas.ler.nextLine()
            empresa.competencias.add(competencia)
        }

        println "Digite o cep da Empresa"
        empresa.cep = Ferramentas.ler.nextLine()

        println "Digite o país da Empresa"
        empresa.pais = Ferramentas.ler.nextLine()

        println "Digite o cnpj da Empresa"
        empresa.cnpj = Ferramentas.ler.nextLine()

        ListaPessoa.empresas.add(empresa)

        println "Empresa cadastrada com sucesso!!!"
    }

}