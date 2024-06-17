import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private ArrayList<ItemBiblioteca> itens = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public void cadastrar(ItemBiblioteca item) {
        itens.add(item);
        System.out.println(item.getTitulo() + " cadastrado com sucesso.");
    }

    public void cadastrar(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário " + usuario.getNome() + " cadastrado com sucesso.");
    }

    public void listarItens() {
        for (ItemBiblioteca item : itens) {
            item.exibirDetalhes();
        }
    }

    public void listarUsuarios() {
        for (Usuario usuario : usuarios) {
            usuario.tipoUsuario();
        }
    }

    public void visualizarItem(int id) {
        for (ItemBiblioteca item : itens) {
            if (item.getId() == id) {
                item.exibirDetalhes();
                return;
            }
        }
        System.out.println("Item não encontrado.");
    }

    public void visualizarUsuario(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                usuario.tipoUsuario();
                return;
            }
        }
        System.out.println("Usuário não encontrado.");
    }

    public void excluirItem(int id) {
        for (ItemBiblioteca item : itens) {
            if (item.getId() == id) {
                itens.remove(item);
                System.out.println(item.getTitulo() + " removido com sucesso.");
                return;
            }
        }
        System.out.println("Item não encontrado.");
    }

    public void excluirUsuario(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                usuarios.remove(usuario);
                System.out.println("Usuário " + usuario.getNome() + " removido com sucesso.");
                return;
            }
        }
        System.out.println("Usuário não encontrado.");
    }

    public void editarItem(int id) {
        Scanner sc = new Scanner(System.in);
        for (ItemBiblioteca item : itens) {
            if (item.getId() == id) {
                if (item instanceof Livro) {
                    System.out.println("Editando Livro...");
                    System.out.print("Novo Título: ");
                    item.setTitulo(sc.nextLine());
                    System.out.print("Novo Autor: ");
                    ((Livro) item).setAutor(sc.nextLine());
                    System.out.print("Novas Páginas: ");
                    ((Livro) item).setPaginas(sc.nextInt());
                } else if (item instanceof Autor) {
                    System.out.println("Editando Autor...");
                    System.out.print("Novo Nome: ");
                    item.setTitulo(sc.nextLine());
                    System.out.print("Nova Biografia: ");
                    ((Autor) item).setBiografia(sc.nextLine());
                }
                System.out.println("Item atualizado com sucesso.");
                return;
            }
        }
        System.out.println("Item não encontrado.");
    }

    public void editarUsuario(int id) {
        Scanner sc = new Scanner(System.in);
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                System.out.print("Novo Nome: ");
                usuario.setNome(sc.nextLine());
                System.out.println("Usuário atualizado com sucesso.");
                return;
            }
        }
        System.out.println("Usuário não encontrado.");
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar Item");
            System.out.println("2. Cadastrar Usuário");
            System.out.println("3. Listar Itens");
            System.out.println("4. Listar Usuários");
            System.out.println("5. Visualizar Item");
            System.out.println("6. Visualizar Usuário");
            System.out.println("7. Excluir Item");
            System.out.println("8. Excluir Usuário");
            System.out.println("9. Editar Item");
            System.out.println("10. Editar Usuário");
            System.out.println("11. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.println("1. Livro");
                    System.out.println("2. Autor");
                    System.out.print("Escolha o tipo: ");
                    int tipo = sc.nextInt();
                    sc.nextLine(); 
                    if (tipo == 1) {
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine(); 
                        System.out.print("Título: ");
                        String titulo = sc.nextLine();
                        System.out.print("Autor: ");
                        String autor = sc.nextLine();
                        System.out.print("Páginas: ");
                        int paginas = sc.nextInt();
                        sc.nextLine(); 

                        Livro livro = new Livro(id, titulo, autor, paginas);
                        biblioteca.cadastrar(livro);
                    } else if (tipo == 2) {
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine(); 
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();
                        System.out.print("Biografia: ");
                        String biografia = sc.nextLine();

                        Autor autor = new Autor(id, nome, biografia);
                        biblioteca.cadastrar(autor);
                    }
                    break;

                case 2:
                    System.out.println("1. Usuário Adulto");
                    System.out.println("2. Usuário Infantil");
                    System.out.print("Escolha o tipo: ");
                    int tipoUsuario = sc.nextInt();
                    sc.nextLine(); 

                    System.out.print("ID: ");
                    int idUsuario = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Nome: ");
                    String nomeUsuario = sc.nextLine();

                    if (tipoUsuario == 1) {
                        UsuarioAdulto usuarioAdulto = new UsuarioAdulto(idUsuario, nomeUsuario);
                        biblioteca.cadastrar(usuarioAdulto);
                    } else if (tipoUsuario == 2) {
                        UsuarioInfantil usuarioInfantil = new UsuarioInfantil(idUsuario, nomeUsuario);
                        biblioteca.cadastrar(usuarioInfantil);
                    }
                    break;

                case 3:
                    biblioteca.listarItens();
                    break;

                case 4:
                    biblioteca.listarUsuarios();
                    break;

                case 5:
                    System.out.print("ID do item a visualizar: ");
                    int idVisualizarItem = sc.nextInt();
                    biblioteca.visualizarItem(idVisualizarItem);
                    break;

                case 6:
                    System.out.print("ID do usuário a visualizar: ");
                    int idVisualizarUsuario = sc.nextInt();
                    biblioteca.visualizarUsuario(idVisualizarUsuario);
                    break;

                case 7:
                    System.out.print("ID do item a excluir: ");
                    int idExcluirItem = sc.nextInt();
                    biblioteca.excluirItem(idExcluirItem);
                    break;

                case 8:
                    System.out.print("ID do usuário a excluir: ");
                    int idExcluirUsuario = sc.nextInt();
                    biblioteca.excluirUsuario(idExcluirUsuario);
                    break;

                case 9:
                    System.out.print("ID do item a editar: ");
                    int idEditarItem = sc.nextInt();
                    biblioteca.editarItem(idEditarItem);
                    break;

                case 10:
                    System.out.print("ID do usuário a editar: ");
                    int idEditarUsuario = sc.nextInt();
                    biblioteca.editarUsuario(idEditarUsuario);
                    break;

                case 11:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 11);
    }
}
