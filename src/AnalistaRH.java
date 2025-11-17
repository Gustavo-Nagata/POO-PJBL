public class AnalistaRH extends Colaborador{

    public AnalistaRH(String nome, String cpf, String rg, String telefone, int ramal, int matricula, float salario) {
        super(nome, cpf, rg, telefone, ramal, matricula, salario);
    }

    public void executarTarefa() {
        System.out.println("Executando tarefas de recursos humanos...");
    }

    public void cadastrarFuncionario(String nomeFuncionario) {
        System.out.println("Funcionário " + nomeFuncionario + " cadastrado com sucesso!");
    }

    public void cadastrarCliente(String nomeCliente) {
        System.out.println("Funcionário " + nomeCliente + " cadastrado com sucesso!");
    }

    @Override
    public float calcularSalario() {
        // O salário do RH é apenas o base
        return this.salario;
    }
}