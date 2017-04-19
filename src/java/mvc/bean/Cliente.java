/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.bean;

import java.io.Serializable;
import java.util.Calendar;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author GRS
 */
public class Cliente implements Serializable{
    private Long id;

    @NotEmpty(message = "{cliente.nome.vazia}")
    @Size(min=5, max = 100, message="{tarefa.nome.limite}")
    private String cli_nome;
    
    @NotEmpty(message = "{cliente.email.vazia}")
    @Size(min=10, max = 100, message="{cliente.email.limite}")
    private String cli_email;
    
    private String cli_senha;
    
    private String cli_endereco;
    
    private String cli_rg;
    
    private String cli_cpf;
    
    private String cli_telefone;
   
    
    private String  sexo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCli_nome() {
        return cli_nome;
    }

    public void setCli_nome(String cli_nome) {
        this.cli_nome = cli_nome;
    }

    public String getCli_email() {
        return cli_email;
    }

    public void setCli_email(String cli_email) {
        this.cli_email = cli_email;
    }

    public String getCli_senha() {
        return cli_senha;
    }

    public void setCli_senha(String cli_senha) {
        this.cli_senha = cli_senha;
    }

    public String getCli_endereco() {
        return cli_endereco;
    }

    public void setCli_endereco(String cli_endereco) {
        this.cli_endereco = cli_endereco;
    }

    public String getCli_rg() {
        return cli_rg;
    }

    public void setCli_rg(String cli_rg) {
        this.cli_rg = cli_rg;
    }

    public String getCli_cpf() {
        return cli_cpf;
    }

    public void setCli_cpf(String cli_cpf) {
        this.cli_cpf = cli_cpf;
    }

    public String getCli_telefone() {
        return cli_telefone;
    }

    public void setCli_telefone(String cli_telefone) {
        this.cli_telefone = cli_telefone;
    }

  
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
   
}
