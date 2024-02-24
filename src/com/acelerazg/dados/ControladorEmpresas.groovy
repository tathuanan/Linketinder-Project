package com.acelerazg.dados

class ControladorEmpresas{

    static listarEmpresas() {

        ListaPessoa.empresas.each {empresa ->
            println empresa.toString()
        }

    }

}