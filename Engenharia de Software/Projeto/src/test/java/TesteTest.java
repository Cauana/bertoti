import java.util.ArrayList;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TesteTest {
    @Test
    public void testeinicial() {
      
        Usuario usuario1 = new Usuario("João", "joao123", "senha123");
        Usuario usuario2 = new Usuario("Cauana", "cauana123", "cau123");
        List<Usuario> listaMembros = new ArrayList<>();
        List<Despesa> listaDespesas = new ArrayList<>();
        Grupo grupo = new Grupo(1, "fullmad", listaMembros, listaDespesas);
        grupo.adicionarMembro(usuario1);
        grupo.adicionarMembro(usuario2);
        
        
        assertEquals(2, grupo.getMembros().size());
        assertEquals("fullmad", grupo.getNome());

    }
    @Test
    public void segundoTeste() {
      
        Usuario usuario1 = new Usuario("João", "joao123", "senha123");
        Usuario usuario2 = new Usuario("Cauana", "cauana123", "cau123");
        List<Usuario> listaMembros = new ArrayList<>();
        List<Despesa> listaDespesas = new ArrayList<>();
        Grupo grupo = new Grupo(1, "fullmad", listaMembros, listaDespesas);
        grupo.adicionarMembro(usuario1);
        grupo.adicionarMembro(usuario2);
        
        
        assertEquals(2, grupo.getMembros().size());
        assertEquals("fullmad", grupo.getNome());

    }
}