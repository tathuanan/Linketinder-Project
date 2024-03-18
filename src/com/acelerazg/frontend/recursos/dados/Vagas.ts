export class Vagas {

    constructor(
        nome: string,
        estado: string,
        descricao: string,
        competencias: string[]){
    }

    get nome(): string {
        return this.nome;
    }

    set nome(value: string) {
        this.nome = value;
    }

    get estado(): string {
        return this.estado;
    }

    set estado(value: string) {
        this.estado = value;
    }

    get descricao(): string {
        return this.descricao;
    }

    set descricao(value: string) {
        this.descricao = value;
    }

    get competencias(): string[] {
        return this.competencias;
    }

    set competencias(value: string[]) {
        this.competencias = value;
    }

    public static vagas: Vagas[] = [
        {
            nome: "Desenvolvedor Web",
            estado: "DF",
            descricao: "Desenvolvimento web com utilização de Web Crawler",
            competencias: ["TypeScript", "Angular", "Web Crawler", "Scrumban"],
        },
        {
            nome: "Desenvolvedor Groovy",
            estado: "GO",
            descricao: "Desenvolvedor Full-Stack Groovy",
            competencias: ["Angular", "Groovy", "Java", "Scrumban"],
        },
        {
            nome: "Desenvolvedor Back-End",
            estado: "PR",
            descricao: "Responsável pelo desenvolvimento Back-End",
            competencias: ["Python", "Java", "Groovy", "Scrumban"],
        },
        {
            nome: "Desenvolvedor Front-End",
            estado: "MG",
            descricao: "Responsável pelo desenvolvimento Front-End",
            competencias: ["Angular", "JavaScript", "TypeScript", "Scrumban"],
        },
        {
            nome: "Desenvolvedor Full-Stack",
            estado: "SC",
            descricao: "Responsável pelo desenvolvimento Front-End e Back-End",
            competencias: ["Angular", "Java", "Groovy", "Scrumban"],
        },
    ];

}
