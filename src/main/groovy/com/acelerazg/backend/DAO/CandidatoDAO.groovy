package com.acelerazg.backend.DAO

import com.acelerazg.backend.conn.ConnectionDAO
import com.acelerazg.backend.model.Candidato

import java.sql.PreparedStatement
import java.sql.ResultSet

class CandidatoDAO {

    ConnectionDAO connectionDAO = new ConnectionDAO()

    List<Candidato> listar(){
        String sql = "SELECT * FROM candidatos ORDER BY id"
        List<Candidato> listaDeCandidatos = new ArrayList<>()
        try {

            PreparedStatement stmt = this.connectionDAO.connection().prepareStatement(sql)
            ResultSet resultado = stmt.executeQuery()

            while(resultado.next()){

                Candidato candidato = new Candidato()
                candidato.setId(resultado.getInt("id"))
                candidato.setNome(resultado.getString("nome"))
                candidato.setSobrenome(resultado.getString("sobrenome"))
                candidato.setCpf(resultado.getString("cpf"))
                candidato.setDataNascimento(resultado.getString("dt_nascimento"))
                candidato.setEmail(resultado.getString("email"))
                candidato.setDescricao(resultado.getString("descricao"))
                candidato.setSenha(resultado.getString("senha"))
                candidato.setPais(resultado.getString("pais_id"))
                candidato.setCep(resultado.getString("cep"))
                candidato.setEstado(resultado.getString("estado_id"))

                List<String> competencias = new ArrayList<>()
                String sqlCompetencias = "SELECT comp.competencia " +
                        "FROM competencias_candidatos AS comp_c " +
                        "JOIN competencias AS comp ON comp.id = comp_c.competencia_id " +
                        "WHERE comp_c.candidato_id = ?"

                PreparedStatement stmtCompetencias = this.connectionDAO.connection().prepareStatement(sqlCompetencias)

                stmtCompetencias.setInt(1, candidato.getId())
                ResultSet resultadoCompetencias = stmtCompetencias.executeQuery()

                while (resultadoCompetencias.next()) {
                    competencias.add(resultadoCompetencias.getString("competencia"))
                }

                candidato.setCompetencias(competencias)

                listaDeCandidatos.add(candidato)
            }
        } catch (Exception e) {
            e.printStackTrace()
        } finally {
            this.connectionDAO.connection().close()
        }
        return listaDeCandidatos
    }

    boolean inserir(Candidato candidato){
        String sql = "INSERT INTO candidatos(nome, sobrenome, cpf, dt_nascimento, email, descricao, senha, pais_id, cep, estado_id)" +
                "VALUES (?,?,?,?,?,?,?,?,?,?)"
        try {

            PreparedStatement stmt = this.connectionDAO.connection().prepareStatement(sql)
            stmt.setString(1, candidato.getNome())
            stmt.setString(2, candidato.getSobrenome())
            stmt.setString(3, candidato.getCpf())
            stmt.setDate(4, candidato.getDataNascimento())
            stmt.setString(5, candidato.getEmail())
            stmt.setString(6, candidato.getDescricao())
            stmt.setString(7, candidato.getSenha())
            stmt.setInt(8, Integer.parseInt(candidato.getPais()))
            stmt.setString(9, candidato.getCep())
            stmt.setInt(10, Integer.parseInt(candidato.getEstado()))
            stmt.execute()
            return true
        } catch (Exception e) {
            e.printStackTrace()
            return false
        } finally {
            this.connectionDAO.connection().close()
        }
    }

    boolean inserirCompetenciaCandidato(int candidato_id, int competencia_id) {
        String sql = "INSERT INTO competencias_candidatos(candidato_id, competencia_id) VALUES (?,?)"
        try {
            PreparedStatement stmt = this.connectionDAO.connection().prepareStatement(sql)
            stmt.setInt(1, candidato_id)
            stmt.setInt(2, competencia_id)
            stmt.execute()
            return true
        } catch (Exception e) {
            e.printStackTrace()
            return false
        } finally {
            this.connectionDAO.connection().close()
        }
    }

    boolean alterar(Candidato candidato){
        String sql = "UPDATE candidatos SET nome=?, sobrenome=?, cpf=?, dt_nascimento=?, email=?, descricao=?, senha=?, pais_id=?, cep=?, estado_id=? "+
                "WHERE id=?"
        try {

            PreparedStatement stmt = this.connectionDAO.connection().prepareStatement(sql)
            stmt.setString(1, candidato.getNome())
            stmt.setString(2, candidato.getSobrenome())
            stmt.setString(3, candidato.getCpf())
            stmt.setDate(4, candidato.getDataNascimento())
            stmt.setString(5, candidato.getEmail())
            stmt.setString(6, candidato.getDescricao())
            stmt.setString(7, candidato.getSenha())
            stmt.setInt(8, Integer.parseInt(candidato.getPais()))
            stmt.setString(9, candidato.getCep())
            stmt.setInt(10, Integer.parseInt(candidato.getEstado()))
            stmt.setInt(11, candidato.getId())
            stmt.execute()
            return true
        } catch (Exception e) {
            e.printStackTrace()
            return false
        } finally {
            this.connectionDAO.connection().close()
        }
    }

    boolean remover(Integer id){
        String sqlCompetencias = "DELETE FROM competencias_candidatos WHERE candidato_id=?"
        String sql = "DELETE FROM candidatos WHERE id=?"
        try {
            PreparedStatement stmt = this.connectionDAO.connection().prepareStatement(sqlCompetencias)
            stmt.setInt(1, id)
            stmt.execute()

            stmt = this.connectionDAO.connection().prepareStatement(sql)
            stmt.setInt(1, id)
            stmt.execute()
            return true
        } catch (Exception e) {
            e.printStackTrace()
            return false
        } finally {
            this.connectionDAO.connection().close()
        }
    }
}
