package controller

import com.acelerazg.backend.controller.EmpresaController
import com.acelerazg.backend.model.Empresa
import com.acelerazg.backend.service.EmpresaService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.jupiter.MockitoExtension

import static org.mockito.Mockito.when
import static org.mockito.Mockito.verify

@ExtendWith(MockitoExtension.class)
class EmpresaControllerTeste extends GroovyTestCase {

    private EmpresaController empresaController

    @Mock
    private EmpresaService empresaService

    @BeforeEach
    void configuracoes() {
        MockitoAnnotations.initMocks(this)
        empresaController = new EmpresaController()
        empresaController.empresaService = empresaService
    }

    @Test
    void listarEmpresasTeste() {
        // when
        empresaController.listarEmpresas()

        // then
        verify(empresaService).listarEmpresas()

    }

    @Test
    void cadastrarEmpresaTeste() {
        // given
        Empresa empresa = new Empresa()
        when(empresaService.cadastrarEmpresa(empresa)).thenReturn(true)

        // when
        boolean resultado = empresaController.cadastrarEmpresa(empresa)

        // then
        verify(empresaService).cadastrarEmpresa(empresa)
        assertEquals(true, resultado)
    }

    @Test
    void alterarEmpresaTeste() {
        // given
        Empresa empresa = new Empresa()
        when(empresaService.alterarEmpresa(empresa)).thenReturn(true)

        // when
        boolean resultado = empresaController.alterarEmpresa(empresa)

        // then
        verify(empresaService).alterarEmpresa(empresa)
        assertEquals(true, resultado)
    }

    @Test
    void deletarEmpresaTeste() {
        // given
        Integer empresaId = 1
        when(empresaService.deletarEmpresa(empresaId)).thenReturn(true)

        // when
        boolean resultado = empresaController.deletarEmpresa(empresaId)

        // then
        verify(empresaService).deletarEmpresa(empresaId)
        assertEquals(true, resultado)
    }

}
