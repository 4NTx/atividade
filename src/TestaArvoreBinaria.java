import java.util.Scanner;

public class TestaArvoreBinaria {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArvoreBinaria arvore = new ArvoreBinaria();

            System.out.println("Digite os valores para inserir na árvore binária (digite -1 para parar):");
            while (true) {
                int valor = scanner.nextInt();
                if (valor == -1)
                    break;
                arvore.insere(valor);
            }

            System.out.println("Árvore binária inicial:");
            arvore.exibe_arvore();

            System.out.println("Escolha uma das opções:");
            System.out.println("1 - Inverter subárvores");
            System.out.println("2 - Verificar se duas árvores são iguais");
            System.out.println("3 - Armazenar os valores em uma lista duplamente encadeada ordenada");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    if (arvore.raiz != null) {
                        arvore.raiz.inverte();
                        System.out.println("Subárvores invertidas. Nova estrutura da árvore:");
                        arvore.exibe_arvore();
                    } else {
                        System.out.println("A árvore está vazia.");
                    }
                }
                case 2 -> {
                    ArvoreBinaria outra_arvore = new ArvoreBinaria();
                    System.out.println("Digite os valores para a segunda árvore binária (digite -1 para parar):");
                    while (true) {
                        int valor = scanner.nextInt();
                        if (valor == -1)
                            break;
                        outra_arvore.insere(valor);
                    }
                    boolean iguais = (arvore.raiz == null && outra_arvore.raiz == null) ||
                            (arvore.raiz != null && arvore.raiz.verifica_igual(outra_arvore.raiz));
                    System.out.println(iguais ? "As árvores são iguais." : "As árvores são diferentes.");
                }
                case 3 -> {
                    ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
                    arvore.percorre_para_lista(arvore.raiz, lista.lista);
                    lista.exibe();
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}