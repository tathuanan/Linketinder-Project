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
}
exports.Regex = Regex;
