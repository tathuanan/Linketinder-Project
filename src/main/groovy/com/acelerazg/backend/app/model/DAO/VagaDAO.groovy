package com.acelerazg.backend.app.model.DAO

import com.acelerazg.backend.app.model.business.Vaga

import java.sql.PreparedStatement
import java.sql.ResultSet

class VagaDAO {

    private com.acelerazg.backend.app.model.conn.IConnectionDB connectionDB = com.acelerazg.backend.app.model.conn.ConnectionDBFactory.getConnection("postgres")

    List<Vaga> listar() {
        String sql = "SELECT * FROM vagas ORDER BY id"
        List<Vaga> retorno = new ArrayList<>()
        try {
            PreparedStatement stmt = this.connectionDB.connection().prepareStatement(sql)
            ResultSet resultado = stmt.executeQuery()

            while (resultado.next()) {

                Vaga vaga = new Vaga()
                vaga.setId(resultado.getInt("id"))
                vaga.setNome(resultado.getString("nome"))
                vaga.setDescricao(resultado.getString("descricao"))
                vaga.setCidade(resultado.getString("cidade"))
                vaga.setEmpresa(resultado.getString("empresa_id"))

                List<String> competencias = new ArrayList<>()
                String sqlCompetencias = "SELECT comp.competencia " +
                        "FROM competencias_vaga AS comp_v " +
                        "JOIN competencias AS comp ON comp.id = comp_v.competencia_id " +
                        "WHERE comp_v.vaga_id = ?;"
                PreparedStatement stmtCompetencias = this.connectionDB.connection().prepareStatement(sqlCompetencias)
                stmtCompetencias.setInt(1, vaga.getId())
                ResultSet resultadoCompetencias = stmtCompetencias.executeQuery()

                while (resultadoCompetencias.next()) {
                    competencias.add(resultadoCompetencias.getString("competencia"))
                }

                vaga.setCompetencias(competencias)

                retorno.add(vaga)
            }
        } catch (Exception e) {
            e.printStackTrace()
        } finally {
            this.connectionDB.connection().close()
        }
        return retorno
    }

    boolean inserir(Vaga vaga) {
        String sql = "INSERT INTO vagas(nome, descricao, cidade, empresa_id) VALUES (?,?,?,?)"
        try {
            PreparedStatement stmt = this.connectionDB.connection().prepareStatement(sql)
            stmt.setString(1, vaga.getNome())
            stmt.setString(2, vaga.getDescricao())
            stmt.setString(3, (vaga.getCidade()))
            stmt.setInt(4, Integer.parseInt(vaga.getEmpresa()))
            stmt.execute()
            return true
        } catch (Exception e) {
            e.printStackTrace()
            return false
        } finally {
            this.connectionDB.connection().close()
        }
    }

    boolean inserirCompetenciaVaga(int vaga_id, int competencia_id) {
        String sql = "INSERT INTO competencias_vaga(vaga_id, competencia_id) VALUES (?,?)"
        try {
            PreparedStatement stmt = this.connectionDB.connection().prepareStatement(sql)
            stmt.setInt(1, vaga_id)
            stmt.setInt(2, competencia_id)
            stmt.execute()
            return true
        } catch (Exception e) {
            e.printStackTrace()
            return false
        } finally {
            this.connectionDB.connection().close()
        }
    }

    boolean alterar(Vaga vaga) {
        String sql = "UPDATE vagas SET nome=?, descricao=?, cidade=?, empresa_id=? WHERE id=?"
        try {
            PreparedStatement stmt = this.connectionDB.connection().prepareStatement(sql)
            stmt.setString(1, vaga.getNome())
            stmt.setString(2, vaga.getDescricao())
            stmt.setString(3, vaga.getCidade())
            stmt.setInt(4, Integer.parseInt(vaga.getEmpresa()))
            stmt.setInt(5, vaga.getId())
            stmt.execute()
            return true
        } catch (Exception e) {
            e.printStackTrace()
            return false
        } finally {
            this.connectionDB.connection().close()
        }
    }

    boolean deletar(Integer id) {

        String sql = "DELETE FROM vagas WHERE id=?"

        try {

            PreparedStatement stmt = this.connectionDB.connection().prepareStatement(sql)
            stmt.setInt(1, id)
            stmt.execute()

            return true

        } catch (Exception e) {
            e.printStackTrace()
            return false
        } finally {
            this.connectionDB.connection().close()
        }
    }

}
