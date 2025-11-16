public abstract class Colaborador extends Pessoa {
    protected int ramal;
    protected int matricula;
    protected float salario;

    public Colaborador(String nome, String cpf, String rg, String telefone, int ramal, int matricula, float salario) {
        super(nome, cpf, rg, telefone);
        this.salario = salario;
        this.matricula = matricula;
        this.ramal = ramal;
    }

    public int getRamal() { return ramal; }

    public int getMatricula() { return matricula; }

    public float getSalario() {
        return salario;
    }


    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Ramal: " + ramal);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Salário base: " + salario);

    }
}