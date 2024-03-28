package com.acelerazg.backend.aplicacao

import com.acelerazg.backend.dados.ControladorCandidatos
import com.acelerazg.backend.dados.ControladorEmpresas

class Menu {

    static menu() {

        int opcao
        String menuPrincipal =
               "\nPor favor escolha uma opção:\n" +
                       "0. Encerrar aplicação\n" +
                       "1. Menu Candidatos.\n" +
                       "2. Menu Empresas.\n" +
                       "3. Menu Vagas.\n" +
                       "4. Menu Competências."

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
                        MenuCandidato.menuCandidato()
                        break
                    case 2:
                        MenuEmpresa.menuEmpresa()
                        break
                    case 3:
                        MenuVaga.menuVaga()
                        break
                    case 4:
                        MenuCompetencia.menuCompetencia()
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