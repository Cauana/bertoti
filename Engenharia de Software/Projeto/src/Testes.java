import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

public class Testes {

    @Test
    public void testAdicionarMembro() {
        Usuario usuario1 = new Usuario("João", "joao123", "senha123");
        Usuario usuario2 = new Usuario("Cauana", "cauana123", "cau123");
        List<Usuario> listaMembros = new ArrayList<Usuario>();
        List<Despesa> listaDespesas = new ArrayList<Despesa>();
        Grupo grupo = new Grupo(1,"fullmad", listaMembros, listaDespesas);

        grupo.adicionarMembro(usuario1);
        grupo.adicionarMembro(usuario2);

        assertEquals(2, grupo.getMembros().size());
        assertEquals(usuario1, grupo.getMembros().get(0));
        assertEquals(usuario2, grupo.getMembros().get(1));
    }

    @Test
    public void testGetNome() {
        Usuario usuario1 = new Usuario("João", "joao123", "senha123");
        List<Usuario> listaMembros = new ArrayList<Usuario>();
        List<Despesa> listaDespesas = new ArrayList<Despesa>();
        Grupo grupo = new Grupo(1,"fullmad", listaMembros, listaDespesas);

        assertEquals("fullmad", grupo.getNome());
    }

}