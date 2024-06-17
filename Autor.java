public class Autor extends ItemBiblioteca {
    private String biografia;

    public Autor(int id, String titulo, String biografia) {
        super(id, titulo);
        this.biografia = biografia;
    }

    public Autor() {}

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Autor [ID: " + getId() + ", Nome: " + getTitulo() + ", Biografia: " + biografia + "]");
    }
}
