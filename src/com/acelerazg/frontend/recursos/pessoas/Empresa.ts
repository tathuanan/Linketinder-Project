import Pessoa from "./Pessoa";

export class Empresa extends Pessoa {

    constructor(
        nome: string,
        email: string,
        estado: string,
        descricao: string,
        competencias: string[],
        cep: string,
        private _pais: string,
        private _cnpj: string) {
        super(nome, email, estado, descricao, competencias, cep);
    }

    get pais(): string {
        return this._pais;
    }

    set pais(value: string) {
        this._pais = value;
    }

    get cnpj(): string {
        return this._cnpj;
    }

    set cnpj(value: string) {
        this._cnpj = value;
    }
}