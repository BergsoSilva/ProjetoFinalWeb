/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import mvc.dao.ClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author GRS
 */
@Controller
public class MenssagemController {
    
    private final ClienteDao dao;
    
    @Autowired
    public MenssagemController(ClienteDao dao) {
        this.dao = dao;
    }
    
    
    @RequestMapping("/formCadMenssagem")
    public String form(){
        return "view/formCadastrarMenssagem";
    }
/*    
    @RequestMapping("/adicionarMessagem")
    public String adciona(){
        return "view/messagem-Adicionado";
    }
    */
    
    
    
    
}
