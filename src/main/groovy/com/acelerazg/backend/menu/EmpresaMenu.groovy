package com.acelerazg.backend.menu


import com.acelerazg.backend.utilities.Ferramentas
import com.acelerazg.backend.viewer.EmpresaViewer

class EmpresaMenu {

    static menuEmpresa(){

        int opcao
        EmpresaViewer empresaViewer = new EmpresaViewer()
        String menuEmpresa =
                "\nPor favor escolha uma opção:\n" +
                        "0. Voltar ao menu anterior\n" +
                        "1. Listar Empresas.\n" +
                        "2. Cadastrar Empresa.\n" +
                        "3. Alterar Empresa.\n" +
                        "4. Excluir Empresa."

        while (true) {
            println menuEmpresa
            opcao = Integer.parseInt(Ferramentas.ler.nextLine())

            try {

                switch (opcao) {
                    case 0:
                        break
                    case 1:
                        empresaViewer.listarEmpresas()
                        break
                    case 2:
                        empresaViewer.cadastrarEmpresa()
                        break
                    case 3:
                        empresaViewer.alterarEmpresa()
                        break
                    case 4:
                        empresaViewer.deletarEmpresa()
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
