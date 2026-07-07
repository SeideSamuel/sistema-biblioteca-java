import java.util.ArrayList;
import java.util.Comparator;

public class Biblioteca {
    private ArrayList<Livro> livros = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public Biblioteca() {

    }

    public void cadastrarLivro(String titulo, String autor, int ano) {

        if (buscarLivro(titulo) != null) {
            System.out.println("Já existe um livro com esse título");
            return;
        }

        Livro livro = new Livro(titulo, autor, ano);
        livros.add(livro);
        System.out.println("Livro cadastrado com sucesso");
    }

    public void cadastrarUsuario(String nome, String cpf) {


        if (buscarUsuario(cpf) != null) {
            System.out.println("Já existe um usuário com esse CPF");
            return;
        }

        Usuario usuario = new Usuario(nome, cpf);
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso");
    }

    public Livro buscarLivro(String titulo) {

        for (Livro l : livros) {
            if(l.getTitulo().equalsIgnoreCase(titulo)) {
            return l;
            }
        }

        return null;
    }

    public Usuario buscarUsuario(String cpf) {

        for (Usuario u : usuarios) {
            if (u.getCpf().equalsIgnoreCase(cpf)) {
                return u;
            }
        }

        return null;
    }

    public void ordenarPorTitulo() {

        livros.sort(Comparator.comparing(Livro::getTitulo, String.CASE_INSENSITIVE_ORDER));
    }

    public void listarLivros() {

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado");
            return;
        }

        this.ordenarPorTitulo();

        System.out.println("============= LIVROS =============");

        for (Livro l : livros) {
            l.mostrarInformacoes();
        }

    }

    public void listarUsuarios() {

        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado");
            return;
        }

        for (Usuario u : usuarios) {
            System.out.println("Nome do usuário: " + u.getNome());
            System.out.println("CPF: " + u.getCpf());
            u.listarLivros();
        }
    }
}