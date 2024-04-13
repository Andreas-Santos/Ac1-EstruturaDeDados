/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class ListaEncadeada {
    IntNoSimples primeiro, ultimo;
    int numero_nos = 0;

    ListaEncadeada() {
        primeiro = ultimo = null;
    }

    void insereNo_fim(IntNoSimples novoNo) {
        novoNo.prox = null;
        if (primeiro == null)
            primeiro = novoNo;
        if (ultimo != null)
            ultimo.prox = novoNo;
        ultimo = novoNo;
        numero_nos++;
    }

    void insereNo_inicio(IntNoSimples novoNo) {
        novoNo.prox = primeiro;
        if (primeiro == null && ultimo == null) // Só tem um elemento na lista
        {
            ultimo = novoNo;
        }
        primeiro = novoNo;
        numero_nos++;
    }

    int ContarNos() {
        int tamanho = 0;
        IntNoSimples temp_no = primeiro;
        while (temp_no != null) {
            tamanho++;
            temp_no = temp_no.prox;
        }
        return tamanho;
    }

    void insereNo_posicao(IntNoSimples novoNo, int posicao) {
        IntNoSimples temp_no = primeiro;
        int numero_nos = ContarNos();
        int pos_aux;
        if (posicao == 0) {
            novoNo.prox = primeiro;
            if (primeiro == ultimo) {
                ultimo = novoNo;
            }
            primeiro = novoNo;
        } else {
            if (posicao <= numero_nos) {
                pos_aux = 1;
                while (temp_no != null && posicao > pos_aux) {
                    temp_no = temp_no.prox;
                    pos_aux++;
                }
                novoNo.prox = temp_no.prox;
                temp_no.prox = novoNo;
            } else {
                if (posicao > numero_nos) {
                    ultimo.prox = novoNo;
                    ultimo = novoNo;
                }
            }
        }
    }

    IntNoSimples buscaNo(int buscaValor) {
        int i = 0;
        IntNoSimples temp_no = primeiro;
        while (temp_no != null) {
            if (temp_no.pedido.getCodigo() == buscaValor) {
                JOptionPane.showMessageDialog(null, "Pedido " + temp_no.pedido.getCodigo() + " posição " + i);
                return temp_no;
            }
            i++;
            temp_no = temp_no.prox;
        }
        return null;
    }

    void excluiNo(int valor) {
        IntNoSimples temp_no = primeiro;
        IntNoSimples anterior_no = null;
        while (temp_no != null && temp_no.pedido.getCodigo() != valor) {
            anterior_no = temp_no;
            temp_no = temp_no.prox;
        }
        if (temp_no == primeiro) {
            if (temp_no.prox != null)
                primeiro = temp_no.prox;
            else
                primeiro = null;
        } else {
            anterior_no.prox = temp_no.prox;
        }

        if (ultimo == temp_no)
            ultimo = anterior_no;
    }

    void exibeLista() {
        IntNoSimples temp_no = primeiro;
        int i = 0;
        while (temp_no != null) {
            JOptionPane.showMessageDialog(
                null,
                "Pedido " + i + ":" +
                "\nCódigo - " + temp_no.pedido.getCodigo() +
                "\nSabor - " + temp_no.pedido.getPizza() +
                "\nTamanho - " + temp_no.pedido.getTam() +
                "\nEndereço - " + temp_no.pedido.getEndereco() +
                "\nDistância - " + String.format("%.2f", temp_no.pedido.getDistancia()));
            temp_no = temp_no.prox;
            i++;
        }
    }
}