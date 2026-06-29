package model;
/** Classe Abstrata (Abstrata pois não guarda a instancia de um objeto e serve de molde para as classes Paciente e Dentista) Pessoa */
public abstract class Pessoa {
/** Atributos da Classe Pessoa */
    private int id;
    private String nome;
    private String telefone;
    private String email;
/** Construtor da classe Pessoa */
    public Pessoa(int id, String nome, String telefone, String email){
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }
/** Metodos de retorno de informações */
    //retorno de ID
   public int getId(){
        return id;
   }
   //Retorno de Nome
   public String getNome(){
        return nome;
   }
   //Retorno de Telefone
   public String getTelefone(){
        return telefone;
   }
   //Retorno de Email
   public String getEmail(){
        return email;
   }
/** Metodos para settar informações */
   //Metodo para settar nome
   public void setNome(String nome){
        this.nome = nome;
   }
   //Metodo para settar Telefone
   public void setTelefone(String telefone){
        this.telefone = telefone;
   }
   //Metodo para settar Email
   public void setEmail(String email){
        this.email = email;
   }
   //Metodo abstrato getDados para garantir que as subclasses implementaram esse metodo
   public abstract String getDados();
}
