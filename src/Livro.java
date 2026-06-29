
public class Livro {

    // Atributos do livro
    private int codigo;
    private String nome;
    private String autor;
    private String genero;
    private String editora;
    private int numeroPaginas;

    // Construtor, Getters e Setters
    public Livro(int codigo, String nome, String autor, String genero, String editora, int numeroPaginas) {
        this.codigo = codigo;
        this.nome = nome;
        this.autor = autor;
        this.genero = genero;
        this.editora = editora;
        this.numeroPaginas = numeroPaginas;
    }

    // Getters omitidos por brevidade, mas devem ser gerados.
    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return String.format("Código: %d | Nome: %s | Autor: %s | Gênero: %s | Editora: %s | Páginas: %d",
                codigo, nome, autor, genero, editora, numeroPaginas);
        // Formato de saída do livro
    }

    // Adicionado para permitir a pesquisa por código
    public int getCodigo() {
        return codigo;
    }
}
