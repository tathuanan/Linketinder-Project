import {Vagas} from "./Vagas";

export class ListaVagas {

    public static listarVagas() {
        let corpoTabela: any = document.querySelector('#tabelaVagas tbody');

        corpoTabela.innerHTML = '';
        let vagas = Vagas.vagas;

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
