import java.util.LinkedList;

public class ArvoreBinaria {
    NodoArvore raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void insere(int valor) {
        this.raiz = insere_recursivo(this.raiz, valor);
    }

    private NodoArvore insere_recursivo(NodoArvore nodo, int valor) {
        if (nodo == null) {
            return new NodoArvore(valor);
        }
        if (valor < nodo.valor) {
            nodo.esquerda = insere_recursivo(nodo.esquerda, valor);
        } else if (valor > nodo.valor) {
            nodo.direita = insere_recursivo(nodo.direita, valor);
        }
        return nodo;
    }

    public void percorre_para_lista(NodoArvore nodo, LinkedList<Integer> lista) {
        if (nodo == null)
            return;

        percorre_para_lista(nodo.esquerda, lista);
        lista.add(nodo.valor);
        percorre_para_lista(nodo.direita, lista);
    }

    public void exibe_arvore() {
        if (this.raiz != null) {
            this.raiz.exibe_arvore("", false);
        } else {
            System.out.println("Árvore vazia.");
        }
    }
}
