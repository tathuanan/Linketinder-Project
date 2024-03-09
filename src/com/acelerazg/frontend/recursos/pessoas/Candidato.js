"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.Candidato = void 0;
const Pessoa_1 = __importDefault(require("./Pessoa"));
class Candidato extends Pessoa_1.default {
    constructor(nome, email, estado, descricao, competencias, cep, _cpf, _idade) {
        super(nome, email, estado, descricao, competencias, cep);
        this._cpf = _cpf;
        this._idade = _idade;
    }
    get cpf() {
        return this._cpf;
    }
    set cpf(value) {
        this._cpf = value;
    }
    get idade() {
        return this._idade;
    }
    set idade(value) {
        this._idade = value;
    }
}
exports.Candidato = Candidato;
