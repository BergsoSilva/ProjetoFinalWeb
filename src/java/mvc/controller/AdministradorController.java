/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;



import javax.validation.Valid;
import mvc.bean.Administrador;
import mvc.bean.Cliente;
import mvc.bean.Produto;
import mvc.dao.AdministradorDao;
import mvc.dao.ClienteDao;
import mvc.dao.ProdutoDao;
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
public class AdministradorController {
    
    private final AdministradorDao dao;
    
    @Autowired
    public AdministradorController(AdministradorDao dao) {
        this.dao = dao;
    }
   
    // Chama a tela de cadastro
    @RequestMapping("/formCadAdm")
    public String form(){
        return "adm/formCadastrarAdm";
    }
    
    // Persiste o cliente e retorna  a mensagem 
    @RequestMapping("/adicionarAdm")
    public String adciona(Administrador adm){
        dao.adciocnar(adm);
        return "msg/cliente-Adicionado";
    }
    
    @RequestMapping("/listaAdministrador")
    public String lista(Model model){
        model.addAttribute("listaAdm", dao.listarTodos());
        return "adm/formListaAdms";
    }
    
    @RequestMapping("/removerAdm")
    public String remove(Long id){
        dao.remover(id);
        return "redirect:/listaAdministrador";
    }
    
    // Exibir dados para auterar
    
    @RequestMapping("/exibeAdm")
    public String exibe(Long id, Model model){
        model.addAttribute("admins", dao.buscarPorId(id));
        return "adm/formAlterarAdm";
    }
    
    @RequestMapping("/alteraAdm")
    public String altera(Administrador adm){
       dao.alterar(adm);
       return "redirect:/listaAdministrador";
    }
    
    
    
    
}
