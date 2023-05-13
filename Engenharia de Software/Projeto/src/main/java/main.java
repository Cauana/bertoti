import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args){
        Usuario usuario1 = new Usuario("João", "joao123", "senha123");
        Usuario usuario2 = new Usuario("Cauana", "cauana123", "cau123");
        System.out.println(usuario1.getNome());
        List<Usuario> listaMembros = new ArrayList<Usuario>();
        List<Despesa> listaDespesas = new ArrayList<Despesa>();
        Grupo grupo = new Grupo(1,"fullmad", listaMembros, listaDespesas);

        grupo.adicionarMembro(usuario1);
        grupo.adicionarMembro(usuario2);
        System.out.println(grupo.getMembros());

        for(Usuario membro : grupo.getMembros()) {
            System.out.println(membro.getNome());
        }
        }
    }

