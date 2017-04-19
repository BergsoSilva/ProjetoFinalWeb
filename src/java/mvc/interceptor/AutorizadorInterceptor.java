/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author Joyce
 */
public class AutorizadorInterceptor extends HandlerInterceptorAdapter {
   
    @Override
    public boolean preHandle(HttpServletRequest request, 
            HttpServletResponse response,
            Object controller) throws Exception {
        
        String uri = request.getRequestURI();
        
        
        if( ! uri.endsWith("menuCadastro") ){
            
            return true;
        }
        
        HttpSession session = request.getSession();
        
        if(session.getAttribute("usuarioLogado") != null) {
            return true;
        }
        
        response.sendRedirect("formLogin");
        
        return false;
    }
}
