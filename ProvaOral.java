package ExemploProva;
import java.util.Scanner;

public class ProvaOral {
    public static final int TAM = 100;
    static Scanner sc = new Scanner(System.in);

    
    //Primeira QUESTAO

 import java.util.Scanner;

public class Pessoa {
    String nome;
    int idade;
    double peso, altura;

    // Função para buscar pessoa pelo nome
    public static boolean buscarPessoaPorNome(Pessoa[] v, int qtd, String nome) {
        for (int i = 0; i < qtd; i++) {
            if (v[i].nome.equals(nome)) {
                return true;
            }
        }
        return false;
    }

    // Função para cadastrar pessoa
    public static int cadastrarPessoa(Pessoa[] v, int qtd) {
        Scanner scanner = new Scanner(System.in);
        
        // Verifica se há espaço no vetor
        if (qtd >= v.length) {
            System.out.println("Não há espaço para cadastrar mais pessoas.");
            return qtd;
        }
        
        // Solicita informações da pessoa
        Pessoa novaPessoa = new Pessoa();
        
        // Solicita nome e verifica se já existe
        boolean nomeRepetido;
        do {
            System.out.print("Digite o nome da pessoa: ");
            novaPessoa.nome = scanner.nextLine();
            nomeRepetido = buscarPessoaPorNome(v, qtd, novaPessoa.nome);
            if (nomeRepetido) {
                System.out.println("Nome já existe. Digite outro nome.");
            }
        } while (nomeRepetido);
        
        System.out.print("Digite a idade da pessoa: ");
        novaPessoa.idade = scanner.nextInt();
        
        System.out.print("Digite o peso da pessoa: ");
        novaPessoa.peso = scanner.nextDouble();
        
        System.out.print("Digite a altura da pessoa: ");
        novaPessoa.altura = scanner.nextDouble();
        
        // Adiciona a pessoa ao vetor
        v[qtd] = novaPessoa;
        
        return qtd + 1;
    }
}


    //Segunda QUESTAO

    public class Pessoa {
    // ... (código anterior)

    // Função para calcular IMC
    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    // Função para imprimir pessoas
    public static void imprimirPessoas(Pessoa[] v, int qtd) {
        for (int i = 0; i < qtd; i++) {
            double imc = calcularIMC(v[i].peso, v[i].altura);
            System.out.println("Nome: " + v[i].nome);
            System.out.println("Idade: " + v[i].idade);
            System.out.println("Peso: " + v[i].peso);
            System.out.println("Altura: " + v[i].altura);
            System.out.println("IMC: " + imc);
            System.out.println("---------------------");
        }
    }
}


    //Terceira QUESTAO

    public class Pessoa {
    // ... (código anterior)

    public static int maisVelhaMagreza(Pessoa[] v, int qtd) {
        int indiceMaisVelha = -1;
        int maiorIdade = -1;
        
        for (int i = 0; i < qtd; i++) {
            double imc = calcularIMC(v[i].peso, v[i].altura);
            if (imc < 18.5 && v[i].idade > maiorIdade) {
                maiorIdade = v[i].idade;
                indiceMaisVelha = i;
            }
        }
        
        return indiceMaisVelha;
    }
}

    //Quarta QUESTAO

   public class Pessoa {
    // ... (código anterior)

    public static void insertionsortPorNome(Pessoa[] v, int qtd) {
        for (int i = 1; i < qtd; i++) {
            Pessoa atual = v[i];
            int j = i - 1;
            
            while (j >= 0 && v[j].nome.compareTo(atual.nome) > 0) {
                v[j + 1] = v[j];
                j--;
            }
            
            v[j + 1] = atual;
        }
    }
}


    //Quinta QUESTAO
    public class Pessoa {
    // ... (código anterior)

    public static double mediaIdadeFiltro(Pessoa[] v, int qtd, double pesoMinimo, double alturaMaxima) {
        int somaIdades = 0;
        int contador = 0;
        
        for (int i = 0; i < qtd; i++) {
            if (v[i].peso > pesoMinimo && v[i].altura < alturaMaxima) {
                somaIdades += v[i].idade;
                contador++;
            }
        }
        
        if (contador == 0) {
            return 0;
        }
        
        return (double) somaIdades / contador;
    }
}


    public static void main(String[] args) {
        Categoria[] categorias = new Categoria[TAM];
        int qtdCategorias = 0;

        qtdCategorias = cadastrarCategoria(categorias, qtdCategorias);
        imprimirCategoria(categorias, qtdCategorias);
    }
}