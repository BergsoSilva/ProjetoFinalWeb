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
import mvc.dao.StatusDao;
import mvc.dao.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author GRS
 */
@Controller
public class CompraController {

         private String qtdeItemSelecionado="1";

         private List<Produto> produtos;

         private final CompraDao dao;
         private final ProdutoDao daoproduto;
         private final UsuarioDao daoUsuario;
         private final ItemCompraDao daoitem;

         @Autowired
         public CompraController(UsuarioDao daousuario,CompraDao dao,ProdutoDao daoproduto,ItemCompraDao daoitem ) {
                   this.dao = dao;
                   this.daoproduto=daoproduto;
                   this.daoUsuario=daousuario;
                   this.daoitem=daoitem;
         }
    
        // Mostra produto em tamanho maior e mais detalhes
        @RequestMapping("/formCadCompra")
        public String form(Long id, Model model,HttpSession session){
            
                   model.addAttribute("produto",daoproduto.buscarProdutoPorId(id));  
                  session.setAttribute("quantidadeProduto",qtdeItemSelecionado);
                   return "compra/detalhesProduto";
        }
    
    
    @RequestMapping("/fecharCompra")
    public String fercharCompra (Model model,HttpSession session) {
        
        if (session.getAttribute("usuarioLogado") != null){
            Usuario user= (Usuario)session.getAttribute("usuarioLogado");

            Usuario user2 = daoUsuario.pegarUsuario(user.getUsulogin());

            model.addAttribute("usuario", user2 );
        }else {
            return "usuario//formLogin"; 
        }

            return "compra/formFechaCompra";
    }
    
    // adiciona a venda e os itens de venda
    @RequestMapping("/adicionarCompra")
    public String adiciona(Compra compra ,HttpSession session){
        
                  dao.adciocnarCompra(compra);

                  Compra LastSale = dao.buscarUltimaCompra();

                  List<Carrinho> itensSession = new ArrayList<>();

                  itensSession = (List<Carrinho>) session.getAttribute("scproduto");

                  ItemCompra iten = new ItemCompra();

                  iten.setItvcompid(LastSale.getCompid());

                 for (Carrinho listaCarrinho : itensSession) {
 
                            iten.setItvproid(listaCarrinho.getProdutoid());
                            iten.setItvqtde(Long.valueOf(listaCarrinho.getQuantidadeProduto()));

                            daoitem.adciocnarItem(iten);
                 }

            return "msg/compra-Adicionado";
    }


    @RequestMapping("/listaCompras")
    public String lista(Model model){
        model.addAttribute("compras",dao.buscarCompras());
        return "compra/formListaCompras";
    }
   
  
    // Exibir dados para alterar
    
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
    

    
    
}
