package com.acelerazg.dados

class ControladorCandidatos{

    static listarCandidatos(){

        ListaPessoa.candidatos.each { candidato ->
            println candidato.toString()
        }

    }
}

