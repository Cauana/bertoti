import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class TesteTest {
    @Test
    public void testeInicial() {
      
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
    

    @Test
    public void adicionarDespesaTest() {
        Usuario usuario1 = new Usuario("João", "joao123", "senha123");
        Usuario usuario2 = new Usuario("Cauana", "cauana123", "cau123");
        List<Usuario> listaMembros = new ArrayList<>();
        List<Despesa> listaDespesas = new ArrayList<>();
        Grupo grupo = new Grupo(1, "fullmad", listaMembros, listaDespesas);
        grupo.adicionarMembro(usuario1);
        grupo.adicionarMembro(usuario2);

        Despesa despesa1 = new Despesa(1, "Almoço", 50.0f, usuario1, new HashMap<>());
        grupo.adicionarDespesa(despesa1);

        assertEquals(1, grupo.getDespesas().size());
        assertTrue(grupo.getDespesas().contains(despesa1));
    }

    @Test
    public void removerMembroTest() {
        Usuario usuario1 = new Usuario("João", "joao123", "senha123");
        Usuario usuario2 = new Usuario("Cauana", "cauana123", "cau123");
        List<Usuario> listaMembros = new ArrayList<>();
        List<Despesa> listaDespesas = new ArrayList<>();
        Grupo grupo = new Grupo(1, "fullmad", listaMembros, listaDespesas);
        grupo.adicionarMembro(usuario1);
        grupo.adicionarMembro(usuario2);

        grupo.removerMembro(usuario1);

        assertEquals(1, grupo.getMembros().size());
        assertFalse(grupo.getMembros().contains(usuario1));
    }

    @Test
    public void removerDespesaTest() {
        Usuario usuario1 = new Usuario("João", "joao123", "senha123");
        Usuario usuario2 = new Usuario("Cauana", "cauana123", "cau123");
        List<Usuario> listaMembros = new ArrayList<>();
        List<Despesa> listaDespesas = new ArrayList<>();
        Grupo grupo = new Grupo(1, "fullmad", listaMembros, listaDespesas);
        grupo.adicionarMembro(usuario1);
        grupo.adicionarMembro(usuario2);

        Despesa despesa1 = new Despesa(1, "Almoço", 50.0f, usuario1, new HashMap<>());
        grupo.adicionarDespesa(despesa1);
        grupo.removerDespesa(despesa1);

        assertEquals(0, grupo.getDespesas().size());
        assertFalse(grupo.getDespesas().contains(despesa1));
    }
    
    @Test
    public void calcularValorDivisaoTest() {
        Usuario usuario1 = new Usuario("João", "joao123", "senha123");
        Usuario usuario2 = new Usuario("Cauana", "cauana123", "cau123");

        Map<Usuario, Float> divisao = new HashMap<>();
        divisao.put(usuario1, 25.0f);
        divisao.put(usuario2, 75.0f);

        Despesa despesa = new Despesa(1, "Jantar", 100.0f, usuario1, divisao);

        assertEquals(25.0f, despesa.getValorDivisao(usuario1), 0.01f);  // Esperado: 25.0
        assertEquals(75.0f, despesa.getValorDivisao(usuario2), 0.01f);  // Esperado: 75.0
    }

    }