public class Professor extends Pessoa{
    private String departamento;

    public Professor(String nome, int matricula, String departamento){
        super(nome, matricula);
        this.departamento = departamento;
    }
}