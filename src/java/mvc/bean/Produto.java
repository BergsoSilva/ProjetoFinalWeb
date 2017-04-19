/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.bean;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author GRS
 */
public class Produto  implements Serializable {
    private Long proid;
    @NotEmpty(message ="{tarefa.descricao.vazia}")
    private String prodescricao;
    private int proquantde;
    private Double provalor;
    private String proimagem; 
    private Long  procatid;
    private Long proadminid;
    

    public Produto() {
        
    }

    public Long getProid() {
        return proid;
    }

    public void setProid(Long proid) {
        this.proid = proid;
    }

    public String getProdescricao() {
        return prodescricao;
    }

    public void setProdescricao(String prodescricao) {
        this.prodescricao = prodescricao;
    }

    public int getProquantde() {
        return proquantde;
    }

    public void setProquantde(int proquantde) {
        this.proquantde = proquantde;
    }

    public Double getProvalor() {
        return provalor;
    }

    public void setProvalor(Double provalor) {
        this.provalor = provalor;
    }

    public String getProimagem() {
        return proimagem;
    }

    public void setProimagem(String proimagem) {
        this.proimagem = proimagem;
        
    }

    public Long getProcatid() {
        return procatid;
    }

    public void setProcatid(Long procatid) {
        this.procatid = procatid;
    }

    public Long getProadminid() {
        return proadminid;
    }

    public void setProadminid(Long proadminid) {
        this.proadminid = proadminid;
    }
    
    

}
