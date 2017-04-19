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
public class Status {
    private Long staid;
    private String stavalor;

    public Status() {
    }

    public Status(Long staid, String stavalor) {
        this.staid = staid;
        this.stavalor = stavalor;
    }

    public Long getStaid() {
        return staid;
    }

    public void setStaid(Long staid) {
        this.staid = staid;
    }

    public String getStavalor() {
        return stavalor;
    }

    public void setStavalor(String stavalor) {
        this.stavalor = stavalor;
    }
    
    
    
}
