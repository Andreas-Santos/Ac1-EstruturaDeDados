public class Pedido {
    private int codigo;
    private String pizza;
    private String tam;
    private String endereco;
    private float distancia;

    public Pedido() {
        
    }

    public Pedido(int codigo, String pizza, String tam, String endereco, float distancia){
        this.codigo = codigo;
        this.pizza = pizza;
        this.tam = tam;
        this.endereco = endereco;
        this.distancia = distancia;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public String getTam() {
        return tam;
    }

    public void setTam(String tam) {
        this.tam = tam;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    };
}