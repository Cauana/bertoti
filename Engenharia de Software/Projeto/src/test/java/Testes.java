import org.junit.Test;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import static org.junit.Assert.*;

public class Testes {

    @Test
    public void adicionarMembroTest() {
        Usuario usuario1 = new Usuario("João", "joao123", "senha123");
        Usuario usuario2 = new Usuario("Cauana", "cauana123", "cau123");
        List<Usuario> listaMembros = new ArrayList<>();
        List<Despesa> listaDespesas = new ArrayList<>();
        Grupo grupo = new Grupo(1, "fullmad", listaMembros, listaDespesas);

        grupo.adicionarMembro(usuario1);
        grupo.adicionarMembro(usuario2);

        List<Usuario> membrosEsperados = new ArrayList<>();
        membrosEsperados.add(usuario1);
        membrosEsperados.add(usuario2);

        Assert.assertEquals(membrosEsperados, grupo.getMembros());
    }
}