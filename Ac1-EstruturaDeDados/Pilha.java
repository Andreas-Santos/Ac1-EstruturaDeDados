import javax.swing.JOptionPane;

public class Pilha {
    // Declarando os atributos da classe
    int topo;
    int tamanho;
    Pedido vetor[];

    Pilha(int tam) {
        topo = -1; // Marca que a pilha está vazia
        tamanho = tam;
        vetor = new Pedido[tam];
    }

    public boolean vazia() {
        if (topo == -1)
            return true;
        else
            return false;
    }

    public boolean cheia() {
        if (topo == tamanho - 1)
            return true;
        else
            return false;
    }

    public void empilhar(Pedido elem) {
        if (cheia() == false) {
            topo++;
            vetor[topo] = elem;
        } else {
            JOptionPane.showMessageDialog(null,
                    "PILHA CHEIA!");
        }
    }

    public Pedido desempilhar() {
        Pedido valorDesempilhado;
        if (vazia() == true) {
            valorDesempilhado = null;
        } else {
            valorDesempilhado = vetor[topo];
            topo--;
        }
        return valorDesempilhado;
    }

    public void exibePilha() {
        if (vazia() == true) {
            System.out.println("PILHA VAZIA.");
        } else {
            for (int i = topo; i >= 0; i--) {
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
    }
}