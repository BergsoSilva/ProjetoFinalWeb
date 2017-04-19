/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import mvc.bean.Administrador;
import mvc.bean.Categoria;
import mvc.dao.CategoriaDao;
import mvc.dao.ClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author GRS
 */
@Controller
public class CategoriaController {
    
    private final CategoriaDao dao;
    
    @Autowired
    public CategoriaController(CategoriaDao dao) {
        this.dao = dao;
    }
    
    
    @RequestMapping("/formCadCategoria")// Chama formulario de cadastro
    public String form(){
        return "categoria/formCadastrarCategoria";
    }
    
    @RequestMapping("/adicionarCategoria")
    public String adciona(Categoria categoria){
        dao.adciocnar(categoria);
        return "msg/categoria-Adicionado";
    }
    
    
    
    @RequestMapping("/listaCategoria")
    public String lista(Model model){
        model.addAttribute("cats", dao.listarTodos());
        return "categoria/formListaCats";
    }
    
    @RequestMapping("/removerCat")
    public String remove(Long id){
        dao.remover(id);
        return "redirect:/listaCategoria";
    }
    
    // Exibir dados para auterar
    
    @RequestMapping("/exibeCat")
    public String exibe(Long id, Model model){
        model.addAttribute("catbanco",dao.buscarPorId(id));
        return "categoria/formAlterarCat";
    }
    
    @RequestMapping("/alteraCat")
    public String altera(Categoria cat){
       dao.alterar(cat);
       return "redirect:/listaCategoria";
    }
    
    
    
}
