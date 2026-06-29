
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

// Uso de coleção dinâmica em vez de vetor fixo: "public static Campos vet[] = new Campos[3];"
    private static List<Livro> acervo = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");
            processarOpcao(opcao);
        } while (opcao != 5);

        System.out.println("Sistema encerrado.");
        scanner.close();
    }

    private static void exibirMenu() {
        // Menu simplificado
        System.out.println("\n===== MENU ERP (Módulo Biblioteca) =====");
        System.out.println("1 - Cadastrar novo livro");
        System.out.println("2 - Mostrar todos os livros");
        System.out.println("3 - Pesquisar por autor");
        System.out.println("4 - Pesquisar por nome ou gênero");
        System.out.println("5 - Sair");
    }

    private static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1 ->
                cadastrarLivro();
            case 2 ->
                listarLivros();
            case 3 ->
                pesquisar(TipoPesquisa.AUTOR);
            case 4 ->
                pesquisar(TipoPesquisa.NOME_OU_GENERO); // Adicionado para permitir pesquisa por nome ou gênero
            case 5 -> {
            } // Apenas sai
            default ->
                System.out.println("Opção inválida.");
        }
    }

    private static void cadastrarLivro() {
        int codigo = lerInteiro("Digite o código do livro: ");
        System.out.print("Digite o nome da obra: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o nome do autor: ");
        String autor = scanner.nextLine();
        System.out.print("Digite o gênero: ");
        String genero = scanner.nextLine();
        System.out.print("Digite a editora: ");
        String editora = scanner.nextLine();
        int paginas = lerInteiro("Digite o número de páginas: ");

        for (Livro livro : acervo) {
            // Verifica se já existe um livro com o mesmo código
            if (livro.getCodigo() == codigo) {
                System.out.println("Já existe um livro com esse código.");
                return;
            }
        }

        acervo.add(new Livro(codigo, nome, autor, genero, editora, paginas));
        System.out.println("...ARMAZENADO COM SUCESSO...\n");
    }

    private static void listarLivros() {
        if (acervo.isEmpty()) {
            // Verifica se há livros cadastrados
            System.out.println("Nenhum livro cadastrado.");
            return;
        }
        acervo.forEach(System.out::println);
    }

    // Método utilitário para evitar quebra do Scanner com letras
    private static int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                int valor = Integer.parseInt(scanner.nextLine());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
            }
        }
    }

    // Normaliza o texto para facilitar a pesquisa
    private static String normalizar(String texto) {
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("\\p{M}", ""); // Remove acentos
        return texto.toLowerCase().trim();      // Ignora maiúsculas/minúsculas e espaços
    }

    private static void pesquisar(TipoPesquisa tipo) {
        // Verifica se há livros cadastrados
        if (acervo.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        System.out.print("Digite a pesquisa: ");
        String busca = normalizar(scanner.nextLine());

        boolean encontrou = false;

        for (Livro livro : acervo) {
            switch (tipo) {

                case AUTOR -> {
                    if (normalizar(livro.getAutor()).contains(busca)) {
                        System.out.println(livro);
                        encontrou = true;
                    }
                }

                case NOME_OU_GENERO -> {
                    if (normalizar(livro.getNome()).contains(busca)
                            || normalizar(livro.getGenero()).contains(busca)) {
                        System.out.println(livro);
                        encontrou = true;
                    }
                }
            }
        }

        if (!encontrou) {
            // Se não encontrou nenhum livro correspondente
            System.out.println("Nenhum livro encontrado.");
        }
    }
}
