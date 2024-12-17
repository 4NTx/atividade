import java.util.LinkedList;

public class ListaDuplamenteEncadeada {
    LinkedList<Integer> lista;

    public ListaDuplamenteEncadeada() {
        this.lista = new LinkedList<>();
    }

    public void adiciona(int valor) {
        this.lista.add(valor);
    }

    public void exibe() {
        System.out.println("Elementos na lista duplamente encadeada: " + lista);
    }
}
