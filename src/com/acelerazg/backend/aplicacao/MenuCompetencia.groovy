package com.acelerazg.backend.aplicacao

import com.acelerazg.backend.controller.ControllerCompetencia

class MenuCompetencia {

    static menuCompetencia() {

        int opcao
        ControllerCompetencia controllerCompetencia = new ControllerCompetencia()
        String menuCompetencia =
                "\nPor favor escolha uma opção:\n" +
                        "0. Voltar ao menu anterior\n" +
                        "1. Listar Competências.\n" +
                        "2. Cadastrar Competência.\n" +
                        "3. Alterar Competência.\n" +
                        "4. Excluir Competência.\n"

        while (true) {
            println menuCompetencia
            opcao = Integer.parseInt(Ferramentas.ler.nextLine())

            try {

                switch (opcao) {
                    case 0:
                        break
                    case 1:
                        controllerCompetencia.listarCompetencias()
                        break
                    case 2:
                        controllerCompetencia.cadastrarCompetencia()
                        break
                    case 3:
                        controllerCompetencia.alterarCompetencia()
                        break
                    case 4:
                        controllerCompetencia.deletarCompetencia()
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