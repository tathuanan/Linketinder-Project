"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const CadastrarPessoaBotoesEventos_1 = require("./dados/CadastrarPessoaBotoesEventos");
const GraficosCandidatos_1 = require("./dados/GraficosCandidatos");
const ListaCandidatos_1 = require("./dados/ListaCandidatos");
const ListaVagas_1 = require("./dados/ListaVagas");
CadastrarPessoaBotoesEventos_1.CadastrarPessoaBotoesEventos.botoesCadastroPessoa();
if (document.getElementById('competenciasChart')) {
    GraficosCandidatos_1.GraficosCandidatos.gerarGrafico();
    ListaCandidatos_1.ListaCandidatos.listarCandidatos();
}
if (document.getElementById('formCandidato')) {
    CadastrarPessoaBotoesEventos_1.CadastrarPessoaBotoesEventos.cadastrarCandidato();
}
if (document.getElementById('formEmpresa')) {
    CadastrarPessoaBotoesEventos_1.CadastrarPessoaBotoesEventos.cadastrarEmpresa();
}
if (document.getElementById('tabelaVagas')) {
    ListaVagas_1.ListaVagas.listarVagas();
}
