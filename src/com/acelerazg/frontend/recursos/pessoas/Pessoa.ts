export default class Pessoa {
    constructor(
        protected _nome: string,
        protected _email: string,
        protected _estado: string,
        protected _descricao: string,
        protected _competencias: string[],
        protected _cep: string) {
    }

    get nome(): string {
        return this._nome;
    }

    set nome(value: string) {
        this._nome = value;
    }

    get email(): string {
        return this._email;
    }

    set email(value: string) {
        this._email = value;
    }

    get estado(): string {
        return this._estado;
    }

    set estado(value: string) {
        this._estado = value;
    }

    get descricao(): string {
        return this._descricao;
    }

    set descricao(value: string) {
        this._descricao = value;
    }

    get competencias(): string[] {
        return this._competencias;
    }

    set competencias(value: string[]) {
        this._competencias = value;
    }

    get cep(): string {
        return this._cep;
    }

    set cep(value: string) {
        this._cep = value;
    }
}