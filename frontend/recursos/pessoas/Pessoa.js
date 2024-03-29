"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
class Pessoa {
    constructor(nome, email, estado, descricao, competencias, cep) {
    }
    get nome() {
        return this.nome;
    }
    set nome(value) {
        this.nome = value;
    }
    get email() {
        return this.email;
    }
    set email(value) {
        this.email = value;
    }
    get estado() {
        return this.estado;
    }
    set estado(value) {
        this.estado = value;
    }
    get descricao() {
        return this.descricao;
    }
    set descricao(value) {
        this.descricao = value;
    }
    get competencias() {
        return this.competencias;
    }
    set competencias(value) {
        this.competencias = value;
    }
    get cep() {
        return this.cep;
    }
    set cep(value) {
        this.cep = value;
    }
}
exports.default = Pessoa;
