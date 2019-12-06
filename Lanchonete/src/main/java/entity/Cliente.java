package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente implements Serializable {
    
    private Date data;
    
    //Atributos
    @Id
    private String cpf;
    private String nome;
    private String endereco;
    private String nascimento;
    private String telefone;
    private Float creditos;
    private String curso;
    
    //Gets 
    public Date getData(){
        return data;
    }
    
    public String getCPF(){
        return cpf;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getEndereco(){
        return endereco;
    }
    
    public String getNascimento(){
        return nascimento;
    }
    
    public String getTelefone(){
        return telefone;
    }
    
    public Float getCreditos(){
        return creditos;
    }
    
    public String getCurso(){
        return curso;
    }
    
    //Sets  
    public void setData(Date data){
        this.data = data;
    }
    
    public void setCPF(String cpf){
        this.cpf = cpf;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
        
    public void setNascimento(String nascimento){
        this.nascimento = nascimento;
    }
    
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public void setCreditos(Float creditos){
        this.creditos = creditos;
    }
    
    public void setCurso(String curso){
        this.curso = curso;
    }  
    
}
