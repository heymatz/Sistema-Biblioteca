import java.util.Scanner;

public class App {

    public static void main(String args[]) {

        Scanner leia = new Scanner(System.in);
        int resp, nobras = 0;
        String paut, pnome, parea;

        for (int i = 0; i < 10; i++) {

            Campos c = new Campos();
            Campos.vet[i] = new Campos();

            System.out.println("Digite o código do livro");
            Campos.vet[i].setCod(leia.nextInt());

            System.out.println("Digite o nome da obra");
            Campos.vet[i].setNome(leia.next());

            System.out.println("Digite o nome do autor");
            Campos.vet[i].setAut(leia.next());

            System.out.println("Digite a área");
            Campos.vet[i].setArea(leia.next());

            System.out.println("Digite a editora");
            Campos.vet[i].setEditora(leia.next());

            System.out.println("Digite o número de paginas do livro");
            Campos.vet[i].setNpag(leia.nextInt());

            System.out.println("...................\n");
            System.out.println("...RESULTADO... \n");
        }
        for (int i = 0; i < 10; i++) {
            Campos c = new Campos();
            System.out.println("Código..." + Campos.vet[i].getCod());
            System.out.println("nome..." + Campos.vet[i].getNome());
            System.out.println("autor..." + Campos.vet[i].getAut());
            System.out.println("area..." + Campos.vet[i].getArea());
            System.out.println("editora..." + Campos.vet[i].getEditora());
            System.out.println("numero de paginas..." + Campos.vet[i].getNpag());

            System.out.println("Escolha a sua opção \n 1- Incluir livro \n"
                    + "2- mostrar a quantidade de obras de um determinado autor e quais são \n"
                    + "3- pesquisar por nome da obra \n"
                    + "4- pesquisar por area \n"
                    + "5- sair");
            resp = leia.nextInt();

            while (resp >= 1 && resp <= 4) {

                if (resp == 1) {
                    Campos.vet[i] = new Campos();
                }

                if (resp == 2) {
                    System.out.println("Digite o nome que quer pesquisar");
                    paut = leia.next();
                    if (paut.equalsIgnoreCase(Campos.vet[i].getAut())) {
                        System.out.println("As obras do autor são" + Campos.vet[i].getNome());
                        nobras = (nobras + 1);
                        System.out.println("O numero de obras é =" + nobras);
                    }
                }

                if (resp == 3) {
                    System.out.println("Digite o nome da obra a ser pesquisado");
                    pnome = leia.next();
                    if (pnome.equalsIgnoreCase(Campos.vet[i].getNome())) {
                        System.out.println("Código..." + Campos.vet[i].getCod());
                        System.out.println("autor..." + Campos.vet[i].getAut());
                        System.out.println("area..." + Campos.vet[i].getArea());
                        System.out.println("editora..." + Campos.vet[i].getEditora());
                        System.out.println("numero de paginas..." + Campos.vet[i].getNpag());
                    }
                }

                if (resp == 4) {
                    System.out.println("Digite a area a ser pesquisada");
                    parea = leia.next();
                    if (parea.equalsIgnoreCase(Campos.vet[i].getArea())) {
                        System.out.println("Código..." + Campos.vet[i].getCod());
                        System.out.println("nome..." + Campos.vet[i].getNome());
                        System.out.println("autor..." + Campos.vet[i].getAut());
                        System.out.println("editora..." + Campos.vet[i].getEditora());
                        System.out.println("numero de paginas..." + Campos.vet[i].getNpag());
                    }
                }
            }

            if (resp == 5)
                System.out.println("O programa foi encerrado");

        }
    }

}
