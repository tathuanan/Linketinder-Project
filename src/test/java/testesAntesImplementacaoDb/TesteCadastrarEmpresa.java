package testesAntesImplementacaoDb;

import com.acelerazg.backend.dados.IControladorEmpresas;
import com.acelerazg.backend.dados.ListaPessoa;
import com.acelerazg.backend.model.Empresa;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class TesteCadastrarEmpresa {

    @Test
    public void testeCadastrarEmpresa() {

        Empresa empresa = new Empresa();
        IControladorEmpresas iControladorEmpresas = iEmpresa -> ListaPessoa.empresas.add(empresa);

        String nome = "PAÇOCA LTDA";
        String email = "contato@pacoca.com.br";
        String estado = "DF";
        String descricao = "Empresa de médio porte com foco em clientes do ramo alimentício.";
//        List<String> competencias = new ArrayList<>();
        String cep = "72000000";
        String pais = "Brasil";
        String cnpj = "00000111000100";

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

        iControladorEmpresas.iCadastrarEmpresa(empresa);

        Empresa resultadoEsperado = ListaPessoa.empresas.get(ListaPessoa.empresas.size() - 1);

        Assertions.assertEquals(empresa, resultadoEsperado);

    }
}