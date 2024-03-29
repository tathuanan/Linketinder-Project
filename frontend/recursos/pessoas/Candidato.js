"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.Candidato = void 0;
const Pessoa_1 = __importDefault(require("./Pessoa"));
class Candidato extends Pessoa_1.default {
    constructor(nome, email, estado, descricao, competencias, cep, cpf, idade) {
        super(nome, email, estado, descricao, competencias, cep);
    }
    get cpf() {
        return this.cpf;
    }
    set cpf(value) {
        this.cpf = value;
    }
    get idade() {
        return this.idade;
    }
    set idade(value) {
        this.idade = value;
    }
}
exports.Candidato = Candidato;
