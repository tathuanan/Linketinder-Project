"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.ListaVagas = void 0;
const Vagas_1 = require("./Vagas");
class ListaVagas {
    static listarVagas() {
        let corpoTabela = document.querySelector('#tabelaVagas tbody');
        corpoTabela.innerHTML = '';
        let vagas = Vagas_1.Vagas.vagas;
        for (let i = 0; i < vagas.length; i++) {
            let vaga = vagas[i];
            let linha = document.createElement('tr');
            linha.innerHTML = `
                <td>${vaga.nome}</td>
                <td>${vaga.estado}</td>
                <td>${vaga.competencias.join(', ')}</td>
                <td>${vaga.descricao}</td>
            `;
            corpoTabela.appendChild(linha);
        }
    }
}
exports.ListaVagas = ListaVagas;
