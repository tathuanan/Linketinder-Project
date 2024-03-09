"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
class Pessoa {
    constructor(_nome, _email, _estado, _descricao, _competencias, _cep) {
        this._nome = _nome;
        this._email = _email;
        this._estado = _estado;
        this._descricao = _descricao;
        this._competencias = _competencias;
        this._cep = _cep;
    }
    get nome() {
        return this._nome;
    }
    set nome(value) {
        this._nome = value;
    }
    get email() {
        return this._email;
    }
    set email(value) {
        this._email = value;
    }
    get estado() {
        return this._estado;
    }
    set estado(value) {
        this._estado = value;
    }
    get descricao() {
        return this._descricao;
    }
    set descricao(value) {
        this._descricao = value;
    }
    get competencias() {
        return this._competencias;
    }
    set competencias(value) {
        this._competencias = value;
    }
    get cep() {
        return this._cep;
    }
    set cep(value) {
        this._cep = value;
    }
}
exports.default = Pessoa;
