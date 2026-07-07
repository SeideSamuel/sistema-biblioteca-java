public class Livro {
    private String titulo;
    private String autor;
    private int ano;
    private boolean emprestado;
    private Usuario usuarioQuePegou;

    public Livro(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.emprestado = false;
        this.usuarioQuePegou = null;
    }

    public void emprestar(Usuario usuario) {

        if (emprestado) {
            System.out.println("Livro já está emprestado");
        } else {
            setEmprestado(true);
            setUsuarioQuePegou(usuario);
            System.out.println("Livro emprestado com sucesso");
        }


    }


    public void devolver() {

        if (emprestado) {
            setEmprestado(false);
            setUsuarioQuePegou(null);
            System.out.println("Livro devolvido com sucesso");
        } else {
            System.out.println("Esse livro não está emprestado");
        }


    }

    public void mostrarInformacoes() {

        System.out.println("Título : " + titulo);
        System.out.println("Autor  : " + autor);
        System.out.println("Ano    : " + ano);

        if (emprestado) {
            System.out.println("Status : Emprestado");
            System.out.println("Usuário: " + usuarioQuePegou.getNome());
        } else {
            System.out.println("Status : Disponível");
        }

        System.out.println("========================================");
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    public Usuario getUsuarioQuePegou() {
        return this.usuarioQuePegou;
    }

    public void setUsuarioQuePegou(Usuario usuarioQuePegou) {
        this.usuarioQuePegou = usuarioQuePegou;
    }
}