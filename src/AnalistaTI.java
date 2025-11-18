public class AnalistaTI extends Colaborador {
    private float comissaoPorChamado;
    private int quantChamados;

    public AnalistaTI(String nome, String cpf, String rg, String telefone, int ramal, int matricula, float salario, float comissaoPorChamado) {
        super(nome, cpf, rg, telefone, ramal, matricula, salario);
        this.comissaoPorChamado = comissaoPorChamado;
        this.quantChamados = 0;
    }

    public void receberChamado(Chamado c) {
        if (c == null) {
            return; // Não faz nada se o chamado for nulo
        }

        try {
            // 1. Tenta atribuir o chamado
            c.atribuir(this);
            quantChamados++; // Só incrementa se a atribuição for bem-sucedida
            System.out.println("Chamado ID " + c.getId() + " atribuído a " + nome);

        } catch (ChamadoException e) {
            // 2. Se falhar (pegar a exceção), informa o usuário
            System.out.println("Erro ao atribuir chamado ID " + c.getId() + ": " + e.getMessage());
        }
    }

    @Override
    public float calcularSalario() {
        return salario + (quantChamados * comissaoPorChamado);
    }

    @Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Comissão por chamado: " + comissaoPorChamado);
        System.out.println("Quantidade de chamados atendidos: " + quantChamados);
        System.out.println("Salário total (com comissão): " + calcularSalario());
    }
    @Override
    public String toString() {
        return this.getNome(); // Assim o ComboBox mostra "Gustavo" em vez de "Cliente@34a2..."
    }
}
