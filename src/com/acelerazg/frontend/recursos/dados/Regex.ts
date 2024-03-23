export class Regex {

    static validarNome(nome: string): boolean {
        const regex = /^[\ba-zA-ZÀ-ÿ]+( [\ba-zA-ZÀ-ÿ]+)+$/g;
        return regex.test(nome)
    }

    static validarCPF(cpf: string): boolean {
        const regex = /^\d{3}\.?\d{3}\.?\d{3}-?\d{2}$/
        return regex.test(cpf)
    }

    static validarIdade(idade: string): boolean {
        const regex = /^\d+$/
        return regex.test(idade)
    }

    static validarEmail(email: string): boolean {
        const regex = /^[a-zA-Z0-9._-]+@[a-zA-Z]+[^@?%&#$]\.[a-zA-Z]+(\.[a-zA-Z]+)?$/
        return regex.test(email)
    }

    static validarEstado(estado: string): boolean {
        const regex = /^[A-Z]{2}$/
        return regex.test(estado)
    }

    static validarCEP(cep: string): boolean {
        const regex = /^\d{5}-?\d{3}$/
        return regex.test(cep)
    }

    static validarCNPJ(cnpj: string): boolean {
        const regex = /^\d{2}\.?\d{3}\.?\d{3}\/\d{4}-?\d{2}$/
        return regex.test(cnpj)
    }

    static validarPais(pais: string): boolean {
        const regex = /^[\ba-zA-Z]+( [\ba-zA-Z]+)*$/
        return regex.test(pais)
    }

}