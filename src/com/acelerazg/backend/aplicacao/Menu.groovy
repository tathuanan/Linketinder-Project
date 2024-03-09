package com.acelerazg.backend.aplicacao

import com.acelerazg.backend.dados.ControladorCandidatos
import com.acelerazg.backend.dados.ControladorEmpresas

class Menu {

    static menu() {

        int opcao
        String bl = "\n"
        String menuPrincipal =
               "\nPor favor escolha uma opção:\n" +
                       "0. Encerrar aplicação\n" +
                       "1. Listar Candidatos.\n" +
                       "2. Listar Empresas.\n" +
                       "3. Cadastrar Candidato.\n" +
                       "4. Cadastrar Empresa."

        println "Bem-vindo ao Menu Principal do LinkeTinder"

        while (true) {
            println menuPrincipal
            opcao = Integer.parseInt(Ferramentas.ler.nextLine())

            try {

                switch (opcao) {
                    case 0:
                        println "\nEncerrando a aplicação"
                        break
                    case 1:
                        println bl
                        ControladorCandidatos.listarCandidatos()
                        break
                    case 2:
                        println bl
                        ControladorEmpresas.listarEmpresas()
                        break
                    case 3:
                        ControladorCandidatos.cadastrarCandidato()
                        break
                    case 4:
                        ControladorEmpresas.cadastrarEmpresa()
                        break
                    default:
                        println("\nOpção inválida!!")
                        break
                }

                if (opcao == 0) {
                    break
                }

            }
            catch (IOException e) {
                System.err.println("Erro não previsto na aplicação: " + e.getMessage())
            }
        }
    }
}