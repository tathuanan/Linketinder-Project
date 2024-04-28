package com.acelerazg.backend.service

import com.acelerazg.backend.DAO.EmpresaDAO
import com.acelerazg.backend.model.Empresa


class EmpresaService {

    private EmpresaDAO empresaDAO = new EmpresaDAO()
    boolean retornoDB

    void listarEmpresas(){

        this.empresaDAO.listar().each { empresa ->
            println empresa.toString()
        }
    }

    boolean cadastrarEmpresa(Empresa empresa) {

        this.retornoDB = this.empresaDAO.inserir(empresa)
        return this.retornoDB
    }

    boolean alterarEmpresa(Empresa empresa) {

        this.retornoDB = this.empresaDAO.alterar(empresa)
        return this.retornoDB
    }

    boolean deletarEmpresa(Integer id) {

        this.retornoDB = this.empresaDAO.deletar(id)
        return this.retornoDB
    }
    
}
