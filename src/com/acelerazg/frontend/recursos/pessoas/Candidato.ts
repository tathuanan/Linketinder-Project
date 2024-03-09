import Pessoa from "./Pessoa";

export class Candidato extends Pessoa {

    constructor(
        nome: string,
        email: string,
        estado: string,
        descricao: string,
        competencias: string[],
        cep: string,
        private _cpf: string,
        private _idade: string) {
        super(nome, email, estado, descricao, competencias, cep);
    }

    get cpf(): string {
        return this._cpf;
    }

    set cpf(value: string) {
        this._cpf = value;
    }

    get idade(): string {
        return this._idade;
    }

    set idade(value: string) {
        this._idade = value;
    }
}