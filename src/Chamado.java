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

    // --- MUDANÇA DA ETAPA 2B ---
    // Adicionamos "throws ChamadoException" à assinatura
    public void atribuir(AnalistaTI a) throws ChamadoException {
        // Se o status NÃO for "Aberto", lança um erro
        if (!this.status.equals("Aberto")) {
            throw new ChamadoException("Não é possível atribuir um chamado que não está 'Aberto'. Status atual: " + this.status);
        }

        this.responsavel = a;
        this.status = "Atribuido";
    }

    // Adicionamos "throws ChamadoException" à assinatura
    public void fechar() throws ChamadoException {
        // Se o status JÁ FOR "Fechado", lança um erro
        if (this.status.equals("Fechado")) {
            throw new ChamadoException("Este chamado já está 'Fechado'.");
        }

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