public class UsuarioAdulto extends Usuario {
    public UsuarioAdulto(int id, String nome) {
        super(id, nome);
    }

    public UsuarioAdulto() {
        super();
    }

    @Override
    public void tipoUsuario() {
        System.out.println("Usuário Adulto: " + getNome());
    }
}
