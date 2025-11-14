import java.util.ArrayList;

/**
 * Classe principal para demonstrar o funcionamento do sistema de POO.
 * * Simula a criação de usuários, gestão de chamados e tarefas
 * específicas de cada tipo de funcionário.
 */
public class Main {

    public static void main(String[] args) {

        // --- 1. Criação dos Usuários ---
        System.out.println("--- 1. Criando Usuários ---");

        // Criando um Analista de TI
        AnalistaTI alanTuring = new AnalistaTI(1, "Alan Turing", "alan@ti.com", "senha123", 5000.00);
        
        // Criando um Analista de RH
        AnalistaRH robertaHumanos = new AnalistaRH(2, "Roberta Humanos", "roberta@rh.com", "senha456", 4500.00);
        
        // Criando um Cliente
        Cliente carlaCliente = new Cliente(3, "Carla Cliente", "carla@cliente.com", "senha789");

        System.out.println("Usuários criados:");
        System.out.println("- " + alanTuring.getNome() + " (Departamento: " + alanTuring.departamento + ")");
        System.out.println("- " + robertaHumanos.getNome() + " (Departamento: " + robertaHumanos.departamento + ")");
        System.out.println("- " + carlaCliente.getNome() + " (Cliente)");
        System.out.println();

        // --- 2. Simulação de Login e Menus (Polimorfismo) ---
        System.out.println("--- 2. Simulação de Login e Menus ---");
        
        if (carlaCliente.login("carla@cliente.com", "senha789")) {
            System.out.println("Login de " + carlaCliente.getNome() + " bem-sucedido!");
            carlaCliente.exibirMenu(); // Menu específico do Cliente
        }
        System.out.println();

        if (alanTuring.login("alan@ti.com", "senha123")) {
            System.out.println("Login de " + alanTuring.getNome() + " bem-sucedido!");
            alanTuring.exibirMenu(); // Menu específico do Funcionario
        }
        System.out.println();


        // --- 3. Fluxo de Chamado (Cliente -> TI) ---
        System.out.println("--- 3. Fluxo de Chamado (Cliente -> TI) ---");
        
        // Cliente cria um chamado
        System.out.println(carlaCliente.getNome() + " está criando um chamado...");
        carlaCliente.criarChamado("Meu computador não liga");
        System.out.println();

        // Recuperando o chamado criado (em um sistema real, isso viria de um banco de dados)
        ArrayList<Chamado> chamadosDaCarla = carlaCliente.getListaChamados();
        if (!chamadosDaCarla.isEmpty()) {
            Chamado chamadoComputador = chamadosDaCarla.get(0); // Pega o primeiro chamado
            
            System.out.println("Status atual: " + chamadoComputador); // Mostra "Aberto"

            // Analista de TI atende o chamado
            System.out.println(alanTuring.getNome() + " vai atender o chamado...");
            alanTuring.escolherChamado(chamadoComputador);
            alanTuring.atenderChamado(chamadoComputador);
            System.out.println("Status atual: " + chamadoComputador); // Mostra "Em atendimento"

            // Analista de TI (como Funcionario) atualiza o status final
            alanTuring.atualizarChamado(chamadoComputador, "Resolvido");
            System.out.println("Status final: " + chamadoComputador); // Mostra "Resolvido"
        }
        System.out.println();

        // --- 4. Fluxo de RH ---
        System.out.println("--- 4. Fluxo de RH ---");
        
        // Analista de RH cadastra um novo funcionário
        robertaHumanos.cadastrarFuncionario("Novo Estagiário de TI");
        
        // Analista de RH atualiza o salário do Analista de TI
        System.out.println("Salário antigo do " + alanTuring.getNome() + ": R$" + alanTuring.salarioBase);
        robertaHumanos.atualizarSalario(alanTuring, 5500.00);
        System.out.println("Salário novo do " + alanTuring.getNome() + ": R$" + alanTuring.salarioBase);
        System.out.println();

        // --- 5. Demonstração de Métodos Abstratos (Polimorfismo) ---
        System.out.println("--- 5. Demonstração de Polimorfismo (executarTarefa) ---");
        
        System.out.print(alanTuring.getNome() + " (AnalistaTI): ");
        alanTuring.executarTarefa(); // Tarefa de TI

        System.out.print(robertaHumanos.getNome() + " (AnalistaRH): ");
        robertaHumanos.executarTarefa(); // Tarefa de RH
        System.out.println();

        // --- 6. Logout ---
        System.out.println("--- 6. Logout ---");
        carlaCliente.logout();
        alanTuring.logout();
        robertaHumanos.logout();
    }
}