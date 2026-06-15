package model;
/*Classe Paciente que herda a classe pessoa */
public class Paciente extends Pessoa {
/*Atributos da classe Paciente */
    private String cpf;
    private String dataNascimento;
    private String endereco;
/*Construtor da classe Paciente */
    public Paciente(int id, String nome, String telefone, String email, String cpf,
        String dataNascimento, String endereco){
            //Tratamento de exceções
            if(cpf == null || cpf.length() !=11){
                throw new IllegalArgumentException("CPF deve conter 11 dígitos");
            }
            if(nome == null || nome.isBlank()){
                throw new IllegalArgumentException("Nome do paciente é obrigatório");
            }
            super(id, nome, telefone, email);
            this.cpf = cpf;
            this.dataNascimento = dataNascimento;
            this.endereco = endereco;
    }
/*Método para atualizar cadastro */
    public void atualizarCadastro(String novoNome,String novoTelefone, String novoEmail, String novoEndereco ){
            setNome(novoNome);
            setTelefone(novoTelefone);
            setEmail(novoEmail);
            this.endereco = novoEndereco;
    }
 /*Metodos getters(retorno de informações) */
    public String getCpf(){
        return cpf;
    }
    public String getDataNascimento(){
        return dataNascimento;
    }
    public String getEndereco(){
        return endereco;
    }
/*Sobreescrita do método getDados para atender as particularidades da Classe Paciente */
    @Override
/*Método de retorno das informações de paciente concatenadas */
    public String getDados(){
        return "Paciente: " + getNome() +
        "\nCPF: " + this.cpf +
        "\n Data de Nascimento: " + this.dataNascimento +
        "\nTelefone: " + getTelefone() +
        "\nEmail: " + getEmail() +
        "\nEndereço: " + this.endereco;
    }
}
