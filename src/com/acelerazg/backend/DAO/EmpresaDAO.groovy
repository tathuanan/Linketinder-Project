package com.acelerazg.backend.DAO

import com.acelerazg.backend.model.Empresa

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet

class EmpresaDAO {

    private Connection connection

    EmpresaDAO(){

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

    List<Empresa> listar(){
        String sql = "SELECT * FROM empresas"
        List<Empresa> retorno = new ArrayList<>()
        try {
            PreparedStatement stmt = connection.prepareStatement(sql)
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
                empresa.setCep(resultado.getString("cep_id"))
                empresa.setEstado(resultado.getString("estado_id"))
                retorno.add(empresa)
            }
        } catch (Exception e) {
            e.printStackTrace()
        } finally {
            connection.close()
        }
        return retorno
    }

    boolean inserir(Empresa empresa){
        String sql = "INSERT INTO empresas(nome, cnpj, email, descricao, senha, pais_id, cep_id, estado_id)" +
                "VALUES (?,?,?,?,?,?,?,?)"
        try {
            PreparedStatement stmt = connection.prepareStatement(sql)
            stmt.setString(1, empresa.getNome())
            stmt.setString(2, empresa.getCnpj())
            stmt.setString(3, empresa.getEmail())
            stmt.setString(4, empresa.getDescricao())
            stmt.setString(5, empresa.getSenha())
            stmt.setString(6, empresa.getPais())
            stmt.setString(7, empresa.getCep())
            stmt.setString(8, empresa.getEstado())
            stmt.execute()
            return true
        } catch (Exception e) {
            e.printStackTrace()
            return false
        } finally {
            connection.close()
        }
    }

    boolean alterar(Empresa empresa){
        String sql = "UPDATE empresas SET nome=?, cnpj=?, email=?, descricao=?, senha=?, pais_id=?, cep_id=?, estado_id=?"+
                "WHERE id=?"
        try {
            PreparedStatement stmt = connection.prepareStatement(sql)
            stmt.setString(1, empresa.getNome())
            stmt.setString(2, empresa.getCnpj())
            stmt.setString(3, empresa.getEmail())
            stmt.setString(4, empresa.getDescricao())
            stmt.setString(5, empresa.getSenha())
            stmt.setString(6, empresa.getPais())
            stmt.setString(7, empresa.getCep())
            stmt.setString(8, empresa.getEstado())
            stmt.setInt(9, empresa.getId())
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
        String sql = "DELETE FROM empresas WHERE id=?"
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
