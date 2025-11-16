public abstract class Usuario {
    protected  int id;
    protected  String nome;
    protected  String email;
    protected  String senha;

    // Construtor que inicializa os atributos de um objeto Usuario.
    public Usuario(int id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }


    // Método de autenticação
    public boolean login(String email, String senha) {
        return this.email.equals(email) && this.senha.equals(senha);
    }

    // Método de sair do sistema.
    public void logout() {
        System.out.println(nome + " saiu do sistema.");
    }

    // Getters e Setters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public void setSenha(String novaSenha) { this.senha = novaSenha; }
}
