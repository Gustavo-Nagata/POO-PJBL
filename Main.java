import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Chamado> chamados = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();
        List<AnalistaTI> analistaTIS = new ArrayList<>();

        // exemplos iniciais simples
        Cliente u1 = new Cliente("Gustavo", "222-222-222-22", "555555-55", "3232-3232", 32, 12983, 2000f);
        Cliente u2 = new Cliente("Ana", "333-333-333-33", "666666-66", "3434-3434", 34, 12984, 2000f);
        clientes.add(u1);
        clientes.add(u2);

        AnalistaTI a1 = new AnalistaTI("Jorge", "111-111-111-11", "444444-44", "3030-3030", 30, 23948, 3000f,  250f);
        analistaTIS.add(a1);

        Scanner sc = new Scanner(System.in);
        int opc = -1;

        while (opc != 0) {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Listar usuarios");
            System.out.println("2 - Listar analistaTIS");
            System.out.println("3 - Usuario abre chamado");
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
                        chFechar.fechar();
                        System.out.println("Chamado fechado.");
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
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        sc.close();
    }
}