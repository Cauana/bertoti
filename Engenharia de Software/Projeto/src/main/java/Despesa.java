
import java.util.Map;

public class Despesa {
    private int id;
    private String descricao;
    private float valorTotal;
    private Usuario donoConta;
    private Map<Usuario, Float> divisao;

    public Despesa(int id, String descricao, float valorTotal, Usuario donoConta, Map<Usuario, Float> divisao) {
        this.id = id;
        this.descricao = descricao;
        this.valorTotal = valorTotal;
        this.donoConta = donoConta;
        this.divisao = divisao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public Usuario getDonoConta() {
        return donoConta;
    }

    public Map<Usuario, Float> getDivisao() {
        return divisao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setDonoConta(Usuario donoConta) {
        this.donoConta = donoConta;
    }

    public void setDivisao(Map<Usuario, Float> divisao) {
        this.divisao = divisao;
    }

    public float getValorDivisao(Usuario usuario) {
        return divisao.getOrDefault(usuario, 0.0f);
    }

    public void setValorDivisao(Usuario usuario, float valor) {
        divisao.put(usuario, valor);
    }

    public float getValorPendente() {
        float valorPago = 0.0f;
        for (float valor : divisao.values()) {
            valorPago += valor;
        }
        return valorTotal - valorPago;
    }}