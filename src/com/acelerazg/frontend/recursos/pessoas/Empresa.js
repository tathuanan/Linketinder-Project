"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.Empresa = void 0;
const Pessoa_1 = __importDefault(require("./Pessoa"));
class Empresa extends Pessoa_1.default {
    constructor(nome, email, estado, descricao, competencias, cep, _pais, _cnpj) {
        super(nome, email, estado, descricao, competencias, cep);
        this._pais = _pais;
        this._cnpj = _cnpj;
    }
    get pais() {
        return this._pais;
    }
    set pais(value) {
        this._pais = value;
    }
    get cnpj() {
        return this._cnpj;
    }
    set cnpj(value) {
        this._cnpj = value;
    }
}
exports.Empresa = Empresa;
