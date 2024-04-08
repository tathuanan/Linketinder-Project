package com.acelerazg.backend.menu

import com.acelerazg.backend.controller.ControllerCandidato
import com.acelerazg.backend.utilities.Ferramentas
import com.acelerazg.backend.viewer.CandidatoViewer

class MenuCandidato {

    static menuCandidato(){

        int opcao
        CandidatoViewer candidatoViewer = new CandidatoViewer()
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
                        candidatoViewer.listarCandidatos()
                        break
                    case 2:
                        candidatoViewer.cadastrarCandidato()
                        break
                    case 3:
                        candidatoViewer.alterarCandidato()
                        break
                    case 4:
                        candidatoViewer.deletarCandidato()
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
