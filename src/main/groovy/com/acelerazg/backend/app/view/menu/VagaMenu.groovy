package com.acelerazg.backend.app.view.menu


import com.acelerazg.backend.app.view.utilities.LeitorTerminal

class VagaMenu {

    static menuVaga(){

        int opcao
        com.acelerazg.backend.app.view.viewer.VagaViewer vagaViewer = new com.acelerazg.backend.app.view.viewer.VagaViewer()
        String menuVaga =
                "\nPor favor escolha uma opção:\n" +
                        "0. Voltar ao menu anterior\n" +
                        "1. Listar Vagas.\n" +
                        "2. Cadastrar Vaga.\n" +
                        "3. Alterar Vaga.\n" +
                        "4. Excluir Vaga."

        while (true) {
            println menuVaga
            opcao = Integer.parseInt(LeitorTerminal.ler.nextLine())

            try {

                switch (opcao) {
                    case 0:
                        break
                    case 1:
                        vagaViewer.listarVagas()
                        break
                    case 2:
                        vagaViewer.cadastrarVaga()
                        break
                    case 3:
                        vagaViewer.alterarVaga()
                        break
                    case 4:
                        vagaViewer.deletarVaga()
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
