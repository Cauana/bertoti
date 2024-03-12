public class Pessoa {
    private String nome;
    private String matricula;

    public Pessoa(String nome, int matricula){
        this.nome = nome;
        this.matricula = matricula;
    
    }

    public static void matricular() {
        System.out.println("Matrícula efetuada!");
        
    }
}
