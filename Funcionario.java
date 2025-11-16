public abstract class Funcionario extends Usuario {
    protected double salarioBase;
    protected String departamento;

    // Construtor que chama o construtor da classe pai (Usuario) usando 'super()'
    // e inicializa os atributos específicos de Funcionario.
    public Funcionario(int id, String nome, String email, String senha, double salarioBase, String departamento) {
        super(id, nome, email, senha);
        this.salarioBase = salarioBase;
        this.departamento = departamento;
    }

    // Método abstrato que força as subclasses a definirem sua própria tarefa.
    public abstract void executarTarefa(); 



}
