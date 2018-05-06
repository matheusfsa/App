package classes;

public class Pessoa {
    private String nome;
    private String sobrenome;
    private String cpf;
    private String numero;
    private String data_nascimento;
    public Pessoa(String nome, String sobrenome, String cpf, String numero, String data_nascimento){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.numero = numero;
        this.data_nascimento = data_nascimento;
    }
    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNumero() {
        return numero;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
}
