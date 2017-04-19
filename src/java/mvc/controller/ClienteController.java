/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;



import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import mvc.bean.Cliente;
import mvc.bean.Usuario;
import mvc.dao.ClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author GRS
 */
@Controller
public class ClienteController {
    
    private final ClienteDao dao;
    
    @Autowired
    public ClienteController(ClienteDao dao) {
        this.dao = dao;
    }
    
    // Chama a tela de cadastro
    @RequestMapping("/formCadCliente")
    public String form(){
            return "cliente/formCadastrarCliente";
    }
    
    // Persiste o cliente e retorna  a mensagem 
    @RequestMapping("/adicionarCliente")
    public String adciona( Cliente cliente){
             dao.adciocnarCliente(cliente);
             return "cliente/cliente-Adicionado";
    }
    
    @RequestMapping("/listaCliente")
    public String lista(Model model,HttpSession session){
          Usuario usuario=(Usuario) session.getAttribute("usuarioSession");
        
        if (usuario.getUsupermissao()==0){
                 model.addAttribute("listaCli", dao.listarClientes());    
        }else{
                 model.addAttribute("listaCli",dao.buscarClientePorId(Long.parseLong(usuario.getUsucliid()+"")));
        }
        
        return "cliente/formListaClientes";
    }
    
    @RequestMapping("/removerCliente")
    public String remove(Long id){
             dao.removerTarefa(id);
            return "redirect:/listaCliente";
    }
    
    @RequestMapping("/exibeCliente")
    public String exibe(Long id, Model model){
            model.addAttribute("cliente", dao.mostrarDadosPerfil(id));
            return "cliente/formAlterarCliente";
    }
       
    @RequestMapping("/alteraCliente")
    public String altera(Cliente cliente){
       
          dao.alterarTarefa(cliente);
        return "redirect:/listaCliente";
    }
    
    
    
    
}
