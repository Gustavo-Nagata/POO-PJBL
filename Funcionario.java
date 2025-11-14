public abstract class Funcionario extends Usuario {
    protected double salarioBase;
    protected String departamento;

    public Funcionario(int id, String nome, String email, String senha, double salarioBase, String departamento) {
        super(id, nome, email, senha);
        this.salarioBase = salarioBase;
        this.departamento = departamento;
    }

    public abstract void executarTarefa(); // método abstrato

    public void atualizarChamado(Chamado chamado, String status) {
        chamado.setStatus(status);
        System.out.println("Chamado atualizado por " + nome);
    }

    @Override
    public void exibirMenu() {
        System.out.println("=== MENU FUNCIONÁRIO ===");
        System.out.println("1. Atender chamado");
        System.out.println("2. Atualizar chamado");
    }
}
