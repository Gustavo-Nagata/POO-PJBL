public class AnalistaRH extends Funcionario {

     // Construtor: Chama o construtor da classe pai (Funcionario) e define o departamento como "RH"
    public AnalistaRH(int id, String nome, String email, String senha, double salarioBase) {
        super(id, nome, email, senha, salarioBase, "RH");
    }

    // Implementa o método abstrato 'executarTarefa()' de Funcionario.
    @Override
    public void executarTarefa() {
        System.out.println("Executando tarefas de recursos humanos...");
    }

    // Métodos específicos do Analista de RH.
    public void cadastrarFuncionario(String nomeFuncionario) {
        System.out.println("Funcionário " + nomeFuncionario + " cadastrado com sucesso!");
    }

    
    public double calcularSalario(double base, double bonus) {
        double total = base + bonus;
        System.out.println("Salário calculado: R$" + total);
        return total;
    }

    
    public void atualizarComissao(Funcionario f, double novaComissao) {
        System.out.println("Comissão atualizada para funcionário: " + f.nome);
    }

    
    public void atualizarSalario(Funcionario f, double novoSalario) {
        f.salarioBase = novoSalario;
        System.out.println("Salário atualizado para: " + f.nome);
    }


}
