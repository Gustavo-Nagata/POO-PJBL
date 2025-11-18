import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InterfaceController {

    // --- Componentes da Tela (FXML) ---
    @FXML private ComboBox<Cliente> comboSolicitante;
    @FXML private TextField txtDescricao;
    @FXML private TableView<Chamado> tabelaChamados;
    @FXML private TableColumn<Chamado, String> colId;
    @FXML private TableColumn<Chamado, String> colDesc;
    @FXML private TableColumn<Chamado, String> colStatus;
    @FXML private TableColumn<Chamado, String> colSolicitante;
    @FXML private TableColumn<Chamado, String> colResponsavel;

    @FXML private ComboBox<AnalistaTI> comboAnalistas;
    @FXML private ListView<String> listaClientesView;
    @FXML private ListView<String> listaAnalistasView;

    // --- Listas de Dados ---
    private ObservableList<Chamado> listaChamadosObs = FXCollections.observableArrayList();
    private List<Cliente> clientes = new ArrayList<>();
    private List<AnalistaTI> analistas = new ArrayList<>();
    private List<Chamado> chamadosBackend = new ArrayList<>(); // Lista original do backend

    @FXML
    public void initialize() {
        carregarDadosCSV();
        configurarTabela();
        atualizarListasVisuais();
    }

    // --- 1. Configuração Inicial ---
    private void carregarDadosCSV() {
        String caminho = "colaboradores.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha = br.readLine(); // Pula cabeçalho
            linha = br.readLine();
            while (linha != null) {
                String[] dados = linha.split(",");
                if (dados[0].equals("CLIENTE")) {
                    clientes.add(new Cliente(dados[1], dados[2], dados[3], dados[4],
                            Integer.parseInt(dados[5]), Integer.parseInt(dados[6]), Float.parseFloat(dados[7])));
                } else if (dados[0].equals("ANALISTATI")) {
                    analistas.add(new AnalistaTI(dados[1], dados[2], dados[3], dados[4],
                            Integer.parseInt(dados[5]), Integer.parseInt(dados[6]), Float.parseFloat(dados[7]), Float.parseFloat(dados[8])));
                }
                linha = br.readLine();
            }
        } catch (Exception e) {
            mostrarAlerta("Erro", "Erro ao ler CSV: " + e.getMessage());
        }
    }

    private void configurarTabela() {
        // Ensina a tabela a pegar os dados do objeto Chamado
        colId.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getId())));
        colDesc.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDescricao()));
        colStatus.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStatus()));
        colSolicitante.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getSolicitante().getNome()));

        colResponsavel.setCellValueFactory(data -> {
            if (data.getValue().getResponsavel() != null)
                return new SimpleStringProperty(data.getValue().getResponsavel().getNome());
            return new SimpleStringProperty("-");
        });

        tabelaChamados.setItems(listaChamadosObs);
    }

    private void atualizarListasVisuais() {
        // Preenche os ComboBox e ListViews
        comboSolicitante.getItems().setAll(clientes);
        comboAnalistas.getItems().setAll(analistas);

        listaClientesView.getItems().clear();
        for (Cliente c : clientes) listaClientesView.getItems().add(c.getNome() + " (Mat: " + c.getMatricula() + ")");

        listaAnalistasView.getItems().clear();
        for (AnalistaTI a : analistas) listaAnalistasView.getItems().add(a.getNome() + " (Mat: " + a.getMatricula() + ")");
    }

    // --- 2. Ações dos Botões (Mapeando o Switch do Main.java) ---

    // Menu 3: Abrir Chamado
    @FXML
    public void abrirChamado() {
        Cliente solicitante = comboSolicitante.getValue();
        String desc = txtDescricao.getText();

        if (solicitante == null || desc.isEmpty()) {
            mostrarAlerta("Atenção", "Selecione um cliente e digite a descrição.");
            return;
        }

        solicitante.abrirChamado(desc, chamadosBackend);

        // Pega o último chamado adicionado para por na tabela
        Chamado novo = chamadosBackend.get(chamadosBackend.size() - 1);
        listaChamadosObs.add(novo);

        txtDescricao.clear();
        mostrarAlerta("Sucesso", "Chamado ID " + novo.getId() + " criado!");
    }

    // Menu 5: Atribuir Chamado
    @FXML
    public void atribuirChamado() {
        Chamado selecionado = tabelaChamados.getSelectionModel().getSelectedItem();
        AnalistaTI analista = comboAnalistas.getValue();

        if (selecionado == null || analista == null) {
            mostrarAlerta("Atenção", "Selecione um chamado na tabela e um analista no menu.");
            return;
        }

        try {
            analista.receberChamado(selecionado); // Usa sua lógica com Exception
            tabelaChamados.refresh(); // Atualiza a tabela visualmente
            mostrarAlerta("Sucesso", "Chamado atribuído a " + analista.getNome());
        } catch (Exception e) { // Captura ChamadoException se ocorrer
            mostrarAlerta("Erro", "Não foi possível atribuir: " + e.getMessage());
        }
    }

    // Menu 6: Fechar Chamado
    @FXML
    public void fecharChamado() {
        Chamado selecionado = tabelaChamados.getSelectionModel().getSelectedItem();
        if (selecionado == null) {
            mostrarAlerta("Atenção", "Selecione um chamado na tabela.");
            return;
        }

        try {
            selecionado.fechar(); // Usa sua lógica com Exception
            tabelaChamados.refresh();
            mostrarAlerta("Sucesso", "Chamado fechado!");
        } catch (Exception e) {
            mostrarAlerta("Erro", e.getMessage());
        }
    }

    // Menu 7: Mostrar Dados Analista (CORRIGIDO)
    @FXML
    public void mostrarDadosAnalista() {
        int index = listaAnalistasView.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            AnalistaTI a = analistas.get(index);

            // CORREÇÃO AQUI: Removemos o getSalario() e usamos apenas calcularSalario()
            mostrarAlerta("Dados do Analista",
                    "Nome: " + a.getNome() + "\n" +
                            "Matrícula: " + a.getMatricula() + "\n" +
                            "Salário Total (com comissão): " + a.calcularSalario());
        } else {
            mostrarAlerta("Atenção", "Selecione um analista na lista primeiro.");
        }
    }

    // Menu 0: Salvar e Sair
    @FXML
    public void salvarESair() {
        // Lógica de salvar
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("chamados_abertos.csv"))) {
            bw.write("ID,DESCRICAO,STATUS,SOLICITANTE_MATRICULA,RESPONSAVEL_MATRICULA");
            bw.newLine();
            for (Chamado c : chamadosBackend) {
                if (!c.getStatus().equals("Fechado")) {
                    String respMat = (c.getResponsavel() != null) ? String.valueOf(c.getResponsavel().getMatricula()) : "N/A";
                    bw.write(c.getId() + "," + c.getDescricao() + "," + c.getStatus() + "," + c.getSolicitante().getMatricula() + "," + respMat);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Fecha a janela
        Stage stage = (Stage) txtDescricao.getScene().getWindow();
        stage.close();
    }

    private void mostrarAlerta(String titulo, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}