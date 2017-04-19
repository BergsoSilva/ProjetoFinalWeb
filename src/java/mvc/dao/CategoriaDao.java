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
public class CategoriaDao {


    private final Connection connection;
    
    @Autowired // injection  de dependencia 
    public CategoriaDao(DataSource dataSource) {
        try {
            this.connection =dataSource.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }
    
    public void adciocnar(Categoria categoria){

        String sql = "insert into categoria (cat_descricao) values (?);";
        
     try (   PreparedStatement stm =connection.prepareStatement(sql)){
              
         stm.setString(1,categoria.getDescricao());
         
         stm.execute();
       
     } catch (SQLException e) {
         throw new RuntimeException(e.getCause());
         
     }
        
        
    }

    public List<Categoria> listarTodos(){
       List<Categoria> lista = new ArrayList<>();
       String sql = "select *from categoria";
               
       try ( 
        PreparedStatement stmt = connection.prepareStatement(sql)) {
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
           Categoria cat  = new Categoria();
           cat.setId(rs.getLong("cat_id"));
           cat.setDescricao(rs.getString("cat_descricao"));
           //montando data
           /*Calendar data = Calendar.getInstance();
           if(rs.getDate("dataFinalizacao") != null)
           {
               data.setTime(rs.getDate("dataFinalizacao"));
               cliente.setDataFinalizacao(data);
           } 
                   */
           
           lista.add(cat);
         }
        return lista;
       } catch (SQLException e) {
         throw new RuntimeException(e);
       }
      
    }
    
    public Categoria buscarPorId(Long id){
       String sql = "select * "
               + " from categoria where cat_id=?";
              
       try ( 
        PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setLong(1,id);
        ResultSet rs = stmt.executeQuery();
        Categoria cat = new Categoria();
        if(rs.next()) {
           cat.setId(rs.getLong("cat_id"));
           cat.setDescricao(rs.getString("cat_descricao"));
                   /*montando data
           Calendar data = Calendar.getInstance();
           if(rs.getDate("dataFinalizacao") != null)
           {
               data.setTime(rs.getDate("dataFinalizacao"));
               System.out.println("data");
               cliente.setDataFinalizacao(data);
           }*/
                   
        }
        return cat;
       } catch (SQLException e) {
         throw new RuntimeException(e);
       }
    }
    
    public boolean remover(Long id){
       String sql = "delete from categoria where cat_id = ? ";
       try ( 
        PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setLong(1,id);
        stmt.execute();
       } catch (SQLException e) {
         throw new RuntimeException(e);
       }
       return true;
    }
    
    public boolean alterar(Categoria cat){
       String sql = "update categoria set cat_descricao=? "
                    + " where cat_id =?"; 
               
       try ( 
               
        PreparedStatement stm = connection.prepareStatement(sql)) {
         stm.setString(1,cat.getDescricao());
         stm.setLong(2,cat.getId());
         
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
