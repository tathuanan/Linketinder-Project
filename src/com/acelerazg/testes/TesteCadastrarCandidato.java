package com.acelerazg.testes;

import com.acelerazg.dados.ListaPessoa;
import com.acelerazg.pessoas.CadastrarCandidato;
import com.acelerazg.pessoas.Candidato;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;


public class TesteCadastrarCandidato {
    @Test
    public void testeCadastrarCantidato(){

        Candidato candidato = new Candidato();
        CadastrarCandidato cc = new CadastrarCandidato();

        String nome = "Ze das Quantas";
        String email = "ze.quantas@acelerazg.com.br";
        String estado = "DF";
        String descricao = "Excelente programador com experiência";
        List<String> competencias = new ArrayList<>();
        String cep = "72000000";
        String cpf = "11122233344";
        int idade = 18;

        competencias.add("Java");
        competencias.add("Groovy");
        competencias.add("JUnit");
        competencias.add("Scrumban");

        candidato.setNome(nome);
        candidato.setEmail(email);
        candidato.setEstado(estado);
        candidato.setDescricao(descricao);
        candidato.setCompetencias(competencias);
        candidato.setCep(cep);
        candidato.setCpf(cpf);
        candidato.setIdade(idade);

        cc.cadastrarCandidato(candidato);

        Candidato resultadoEsperado = ListaPessoa.candidatos.get(ListaPessoa.candidatos.size() -1);

        assertEquals(candidato, resultadoEsperado);

        };
}