import javax.swing.JOptionPane;

public class Fila {
    private int tamanho;
    private int inicio;
    private int fim;
    private int total;
    private Pedido vetor[];

    public Fila(int tam) {
        inicio = 0;
        fim = 0;
        total = 0;
        tamanho = tam;
        vetor = new Pedido[tam];
    }

    public boolean vazia() {
        if (total == 0)
            return true;
        else
            return false;
    }

    public boolean cheia() {
        if (total >= tamanho)
            return true;
        else
            return false;
    }

    public void enfileirar(Pedido elem) {
        if (!cheia()) {
            vetor[fim] = elem;
            fim++;
            total++;
            if (fim > tamanho)
                fim = 0;
        } else
            JOptionPane.showMessageDialog(null, "Fila cheia");
    }

    public Pedido desenfileirar() {
        Pedido elem;
        if (vazia() == false) {
            elem = vetor[inicio];
            inicio++;
            if (inicio > tamanho)
                inicio = 0;
            total--;
        } else
            elem = null;
        return elem;
    }

    public void exibeFila() {
        for (int i = inicio; i < fim; i++)
            JOptionPane.showMessageDialog(
                null,
                "Pedido " + i + ":" +
                "\nCódigo - " + vetor[i].getCodigo() +
                "\nSabor - " + vetor[i].getPizza() +
                "\nTamanho - " + vetor[i].getTam() +
                "\nEndereço - " + vetor[i].getEndereco() +
                "\nDistância - " + String.format("%.2f", vetor[i].getDistancia()));
    }
}