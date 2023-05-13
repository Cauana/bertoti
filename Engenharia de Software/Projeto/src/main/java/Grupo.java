
import java.util.List;

public class Grupo {
    private int id;
    private String nome;
    private List<Usuario> membros;
    private List<Despesa> despesas;

    public Grupo(int id, String nome, List<Usuario> membros, List<Despesa> despesas) {
        this.id = id;
        this.nome = nome;
        this.membros = membros;
        this.despesas = despesas;
    }

    // Métodos getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Usuario> getMembros() {
        return membros;
    }

    public void setMembros(List<Usuario> membros) {
        this.membros = membros;
    }

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public void setDespesas(List<Despesa> despesas) {
        this.despesas = despesas;
    }

    // Métodos específicos da classe Grupo
    public void adicionarMembro(Usuario usuario) {
        membros.add(usuario);
    }

    public void adicionarDespesa(Despesa despesa) {
        despesas.add(despesa);
    }

    public void removerMembro(Usuario usuario) {
        membros.remove(usuario);
    }

    public void removerDespesa(Despesa despesa) {
        despesas.remove(despesa);
    }

}