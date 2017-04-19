/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;



import javax.validation.Valid;
import mvc.bean.Cliente;
import mvc.bean.Produto;
import mvc.dao.AdministradorDao;
import mvc.dao.CategoriaDao;
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
public class ProdutoController {
    
    private final ProdutoDao dao;
    private final AdministradorDao dao1;
    private final CategoriaDao dao2;
    
    @Autowired
    public ProdutoController(ProdutoDao dao,AdministradorDao dao1, CategoriaDao dao2) {
        this.dao = dao;
        this.dao1=dao1;
        this.dao2=dao2;
    }
    
    // Chama a tela de cadastro
    @RequestMapping("/formCadProduto")
    public String form(Model model){
        model.addAttribute("adms", dao1.listarTodos());
        model.addAttribute("cats",dao2.listarTodos());
        return "produto/formCadastroProduto";
    }
    
    @RequestMapping("/adicionarProduto")
    public String adiciona(@Valid Produto produto){
        
        dao.adciocnarProduto(produto);
        return "msg/produto-Adicionado";
    }
    
    
    @RequestMapping("/listaProduto")
    public String lista(Model model){
        model.addAttribute("listaPro", dao.listarProdutos());
        return "produto/formListaProdutos";
    }
    @RequestMapping("/listaProImagem")
    public String listaImagem (Model model) {
        model.addAttribute("listaPro", dao.listarProdutos());
        return "produto/listaProdutos";
    }
    
    @RequestMapping("/removerProduto")
    public String remove(Long id){
        dao.removerTarefa(id);
        return "redirect:/listaProduto";
    }
    
    // Exibir dados para auterar
    
    @RequestMapping("/exibeProduto")
    public String exibe(Long id, Model model){
        model.addAttribute("pro", dao.buscarProdutoPorId(id));
        return "produto/formAlterarProduto";
    }
    
    @RequestMapping("/alteraProduto")
    public String altera(Produto produto){
       
        dao.alterar(produto);
       return "redirect:/listaProduto";
    }
    
    
    
    
}
