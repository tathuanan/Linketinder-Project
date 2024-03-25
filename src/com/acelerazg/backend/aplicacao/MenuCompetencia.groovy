package com.acelerazg.backend.aplicacao

import com.acelerazg.backend.dados.ControladorCandidatos
import com.acelerazg.backend.dados.ControladorEmpresas
import com.acelerazg.backend.model.Competencia
import com.acelerazg.backend.service.CompetenciaService

class MenuCompetencia {

    static menuCompetencia() {

        int opcao
        CompetenciaService competencias = new CompetenciaService()
        Competencia novaCompetencia = new Competencia()
        String nomeNovaCompetencia
        String menuCompetencia =
                "\nPor favor escolha uma opção:\n" +
                        "0. Voltar ao menu anterior\n" +
                        "1. Listar Competências.\n" +
                        "2. Inserir Competência.\n" +
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
                        competencias.listarCompetencia()
                        break
                    case 2:
                        println("Digite a nova competência:")
                        nomeNovaCompetencia = Ferramentas.ler.nextLine()
                        novaCompetencia.setCompetencia(nomeNovaCompetencia)
                        CompetenciaService.cadastrarCompetencia(novaCompetencia)
                        break
                    case 3:
                        competencias.listarCompetencia()
                        println("\nEscolha qual a competência que você deseja alterar:")
                        opcao = Integer.parseInt(Ferramentas.ler.nextLine())
                        println("Digite a nova competência:")
                        nomeNovaCompetencia = Ferramentas.ler.nextLine()
                        novaCompetencia.setId(opcao)
                        novaCompetencia.setCompetencia(nomeNovaCompetencia)
                        CompetenciaService.alterarCompetencia(novaCompetencia)
                        break
                    case 4:
                        competencias.listarCompetencia()
                        println("\nEscolha qual a competência que você deseja deletar:")
                        opcao = Integer.parseInt(Ferramentas.ler.nextLine())
                        CompetenciaService.deletarCompetencia(opcao)
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