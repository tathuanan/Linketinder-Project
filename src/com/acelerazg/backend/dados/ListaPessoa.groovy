package com.acelerazg.backend.dados

import com.acelerazg.backend.model.Candidato
import com.acelerazg.backend.model.Empresa

class ListaPessoa {

    public static List<Candidato> candidatos = [

            new Candidato(
                    nome:"Jose das Couves",
                    email:"jose.couves@acelerazg.com.br",
                    estado:"DF",
                    descricao:"Descolado, responsavel e gosto de estudar",
                    competencias:["Java", "Groovy", "Python", "Scrumban"],
                    cep: "72000000",
                    cpf: "11122233344",
                    idade: 20,),

            new Candidato(
                    nome:"Maria das Orquideas",
                    email:"maria.orquideas@acelerazg.com.br",
                    estado:"GO",
                    descricao:"Bem correta e organizada",
                    competencias:["Golang", "Cobol", "JavaScript", "Kanban"],
                    cep: "72000000",
                    cpf: "22233344455",
                    idade: 23,),

            new Candidato(
                    nome:"Francisco das Abobrinhas",
                    email:"francisco.abobrinhas@acelerazg.com.br",
                    estado:"MG",
                    descricao:"Bastante comunicativo, cativante",
                    competencias:["Ruby", "TypeScript", "Angular", "Scrum"],
                    cep: "72000000",
                    cpf: "33344455566",
                    idade: 18,),

            new Candidato(
                    nome:"Marcia das Flores",
                    email:"marcia.flores@acelerazg.com.br",
                    estado:"MA",
                    descricao:"Apaixonada por desafios, focada em superar barreiras",
                    competencias:["C#", "C++", "React", "Crystal"],
                    cep: "72000000",
                    cpf: "44455566677",
                    idade: 29,),

            new Candidato(
                    nome:"Joao do Feijao",
                    email:"joao.feijao@acelerazg.com.br",
                    estado:"MT",
                    descricao:"Antenado em lançamentos tecnologicos, super entusiasmado",
                    competencias:["R", "Python", "C", "Metodologias Ageis"],
                    cep: "72000000",
                    cpf: "55566677788",
                    idade: 35,),


    ]

    public static List<Empresa> empresas = [

            new Empresa(
                    nome:"AMENDOIM LTDA",
                    email:"contato@amendoim.com.br",
                    estado:"DF",
                    descricao:"Empresa de grande porte, focada em desenvolver solucoes inovadoras",
                    competencias:["Java", "Groovy", "Python", "Metodos Ageis"],
                    cep: "72000000",
                    pais: "Brasil",
                    cnpj: "11222333000144",),

            new Empresa(
                    nome:"CASTANHA LTDA",
                    email:"contado@castanha.com.br",
                    estado:"PA",
                    descricao:"Empresa solida, com forte atuacao em desenvolver programas",
                    competencias:["Golang", "Cobol", "JavaScript", "Kanban"],
                    cep: "72000000",
                    pais: "Brasil",
                    cnpj: "22333444000155",),

            new Empresa(
                    nome:"PAO DE QUEIJO LTDA",
                    email:"contado@pdq.com.br",
                    estado:"MG",
                    descricao:"Empresa homogenia no setor de tecnologia, mistura solucoes de infraestrutura e desenvolvimento",
                    competencias:["Ruby", "TypeScript", "Angular", "Scrum"],
                    cep: "72000000",
                    pais: "Brasil",
                    cnpj: "33444555000166",),

            new Empresa(
                    nome:"BRIGADEIRO LTDA",
                    email:"contato@brigadeiro.com.br",
                    estado:"SP",
                    descricao:"Empresa de pequeno porte, mas trazendo grandes solucoes para seus clientes",
                    competencias:["C#", "C++", "React", "Crystal"],
                    cep: "72000000",
                    pais: "Brasil",
                    cnpj: "44555666000177",),

            new Empresa(
                    nome:"MATE LTDA",
                    email:"contato@mate.com.br",
                    estado:"RS",
                    descricao:"Empresa em expansao, buscando fluidez no mercado",
                    competencias:["R", "Python", "C", "Metodologias Ageis"],
                    cep: "72000000",
                    pais: "Brasil",
                    cnpj: "55666777000188",),

    ]

}

