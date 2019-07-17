package sistema.entidades;

public class Cargo {
    
    public Cargo(){
    }
    
    private int id;
    private String nome;
    
    public int getid(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }
    
    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
}
