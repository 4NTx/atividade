public class NodoArvore {
    int valor;
    NodoArvore esquerda;
    NodoArvore direita;

    public NodoArvore(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }

    public void inverte() {
        NodoArvore temp = this.esquerda;
        this.esquerda = this.direita;
        this.direita = temp;

        if (this.esquerda != null)
            this.esquerda.inverte();
        if (this.direita != null)
            this.direita.inverte();
    }

    public boolean verifica_igual(NodoArvore outra) {
        if (this == null && outra == null)
            return true;
        if (this == null || outra == null)
            return false;
        if (this.valor != outra.valor)
            return false;

        return (this.esquerda == null ? outra.esquerda == null : this.esquerda.verifica_igual(outra.esquerda))
                && (this.direita == null ? outra.direita == null : this.direita.verifica_igual(outra.direita));
    }

    public void exibe_arvore(String prefixo, boolean is_esquerda) {
        if (this.direita != null) {
            this.direita.exibe_arvore(prefixo + (is_esquerda ? "|   " : "    "), false);
        }
        System.out.println(prefixo + (is_esquerda ? "|-- " : "\\-- ") + this.valor);
        if (this.esquerda != null) {
            this.esquerda.exibe_arvore(prefixo + (is_esquerda ? "|   " : "    "), true);
        }
    }
}
