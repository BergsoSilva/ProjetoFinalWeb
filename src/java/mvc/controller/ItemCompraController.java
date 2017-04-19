/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;



import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.validation.Valid;
import mvc.bean.Carrinho;
import mvc.bean.Cliente;
import mvc.bean.Compra;
import mvc.bean.ItemCompra;
import mvc.bean.Produto;
import mvc.bean.Usuario;
import mvc.dao.AdministradorDao;
import mvc.dao.CategoriaDao;
import mvc.dao.ClienteDao;
import mvc.dao.CompraDao;
import mvc.dao.ItemCompraDao;
import mvc.dao.ProdutoDao;
import mvc.dao.UsuarioDao;
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
public class ItemCompraController {
    
    private Double totalCompra=0.0;

    List<Carrinho> itensCarrinho = new ArrayList<>();
    
    
    private final ItemCompraDao dao;
    private final CompraDao daocompra;
    private final ProdutoDao daoproduto;
    private final UsuarioDao daousuario;
    @Autowired
    public ItemCompraController(ItemCompraDao dao , CompraDao daocompra,ProdutoDao daoproduto, UsuarioDao daousuario) {
     
        this.dao = dao;
        this.daocompra=daocompra;
        this.daoproduto=daoproduto;
        this.daousuario=daousuario;
       
    }
  
    /**
     * Chama o carrinho de qualquer lugar e o exibe na sessao que enta em  curso;
     * @param session
     * @return 
     */
   @RequestMapping("/verCarrinho")
    public String verCarrinho ( HttpSession session){
        
                  for (int i = 0; i <itensCarrinho.size(); i++) {
                           totalCompra=totalCompra+itensCarrinho.get(i).getValorProduto()*itensCarrinho.get(i).getQuantidadeProduto();

                  }
                  session.setAttribute("scproduto", itensCarrinho);
                  session.setAttribute("sctotalCompra",totalCompra); // valor  total da compra
                  return "compra/formFinalizarCompra";

     }
    /**
     * pega o produto que esta sendo exibido em detalhes e preenche o objeto Carrinho
     * que sera inserido na lista de itensCarrinho 
     * lista itensCarrinho é enviado pra a sessão em andamento
    */
    @RequestMapping("/formFimCompra")
    public String finalizar(Long id, HttpSession session){
                
                   
                   Carrinho  itens = new Carrinho();
                 
                  itens.setProdutoid(daoproduto.buscarProdutoPorId(id).getProid());
                
                
                  itens.setDescricaoProduto(daoproduto.buscarProdutoPorId(id).getProdescricao());
                 
                  
                  itens.setValorProduto(daoproduto.buscarProdutoPorId(id).getProvalor());
                  
              //    String qtde = (String) session.getAttribute("qtdeItemSelecionado");
                  
                // itens.setQuantidadeProduto(Integer.parseInt(qtde));
            
                 
                           this.itensCarrinho.add(itens);
                           
                           session.setAttribute("scproduto", itensCarrinho);
                    
            
            
                for (int i = 0; i <itensCarrinho.size(); i++) {
                    totalCompra=totalCompra+itensCarrinho.get(i).getValorProduto()*itensCarrinho.get(i).getQuantidadeProduto();

                }

                 session.setAttribute("sctotalCompra",totalCompra); //  envia o valor  dos itens da compra
         
         return "compra/formFinalizarCompra";
    }
    
    
    @RequestMapping("/removerItem")
    public String removerItemSessao (Long id,HttpSession session){
        
         for (int i = 0; i < itensCarrinho.size(); i++) {
              if (id==itensCarrinho.get(i).getProdutoid()){
                  this.itensCarrinho.remove(itensCarrinho.get(i));
              }
        }
        
        session.setAttribute("produto",itensCarrinho);
        
        return "redirect:/verCarrinho";
    }
    
    
    
    
     @RequestMapping("/adicionarItemPedido")
    public String finalizar(@Valid ItemCompra item,BindingResult result){
         if(result.hasErrors()){
             return "compra/formFinalizarCompra";
         }
         dao.adciocnarItem(item);
         
         return "cliente/formCadastrarCliente";
    }
    /*
    @RequestMapping("/adicionarItemCompra")
    public String adiciona(@Valid ItemCompra item,BindingResult result){  
        if (result.hasErrors()){
            return "compra/formFinalizarCompra";
        }
        dao.adciocnarItem(item);
        return "msg/compra-Adicionado";
    }
    
    /*
    @RequestMapping("/listaCompras")
    public String lista(Model model){
        model.addAttribute("compras",dao.buscarCompras());
        return "compra/formListaCompras";
    }
   
  
    // Exibir dados para auterar
    
    @RequestMapping("/exibeCompra")
    public String exibe(Long id, Model model){
        model.addAttribute("compalt", dao.buscarComprasPorid(id));
        return "compra/formAlterarCompra";
    }
    
    @RequestMapping("/alteraCompra")
    public String altera(Compra compra){
       
        dao.alterar(compra);
       return "redirect:/listaCompras";
    }
    
    @RequestMapping("/removerCompra")
    public String remover (Long id) {
        dao.removerCompra(id);
        return "redirect:/listaCompras";
    }
    

    
    */
}
