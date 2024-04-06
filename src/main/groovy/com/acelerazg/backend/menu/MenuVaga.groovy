package com.acelerazg.backend.menu

import com.acelerazg.backend.controller.ControllerVaga
import com.acelerazg.backend.utilities.Ferramentas

class MenuVaga {

    static menuVaga(){

        int opcao
        ControllerVaga controllerVaga = new ControllerVaga()
        String menuVaga =
                "\nPor favor escolha uma opção:\n" +
                        "0. Voltar ao menu anterior\n" +
                        "1. Listar Vagas.\n" +
                        "2. Cadastrar Vaga.\n" +
                        "3. Alterar Vaga.\n" +
                        "4. Excluir Vaga."

        while (true) {
            println menuVaga
            opcao = Integer.parseInt(Ferramentas.ler.nextLine())

            try {

                switch (opcao) {
                    case 0:
                        break
                    case 1:
                        controllerVaga.listarVagas()
                        break
                    case 2:
                        controllerVaga.cadastrarVaga()
                        break
                    case 3:
                        controllerVaga.alterarVaga()
                        break
                    case 4:
                        controllerVaga.deletarVaga()
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
