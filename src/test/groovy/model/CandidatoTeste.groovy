package model;

import com.acelerazg.backend.model.Candidato
import groovy.test.GroovyTestCase
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

import java.sql.Date

class CandidatoTeste extends GroovyTestCase {

    private static Candidato candidato

    @BeforeAll
    static void instanciaCandidato() {

        candidato = new Candidato(
                1,
                "Vitao",
                "Melhor Tutor",
                "05/03/2000",
                "00011122233",
                "vitao.tutor@acelerazg.com.br",
                "GO",
                "Tutor mais descolado do AceleraZG",
                "Brasil",
                "72000000",
                "[Java, Groovy, Angular, TypeScript]" as List<String>,
                "112233")
    }

    @Test
    void transformaDataNascimentoParaDateSQLTeste() {

        //given:
        Date dataSql = new Date(100, 02, 05)

        //when:
        Date dataNascimento = candidato.getDataNascimento()

        //then:
        assertEquals(dataSql, dataNascimento)
    }

}

