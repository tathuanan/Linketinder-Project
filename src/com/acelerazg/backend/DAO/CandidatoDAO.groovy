package com.acelerazg.backend.DAO

import com.acelerazg.backend.model.Candidato

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet

class CandidatoDAO {

    private Connection connection

    CandidatoDAO(){

        try {
            Properties props = new Properties()
            props.setProperty("user", "acelerazg")
            props.setProperty("password", "acelerazg@")
            props.setProperty("ssl", "false")
            String URL_SERVIDOR = "jdbc:postgresql://localhost:5432/linketinder"

            this.connection = DriverManager.getConnection(URL_SERVIDOR, props)

        } catch (Exception e) {
            e.printStackTrace()
            if(e instanceof ClassNotFoundException){
                System.err.println("Verifique o driver de conexão.")
            } else {
                System.err.println("Verifique se o servidor está ativo.")
            }
        }
    }

    List<Candidato> listar(){
        String sql = "SELECT * FROM candidatos"
        List<Candidato> retorno = new ArrayList<>()
        try {
            PreparedStatement stmt = connection.prepareStatement(sql)
            ResultSet resultado = stmt.executeQuery()
            while(resultado.next()){
                Candidato candidato = new Candidato()
                candidato.setId(resultado.getInt("id"))
                candidato.setNome(resultado.getString("nome"))
                candidato.setSobrenome(resultado.getString("sobrenome"))
                candidato.setCpf(resultado.getString("cpf"))
                candidato.setDt_nascimento(resultado.getString("dt_nascimento"))
                candidato.setEmail(resultado.getString("email"))
                candidato.setDescricao(resultado.getString("descricao"))
                candidato.setSenha(resultado.getString("senha"))
                candidato.setPais(resultado.getString("pais_id"))
                candidato.setCep(resultado.getString("cep_id"))
                candidato.setEstado(resultado.getString("estado_id"))
                retorno.add(candidato)
            }
        } catch (Exception e) {
            e.printStackTrace()
        } finally {
            connection.close()
        }
        return retorno
    }

    boolean inserir(Candidato candidato){
        String sql = "INSERT INTO candidatos(nome, sobrenome, cpf, dt_nascimento, email, descricao, senha, pais_id, cep_id, estado_id)" +
                "VALUES (?,?,?,?,?,?,?,?,?,?)"
        try {
            PreparedStatement stmt = connection.prepareStatement(sql)
            stmt.setString(1, candidato.getNome())
            stmt.setString(2, candidato.getSobrenome())
            stmt.setString(3, candidato.getCpf())
            stmt.setString(4, candidato.getDt_nascimento())
            stmt.setString(5, candidato.getEmail())
            stmt.setString(6, candidato.getDescricao())
            stmt.setString(7, candidato.getSenha())
            stmt.setString(8, candidato.getPais())
            stmt.setString(9, candidato.getCep())
            stmt.setString(10, candidato.getEstado())
            stmt.execute()
            return true
        } catch (Exception e) {
            e.printStackTrace()
            return false
        } finally {
            connection.close()
        }
    }

    boolean alterar(Candidato candidato){
        String sql = "UPDATE candidatos SET nome=?, sobrenome=?, cpf=?, dt_nascimento=?, email=?, descricao=?, senha=?, pais_id=?, cep_id=?, estado_id=?"+
                "WHERE id=?"
        try {
            PreparedStatement stmt = connection.prepareStatement(sql)
            stmt.setString(1, candidato.getNome())
            stmt.setString(2, candidato.getSobrenome())
            stmt.setString(3, candidato.getCpf())
            stmt.setString(4, candidato.getDt_nascimento())
            stmt.setString(5, candidato.getEmail())
            stmt.setString(6, candidato.getDescricao())
            stmt.setString(7, candidato.getSenha())
            stmt.setString(8, candidato.getPais())
            stmt.setString(9, candidato.getCep())
            stmt.setString(10, candidato.getEstado())
            stmt.setInt(11, candidato.getId())
            stmt.execute()
            return true
        } catch (Exception e) {
            e.printStackTrace()
            return false
        } finally {
            connection.close()
        }
    }

    boolean remover(Integer id){
        String sql = "DELETE FROM candidatos WHERE id=?"
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