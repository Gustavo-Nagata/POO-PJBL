public class AnalistaTI extends Funcionario {

    public AnalistaTI(int id, String nome, String email, String senha, double salarioBase) {
        super(id, nome, email, senha, salarioBase, "TI");
    }

    @Override
    public void executarTarefa() {
        System.out.println("Executando tarefas de suporte técnico...");
    }

    public void atenderChamado(Chamado chamado) {
        chamado.setStatus("Em atendimento");
        System.out.println("Atendendo chamado: " + chamado.getDescricao());
    }

    public void retrabalharChamado(Chamado chamado) {
        chamado.setStatus("Em retrabalho");
        System.out.println("Chamado em retrabalho: " + chamado.getDescricao());
    }

    public void escolherChamado(Chamado chamado) {
        System.out.println("Chamado selecionado: " + chamado.getDescricao());
    }
}
