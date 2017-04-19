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
import mvc.bean.ItemCompra;
import mvc.bean.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



/**
 *
 * @author GRS
 */

@Repository
public class ItemCompraDao {


    private final Connection connection;
    
     @Autowired
    public ItemCompraDao(DataSource dataSource) {
            try {
                this.connection =dataSource.getConnection();
            } catch (SQLException ex) {
                throw new RuntimeException(ex.getCause());
            }
    }
    
    public void adciocnarItem(ItemCompra item){
      
        
         try (   CallableStatement stm =connection.prepareCall( "{call sp_iud_itensCompra(?,?,?,?)}")){

                if (item.getItvcompid()!= null) {
                            stm.setLong(1,item.getItvcompid());
                 } else {
                            stm.setNull(1, java.sql.Types.INTEGER);
                 }

                 if (item.getItvproid()!= null) {
                            stm.setLong(2,item.getItvproid());
                 } else {
                            stm.setNull(2, java.sql.Types.INTEGER);
                 }
                 if (item.getItvqtde()!=null) {
                            stm.setLong(3,item.getItvqtde());
                 } else {
                            stm.setNull(3, java.sql.Types.INTEGER);
                 }

                stm.setString(4,"I");

                 stm.execute();

        } catch (SQLException e) {
            System.out.println("Erro aqui Item compra "+e.getMessage());
        }

        
    }
  
       
 
    public boolean alterar(ItemCompra itemCompra){
        

                    try (   CallableStatement stm =connection.prepareCall( "{call sp_iud_itensCompra(?,?,?,?)}")){

                                if ( itemCompra.getItvcompid()!= null) {
                                              stm.setLong(1, itemCompra.getItvcompid());
                                 } else {
                                              stm.setNull(1, java.sql.Types.INTEGER);
                                 }

                                 if ( itemCompra.getItvproid()!= null) {
                                              stm.setLong(2, itemCompra.getItvproid());
                                 } else {
                                    stm.setNull(2, java.sql.Types.INTEGER);
                                 }
                                 if ( itemCompra.getItvqtde()!=null) {
                                            stm.setLong(3, itemCompra.getItvqtde());
                                 } else {
                                            stm.setNull(3, java.sql.Types.INTEGER);
                                 }

                                stm.setString(4,"U");

                                stm.execute();
                                 return  true;
                   } catch (SQLException e) {
                            System.out.println("Erro aqui Item compra "+e.getMessage());
                   }
                     return  false;
   
    } 
    
}
