public class AnalistaTI extends Funcionario {

    // Construtor: Chama o construtor da classe pai (Funcionario) e define o departamento como "TI".
    public AnalistaTI(int id, String nome, String email, String senha, double salarioBase) {
        super(id, nome, email, senha, salarioBase, "TI");
    }

    // Implementa o método abstrato 'executarTarefa()' de Funcionario.
    @Override
    public void executarTarefa() {
        System.out.println("Executando tarefas de suporte técnico...");
    }

    // Métodos específicos do Analista de TI.
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

    public void atualizarStatusChamado(Chamado chamado, String novoStatus) {
        chamado.setStatus(novoStatus);
        System.out.println("Chamado #" + chamado.getId() + " atualizado para '" + novoStatus + "' por " + nome);
    }

 
}
