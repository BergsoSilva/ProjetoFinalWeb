/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import mvc.bean.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDao {
    
    private final Connection connection;
    
    @Autowired 
    public UsuarioDao(DataSource dataSource) {
        try {
            this.connection =dataSource.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }
    
    public boolean validaUsuario(Usuario user){
       String sql = "select usuid, usulogin,ususenha from usuario where usulogin = ? and ususenha = ? ";
       try ( 
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1,user.getUsulogin());
            stmt.setString(2,user.getUsusenha());
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                 return true;        
            }else{
                return false;
            }
       } catch (SQLException e) {
         throw new RuntimeException(e);
       }
    }

    public Usuario pegarUsuario(String login){
       String sql = "select *from usuario where usulogin= ? ";
       
       try ( 
        PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setString(1,login);
        
          ResultSet rs = stmt.executeQuery();
          Usuario usu= new Usuario();
          while(rs.next()){
          
                usu.setUsuid(rs.getLong("usuid"));
                usu.setUsulogin(rs.getString("usulogin"));
                usu.setUsusenha(rs.getString("ususenha"));
                usu.setUsupermissao(rs.getInt("usupermissao"));
                usu.setUsucliid(rs.getInt("usucliid"));
          }
           return usu;
         
       } catch (SQLException e) {
         throw new RuntimeException("errrr"+e);
       }
    }
 
}
