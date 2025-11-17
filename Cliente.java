import java.util.List;

public class Cliente extends Colaborador {

    public Cliente(String nome, String cpf, String rg, String telefone, int ramal, int matricula, float salario) {
        super(nome, cpf, rg, telefone, matricula, ramal, salario);
    }

    // Abre um chamado e adiciona à lista de chamados do sistema
    public void abrirChamado(String descricao, List<Chamado> listaChamados) {
        if (descricao == null || descricao.trim().isEmpty()) {
            System.out.println("Descrição inválida.");
            return;
        }
        Chamado c = new Chamado(descricao, this);
        listaChamados.add(c);
        System.out.println("Chamado criado com ID " + c.getId());
    }
    @Override
    public float calcularSalario() {
        return this.salario;
    }
}