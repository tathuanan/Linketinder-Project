import {ListaPessoa} from "./ListaPessoa";

export class ListaCandidatos {

    public static listarCandidatos() {
        let corpoTabela: any = document.querySelector('#tabelaCandidatos tbody');

        corpoTabela.innerHTML = '';
        let candidatos = ListaPessoa.candidatos;

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
