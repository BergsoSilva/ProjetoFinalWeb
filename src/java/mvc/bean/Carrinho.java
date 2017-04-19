/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.bean;

import java.io.Serializable;

/**
 *
 * @author GRS
 */
public class Carrinho  implements Serializable{
    
    private Long produtoid;
    private  String descricaoProduto;
    private Double  valorProduto;
    private int quantidadeProduto;

    public Carrinho() {
    }

    public void setProdutoid(Long produtoid) {
        this.produtoid = produtoid;
    }

    public Long getProdutoid() {
        return produtoid;
    }
    
    

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public Double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(Double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }
    
    
    

    
}
