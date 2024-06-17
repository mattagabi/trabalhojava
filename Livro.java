public class Livro extends ItemBiblioteca {
    private String autor;
    private int paginas;

    public Livro(int id, String titulo, String autor, int paginas) {
        super(id, titulo);
        this.autor = autor;
        this.paginas = paginas;
    }

    public Livro() {}

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Livro [ID: " + getId() + ", Título: " + getTitulo() + ", Autor: " + autor + ", Páginas: " + paginas + "]");
    }
}
