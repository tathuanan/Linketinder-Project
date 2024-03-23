import {ListaPessoa} from "./ListaPessoa";
import {Candidato} from "../pessoas/Candidato";
import {Empresa} from "../pessoas/Empresa";

export class CadastrarPessoaBotoesEventos {

    public static botoesCadastroPessoa() {

        const mostrarFormularioEmpresa = document.getElementById('mostrarFormularioEmpresa');
        const mostrarFormularioCandidato = document.getElementById('mostrarFormularioCandidato');
        const formEmpresa = document.getElementById('formEmpresa');
        const formCandidato = document.getElementById('formCandidato');

        if (formEmpresa && formCandidato && mostrarFormularioEmpresa && mostrarFormularioCandidato) {

            mostrarFormularioEmpresa.addEventListener('click', function () {
                formEmpresa.removeAttribute('hidden');
                mostrarFormularioEmpresa.setAttribute('hidden', 'true');
                mostrarFormularioCandidato.setAttribute('hidden', 'true');
            });

            mostrarFormularioCandidato.addEventListener('click', function () {
                formCandidato.removeAttribute('hidden');
                mostrarFormularioEmpresa.setAttribute('hidden', 'true');
                mostrarFormularioCandidato.setAttribute('hidden', 'true');
            });
        }

    }

    public static cadastrarCandidato() {

        const formCandidato: any = document.getElementById('formCandidato');

        if (formCandidato != formCandidato.getAttribute('hidden')) {

            formCandidato.addEventListener('submit', function (event: { preventDefault: () => void; }) {

                    let competencias: any = document.querySelectorAll('#candidatoCompetencias input[type="checkbox"]:checked');
                    let candidatoNome: any = document.getElementById('candidatoNome');
                    let cpf: any = document.getElementById('cpf');
                    let idade: any = document.getElementById('idade');
                    let email: any = document.getElementById('candidatoEmail');
                    let estado: any = document.getElementById('candidatoEstado');
                    let cep: any = document.getElementById('candidatoCep');
                    let descricao: any = document.getElementById('candidatoDescricao');
                    let competenciasSelecionadas: any[];

                    if (competencias.length === 0) {
                        event.preventDefault();
                        alert('Selecione pelo menos uma competência.');

                    } else {
                        function obterCompetenciasSelecionadas() {
                            competenciasSelecionadas = [];
                            const checkboxes = document.querySelectorAll('#candidatoCompetencias input[type="checkbox"]:checked');

                            checkboxes.forEach(function (checkbox) {
                                competenciasSelecionadas.push(checkbox.getAttribute('value'));
                            });
                            return competenciasSelecionadas;
                        }

                        competenciasSelecionadas = obterCompetenciasSelecionadas();
                        competenciasSelecionadas.join(', ');
                        competenciasSelecionadas.toString();

                        localStorage.setItem('candidatoNome', candidatoNome.value);
                        localStorage.setItem('cpf', cpf.value);
                        localStorage.setItem('idade', idade.value);
                        localStorage.setItem('email', email.value);
                        localStorage.setItem('estado', estado.value);
                        localStorage.setItem('cep', cep.value);
                        localStorage.setItem('descricao', descricao.value);
                        localStorage.setItem('competencias', competenciasSelecionadas.toString());

                        candidatoNome = localStorage.getItem('candidatoNome');
                        email = localStorage.getItem('email');
                        estado = localStorage.getItem('estado');
                        descricao = localStorage.getItem('descricao');
                        competencias = localStorage.getItem('competencias');
                        cep = localStorage.getItem('cep');
                        cpf = localStorage.getItem('cpf');
                        idade = localStorage.getItem('idade');

                        ListaPessoa.candidatos.push(new Candidato(
                            candidatoNome,
                            email,
                            estado,
                            descricao,
                            competencias,
                            cep,
                            cpf,
                            idade))

                        alert("Candidato cadastrado com sucesso!!");
                    }
                }
            )
        }
    }

    public static cadastrarEmpresa() {

        const formEmpresa: any = document.getElementById('formEmpresa');

        if (formEmpresa != formEmpresa.getAttribute('hidden')) {

            formEmpresa.addEventListener('submit', function (event: { preventDefault: () => void; }) {

                    let competencias: any = document.querySelectorAll('#empresaCompetencias input[type="checkbox"]:checked');
                    let empresaNome: any = document.getElementById('empresaNome');
                    let cnpj: any = document.getElementById('cnpj');
                    let pais: any = document.getElementById('pais');
                    let email: any = document.getElementById('empresaEmail');
                    let estado: any = document.getElementById('empresaEstado');
                    let cep: any = document.getElementById('empresaCep');
                    let descricao: any = document.getElementById('empresaDescricao');
                    let competenciasSelecionadas: any[];

                    if (competencias.length === 0) {
                        event.preventDefault();
                        alert('Selecione pelo menos uma competência.');

                    } else {
                        function obterCompetenciasSelecionadas() {
                            competenciasSelecionadas = [];
                            const checkboxes = document.querySelectorAll('#empresaCompetencias input[type="checkbox"]:checked');

                            checkboxes.forEach(function (checkbox) {
                                competenciasSelecionadas.push(checkbox.getAttribute('value'));
                            })
                            return competenciasSelecionadas;
                        }

                        competenciasSelecionadas = obterCompetenciasSelecionadas();
                        competenciasSelecionadas.join(', ');
                        competenciasSelecionadas.toString();

                        localStorage.setItem('empresaNome', empresaNome.value);
                        localStorage.setItem('cnpj', cnpj.value);
                        localStorage.setItem('pais', pais.value);
                        localStorage.setItem('empresaEmail', email.value);
                        localStorage.setItem('empresaEstado', estado.value);
                        localStorage.setItem('empresaCep', cep.value);
                        localStorage.setItem('empresaDescricao', descricao.value);
                        localStorage.setItem('empresaCompetencias', competenciasSelecionadas.toString());

                        empresaNome = localStorage.getItem('empresaNome');
                        email = localStorage.getItem('empresaEmail');
                        estado = localStorage.getItem('empresaEstado');
                        descricao = localStorage.getItem('empresaDescricao');
                        competencias = localStorage.getItem('empresaCompetencias');
                        cep = localStorage.getItem('empresaCep');
                        cnpj = localStorage.getItem('cnpj');
                        pais = localStorage.getItem('pais');

                        ListaPessoa.empresas.push(new Empresa(
                            empresaNome,
                            email,
                            estado,
                            descricao,
                            competencias,
                            cep,
                            pais,
                            cnpj))

                        alert("Empresa cadastrada com sucesso!!");
                    }
                }
            )
        }
    }
}