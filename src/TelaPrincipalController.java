import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert; // Para mostrar pop-ups
import java.util.ArrayList;
import java.util.List;

public class TelaPrincipalController {

    // --- LIGAÇÕES COM O FXML ---
    // Estas variáveis são automaticamente preenchidas pelo JavaFX
    @FXML
    private ListView<String> listaClientes; // Mostra Clientes

    @FXML
    private ListView<String> listaChamados; // Mostra Chamados

    @FXML
    private TextArea campoDescricao; // Campo para escrever o novo chamado

    @FXML
    private Button botaoAbrirChamado; // Botão para criar


    // --- DADOS DO "BACK-END" ---
    private List<Chamado> chamados = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<AnalistaTI> analistaTIS = new ArrayList<>();


    // O método initialize() é chamado automaticamente quando a tela é criada
    @FXML
    public void initialize() {
        carregarDadosExemplo(); // Carrega os dados de exemplo

        atualizarListaClientes(); // Mostra os clientes na lista

        System.out.println("Controlador iniciado e listas atualizadas.");
    }

    // --- MÉTODOS DE AÇÃO (LIGADOS AOS BOTÕES) ---

    // Este método é chamado pelo onAction="#handleAbrirChamado" do botão
    @FXML
    private void handleAbrirChamado() {
        String descricao = campoDescricao.getText();

        // Pega o primeiro cliente da lista (só para este exemplo)
        if (clientes.isEmpty()) {
            mostrarAlerta("Erro", "Nenhum cliente carregado para abrir chamado.");
            return;
        }
        Cliente solicitante = clientes.get(0); // Vamos usar o "Gustavo"

        // Validação simples
        if (descricao == null || descricao.trim().isEmpty()) {
            mostrarAlerta("Erro", "A descrição não pode estar vazia.");
            return;
        }

        // Usa o método da sua classe Cliente!
        solicitante.abrirChamado(descricao, chamados);

        // Limpa o campo de texto e atualiza a lista de chamados
        campoDescricao.clear();
        atualizarListaChamados();

        System.out.println("Novo chamado criado pelo " + solicitante.getNome());
    }


    // --- MÉTODOS AUXILIARES ---

    // Atualiza a lista gráfica de Clientes
    private void atualizarListaClientes() {
        listaClientes.getItems().clear(); // Limpa a lista
        for (Cliente c : clientes) {
            // Adiciona o nome e matrícula à lista
            listaClientes.getItems().add(c.getNome() + " (Mat: " + c.getMatricula() + ")");
        }
    }

    // Atualiza a lista gráfica de Chamados
    private void atualizarListaChamados() {
        listaChamados.getItems().clear(); // Limpa a lista
        for (Chamado c : chamados) {
            // Adiciona o ID e Descrição do chamado
            listaChamados.getItems().add("ID " + c.getId() + ": " + c.getDescricao());
        }
    }

    // Método simples para mostrar um pop-up de alerta
    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null); // Sem cabeçalho
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    // Método privado para carregar dados (simplificado do seu Main.java)
    private void carregarDadosExemplo() {
        try {
            Cliente u1 = new Cliente("Gustavo (GUI)", "222-222-222-22", "55555G-55", "3232-3232", 32, 12983, 2000f);
            Cliente u2 = new Cliente("Ana (GUI)", "333-333-333-33", "66666G-66", "3434-3434", 34, 12984, 2000f);
            clientes.add(u1);
            clientes.add(u2);

            AnalistaTI a1 = new AnalistaTI("Jorge (GUI)", "111-111-111-11", "44444G-44", "3030-3030", 30, 23948, 3000f,  250f);
            analistaTIS.add(a1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}