"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.Empresa = void 0;
const Pessoa_1 = __importDefault(require("./Pessoa"));
class Empresa extends Pessoa_1.default {
    constructor(nome, email, estado, descricao, competencias, cep, pais, cnpj) {
        super(nome, email, estado, descricao, competencias, cep);
    }
    get pais() {
        return this.pais;
    }
    set pais(value) {
        this.pais = value;
    }
    get cnpj() {
        return this.cnpj;
    }
    set cnpj(value) {
        this.cnpj = value;
    }
}
exports.Empresa = Empresa;
