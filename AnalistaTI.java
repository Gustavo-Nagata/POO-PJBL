public class AnalistaTI extends Colaborador {
    private float comissaoPorChamado;
    private int quantChamados;

    public AnalistaTI(String nome, String cpf, String rg, String telefone, int ramal, int matricula, float salario, float comissaoPorChamado) {
        super(nome, cpf, rg, telefone, ramal, matricula, salario);
        this.comissaoPorChamado = comissaoPorChamado;
        this.quantChamados = 0;
    }

    // Recebe/assume um chamado e contabiliza
    public void receberChamado(Chamado c) {
        if (c != null) {
            c.atribuir(this);
            quantChamados++;
            System.out.println("Chamado ID " + c.getId() + " atribuído a " + nome);
        }
    }

    public float calcularSalarioComComissao() {
        return salario + (quantChamados * comissaoPorChamado);
    }

    @Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Comissão por chamado: " + comissaoPorChamado);
        System.out.println("Quantidade de chamados atendidos: " + quantChamados);
        System.out.println("Salário com comissão: " + calcularSalarioComComissao());
    }
}