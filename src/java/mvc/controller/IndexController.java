/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author GRS
 */
@Controller
public class IndexController {
    
  @RequestMapping("/")
    public String index(){
    
        return "index";
    }
    
    
    @RequestMapping("/welcome")
    public ModelAndView wellcome(){
        String viewName = "welcome";
        String var = "message";
        String content = "WELCOME TO SPRING WORLD!";
        return new ModelAndView(viewName, var, content) ;
    }
    // chamar menu de cadastro
    @RequestMapping("/menuCadastro")
    public  String menu(){
        return  "menuCadastro";
    }
    
     @RequestMapping("/menuNavegacao")
    public  String navegacao(){
        return  "menuNavegacao";
    }
   
    
}
