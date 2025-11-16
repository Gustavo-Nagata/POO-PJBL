public class Chamado {
    // Usado para gerar IDs únicos automaticamente
    private static int contador = 1;
    // Outros atributos
    private int id;
    private String descricao;
    private String status;
    private Cliente cliente;

    // Construtor: Inicializa um novo chamado.
    public Chamado(String descricao, Cliente cliente) {
        this.id = contador++;
        this.descricao = descricao;
        this.status = "Aberto";
        this.cliente = cliente;
    }

    // Permitem acesso e modificação controlados dos atributos.
    public int getId() { return id; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Representação em string para facilitar a visualização do print de chamado
    @Override
    public String toString() {
        return "Chamado #" + id + " - " + descricao + " (" + status + ")";
    }
}
