/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import javax.servlet.http.HttpSession;
import mvc.bean.Cliente;
import mvc.bean.Usuario;
import mvc.dao.AdministradorDao;
import mvc.dao.ClienteDao;
import mvc.dao.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author GRS
 */
@Controller
public class LoginController {
    
     private final UsuarioDao dao;
     private final ClienteDao daoCliente;
    
    @Autowired
    public LoginController(UsuarioDao dao, ClienteDao daoClinte) {
        this.dao = dao;
        this.daoCliente=daoClinte;
        
    }
    @RequestMapping("/formLogin")
    public String formLogin(){
        
        return "usuario/formUsuarioLogin";
    }
    
    @RequestMapping("/formLoginCliente")
    public String formLoginCliente(){
        
        return "cliente/formLoginCliente";
    }
   
    @RequestMapping("/efetuarLogin")
    public String efetuarLogin(Usuario user,HttpSession session){
         Usuario usuarioSession ;
        
        if (dao.validaUsuario(user)){
                usuarioSession=dao.pegarUsuario(user.getUsulogin());
                session.setAttribute("usuarioLogado", user);
                session.setAttribute("usuarioSession", usuarioSession);
            
                session.removeAttribute("msgLoginInvalido");
                
            
        }else{
            session.setAttribute("msgLoginIvalido","Usuario nao validado");
            return "redirec:formLogin";
        }
        
         return "index";
    }
    
    @RequestMapping("formCadastro")
    public String cadastra (){
        return "usuario/formCadastroUsuario";
    }
    
    
    
     @RequestMapping("/efetuarLoginCliente")
    public String efetuarLoginCliente( Cliente cliente,HttpSession session){
         Cliente clienteSession ;
        
        if (daoCliente.validaCliente(cliente)){
            
                clienteSession=daoCliente.pegarCliente(cliente.getCli_email());
                session.setAttribute("clienteLogado", cliente);
                session.setAttribute("clienteSession", clienteSession);
            
                session.removeAttribute("msgLoginInvalido");
                
            
        }else{
            session.setAttribute("msgLoginIvalido","Usuario nao validado");
            return "redirec:formLogin";
        }
        
         return "/index";
    }
    
    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
    
}
