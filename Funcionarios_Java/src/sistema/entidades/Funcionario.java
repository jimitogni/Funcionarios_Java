package sistema.entidades;

public class Funcionario {
    
public Funcionario(){
    }
    
    private int id, cargo;
    private String nome, sobrenome, dataNascimento, email;
    private Double salario;
    
    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }
    
    public int getCargo(){
        return this.cargo;
    }

    public void setCargo(int cargo){
        this.cargo = cargo;
    }
    
    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getSobreNome(){
        return this.sobrenome;
    }

    public void setSobreNome(String sobrenome){
        this.sobrenome = sobrenome;
    }
    
    public String getDataNascimento(){
        return this.dataNascimento;
    }

    public void setDataNascimento(String datanascimento){
        this.dataNascimento = datanascimento;
    }
    
    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }
    
    public Double getSalario(){
        return this.salario;
    }

    public void setSalario(Double salario){
        this.salario = salario;
    }
    
}
