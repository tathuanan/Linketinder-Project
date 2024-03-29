import {CadastrarPessoaBotoesEventos} from "./dados/CadastrarPessoaBotoesEventos";
import {GraficosCandidatos} from "./dados/GraficosCandidatos";
import {ListaCandidatos} from "./dados/ListaCandidatos";
import {ListaVagas} from "./dados/ListaVagas";


CadastrarPessoaBotoesEventos.botoesCadastroPessoa();

if (document.getElementById('competenciasChart')) {
    GraficosCandidatos.gerarGrafico();
    ListaCandidatos.listarCandidatos();
}

if (document.getElementById('formCandidato')) {
    CadastrarPessoaBotoesEventos.cadastrarCandidato();
}

if (document.getElementById('formEmpresa')) {
    CadastrarPessoaBotoesEventos.cadastrarEmpresa();
}

if (document.getElementById('tabelaVagas')) {
    ListaVagas.listarVagas();
}
