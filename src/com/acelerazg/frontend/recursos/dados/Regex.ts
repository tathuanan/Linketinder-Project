export class Regex {

    static validarNome(nome: string): boolean {
        const regex = /^[\ba-zA-ZÀ-ÿ]+( [\ba-zA-ZÀ-ÿ]+)+$/g;
        return regex.test(nome)
    }

    static validarCPF(cpf: string): boolean {
        const regex = /^\d{3}\.?\d{3}\.?\d{3}-?\d{2}$/
        return regex.test(cpf)
    }

}