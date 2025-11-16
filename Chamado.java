public class Chamado {
    private static int contador = 1;
    private int id;
    private String descricao;
    private Cliente solicitante;
    private AnalistaTI responsavel; // pode ser null
    private String status; // "Aberto", "Atribuido", "Fechado"

    public Chamado(String descricao, Cliente solicitante) {
        this.id = contador++;
        this.descricao = descricao;
        this.solicitante = solicitante;
        this.responsavel = null;
        this.status = "Aberto";
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Cliente getSolicitante() {
        return solicitante;
    }

    public AnalistaTI getResponsavel() {
        return responsavel;
    }

    public String getStatus() {
        return status;
    }

    public void atribuir(AnalistaTI a) {
        this.responsavel = a;
        this.status = "Atribuido";
    }

    public void fechar() {
        this.status = "Fechado";
    }

    public void mostrarResumo() {
        System.out.println("ID: " + id + " | Status: " + status + " | Descrição: " + descricao);
        System.out.println("Solicitante: " + solicitante.getNome() + " (Mat: " + solicitante.getMatricula() + ")");
        if (responsavel != null) {
            System.out.println("Responsável: " + responsavel.getNome());
        } else {
            System.out.println("Responsável: (não atribuído)");
        }
    }
}