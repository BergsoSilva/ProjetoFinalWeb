/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.interfaces;

import java.util.List;

/**
 *
 * @author GRS
 */
public interface Dao {
    
    void inserir(Object  ob);
    void alterar(Object  ob);
    void excluir(Object  ob);
    List<Object> pesquisar();
    
    
}
