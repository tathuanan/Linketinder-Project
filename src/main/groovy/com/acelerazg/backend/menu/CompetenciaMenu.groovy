package com.acelerazg.backend.menu


import com.acelerazg.backend.utilities.Ferramentas
import com.acelerazg.backend.viewer.CompetenciaViewer

class CompetenciaMenu {

    static menuCompetencia() {

        int opcao
        CompetenciaViewer competenciaViewer = new CompetenciaViewer()
        String menuCompetencia =
                "\nPor favor escolha uma opção:\n" +
                        "0. Voltar ao menu anterior\n" +
                        "1. Listar Competências.\n" +
                        "2. Cadastrar Competência.\n" +
                        "3. Alterar Competência.\n" +
                        "4. Excluir Competência."

        while (true) {
            println menuCompetencia
            opcao = Integer.parseInt(Ferramentas.ler.nextLine())

            try {

                switch (opcao) {
                    case 0:
                        break
                    case 1:
                        competenciaViewer.listarCompetencias()
                        break
                    case 2:
                        competenciaViewer.cadastrarCompetencia()
                        break
                    case 3:
                        competenciaViewer.alterarCompetencia()
                        break
                    case 4:
                        competenciaViewer.deletarCompetencia()
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