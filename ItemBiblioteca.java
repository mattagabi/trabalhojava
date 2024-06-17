public abstract class ItemBiblioteca {
    private int id;
    private String titulo;

    public ItemBiblioteca(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public ItemBiblioteca() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public abstract void exibirDetalhes();
}
