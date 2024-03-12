public class Aluno extends Pessoa {
    private String curso;
    private String periodo;

    public Aluno(String nome, int matricula, String curso, String periodo) {
        super(nome, matricula);
        this.curso = curso;
        this.periodo = periodo;
    }
    
}
