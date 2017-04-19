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
public class Usuario implements Serializable{
   private long usuid;
   private String usulogin;
   private String ususenha;
   private int usupermissao;
   private int usucliid;

    public Usuario() {
    }

    public void setUsucliid(int usucliid) {
        this.usucliid = usucliid;
    }

    public int getUsucliid() {
        return usucliid;
    }
    

    public int getUsupermissao() {
        return usupermissao;
    }

    public void setUsupermissao(int usupermissao) {
        this.usupermissao = usupermissao;
    }

    
    public long getUsuid() {
        return usuid;
    }

    public void setUsuid(long usuid) {
        this.usuid = usuid;
    }

    public String getUsulogin() {
        return usulogin;
    }

    public void setUsulogin(String usulogin) {
        this.usulogin = usulogin;
    }

    public String getUsusenha() {
        return ususenha;
    }

    public void setUsusenha(String ususenha) {
        this.ususenha = ususenha;
    }
   
   
}
