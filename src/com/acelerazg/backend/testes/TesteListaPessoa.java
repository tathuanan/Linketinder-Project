package com.acelerazg.backend.testes;

import com.acelerazg.backend.model.Candidato;
import com.acelerazg.backend.model.Empresa;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class TesteListaPessoa {

    @Test
    public void testeListaPessoaCandidatos(){

        List<Candidato> candidatos = new ArrayList<>();
        Candidato candidato = new Candidato();

        String nome = "Ze das Quantas";
        String email = "ze.quantas@acelerazg.com.br";
        String estado = "DF";
        String descricao = "Excelente programador com experiência";
        List<String> competencias = new ArrayList<>();
        String cep = "72000000";
        String cpf = "11122233344";
        // int idade = 18;
        int resultadoEsperado = candidatos.size()+1;

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
        //candidato.setIdade(idade);

        candidatos.add(candidato);

        int resultado = candidatos.size();

        Assertions.assertEquals(resultado, resultadoEsperado);

    }

    @Test
    public void testeListaPessoaEmpresas(){

        List<Empresa> empresas = new ArrayList<>();
        Empresa empresa = new Empresa();

        String nome = "PAÇOCA LTDA";
        String email = "contato@pacoca.com.br";
        String estado = "DF";
        String descricao = "Empresa de médio porte com foco em clientes do ramo alimentício";
        //List<String> competencias = new ArrayList<>();
        String cep = "72000000";
        String pais = "Brasil";
        String cnpj = "00000111000100";
        int resultadoEsperado = empresas.size()+1;

//        competencias.add("Java");
//        competencias.add("Groovy");
//        competencias.add("JUnit");
//        competencias.add("Scrumban");

        empresa.setNome(nome);
        empresa.setEmail(email);
        empresa.setEstado(estado);
        empresa.setDescricao(descricao);
        //empresa.setCompetencias(competencias);
        empresa.setCep(cep);
        empresa.setPais(pais);
        empresa.setCnpj(cnpj);

        empresas.add(empresa);

        int resultado = empresas.size();

        Assertions.assertEquals(resultado, resultadoEsperado);
    }

}
