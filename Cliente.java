import java.util.ArrayList;

public class Cliente extends Usuario {
    // Atributo específico de Cliente: uma lista de Chamados que o cliente abriu
    private ArrayList<Chamado> listaChamados = new ArrayList<>();

    // Construtor: Chama o construtor da classe pai (Usuario).
    public Cliente(int id, String nome, String email, String senha) {
        super(id, nome, email, senha);
    }

    // Implementa o método abstrato 'exibirMenu()' de Usuario
    
    public void exibirMenu() {
        System.out.println("=== MENU CLIENTE ===");
        System.out.println("1. Criar chamado");
        System.out.println("2. Atualizar chamado");
    }

    // Métodos específicos de Cliente
    public void criarChamado(String descricao) {
        Chamado chamado = new Chamado(descricao, this);
        listaChamados.add(chamado);
        System.out.println("Chamado criado com sucesso!");
    }

    public void atualizarChamado(int id, String novaDescricao) {
        for (Chamado c : listaChamados) {
            if (c.getId() == id) {
                c.setDescricao(novaDescricao);
                System.out.println("Chamado atualizado!");
                return;
            }
        }
        System.out.println("Chamado não encontrado.");
    }

    // Getter para a lista de chamados do cliente.
    public ArrayList<Chamado> getListaChamados() {
        return listaChamados;
    }
}
