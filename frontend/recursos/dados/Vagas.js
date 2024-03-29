"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Vagas = void 0;
class Vagas {
    constructor(nome, estado, descricao, competencias) {
    }
    get nome() {
        return this.nome;
    }
    set nome(value) {
        this.nome = value;
    }
    get estado() {
        return this.estado;
    }
    set estado(value) {
        this.estado = value;
    }
    get descricao() {
        return this.descricao;
    }
    set descricao(value) {
        this.descricao = value;
    }
    get competencias() {
        return this.competencias;
    }
    set competencias(value) {
        this.competencias = value;
    }
}
exports.Vagas = Vagas;
Vagas.vagas = [
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
