# Linketinder

### Introdução

Projeto Linketinder que está sendo desenvolvido no programa de capacitação AceleraZG

O projeto consiste em combinar o sistema de "double opt-in" (Match do Tinder) com o sistema de rede social do LinkedIn.

Assim caso seja estabelecido um "Match" entre a empresa recrutadora e o candidato, eles poderiam iniciar uma intereção.

### No atual estado do programa existe as seguintes funcionalidades:

#### Observação: O Back-End e o Front-End ainda não se interagem.

### Versão Back-End em GROOVY:

    Encerrar aplicação.
    CRUD Candidatos
    CRUD Empresas
    CRUD Vagas
    CRUD Competências

### Como executar o Back-End:

Seu computador deverá ter os ambientes 

    Groovy.
    PostgreSQL

A aplicação inicia com a execução da classe "Main.groovy"

## Observação:

O ambiente PostgreSQL deverá ser configurado antes de rodar a aplicação, bem como deverá ser alterado as informações de
Login e Nome do Banco utilizadas nas classes DAO para que reflita com as configurações do ambiente

### Versão Front-End (HTML, CSS, Bootstrap e TS):

    Página inicial.
    Página de Cadastro (Empresa e Candidato)
    Página de Visão Empresa
    Página de Visão Candidato
    Validação dos formulários de cadastro (Empresa e Candidato) com RegEx

### Como executar o Front-End:

Seu computador deverá ter os ambientes:

* Node.js
* TypeScript
* Webpack
* O gerenciador de pacotes NPM

Pelo terminal navegue até a pasta "frontend" e execute o comando "npm start"

No seu navegador, digite a URL `http://localhost:9000/Inicio.html`

### Arquivos relacionados ao Banco de dados:

Acesse o DER (Diagrama de Entidade-Relacionameto) [aqui](https://github.com/tathuanan/Linketinder-Project/blob/main/src/com/acelerazg/db/der_linketinder.png)

Acesse o arquivo SQL [aqui](https://github.com/tathuanan/Linketinder-Project/blob/main/src/com/acelerazg/db/linketinder.sql)

SGDB escolhido para rodar a aplicação:

* PostgreSQL

Por [Murillo Santos](https://br.linkedin.com/in/murillo-santos-6a179a1b8)