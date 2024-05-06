package com.acelerazg.backend.app.service.endpoints

import com.acelerazg.backend.app.model.DAO.CandidatoDAO
import com.acelerazg.backend.app.model.user.Candidato
import com.google.gson.Gson
import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "/candidato", urlPatterns = "/candidato")
class CandidatoServlet extends HttpServlet {

    private CandidatoDAO candidatoDAO = new CandidatoDAO()
    private Gson gson = new Gson()
    private boolean retornoDB

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            Candidato candidato = gson.fromJson(request.getReader(), Candidato)
            this.retornoDB = this.candidatoDAO.inserir(candidato)

            List<String> competencias = candidato.getCompetencias()

            if(retornoDB){
                for(int i = 0; i < competencias.size(); i++){
                    this.candidatoDAO.inserirCompetenciaCandidato(this.candidatoDAO.obterCandidatoId(), Integer.parseInt(competencias[i]))
                }
            }

            switch (retornoDB){
                case true:
                    response.setStatus(HttpServletResponse.SC_CREATED)
                    response.getWriter().write(gson.toJson(candidato))
                    break
                case false:
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST)
                    response.getWriter().println("Informacoes do body invalidas")
            }
        } catch (Exception e){
            e.printStackTrace()
        }

    }
}
