"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.ListaCandidatos = void 0;
const ListaPessoa_1 = require("./ListaPessoa");
class ListaCandidatos {
    static listarCandidatos() {
        let corpoTabela = document.querySelector('#tabelaCandidatos tbody');
        corpoTabela.innerHTML = '';
        let candidatos = ListaPessoa_1.ListaPessoa.candidatos;
        for (let i = 0; i < candidatos.length; i++) {
            let candidato = candidatos[i];
            let linha = document.createElement('tr');
            linha.innerHTML = `
                <td>Candidato ${[i + 1]}</td>
                <td>${candidato.idade}</td>
                <td>${candidato.estado}</td>
                <td>${candidato.competencias.join(', ')}</td>
                <td>${candidato.descricao}</td>
            `;
            corpoTabela.appendChild(linha);
        }
    }
}
exports.ListaCandidatos = ListaCandidatos;
