package com.acelerazg.backend.aplicacao

import com.acelerazg.backend.controller.ControllerEmpresa

class MenuEmpresa {

    static menuEmpresa(){

        int opcao
        ControllerEmpresa controllerEmpresa = new ControllerEmpresa()
        String menuEmpresa =
                "\nPor favor escolha uma opção:\n" +
                        "0. Voltar ao menu anterior\n" +
                        "1. Listar Empresas.\n" +
                        "2. Cadastrar Empresa.\n" +
                        "3. Alterar Empresa.\n" +
                        "4. Excluir Empresa.\n"

        while (true) {
            println menuEmpresa
            opcao = Integer.parseInt(Ferramentas.ler.nextLine())

            try {

                switch (opcao) {
                    case 0:
                        break
                    case 1:
                        controllerEmpresa.listarEmpresas()
                        break
                    case 2:
                        controllerEmpresa.cadastrarEmpresa()
                        break
                    case 3:
                        controllerEmpresa.alterarEmpresa()
                        break
                    case 4:
                        controllerEmpresa.deletarEmpresa()
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
