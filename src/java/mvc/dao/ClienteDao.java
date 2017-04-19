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
import mvc.bean.Cliente;
import mvc.bean.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



/**
 *
 * @author GRS
 */

@Repository
public class ClienteDao {


    private final Connection connection;
    
     @Autowired
    public ClienteDao(DataSource dataSource) {
        try {
            this.connection =dataSource.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }
    
    public void adciocnarCliente(Cliente cliente){

        String sql = "insert into cliente (cli_nome, cli_email,cli_senha,cli_endereco) values (?,?,?,?)";
        
     try (   PreparedStatement stm =connection.prepareStatement(sql)){
              
         stm.setString(1,cliente.getCli_nome());
         stm.setString(2,cliente.getCli_email());
         stm.setString(3, cliente.getCli_senha());
         stm.setString(4,cliente.getCli_endereco());
         
         stm.execute();
       
     } catch (SQLException e) {
         throw new RuntimeException(e.getCause());
         
     }
        
        
    }
    
//----------------
    
    public List<Cliente> listarClientes(){
       List<Cliente> listaTarefas = new ArrayList<>();
       String sql = "select * from cliente order by cli_id";
       try ( 
        PreparedStatement stmt = connection.prepareStatement(sql)) {
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
           Cliente cliente = new Cliente();
           cliente.setId(rs.getLong("cli_id"));
           cliente.setCli_nome(rs.getString("cli_nome"));
           cliente.setCli_email(rs.getString("cli_email"));
           cliente.setCli_senha(rs.getString("cli_senha"));
           cliente.setCli_endereco(rs.getString("cli_endereco"));
           
           listaTarefas.add(cliente);
         }
        return listaTarefas;
       } catch (SQLException e) {
         throw new RuntimeException(e);
       }
      
    }
    
    public List<Cliente> buscarClientePorId(Long id){
         List<Cliente> clientes =  new ArrayList<>();
         
        String sql = "select * from cliente where cli_id = ? ";
       try ( 
                PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setLong(1,id);
                ResultSet rs = stmt.executeQuery();
                Cliente cliente = new Cliente();
                if(rs.next()) {
                        cliente.setId(rs.getLong("cli_id"));
                        cliente.setCli_nome(rs.getString("cli_nome"));
                        cliente.setCli_email(rs.getString("cli_email"));
                        cliente.setCli_senha(rs.getString("cli_senha"));
                        cliente.setCli_endereco(rs.getString("cli_endereco"));
                } 
                 return clientes;
       } catch (SQLException e) {
                 throw new RuntimeException(e);
       }
    }
    // Perfil
    public Cliente mostrarDadosPerfil(Long id){
         
        String sql = "select * from cliente where cli_id = ? ";
       try ( 
                PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setLong(1,id);
                ResultSet rs = stmt.executeQuery();
                Cliente cliente = new Cliente();
                if(rs.next()) {
                        cliente.setId(rs.getLong("cli_id"));
                        cliente.setCli_nome(rs.getString("cli_nome"));
                        cliente.setCli_email(rs.getString("cli_email"));
                        cliente.setCli_senha(rs.getString("cli_senha"));
                        cliente.setCli_endereco(rs.getString("cli_endereco"));
                }
                 return cliente;
       } catch (SQLException e) {
                 throw new RuntimeException(e);
       }
    }
    
    public boolean removerTarefa(Long id){
       String sql = "delete from cliente where cli_id = ? ";
       try ( 
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1,id);
            stmt.execute();
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
       return true;
    }
    
    public boolean alterarTarefa(Cliente cliente){
       String sql = "update cliente set cli_nome=?, cli_email=?, cli_senha=?, cli_endereco=? where cli_id =?"; 
               
       try ( 
        PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setString(1,cliente.getCli_nome());
        stmt.setString(2,cliente.getCli_email());
        stmt.setString(3,cliente.getCli_senha());
        stmt.setString(4,cliente.getCli_endereco());
        
        stmt.setLong(5,cliente.getId());
        stmt.execute();
       } catch (SQLException e) {
         throw new RuntimeException(e);
       }
       return true;
    }
    
    // Validadr cliente
    public boolean validaCliente(Cliente cliente){
          
       String sql = "select cliemail, clisenha from cliente where cliemail = ? and clisenha = ? ";
       try ( 
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1,cliente.getCli_email());
            stmt.setString(2,cliente.getCli_senha());
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
      
    public Cliente pegarCliente(String email){
       String sql = "select *from cliente where cli_email= ? ";
       
       try ( 
        PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setString(1,email);
        
          ResultSet rs = stmt.executeQuery();
          Cliente cli= new Cliente();
          while(rs.next()){
          
                cli.setId(rs.getLong("cli_id"));
                cli.setCli_nome(rs.getString("cli_nome"));
                cli.setCli_email(rs.getString("cli_email"));
                cli.setCli_senha(rs.getString("cli_senha"));
                cli.setCli_endereco(rs.getString("cli_endereco"));
          }
           return cli;
         
       } catch (SQLException e) {
         throw new RuntimeException("errrr"+e);
       }
    }
    
}
