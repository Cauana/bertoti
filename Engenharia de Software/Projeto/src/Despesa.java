import java.util.HashMap;

public class Despesa {
    private int id;
    private String descricao;
    private Float valor_total;
    private Usuario dono_conta;
    private HashMap divisao;

    public Despesa(int id, String descricao, Float valor_total, Usuario dono_conta, HashMap divisao) {
        this.id = id;
        this.descricao = descricao;
        this.valor_total = valor_total;
        this.dono_conta = dono_conta;
        this.divisao = divisao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getValor_total() {
        return valor_total;
    }

    public void setValor_total(Float valor_total) {
        this.valor_total = valor_total;
    }

    public Usuario getDono_conta() {
        return dono_conta;
    }

    public void setDono_conta(Usuario dono_conta) {
        this.dono_conta = dono_conta;
    }

    public HashMap getDivisao() {
        return divisao;
    }

    public void setDivisao(HashMap divisao) {
        this.divisao = divisao;
    }
}
