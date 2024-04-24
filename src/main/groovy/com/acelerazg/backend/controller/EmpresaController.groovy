package com.acelerazg.backend.controller


import com.acelerazg.backend.model.Empresa
import com.acelerazg.backend.service.EmpresaService

class EmpresaController {

    EmpresaService empresaService = new EmpresaService()
    private boolean retornoDB

    void listarEmpresas(){

        this.empresaService.listarEmpresas()
    }

    boolean cadastrarEmpresa(Empresa empresa){

        this.retornoDB = this.empresaService.cadastrarEmpresa(empresa)
        return this.retornoDB
    }

    boolean alterarEmpresa(Empresa empresa){

        this.retornoDB = this.empresaService.alterarEmpresa(empresa)
        return this.retornoDB
    }

    boolean deletarEmpresa(Empresa empresa){

        this.retornoDB = this.empresaService.deletarEmpresa(empresa)
        return this.retornoDB
    }

}
