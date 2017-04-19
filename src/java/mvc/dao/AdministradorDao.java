
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.sql.DataSource;
import mvc.bean.Administrador;
import mvc.bean.Categoria;
import mvc.bean.Cliente;
import mvc.bean.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



/**
 *
 * @author GRS
 */

@Repository
public class AdministradorDao {


    private final Connection connection;
    
     @Autowired
    public AdministradorDao(DataSource dataSource) {
        try {
            this.connection =dataSource.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }
    
    public void adciocnar(Administrador administrador){

        String sql = "insert into administrador (adm_nome) values (?)";
        
     try (   PreparedStatement stm =connection.prepareStatement(sql)){
              
         stm.setString(1,administrador.getNome());
         
         stm.execute();
       
     } catch (SQLException e) {
         throw new RuntimeException(e.getCause());
         
     }
        
        
    }

    public List<Administrador> listarTodos(){
       List<Administrador> lista = new ArrayList<>();
       String sql = "select * "
                  + " from administrador";
               
       try ( 
        PreparedStatement stmt = connection.prepareStatement(sql)) {
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
           Administrador adm  = new Administrador();
           adm.setId(rs.getLong("adm_id"));
           adm.setNome(rs.getString("adm_nome"));
           //montando data
           /*Calendar data = Calendar.getInstance();
           if(rs.getDate("dataFinalizacao") != null)
           {
               data.setTime(rs.getDate("dataFinalizacao"));
               cliente.setDataFinalizacao(data);
           } 
                   */
           
           lista.add(adm);
         }
        return lista;
       } catch (SQLException e) {
         throw new RuntimeException(e);
       }
      
    }
    
    public Administrador buscarPorId(Long id){
       String sql = "select * "
               + " from administrador where adm_id=?";
              
       try ( 
        PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setLong(1,id);
        ResultSet rs = stmt.executeQuery();
        Administrador adm = new Administrador();
        if(rs.next()) {
           adm.setId(rs.getLong("adm_id"));
           adm.setNome(rs.getString("adm_nome"));
                   /*montando data
           Calendar data = Calendar.getInstance();
           if(rs.getDate("dataFinalizacao") != null)
           {
               data.setTime(rs.getDate("dataFinalizacao"));
               System.out.println("data");
               cliente.setDataFinalizacao(data);
           }*/
                   
        }
        return adm;
       } catch (SQLException e) {
         throw new RuntimeException(e);
       }
    }
    
    public boolean remover(Long id){
       String sql = "delete from administrador where adm_id = ? ";
       try ( 
        PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setLong(1,id);
        stmt.execute();
       } catch (SQLException e) {
         throw new RuntimeException(e);
       }
       return true;
    }
    
    public boolean alterar(Administrador adm){
       String sql = "update administrador set adm_nome=? "
                    + " where adm_id =?"; 
               
       try ( 
               
        PreparedStatement stm = connection.prepareStatement(sql)) {
         stm.setString(1,adm.getNome());
         stm.setLong(2,adm.getId());
         
         /* if(cliente.getDataFinalizacao() != null){
            stmt.setDate(3, new Date(cliente.getDataFinalizacao().getTimeInMillis()));
        }else{
            stmt.setNull(3, java.sql.Types.DATE);
        }*/
        stm.execute();
       } catch (SQLException e) {
         throw new RuntimeException(e);
       }
       return true;
    }
    /*
    public boolean finalizarTarefa(Long id){
       String sql = " update tarefas set finalizado=true, "
               +    " dataFinalizacao=now() where id = ? ";
       try { 
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, id);
        stmt.execute();
       } catch (SQLException e) {
         throw new RuntimeException(e);
       }
       return true;
    }
   
    
    
    
    */
}
