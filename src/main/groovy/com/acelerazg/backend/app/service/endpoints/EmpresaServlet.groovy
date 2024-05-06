package com.acelerazg.backend.app.service.endpoints

import com.acelerazg.backend.app.model.DAO.EmpresaDAO
import com.acelerazg.backend.app.model.user.Empresa
import com.google.gson.Gson
import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "/empresa", urlPatterns = "/empresa")
class EmpresaServlet extends HttpServlet {

    private EmpresaDAO empresaDAO = new EmpresaDAO()
    private Gson gson = new Gson()
    private boolean retornoDB

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            Empresa empresa = gson.fromJson(request.getReader(), Empresa)
            this.retornoDB = this.empresaDAO.inserir(empresa)

            switch (retornoDB){
                case true:
                    response.setStatus(HttpServletResponse.SC_CREATED)
                    response.getWriter().write(gson.toJson(empresa))
                    break
                case false:
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST)
                    response.getWriter().println("Informacoes do body invalidas")
            }
        } catch (Exception e) {
            e.printStackTrace()
        }
    }
}