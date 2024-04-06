package com.acelerazg.backend.menu

import com.acelerazg.backend.controller.ControllerCandidato
import com.acelerazg.backend.utilities.Ferramentas

class MenuCandidato {

    static menuCandidato(){

        int opcao
        ControllerCandidato controllerCandidato = new ControllerCandidato()
        String menuCandidato =
                "\nPor favor escolha uma opção:\n" +
                        "0. Voltar ao menu anterior\n" +
                        "1. Listar Candidatos.\n" +
                        "2. Cadastrar Candidato.\n" +
                        "3. Alterar Candidato.\n" +
                        "4. Excluir Candidato."

        while (true) {
            println menuCandidato
            opcao = Integer.parseInt(Ferramentas.ler.nextLine())

            try {

                switch (opcao) {
                    case 0:
                        break
                    case 1:
                        controllerCandidato.listarCandidatos()
                        break
                    case 2:
                        controllerCandidato.cadastrarCandidato()
                        break
                    case 3:
                        controllerCandidato.alterarCandidato()
                        break
                    case 4:
                        controllerCandidato.deletarCandidato()
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
