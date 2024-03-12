public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        
        cliente.setEmprestimo(new Proibido());

        cliente.getEmprestimo().emprestar();
    }
}
