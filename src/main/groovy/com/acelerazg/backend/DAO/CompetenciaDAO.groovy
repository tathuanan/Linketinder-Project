package com.acelerazg.backend.DAO

import com.acelerazg.backend.conn.ConnectionDAO
import com.acelerazg.backend.model.Competencia

import java.sql.PreparedStatement
import java.sql.ResultSet

class CompetenciaDAO {

    ConnectionDAO connectionDAO = new ConnectionDAO()

    List<Competencia> listar() {
        String sql = "SELECT * FROM competencias ORDER BY id"
        List<Competencia> retorno = new ArrayList<>()
        try {
            PreparedStatement stmt = this.connectionDAO.connection().prepareStatement(sql)
            ResultSet resultado = stmt.executeQuery()
            while (resultado.next()) {
                Competencia competencia = new Competencia()
                competencia.setId(resultado.getInt("id"))
                competencia.setCompetencia(resultado.getString("competencia"))
                retorno.add(competencia)
            }
        } catch (Exception e) {
            e.printStackTrace()
        } finally {
            this.connectionDAO.connection().close()
        }
        return retorno
    }

    boolean inserir(Competencia competencia) {
        String sql = "INSERT INTO competencias(competencia) VALUES (?)"
        try {
            PreparedStatement stmt = this.connectionDAO.connection().prepareStatement(sql)
            stmt.setString(1, competencia.getCompetencia())
            stmt.execute()
            return true
        } catch (Exception e) {
            e.printStackTrace()
            return false
        } finally {
            this.connectionDAO.connection().close()
        }
    }

    boolean alterar(Competencia competencia) {
        String sql = "UPDATE competencias SET competencia=? WHERE id=?"
        try {
            PreparedStatement stmt = this.connectionDAO.connection().prepareStatement(sql)
            stmt.setString(1, competencia.getCompetencia())
            stmt.setInt(2, competencia.getId())
            stmt.execute()
            return true
        } catch (Exception e) {
            e.printStackTrace()
            return false
        } finally {
            this.connectionDAO.connection().close()
        }
    }

    boolean remover(Integer id) {
        String sql = "DELETE FROM competencias WHERE id=?"
        try {
            PreparedStatement stmt = this.connectionDAO.connection().prepareStatement(sql)
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
