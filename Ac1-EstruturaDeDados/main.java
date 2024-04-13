import java.util.ArrayList;

import javax.swing.JOptionPane;

public class main {
    public static void main(String[] args) {
        Fila f = new Fila(9); // Fila com pedidos a serem feitos
        Pilha p = new Pilha(9); // Pilha dos pedidos a serem entregues
        ListaEncadeada l = new ListaEncadeada(); // Lista com todos os pedidos
        int op;
        int codigo = 1;
        int pedidoIncluidoFila = 1;

        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(
                    null,
                    "Selecione uma opção:" +
                            "\n1 - Novo pedido" +
                            "\n2 - Cancelar pedido" +
                            "\n3 - Listar todos os pedidos" +
                            "\n4 - Incluir pedidos na fila de preparo(3 pedidos)" +
                            "\n5 - Incluir pedidos na pilha de entrega(3 pedidos)" +
                            "\n6 - Gerar relatório de entrega" +
                            "\n7 - Informar entrega realizada" +
                            "\n0 - Encerrar programa!"));

            switch (op) {
                case 1:
                    Pedido pedido = new Pedido(); // cria o pedido

                    pedido.setCodigo(codigo);
                    pedido.setPizza(JOptionPane.showInputDialog(
                            null,
                            "Qual o sabor da pizza?"));
                    pedido.setTam(JOptionPane.showInputDialog(
                            null,
                            "Qual o tamanho da pizza?(P, M ou G)"));
                    pedido.setEndereco(JOptionPane.showInputDialog(
                            null,
                            "Qual o endereço para entrega?"));
                    pedido.setDistancia(Float.parseFloat(JOptionPane.showInputDialog(
                            null,
                            "Qual a distância até o endereço?")));
                    codigo++;

                    l.insereNo_fim(new IntNoSimples(pedido)); // acrescenta o pedido na lista
                    break;

                case 2: // testar
                    int pedidoExcluir = Integer.parseInt(JOptionPane.showInputDialog(
                            null,
                            "Qual o código do pedido que deseja excluir?")); // pega o codigo do pedido a ser excluido

                    Fila fAux = f;
                    boolean encontrou = false;

                    // checa na fila se o código está nela
                    while (!fAux.vazia()) {
                        if (pedidoExcluir == fAux.desenfileirar().getCodigo()) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "O pedido do código digitado já está sendo preparado e não pode ser excluído!");
                            encontrou = true;
                        }
                    }

                    if (!encontrou) {
                        l.excluiNo(pedidoExcluir);
                    }

                    break;

                case 3:
                    l.exibeLista();
                    break;

                case 4: // Testar
                    for (int i = 0; i < 3; i++) {
                        f.enfileirar(l.buscaNo(pedidoIncluidoFila).pedido);
                        pedidoIncluidoFila++;
                    }
                    break;

                case 5:
                    Pedido aux = new Pedido();

                    for (int i = 0; i < 3; i++) {
                        Pedido valorDesenfileirado = f.desenfileirar();
                        p.empilhar(valorDesenfileirado);
                    }

                    ArrayList<Pedido> array = new ArrayList<Pedido>();

                    while (!p.vazia()) {
                        array.add(p.desempilhar());
                    }

                    for (int i = 0; i < array.size(); i++) {
                        for (int j = 0; j < array.size() - 1; j++) {
                            if (array.get(j).getDistancia() < array.get(j + 1).getDistancia()) {
                                aux = array.get(j);
                                array.add(j, array.get(j + 1));
                                array.add(j + 1, aux);
                            }
                        }
                    }

                    for (int i = 0; i < array.size(); i++) {
                        p.empilhar(array.get(i));
                    }

                    break;

                case 6:
                    p.exibePilha();
                    break;

                case 7:

                    break;

                case 0:
                    break;

                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "O valor digitado não é válido, tente novamente!");
                    break;
            }
        } while (op != 0);
    }
}