"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Regex = void 0;
class Regex {
    static validarNome(nome) {
        const regex = /^[\ba-zA-ZÀ-ÿ]+( [\ba-zA-ZÀ-ÿ]+)+$/g;
        return regex.test(nome);
    }
    static validarCPF(cpf) {
        const regex = /^\d{3}\.?\d{3}\.?\d{3}-?\d{2}$/;
        return regex.test(cpf);
    }
    static validarIdade(idade) {
        const regex = /^\d+$/;
        return regex.test(idade);
    }
    static validarEmail(email) {
        const regex = /^[a-zA-Z0-9._-]+@[a-zA-Z]+[^@?%&#$]\.[a-zA-Z]+(\.[a-zA-Z]+)?$/;
        return regex.test(email);
    }
    static validarEstado(estado) {
        const regex = /^[A-Z]{2}$/;
        return regex.test(estado);
    }
    static validarCEP(cep) {
        const regex = /^\d{5}-?\d{3}$/;
        return regex.test(cep);
    }
    static validarCNPJ(cnpj) {
        const regex = /^\d{2}\.?\d{3}\.?\d{3}\/\d{4}-?\d{2}$/;
        return regex.test(cnpj);
    }
    static validarPais(pais) {
        const regex = /^[\ba-zA-Z]+( [\ba-zA-Z]+)*$/;
        return regex.test(pais);
    }
    static validarDescricao(descricao) {
        const regex = /^[a-zA-ZÀ-ÿ0-9,.; ]{30,}$/;
        return regex.test(descricao);
    }
}
exports.Regex = Regex;
