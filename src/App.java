
import java.text.Normalizer;
import java.util.Scanner;

public class App {

    public static String normalizar(String texto) {
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("\\p{M}", "");       // Remove acentos
        texto = texto.replaceAll("[^a-zA-Z0-9 ]", ""); // Remove pontuação
        return texto.toLowerCase().trim();
    } // Método para normalizar o texto, removendo acentos e pontuação

    public static void main(String args[]) {

        Scanner leia = new Scanner(System.in); //
        int resp, nobras;
        String paut, pnome, parea;

        for (int i = 0; i < 3; i++) {

            Campos.vet[i] = new Campos();

            System.out.println("Digite o código do livro");
            Campos.vet[i].setCod(leia.nextInt());
            leia.nextLine(); // Limpa o buffer do teclado

            System.out.println("Digite o nome da obra");
            Campos.vet[i].setNome(leia.nextLine());

            System.out.println("Digite o nome do autor");
            Campos.vet[i].setAut(leia.nextLine());

            System.out.println("Digite o gênero");
            Campos.vet[i].setArea(leia.nextLine());

            System.out.println("Digite a editora");
            Campos.vet[i].setEditora(leia.nextLine());

            System.out.println("Digite o número de páginas do livro");
            Campos.vet[i].setNpag(leia.nextInt());
            leia.nextLine(); // limpa o buffer do teclado

            System.out.println("...................\n");
            System.out.println("...ARMAZENADO COM SUCESSO... \n");
        }

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1 - Mostrar todos os livros");
            System.out.println("2 - Pesquisar por autor");
            System.out.println("3 - Pesquisar por nome");
            System.out.println("4 - Pesquisar por gênero");
            System.out.println("5 - Sair");

            resp = leia.nextInt();

            switch (resp) {

                case 1 -> {
                    for (int i = 0; i < 3; i++) {
                        System.out.println("----------------");
                        System.out.println("Código: " + Campos.vet[i].getCod());
                        System.out.println("Nome: " + Campos.vet[i].getNome());
                        System.out.println("Autor: " + Campos.vet[i].getAut());
                        System.out.println("Gênero: " + Campos.vet[i].getArea());
                        System.out.println("Editora: " + Campos.vet[i].getEditora());
                        System.out.println("Páginas: " + Campos.vet[i].getNpag());
                        System.out.println("----------------");
                    }
                }

                case 2 -> {
                    nobras = 0;
                    leia.nextLine(); // Limpa o buffer do teclado

                    System.out.println("Digite o autor:");
                    paut = leia.nextLine();

                    for (int i = 0; i < 3; i++) {
                        String pesquisa = normalizar(paut);// Normaliza os nomes para comparação sem acentos e pontuação
                        String nomeAutor = normalizar(Campos.vet[i].getAut());

                        if (nomeAutor.contains(pesquisa)) {
                            System.out.println("----------------");
                            System.out.println(Campos.vet[i].getNome());
                            nobras++;
                            System.out.println("----------------");
                        }
                    }

                    System.out.println("Quantidade de obras desse autor: " + nobras);
                    System.out.println("----------------");
                }

                case 3 -> {
                    leia.nextLine(); // Limpa o buffer do teclado
                    System.out.println("Digite o nome da obra:");
                    pnome = leia.nextLine();

                    for (int i = 0; i < 3; i++) {
                        String pesquisa = normalizar(pnome);// Normaliza os nomes para comparação sem acentos e pontuação
                        String nomeLivro = normalizar(Campos.vet[i].getNome());

                        if (nomeLivro.contains(pesquisa)) {
                            System.out.println("----------------");
                            System.out.println("Código: " + Campos.vet[i].getCod());
                            System.out.println("Autor: " + Campos.vet[i].getAut());
                            System.out.println("Editora: " + Campos.vet[i].getEditora());
                            System.out.println("Páginas: " + Campos.vet[i].getNpag());
                            System.out.println("----------------");
                        }
                    }
                }

                case 4 -> {
                    leia.nextLine(); // Limpa o buffer do teclado
                    System.out.println("Digite o gênero:");
                    parea = leia.nextLine();

                    for (int i = 0; i < 3; i++) {
                        String nomeArea = normalizar(Campos.vet[i].getArea());
                        String pesquisa = normalizar(parea);// Normaliza os nomes para comparação sem acentos e pontuação

                        if (nomeArea.contains(pesquisa)) {
                            System.out.println("----------------");
                            System.out.println("Nome: " + Campos.vet[i].getNome());
                            System.out.println("Autor: " + Campos.vet[i].getAut());
                            System.out.println("Páginas: " + Campos.vet[i].getNpag());
                            System.out.println("----------------");
                        }
                    }
                }

                case 5 ->
                    System.out.println("Programa encerrado.");

                default ->
                    System.out.println("Opção inválida.");

            }
        } while (resp != 5);
        leia.close();
    }
}
