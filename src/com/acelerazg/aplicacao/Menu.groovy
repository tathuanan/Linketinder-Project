package com.acelerazg.aplicacao

import com.acelerazg.dados.ControladorCandidatos
import com.acelerazg.dados.ControladorEmpresas

class Menu {

    static menu() {

        Scanner ler = new Scanner(System.in)

        int opcao

        String menuPrincipal =
                "Bem-vindo ao Menu Principal do LinkeTinder\n\n" +
                        "Por favor escolha uma opção:\n" +
                        "1. Listar Candidatos.\n" +
                        "2. Listar Empresas.\n" +
                        "3. Encerrar aplicação."
        while (true) {
            println menuPrincipal
            opcao = Integer.parseInt(ler.nextLine())

            try {

                switch (opcao) {
                    case 1:
                        ControladorCandidatos.listarCandidatos()
                        break
                    case 2:
                        ControladorEmpresas.listarEmpresas()
                        break
                    case 3:
                        println "Encerrando a aplicação"
                        break
                    default:
                        println("Por favor escolha uma opção válida")
                        break
                }

                if (opcao == 3) {
                    break
                }

            }
            catch (IOException e) {
                System.err.println("Erro não previsto na aplicação: " + e.getMessage())
            }
        }
    }
}