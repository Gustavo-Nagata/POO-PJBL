import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Chamado> chamados = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();
        List<AnalistaTI> analistaTIS = new ArrayList<>();

        String caminhoFicheiro = "colaboradores.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoFicheiro))) {
            String linha = br.readLine(); // Lê a primeira linha (cabeçalho)

            // Ignora o cabeçalho, vamos para a próxima linha
            linha = br.readLine();

            while (linha != null) {
                String[] dados = linha.split(","); // Divide a linha pela vírgula

                String tipo = dados[0];
                String nome = dados[1];
                String cpf = dados[2];
                String rg = dados[3];
                String telefone = dados[4];
                int ramal = Integer.parseInt(dados[5]);
                int matricula = Integer.parseInt(dados[6]);
                float salario = Float.parseFloat(dados[7]);
                float extra = Float.parseFloat(dados[8]); // comissao ou 0

                if (tipo.equals("CLIENTE")) {
                    Cliente c = new Cliente(nome, cpf, rg, telefone, ramal, matricula, salario);
                    clientes.add(c);
                } else if (tipo.equals("ANALISTATI")) {
                    // O valor 'extra' é usado como comissão
                    AnalistaTI a = new AnalistaTI(nome, cpf, rg, telefone, ramal, matricula, salario, extra);
                    analistaTIS.add(a);
                }

                linha = br.readLine(); // Lê a próxima linha
            }
            System.out.println("Dados carregados de " + caminhoFicheiro + " com sucesso.");

        } catch (IOException e) {
            System.out.println("Erro ao ler o ficheiro: " + e.getMessage());
            // Se der erro a ler, cria os dados de exemplo para o programa não falhar
            System.out.println("A carregar dados de exemplo...");
            Cliente u1 = new Cliente("Gustavo (Exemplo)", "222-222-222-22", "555555-55", "3232-3232", 32, 12983, 2000f);
            clientes.add(u1);
            AnalistaTI a1 = new AnalistaTI("Jorge (Exemplo)", "111-111-111-11", "444444-44", "3030-3030", 30, 23948, 3000f,  250f);
            analistaTIS.add(a1);
        }

        Scanner sc = new Scanner(System.in);
        int opc = -1;

        while (opc != 0) {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Listar usuários");
            System.out.println("2 - Listar analistaTIS");
            System.out.println("3 - Usuário abre chamado");
            System.out.println("4 - Listar chamados");
            System.out.println("5 - Atribuir chamado a admin");
            System.out.println("6 - Fechar chamado");
            System.out.println("7 - Mostrar dados de admin");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            try {
                opc = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                opc = -1;
            }

            switch (opc) {
                case 1:
                    System.out.println("-- Usuários cadastrados --");
                    for (int i = 0; i < clientes.size(); i++) {
                        Cliente uu = clientes.get(i);
                        System.out.println(i + " - " + uu.getNome() + " (Mat: " + uu.getMatricula() + ")");
                    }
                    break;
                case 2:
                    System.out.println("-- Admins cadastrados --");
                    for (int i = 0; i < analistaTIS.size(); i++) {
                        AnalistaTI aa = analistaTIS.get(i);
                        System.out.println(i + " - " + aa.getNome() + " (Mat: " + aa.getMatricula() + ")");
                    }
                    break;
                case 3:
                    System.out.println("-- Abrir chamado --");
                    System.out.print("Indice do usuário (ex: 0): ");
                    int idxU = Integer.parseInt(sc.nextLine());
                    if (idxU < 0 || idxU >= clientes.size()) {
                        System.out.println("Usuário inválido.");
                    } else {
                        System.out.print("Descrição do chamado: ");
                        String desc = sc.nextLine();
                        clientes.get(idxU).abrirChamado(desc, chamados);
                    }
                    break;
                case 4:
                    System.out.println("-- Chamados --");
                    if (chamados.isEmpty()) {
                        System.out.println("Nenhum chamado.");
                    } else {
                        for (Chamado c : chamados) {
                            c.mostrarResumo();
                            System.out.println("-------------------");
                        }
                    }
                    break;
                case 5:
                    System.out.println("-- Atribuir chamado --");
                    System.out.print("Indice do chamado (ID): ");
                    int idEscolhido = Integer.parseInt(sc.nextLine());
                    Chamado escolhido = null;
                    for (Chamado c : chamados) {
                        if (c.getId() == idEscolhido) {
                            escolhido = c;
                            break;
                        }
                    }
                    if (escolhido == null) {
                        System.out.println("Chamado não encontrado.");
                        break;
                    }
                    System.out.print("Indice do admin (ex: 0): ");
                    int idxA = Integer.parseInt(sc.nextLine());
                    if (idxA < 0 || idxA >= analistaTIS.size()) {
                        System.out.println("AnalistaTI inválido.");
                    } else {
                        analistaTIS.get(idxA).receberChamado(escolhido);
                    }
                    break;
                case 6:
                    System.out.println("-- Fechar chamado --");
                    System.out.print("ID do chamado: ");
                    int idFechar = Integer.parseInt(sc.nextLine());
                    Chamado chFechar = null;
                    for (Chamado c : chamados) {
                        if (c.getId() == idFechar) {
                            chFechar = c;
                            break;
                        }
                    }

                    if (chFechar != null) {
                        try {
                            chFechar.fechar();
                            System.out.println("Chamado fechado.");
                        } catch (ChamadoException e) {
                            System.out.println("Erro ao fechar chamado: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Chamado não encontrado.");
                    }
                    break;
                case 7:
                    System.out.print("Indice do admin (ex: 0): ");
                    int idxAdm = Integer.parseInt(sc.nextLine());
                    if (idxAdm < 0 || idxAdm >= analistaTIS.size()) {
                        System.out.println("AnalistaTI inválido.");
                    } else {
                        analistaTIS.get(idxAdm).mostrarDados();
                    }
                    break;
                case 0:
                    String ficheiroSaida = "chamados_abertos.csv";
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(ficheiroSaida))) {

                        // Escreve o cabeçalho
                        bw.write("ID,DESCRICAO,STATUS,SOLICITANTE_MATRICULA,RESPONSAVEL_MATRICULA");
                        bw.newLine();

                        int chamadosSalvos = 0;
                        for (Chamado c : chamados) {
                            // Só guarda chamados que NÃO estão fechados
                            if (!c.getStatus().equals("Fechado")) {
                                String responsavelMat = "N/A";
                                if (c.getResponsavel() != null) {
                                    responsavelMat = String.valueOf(c.getResponsavel().getMatricula());
                                }

                                String linha = c.getId() + "," +
                                        c.getDescricao() + "," +
                                        c.getStatus() + "," +
                                        c.getSolicitante().getMatricula() + "," +
                                        responsavelMat;

                                bw.write(linha);
                                bw.newLine();
                                chamadosSalvos++;
                            }
                        }
                        System.out.println(chamadosSalvos + " chamados não fechados foram salvos em " + ficheiroSaida);

                    } catch (IOException e) {
                        System.out.println("Erro ao salvar chamados: " + e.getMessage());
                    }

                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        sc.close();
    }
}