package com.acelerazg.testes;

import com.acelerazg.dados.ListaPessoa;
import com.acelerazg.pessoas.Empresa;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;


public class TesteCadastrarEmpresa {

    static class ControladorEmpresas extends com.acelerazg.dados.ControladorEmpresas{
        static void cadastrarEmpresa(Empresa empresa) {
        }
    }

    @Test
    public void testeCadastrarEmpresa() {

        Empresa empresa = new Empresa();

        String nome = "";
        String email = "ze.quantas@acelerazg.com.br";
        String estado = "DF";
        String descricao = "Excelente programador com experiência";
        List<String> competencias = new ArrayList<>();
        String cep = "72000000";
        String pais = "Brasil";
        String cnpj = "00000111000100";

        competencias.add("Java");
        competencias.add("Groovy");
        competencias.add("JUnit");
        competencias.add("Scrumban");

        empresa.setNome(nome);
        empresa.setEmail(email);
        empresa.setEstado(estado);
        empresa.setDescricao(descricao);
        empresa.setCompetencias(competencias);
        empresa.setCep(cep);
        empresa.setPais(pais);
        empresa.setCnpj(cnpj);

        ControladorEmpresas.cadastrarEmpresa(empresa);

        Empresa resultadoEsperado = ListaPessoa.empresas.get(ListaPessoa.empresas.size() - 1);

        Assertions.assertEquals(empresa, resultadoEsperado);

    }
}