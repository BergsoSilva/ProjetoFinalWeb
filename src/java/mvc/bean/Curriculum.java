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
public class Curriculum {
    private Long id;
    private String interesado;
    private String menssagem;

    public Curriculum() {
    }

    public Curriculum(Long id, String interesado, String menssagem) {
        this.id = id;
        this.interesado = interesado;
        this.menssagem = menssagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInteresado() {
        return interesado;
    }

    public void setInteresado(String interesado) {
        this.interesado = interesado;
    }

    public String getMenssagem() {
        return menssagem;
    }

    public void setMenssagem(String menssagem) {
        this.menssagem = menssagem;
    }
    
    
    
}
