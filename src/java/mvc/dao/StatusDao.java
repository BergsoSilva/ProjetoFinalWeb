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
import mvc.bean.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



/**
 *
 * @author GRS
 */

@Repository
public class StatusDao {


    private final Connection connection;
    
     @Autowired
    public StatusDao(DataSource dataSource) {
        try {
            this.connection =dataSource.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }
    
    public List<Status> listaStatus(){
        List<Status> litStatus = new ArrayList<>();
        String sql = " select *from status";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            
            ResultSet rs= stmt.executeQuery();
            
            while (rs.next() ){
                Status st = new Status();
                st.setStaid(rs.getLong("staid"));
                st.setStavalor(rs.getString("stavalor"));
                
                litStatus.add(st);
            }
            
            return litStatus;
            
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public Status listaStatusID(Long id){
        
        String sql = " select *from status where staid=?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            
            stmt.setLong(1,id);
            ResultSet rs= stmt.executeQuery();
            
           
                Status st = new Status();
                st.setStaid(rs.getLong("staid"));
                st.setStavalor(rs.getString("stavalor"));
                
            
            return st;
            
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
  
  
}
