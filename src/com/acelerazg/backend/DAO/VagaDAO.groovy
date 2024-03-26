package com.acelerazg.backend.DAO

import com.acelerazg.backend.model.Vaga

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet

class VagaDAO {

    private Connection connection

    VagaDAO() {

        try {
            Properties props = new Properties()
            props.setProperty("user", "acelerazg")
            props.setProperty("password", "acelerazg@")
            props.setProperty("ssl", "false")
            String URL_SERVIDOR = "jdbc:postgresql://localhost:5432/linketinder"

            this.connection = DriverManager.getConnection(URL_SERVIDOR, props)

        } catch (Exception e) {
            e.printStackTrace()
            if (e instanceof ClassNotFoundException) {
                System.err.println("Verifique o driver de conexão.")
            } else {
                System.err.println("Verifique se o servidor está ativo.")
            }
        }
    }

    List<Vaga> listar() {
        String sql = "SELECT * FROM vagas ORDER BY id"
        List<Vaga> retorno = new ArrayList<>()
        try {
            PreparedStatement stmt = connection.prepareStatement(sql)
            ResultSet resultado = stmt.executeQuery()

            while (resultado.next()) {

                Vaga vaga = new Vaga()
                vaga.setId(resultado.getInt("id"))
                vaga.setNome(resultado.getString("nome"))
                vaga.setDescricao(resultado.getString("descricao"))
                vaga.setCidade(resultado.getString("cidade_id"))
                vaga.setEmpresa(resultado.getString("empresa_id"))

                List<String> competencias = new ArrayList<>();
                String sqlCompetencias = "SELECT comp.competencia " +
                        "FROM competencias_vaga AS comp_v " +
                        "JOIN competencias AS comp ON comp.id = comp_v.competencia_id " +
                        "WHERE comp_c.vaga_id = ?";
                PreparedStatement stmtCompetencias = connection.prepareStatement(sqlCompetencias);
                stmtCompetencias.setInt(1, vaga.getId());
                ResultSet resultadoCompetencias = stmtCompetencias.executeQuery();

                while (resultadoCompetencias.next()) {
                    competencias.add(resultadoCompetencias.getString("competencia"));
                }

                vaga.setCompetencias(competencias);

                retorno.add(vaga)
            }
        } catch (Exception e) {
            e.printStackTrace()
        } finally {
            connection.close()
        }
        return retorno
    }

    boolean inserir(Vaga vaga) {
        String sql = "INSERT INTO vagas(nome, descricao, cidade_id, empresa_id) VALUES (?,?,?,?)"
        try {
            PreparedStatement stmt = connection.prepareStatement(sql)
            stmt.setString(1, vaga.getNome())
            stmt.setString(2, vaga.getDescricao())
            stmt.setInt(3, Integer.parseInt(vaga.getCidade()))
            stmt.setInt(4, Integer.parseInt(vaga.getEmpresa()))
            stmt.execute()
            return true
        } catch (Exception e) {
            e.printStackTrace()
            return false
        } finally {
            connection.close()
        }
    }

    boolean inserirCompetenciaVaga(int vaga_id, int competencia_id) {
        String sql = "INSERT INTO competencias_vaga(vaga_id, competencia_id) VALUES (?,?)"
        try {
            PreparedStatement stmt = connection.prepareStatement(sql)
            stmt.setInt(1, vaga_id)
            stmt.setInt(2, competencia_id)
            stmt.execute()
            return true
        } catch (Exception e) {
            e.printStackTrace()
            return false
        } finally {
            connection.close()
        }
    }

    boolean alterar(Vaga vaga) {
        String sql = "UPDATE vagas SET nome=?, descricao=?, cidade_id=?, empresa_id=? WHERE id=?"
        try {
            PreparedStatement stmt = connection.prepareStatement(sql)
            stmt.setString(1, vaga.getNome())
            stmt.setString(2, vaga.getDescricao())
            stmt.setInt(3, Integer.parseInt(vaga.getCidade()))
            stmt.setInt(4, Integer.parseInt(vaga.getEmpresa()))
            stmt.setInt(5, vaga.getId())
            stmt.execute()
            return true
        } catch (Exception e) {
            e.printStackTrace()
            return false
        } finally {
            connection.close()
        }
    }

    boolean remover(Integer id) {
        String sql = "DELETE FROM vagas WHERE id=?"
        try {
            PreparedStatement stmt = connection.prepareStatement(sql)
            stmt.setInt(1, id)
            stmt.execute()
            return true
        } catch (Exception e) {
            e.printStackTrace()
            return false
        } finally {
            connection.close()
        }
    }

}
