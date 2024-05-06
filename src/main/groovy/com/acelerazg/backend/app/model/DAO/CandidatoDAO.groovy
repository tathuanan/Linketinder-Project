package com.acelerazg.backend.app.model.DAO

import com.acelerazg.backend.app.model.conn.ConnectionDBFactory
import com.acelerazg.backend.app.model.conn.IConnectionDB
import com.acelerazg.backend.app.model.user.Candidato

import java.sql.PreparedStatement
import java.sql.ResultSet

class CandidatoDAO {

    private IConnectionDB connectionDB = ConnectionDBFactory.getConnection("postgres")

    List<Candidato> listar() {

        String sql = "SELECT * FROM candidatos ORDER BY id"
        List<Candidato> listaDeCandidatos = new ArrayList<>()
        try {

            PreparedStatement stmt = this.connectionDB.connection().prepareStatement(sql)
            ResultSet resultado = stmt.executeQuery()

            while (resultado.next()) {

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

                List<String> competenciasCandidato = listarCompetenciasCandidato(candidato)
                candidato.setCompetencias(competenciasCandidato)

                listaDeCandidatos.add(candidato)
            }
        } catch (Exception e) {
            e.printStackTrace()
        } finally {
            this.connectionDB.connection().close()
        }
        return listaDeCandidatos
    }

    List<String> listarCompetenciasCandidato(Candidato candidato) {

        List<String> competenciasCandidato = new ArrayList<>()
        String sqlCompetenciasCandidato = "SELECT competencias.competencia " +
                "FROM competencias_candidatos " +
                "JOIN competencias ON competencias.id = competencias_candidatos.competencia_id " +
                "WHERE competencias_candidatos.candidato_id = ?"

        try {

            PreparedStatement stmtCompetenciasCandidato = this.connectionDB.connection().prepareStatement(sqlCompetenciasCandidato)

            stmtCompetenciasCandidato.setInt(1, candidato.getId())
            ResultSet resultadoCompetencias = stmtCompetenciasCandidato.executeQuery()

            while (resultadoCompetencias.next()) {
                competenciasCandidato.add(resultadoCompetencias.getString("competencia"))
            }

        } catch (Exception e) {
            e.printStackTrace()
        }
        return competenciasCandidato
    }

    boolean inserir(Candidato candidato) {

        String sql = "INSERT INTO candidatos(nome, sobrenome, cpf, dt_nascimento, email, descricao, senha, pais_id, cep, estado_id)" +
                "VALUES (?,?,?,?,?,?,?,?,?,?)"

        try {

            PreparedStatement stmt = this.connectionDB.connection().prepareStatement(sql)
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
            this.connectionDB.connection().close()
        }
    }

    boolean inserirCompetenciaCandidato(int candidato_id, int competencia_id) {

        String sql = "INSERT INTO competencias_candidatos(candidato_id, competencia_id) VALUES (?,?)"

        try {

            PreparedStatement stmt = this.connectionDB.connection().prepareStatement(sql)
            stmt.setInt(1, candidato_id)
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

    boolean alterar(Candidato candidato) {

        String sql = "UPDATE candidatos SET nome=?, sobrenome=?, cpf=?, dt_nascimento=?, email=?, descricao=?, senha=?, pais_id=?, cep=?, estado_id=? " +
                "WHERE id=?"

        try {

            PreparedStatement stmt = this.connectionDB.connection().prepareStatement(sql)
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
            this.connectionDB.connection().close()
        }
    }

    boolean deletar(Integer id) {

        String sql = "DELETE FROM candidatos WHERE id=?"

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

    Integer obterCandidatoId(){

        String sql = "SELECT id FROM candidatos ORDER BY id DESC LIMIT 1"
        try {

            PreparedStatement stmt = this.connectionDB.connection().prepareStatement(sql)
            ResultSet resultado = stmt.executeQuery()
            if (resultado.next()) {
                return resultado.getInt("id")
            }

        } catch (Exception e) {
            e.printStackTrace()
            return null
        } finally {
            this.connectionDB.connection().close()
        }
    }

}
