package com.acelerazg.backend.service

import com.acelerazg.backend.DAO.EmpresaDAO
import com.acelerazg.backend.model.Empresa


class EmpresaService {

    static listarEmpresas(){

        EmpresaDAO empresaDAO = new EmpresaDAO()
        empresaDAO.listar().each { empresa ->
            println empresa.toString()
        }

    }

    List<Empresa> empresasCadastradas(){

        List<Empresa> listaEmpresa
        EmpresaDAO empresaDAO = new EmpresaDAO()

        listaEmpresa = empresaDAO.listar()
        return listaEmpresa

    }

    static cadastrarEmpresa(Empresa empresa) {

        boolean retornoDB

        EmpresaDAO empresaDAO = new EmpresaDAO()
        retornoDB = empresaDAO.inserir(empresa)

        if (retornoDB){
            println("\nEmpresa cadastrada com sucesso!!!")
        } else {
            println("\nOcorreu um erro no cadastro")
        }

    }

    static alterarEmpresa(Empresa empresa) {

        boolean retornoDB

        EmpresaDAO empresaDAO = new EmpresaDAO()
        retornoDB = empresaDAO.alterar(empresa)

        if (retornoDB){
            println("\nEmpresa alterada com sucesso!!!")
        } else {
            println("\nOcorreu um erro na alteração")
        }

    }

    static deletarEmpresa(Integer id) {

        boolean retornoDB

        EmpresaDAO empresaDAO = new EmpresaDAO()
        retornoDB = empresaDAO.remover(id)

        if (retornoDB){
            println("\nEmpresa deletada com sucesso!!!")
        } else {
            println("\nOcorreu um erro ao tentar deletar")
        }

    }
    
}
