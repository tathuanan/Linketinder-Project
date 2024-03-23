export class Regex {

    static validarNome(nome: string): boolean {
        const regex = /^[\ba-zA-ZÀ-ÿ]+( [\ba-zA-ZÀ-ÿ]+)+$/g;
        return regex.test(nome)
    }

}