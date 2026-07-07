import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String cpf;
    private ArrayList<Livro> livrosEmprestados = new ArrayList<>();

    public Usuario(String nome, String cpf ) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public void pegarLivro(Livro livro) {

        if (!livro.isEmprestado()) {
            livrosEmprestados.add(livro);
            livro.emprestar(this);
        } else {
            System.out.println("Livro indisponível para empréstimo");
        }
    }

    public void devolverLivro(Livro livro) {

        if (livrosEmprestados.contains(livro)) {
            livrosEmprestados.remove(livro);
            livro.devolver();
        } else {
            System.out.println("Livro disponível para empréstimo");
        }
    }

    public void listarLivros() {

        if (livrosEmprestados.isEmpty()) {
            System.out.println("Este usuário não possui livros emprestados");
            return;
        }

        for (Livro l : livrosEmprestados) {
           l.mostrarInformacoes();
        }
    }

    public void mostrarInfo() {
        System.out.println("Nome do usuário: " + this.nome);
        System.out.println("CPF:" + this.cpf);
        System.out.println("Livros Emprestados:");
        listarLivros();

    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}