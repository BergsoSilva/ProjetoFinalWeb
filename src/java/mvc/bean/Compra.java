/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.bean;

/**
 *
 * @author GRS
 */
public class Compra {
    private Long compid;
    private Long compcliid;
    private Long compstaid;
 

    public Compra() {
    }

    public Long getCompid() {
        return compid;
    }

    public void setCompid(Long compid) {
        this.compid = compid;
    }

    public Long getCompcliid() {
        return compcliid;
    }

    public void setCompcliid(Long compcliid) {
        this.compcliid = compcliid;
    }

    public Long getCompstaid() {
        return compstaid;
    }

    public void setCompstaid(Long compstaid) {
        this.compstaid = compstaid;
    }

    
}
