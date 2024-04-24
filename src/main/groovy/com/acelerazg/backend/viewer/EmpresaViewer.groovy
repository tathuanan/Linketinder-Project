package com.acelerazg.backend.viewer

import com.acelerazg.backend.controller.EmpresaController
import com.acelerazg.backend.model.Empresa
import com.acelerazg.backend.utilities.Ferramentas

class EmpresaViewer {

    private EmpresaController controllerEmpresa = new EmpresaController()

    private Empresa novaEmpresa = new Empresa()

    private boolean retornoDB

    private int opcao
    private String nomeEmpresa
    private String cnpj
    private String email
    private String cep
    private String descricao
    private String senha
    private String pais
    private String estado

    void listarEmpresas(){

        this.controllerEmpresa.listarEmpresas()
    }

    void cadastrarEmpresa(){

        println("Digite o nome da empresa:")
        this.nomeEmpresa = Ferramentas.ler.nextLine()

        println("Digite o cnpj da empresa:")
        this.cnpj = Ferramentas.ler.nextLine()

        println("Digite o email da empresa:")
        this.email = Ferramentas.ler.nextLine()

        println("Digite o cep da empresa:")
        this.cep = Ferramentas.ler.nextLine()

        println("Faça uma descrição da empresa:")
        this.descricao = Ferramentas.ler.nextLine()

        println("Selecione o pais:\n1. Brasil")
        this.pais = Integer.parseInt(Ferramentas.ler.nextLine())

        println("Selecione o estado:")
        println(Ferramentas.estados)
        this.estado = Integer.parseInt(Ferramentas.ler.nextLine())

        println("Digite uma senha:")
        this.senha = Ferramentas.ler.nextLine()

        this.novaEmpresa.setNome(this.nomeEmpresa)
        this.novaEmpresa.setCnpj(this.cnpj)
        this.novaEmpresa.setEmail(this.email)
        this.novaEmpresa.setCep(this.cep)
        this.novaEmpresa.setDescricao(this.descricao)
        this.novaEmpresa.setPais(this.pais)
        this.novaEmpresa.setEstado(this.estado)
        this.novaEmpresa.setSenha(this.senha)

        this.retornoDB = this.controllerEmpresa.cadastrarEmpresa(this.novaEmpresa)

        if (this.retornoDB) {
            println("\nEmpresa cadastrada com sucesso!!!")
        } else {
            println("\nOcorreu um erro no cadastro")
        }

    }

    void alterarEmpresa(){

        this.controllerEmpresa.listarEmpresas()

        println "\nEscolha qual empresa você deseja alterar:"
        this.opcao = Integer.parseInt(Ferramentas.ler.nextLine())

        println("Altere o nome da empresa:")
        this.nomeEmpresa = Ferramentas.ler.nextLine()

        println("Altere o cnpj da empresa:")
        this.cnpj = Ferramentas.ler.nextLine()

        println("Altere email da empresa:")
        this.email = Ferramentas.ler.nextLine()

        println("Altere o cep da empresa:")
        this.cep = Ferramentas.ler.nextLine()

        println("Altere a descrição da empresa:")
        this.descricao = Ferramentas.ler.nextLine()

        println("Altere o pais:\n1. Brasil")
        this.pais = Integer.parseInt(Ferramentas.ler.nextLine())

        println("Altere o estado:")
        println(Ferramentas.estados)
        this.estado = Integer.parseInt(Ferramentas.ler.nextLine())

        println("Altere a senha:")
        this.senha = Ferramentas.ler.nextLine()

        this.novaEmpresa.setId(this.opcao)
        this.novaEmpresa.setNome(this.nomeEmpresa)
        this.novaEmpresa.setCnpj(this.cnpj)
        this.novaEmpresa.setEmail(this.email)
        this.novaEmpresa.setCep(this.cep)
        this.novaEmpresa.setDescricao(this.descricao)
        this.novaEmpresa.setPais(this.pais)
        this.novaEmpresa.setEstado(this.estado)
        this.novaEmpresa.setSenha(this.senha)

        this.retornoDB = this.controllerEmpresa.alterarEmpresa(this.novaEmpresa)

        if (this.retornoDB) {
            println("\nEmpresa alterada com sucesso!!!")
        } else {
            println("\nOcorreu um erro na alteração")
        }

    }

    void deletarEmpresa(){

        this.controllerEmpresa.listarEmpresas()

        println "\nEscolha qual empresa você deseja deletar:"
        this.opcao = Integer.parseInt(Ferramentas.ler.nextLine())

        this.retornoDB = this.controllerEmpresa.deletarEmpresa(this.opcao)

        if (this.retornoDB) {
            println("\nEmpresa deletada com sucesso!!!")
        } else {
            println("\nOcorreu um erro ao tentar deletar")
        }

    }

}
