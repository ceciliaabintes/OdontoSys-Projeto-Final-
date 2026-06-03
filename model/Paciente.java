package model;

public class Paciente extends Pessoa {
    private String cpf;
    private String dataNascimento;
    private String endereco;
    public Paciente(int id, String nome, String telefone, String email, String cpf,
        String dataNascimento, String endereco){
            super();
            this.cpf = cpf;
            this.dataNascimento = dataNascimento;
            this.endereco = endereco;
    }
    public void AtualizarCadastro(String novoNome,String novoTelefone, String novoEmail, String novoEndereco ){
            setNome(novoNome);
            setTelefone(novoTelefone);
            setEmail(novoEmail);
            setNome(novoEndereco);
    }

    @Override
    public String getDados(){
        return "Paciente: " + getNome() +
        "\nCPF: " + this.cpf +
        "\n Data de Nascimento: " + this.dataNascimento +
        "\nTelefone: " + getTelefone() +
        "\nEmail: " + getEmail() +
        "\nEndereço: " + this.endereco;
    }
}