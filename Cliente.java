import java.util.ArrayList;

public class Cliente extends Usuario {
    private ArrayList<Chamado> listaChamados = new ArrayList<>();

    public Cliente(int id, String nome, String email, String senha) {
        super(id, nome, email, senha);
    }

    @Override
    public void exibirMenu() {
        System.out.println("=== MENU CLIENTE ===");
        System.out.println("1. Criar chamado");
        System.out.println("2. Atualizar chamado");
    }

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

    public ArrayList<Chamado> getListaChamados() {
        return listaChamados;
    }
}
