public class UsuarioInfantil extends Usuario {
    public UsuarioInfantil(int id, String nome) {
        super(id, nome);
    }

    public UsuarioInfantil() {
        super();
    }

    @Override
    public void tipoUsuario() {
        System.out.println("Usuário Infantil: " + getNome());
    }
}
