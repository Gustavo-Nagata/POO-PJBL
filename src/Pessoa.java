import java.time.LocalDate;

public abstract class Pessoa {
    protected String nome;
    protected String cpf;
    protected String rg;
    protected String telefone;

    public Pessoa(String nome, String cpf, String rg, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getTelefone() { return telefone; }

    public void mostrarDados() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Rg: " + rg);
        System.out.println("Telefone: " + telefone);
    }
}