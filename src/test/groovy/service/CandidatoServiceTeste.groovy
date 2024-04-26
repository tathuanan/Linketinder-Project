package service

import com.acelerazg.backend.DAO.CandidatoDAO
import com.acelerazg.backend.model.Candidato
import com.acelerazg.backend.service.CandidatoService
import groovy.test.GroovyTestCase
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

import static org.mockito.Mockito.verify
import static org.mockito.Mockito.when

@ExtendWith(MockitoExtension.class)
class CandidatoServiceTeste extends GroovyTestCase {

    @InjectMocks
    private CandidatoService candidatoService

    @Mock
    private CandidatoDAO candidatoDAO

    static List<Candidato> intanciaDeCandidatosMock() {
        List<Candidato> candidatosMock = Arrays.asList(
                new Candidato(id: 1, nome: "João"),
                new Candidato(id: 2, nome: "Maria")
        )
        return candidatosMock
    }

    @Test
    void listarCandidatosTeste() {
        // given
        when(candidatoService.listarCandidatos()).thenReturn(intanciaDeCandidatosMock())

        // when
        candidatoService.listarCandidatos()

        // then
        verify(candidatoDAO).listar()
    }

    @Test
    void candidatosCadastradosTeste() {
        // given
        when(candidatoService.candidatosCadastrados()).thenReturn(intanciaDeCandidatosMock())

        // when
        List<Candidato> candidatos = candidatoService.candidatosCadastrados()

        // then
        verify(candidatoDAO).listar()
        assertEquals(2, candidatos.size())
        assertEquals("João", candidatos.get(0).getNome())
        assertEquals("Maria", candidatos.get(1).getNome())
    }

    @Test
    void cadastrarCandidatoTeste() {
        // given
        Candidato candidato = new Candidato()
        when(candidatoService.cadastrarCandidato(candidato)).thenReturn(true)

        // when
        boolean resultado = candidatoService.cadastrarCandidato(candidato)

        // then
        assertEquals(true, resultado)
    }

    @Test
    void cadastrarCompetenciaCandidatoTeste() {
        // given
        Integer candidatoId = 1
        Integer competenciaId = 1
        when(candidatoService.cadastrarCompetenciaCandidato(candidatoId, competenciaId)).thenReturn(true)

        // when
        boolean resultado = candidatoService.cadastrarCompetenciaCandidato(candidatoId, competenciaId)

        // then
        assertEquals(true, resultado)
    }

    @Test
    void alterarCandidatoTeste() {
        // given
        Candidato candidato = new Candidato()
        when(candidatoService.alterarCandidato(candidato)).thenReturn(true)

        // when
        boolean resultado = candidatoService.alterarCandidato(candidato)

        // then
        assertEquals(true, resultado)
    }

    @Test
    void deletarCandidatoTeste() {
        // given
        Integer candidatoId = 1
        when(candidatoService.deletarCandidato(candidatoId)).thenReturn(true)

        // when
        boolean resultado = candidatoService.deletarCandidato(candidatoId)

        // then
        assertEquals(true, resultado)
    }

}
