package com.acelerazg.backend.DAO

import com.acelerazg.backend.conn.ConnectionDAO
import com.acelerazg.backend.model.Empresa

import java.sql.PreparedStatement
import java.sql.ResultSet

class EmpresaDAO {

    ConnectionDAO connectionDAO = new ConnectionDAO()

    List<Empresa> listar(){
        String sql = "SELECT * FROM empresas ORDER BY id"
        List<Empresa> retorno = new ArrayList<>()
        try {
            PreparedStatement stmt = this.connectionDAO.connection().prepareStatement(sql)
            ResultSet resultado = stmt.executeQuery()
            while(resultado.next()){
                Empresa empresa = new Empresa()
                empresa.setId(resultado.getInt("id"))
                empresa.setNome(resultado.getString("nome"))
                empresa.setCnpj(resultado.getString("cnpj"))
                empresa.setEmail(resultado.getString("email"))
                empresa.setDescricao(resultado.getString("descricao"))
                empresa.setSenha(resultado.getString("senha"))
                empresa.setPais(resultado.getString("pais_id"))
                empresa.setCep(resultado.getString("cep"))
                empresa.setEstado(resultado.getString("estado_id"))
                retorno.add(empresa)
            }
        } catch (Exception e) {
            e.printStackTrace()
        } finally {
            this.connectionDAO.connection().close()
        }
        return retorno
    }

    boolean inserir(Empresa empresa){
        String sql = "INSERT INTO empresas(nome, cnpj, email, descricao, senha, pais_id, cep, estado_id)" +
                "VALUES (?,?,?,?,?,?,?,?)"
        try {
            PreparedStatement stmt = this.connectionDAO.connection().prepareStatement(sql)
            stmt.setString(1, empresa.getNome())
            stmt.setString(2, empresa.getCnpj())
            stmt.setString(3, empresa.getEmail())
            stmt.setString(4, empresa.getDescricao())
            stmt.setString(5, empresa.getSenha())
            stmt.setInt(6, Integer.parseInt(empresa.getPais()))
            stmt.setString(7, empresa.getCep())
            stmt.setInt(8, Integer.parseInt(empresa.getEstado()))
            stmt.execute()
            return true
        } catch (Exception e) {
            e.printStackTrace()
            return false
        } finally {
            this.connectionDAO.connection().close()
        }
    }

    boolean alterar(Empresa empresa){
        String sql = "UPDATE empresas SET nome=?, cnpj=?, email=?, descricao=?, senha=?, pais_id=?, cep=?, estado_id=? "+
                "WHERE id=?"
        try {
            PreparedStatement stmt = this.connectionDAO.connection().prepareStatement(sql)
            stmt.setString(1, empresa.getNome())
            stmt.setString(2, empresa.getCnpj())
            stmt.setString(3, empresa.getEmail())
            stmt.setString(4, empresa.getDescricao())
            stmt.setString(5, empresa.getSenha())
            stmt.setInt(6, Integer.parseInt(empresa.getPais()))
            stmt.setString(7, empresa.getCep())
            stmt.setInt(8, Integer.parseInt(empresa.getEstado()))
            stmt.setInt(9, empresa.getId())
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
        String sql = "DELETE FROM empresas WHERE id=?"
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
