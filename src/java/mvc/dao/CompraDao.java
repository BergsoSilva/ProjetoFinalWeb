/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.dao;

import java.sql.CallableStatement;
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
import mvc.bean.Compra;
import mvc.bean.Produto;
import mvc.bean.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



/**
 *
 * @author GRS
 */

@Repository
public class CompraDao {


    private final Connection connection;
    
     @Autowired
    public CompraDao(DataSource dataSource) {
        try {
            this.connection =dataSource.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }
    
    public void adciocnarCompra(Compra compra){
      
        
     try (   CallableStatement stm =connection.prepareCall( "{call sp_iud_compra(?,?,?,?)}")){
           
         
            stm.setNull(1, java.sql.Types.INTEGER);
            
            if (compra.getCompcliid()!= null) {
                   stm.setLong(2,compra.getCompcliid());
            } else {
               stm.setNull(2, java.sql.Types.INTEGER);
            }

            if (compra.getCompstaid()!=null) {
                   stm.setLong(3,compra.getCompstaid());
            } else {
               stm.setNull(3, java.sql.Types.INTEGER);
            }

              stm.setString(4,"I");
       
            stm.execute();
       
     } catch (SQLException e) {
         System.out.println("Erro aqui dao Produto"+e.getMessage());
     }
        
        
    }
    
     public Compra buscarUltimaCompra(){
       
       
        String sql =  " select *from compra "
                    + " order by compid desc "
                    + "limit 1 ";
       
      try (PreparedStatement stmt = connection.prepareStatement(sql)) {
             
        ResultSet rs = stmt.executeQuery();
        Compra compra = new Compra();
       while(rs.next()) {
          
           compra.setCompid(rs.getLong("compid"));
           compra.setCompcliid(rs.getLong("compcliid"));
           compra.setCompstaid(rs.getLong("compstaid"));
            
       
        }
        return compra;
       } catch (SQLException e) {
         throw new RuntimeException(e);
       }
    }
   

    public List<Compra> buscarCompras(){
       List<Compra> compras= new ArrayList<>();
       
        String sql = "select *from compra ";
       
      try (PreparedStatement stmt = connection.prepareStatement(sql)) {
             
        ResultSet rs = stmt.executeQuery();

       while(rs.next()) {
           Compra compra = new Compra();
           compra.setCompid(rs.getLong("compid"));
           compra.setCompcliid(rs.getLong("compcliid"));
           compra.setCompstaid(rs.getLong("compstaid"));
            
           compras.add(compra);
        }
        return compras;
       } catch (SQLException e) {
         throw new RuntimeException(e);
       }
    }
    
      public Compra buscarComprasPorid(Long id){
       
        String sql = "select * "
                   + " from compra "
                   + " where compid=?";
                
       
       try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        
             stmt.setLong(1, id);
        
             ResultSet rs = stmt.executeQuery();
        
                Compra compra = new Compra();
                while(rs.next()){
                compra.setCompid(rs.getLong("compid"));
                compra.setCompcliid(rs.getLong("compcliid"));
                compra.setCompstaid(rs.getLong("compstaid"));

          }
        
        return compra;
       } catch (SQLException e) {
         throw new RuntimeException(e);
       }
    }
 
    public boolean removerCompra(Long id){
      // String sql = "delete from compra where compid = ? ";
       try ( CallableStatement stmt =connection.prepareCall("{call sp_iud_compra(?,?,?,?)}")) {
        stmt.setLong(1,id);
        stmt.setNull(2,java.sql.Types.INTEGER);
        stmt.setNull(3,java.sql.Types.INTEGER);
        stmt.setString(4, "D");
        stmt.execute();
       } catch (SQLException e) {
         throw new RuntimeException(e);
       }
       return true;
    }
       
 
    public boolean alterar(Compra compra){
       String sql = "update compra set compcliid=?,compstaid=? where compid =?";
       try ( 
               
        PreparedStatement stm = connection.prepareStatement(sql)) {
        
         if (compra.getCompcliid()!= null) {
                stm.setLong(1,compra.getCompcliid());
         } else {
            stm.setNull(1, java.sql.Types.INTEGER);
         }
         
         if (compra.getCompstaid()!=0) {
                stm.setLong(2,compra.getCompstaid());
         } else {
            stm.setNull(2, java.sql.Types.INTEGER);
         }
         
          // atributo que define o qual vai ser mudado
          stm.setLong(3,compra.getCompid());
          
          stm.execute();
       } catch (SQLException e) {
         throw new RuntimeException(e);
       }
       return true;
    }
    
  
}
