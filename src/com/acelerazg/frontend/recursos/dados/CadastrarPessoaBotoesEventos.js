"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.CadastrarPessoaBotoesEventos = void 0;
const ListaPessoa_1 = require("./ListaPessoa");
const Candidato_1 = require("../pessoas/Candidato");
const Empresa_1 = require("../pessoas/Empresa");
class CadastrarPessoaBotoesEventos {
    static botoesCadastroPessoa() {
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
    static cadastrarCandidato() {
        const formCandidato = document.getElementById('formCandidato');
        if (formCandidato != formCandidato.getAttribute('hidden')) {
            formCandidato.addEventListener('submit', function (event) {
                let competencias = document.querySelectorAll('#candidatoCompetencias input[type="checkbox"]:checked');
                let candidatoNome = document.getElementById('candidatoNome');
                let cpf = document.getElementById('cpf');
                let idade = document.getElementById('idade');
                let email = document.getElementById('candidatoEmail');
                let estado = document.getElementById('candidatoEstado');
                let cep = document.getElementById('candidatoCep');
                let descricao = document.getElementById('candidatoDescricao');
                let competenciasSelecionadas;
                if (competencias.length === 0) {
                    event.preventDefault();
                    alert('Selecione pelo menos uma competência.');
                }
                else {
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
                    ListaPessoa_1.ListaPessoa.candidatos.push(new Candidato_1.Candidato(candidatoNome, email, estado, descricao, competencias, cep, cpf, idade));
                    alert("Candidato cadastrado com sucesso!!");
                }
            });
        }
    }
    static cadastrarEmpresa() {
        const formEmpresa = document.getElementById('formEmpresa');
        if (formEmpresa != formEmpresa.getAttribute('hidden')) {
            formEmpresa.addEventListener('submit', function (event) {
                let competencias = document.querySelectorAll('#empresaCompetencias input[type="checkbox"]:checked');
                let empresaNome = document.getElementById('empresaNome');
                let cnpj = document.getElementById('cnpj');
                let pais = document.getElementById('pais');
                let email = document.getElementById('empresaEmail');
                let estado = document.getElementById('empresaEstado');
                let cep = document.getElementById('empresaCep');
                let descricao = document.getElementById('empresaDescricao');
                let competenciasSelecionadas;
                if (competencias.length === 0) {
                    event.preventDefault();
                    alert('Selecione pelo menos uma competência.');
                }
                else {
                    function obterCompetenciasSelecionadas() {
                        competenciasSelecionadas = [];
                        const checkboxes = document.querySelectorAll('#empresaCompetencias input[type="checkbox"]:checked');
                        checkboxes.forEach(function (checkbox) {
                            competenciasSelecionadas.push(checkbox.getAttribute('value'));
                        });
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
                    ListaPessoa_1.ListaPessoa.empresas.push(new Empresa_1.Empresa(empresaNome, email, estado, descricao, competencias, cep, pais, cnpj));
                    alert("Empresa cadastrada com sucesso!!");
                }
            });
        }
    }
}
exports.CadastrarPessoaBotoesEventos = CadastrarPessoaBotoesEventos;
