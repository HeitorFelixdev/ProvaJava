package ExemploProva;
import java.util.Scanner;

public class Main {
    public static final int TAM = 100;
    static Scanner sc = new Scanner(System.in);

    
    //Primeira QUESTAO

 public static int cadastrarCategoria (Categoria[] vetor, int qtd) {
    boolean continuar = true;
    if ( qtd >= vetor.length) {
        System.out.println ("Limite atingido. Nao pode criar mais categorias!");
        return qtd;

    }
    vetor[qtd] = new Categoria ();
    while (continuar && qtd < vetor.length) {
        System.out.println ("Digite o codigo da Categoria: ");
        vetor[qtd].codigo = sc.nextInt();
        sc.nextLine();
        System.out.println ("Digite o nome da Categoria");
        vetor[qtd].nome = sc.nextLine();
        qtd++;

    }
    return qtd;
}


    //Segunda QUESTAO

    public static void imprimirCategoria (Categoria[] vetor, int qtd) {
        for ( int i = 0; i < qtd; i++) {
        System.out.println("(%d, %s)\n", vetor[i].codigo, 
                                        vetor[i].nome);

    }
}


    //Terceira QUESTAO

    public static void imprimirProdutos(Produto[] vetorP, int qtdP, 
                                  Categoria[] vetorC, int qtdC) {
    for (int i = 0; i < qtdP; i++) {   // Encontrar a categoria correspondente
        String nomeCategoria = "Categoria não encontrada";

        for (int j = 0; j < qtdC; j++) {

            if (vetorC[j].codigo == vetorP[i].codigoCategoria) {
                nomeCategoria = vetorC[j].nome;
                break;
            }
        }
        
        double preco = vetorP[i].preco / 100.0; // Converter o preço para double

        System.out.printf("Código: %d, Título: %s, Descrição: %s, Categoria: %s, Preço: R$ %.2f\n", // Imprimir os dados formatados
                         vetorP[i].codigo,
                         vetorP[i].titulo,
                         vetorP[i].descricao,
                         nomeCategoria,
                         preco);
    }
}

    //Quarta QUESTAO

    public static void selectionSortPorDescricao(Produto[] v, int qtd) {
    int fim = qtd - 1;

    while (fim > 0) {
        int palavraDepois = 0;
        for (int i = 0; i < fim; i++) {
            if (v[i + 1].descricao.compareTo(v[palavraDepois].descricao) > 0) {
                palavraDepois = i + 1;
            }
        }
        Produto aux = v[fim];
        v[fim] = v[palavraDepois];
        v[palavraDepois] = aux;

        fim -= 1;
    }
}


    //Quinta QUESTAO
    public static void buscaBinariaPorDescricao(Produto[] v, int qtd, String x) {
    int comeco = 0, fim = qtd - 1;
    
    while (comeco <= fim) {
        int meio = (comeco + fim) / 2;
        int comparacao = v[meio].descricao.compareTo(x);
        
        if (comparacao == 0) {
            System.out.println("Produto encontrado:\nDescrição: " + v[meio].descricao);
            return;
        }
        comeco = (comparacao < 0) ? meio + 1 : comeco;
        fim = (comparacao > 0) ? meio - 1 : fim;
    }
    System.out.println("Produto não encontrado.");
}


    public static void main(String[] args) {
        Categoria[] categorias = new Categoria[TAM];
        int qtdCategorias = 0;

        qtdCategorias = cadastrarCategoria(categorias, qtdCategorias);
        imprimirCategoria(categorias, qtdCategorias);
    }
}