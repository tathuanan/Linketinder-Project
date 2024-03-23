export class Regex {

    static validarNome(nome: string): boolean {
        const regex = /^[\ba-zA-ZÀ-ÿ]+( [\ba-zA-ZÀ-ÿ]+)+$/g;
        if (!regex.test(nome)){
            alert("Nome fora do padrão,\nDigite ao menos um nome e um sobrenome")
            }
        return regex.test(nome)
    }

    static validarCPF(cpf: string): boolean {
        const regex = /^\d{3}\.?\d{3}\.?\d{3}-?\d{2}$/
        if (!regex.test(cpf)){
            alert("CPF fora do padrão,\nDigite um cpf no padrão 000.000.000-00")
        }
        return regex.test(cpf)
    }

    static validarIdade(idade: string): boolean {
        const regex = /^\d+$/
        if (!regex.test(idade)){
            alert("Idade fora do padrão,\nDigite uma idade numérica válida\nExemplo: 20")
        }
        return regex.test(idade)
    }

    static validarEmail(email: string): boolean {
        const regex = /^[a-zA-Z0-9._-]+@[a-zA-Z]+[^@?%&#$]\.[a-zA-Z]+(\.[a-zA-Z]+)?$/
        if (!regex.test(email)){
            alert("Email fora do padrão,\nPadrões aceitados:\nexemplo@exemplo.com\nexemplo@exemplo.gov\nexemplo@exemplo.com.br")
        }
        return regex.test(email)
    }

    static validarEstado(estado: string): boolean {
        const regex = /^[A-Z]{2}$/
        if (!regex.test(estado)){
            alert("Estado fora do padrão,\nDigite uma UF válida contendo 2 caracteres")
        }
        return regex.test(estado)
    }

    static validarCEP(cep: string): boolean {
        const regex = /^\d{5}-?\d{3}$/
        if (!regex.test(cep)){
            alert("CEP fora do padrão,\nDigite um CEP no padrão:\n00000-000")
        }
        return regex.test(cep)
    }

    static validarCNPJ(cnpj: string): boolean {
        const regex = /^\d{2}\.?\d{3}\.?\d{3}\/\d{4}-?\d{2}$/
        if (!regex.test(cnpj)){
            alert("CNPJ fora do padrão,\nDigite um cnpj no padrão 00.000.000/0000-00")
        }
        return regex.test(cnpj)
    }

    static validarPais(pais: string): boolean {
        const regex = /^[\ba-zA-Z]+( [\ba-zA-Z]+)*$/
        if (!regex.test(pais)){
            alert("País fora do padrão,\nPadrões de nome de país aceitos:\nBrasil\nEstados Unidos\nMacedônia do Norte")
        }
        return regex.test(pais)
    }

    static validarDescricao(descricao: string): boolean {
        const regex = /^[a-zA-ZÀ-ÿ0-9,.; ]{30,}$/
        if (!regex.test(descricao)){
            alert("Descrição fora do padrão,\nDigite ao menos uma descrição com 30 caracteres")
        }
        return regex.test(descricao)
    }

}