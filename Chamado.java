public class Chamado {
    private static int contador = 1;
    private int id;
    private String descricao;
    private String status;
    private Cliente cliente;

    public Chamado(String descricao, Cliente cliente) {
        this.id = contador++;
        this.descricao = descricao;
        this.status = "Aberto";
        this.cliente = cliente;
    }

    public int getId() { return id; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Chamado #" + id + " - " + descricao + " (" + status + ")";
    }
}
