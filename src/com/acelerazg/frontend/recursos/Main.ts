import {CadastrarPessoaBotoesEventos} from "./dados/CadastrarPessoaBotoesEventos";
import {GraficosCandidatos} from "./dados/GraficosCandidatos";
import {ListaCandidatos} from "./dados/ListaCandidatos";


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
