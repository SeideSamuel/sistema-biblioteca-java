import java.util.Scanner;

public class Main {

public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    Biblioteca biblioteca = new Biblioteca();
    int opcao = 0;

    menu: while  (true) {

        Console.limparTela();

        System.out.println("===================================================");
        System.out.println("               SISTEMA DE BIBLIOTECA               ");
        System.out.println("===================================================");
        System.out.println("                            ");
        System.out.println("1 - Cadastrar livro");
        System.out.println("2 - Cadastrar usuário");
        System.out.println("3 - Emprestar livro");
        System.out.println("4 - Devolver livro");
        System.out.println("5 - Listar livros");
        System.out.println("6 - Listar usuários");
        System.out.println("7 - Buscar livro");
        System.out.println("8 - Buscar usuário");
        System.out.println("9 - Sair");
        System.out.println("                             ");
        System.out.print("Escolha uma opção:");

        try {

            opcao = Integer.parseInt(scanner.nextLine());
            
        } catch (NumberFormatException e) {

            System.out.println("Opção inválida! tente novamente");
            Console.pausar(scanner);
            continue;
        }

        switch(opcao) {
            case 1:


                System.out.print("Digite o título do livro:");
                String titulo = scanner.nextLine();

                System.out.print("Digite o autor:");
                String autor = scanner.nextLine();

                System.out.print("Digite o ano de lançamento:");
                int ano = Integer.parseInt(scanner.nextLine());

                biblioteca.cadastrarLivro(titulo, autor, ano);
                Console.pausar(scanner);

                break;

            case 2:
                String nomeUsuario;
                String cpf;

                System.out.println("Digite o usuário:");
                nomeUsuario = scanner.nextLine();
                System.out.println("Digite o CPF:");
                cpf = scanner.nextLine();

                biblioteca.cadastrarUsuario(nomeUsuario, cpf);
                Console.pausar(scanner);

                break;

            case 3:

                System.out.println("Digite o CPF:");
                cpf = scanner.nextLine();
                System.out.println("Digite o titulo do livro:");
                titulo = scanner.nextLine();

                Usuario usuario = biblioteca.buscarUsuario(cpf);
                Livro livro = biblioteca.buscarLivro(titulo);

                if(usuario != null) {
                    if (livro != null) {

                        usuario.pegarLivro(livro);
                    } else {

                        System.out.println("Livro não encontrado");
                    }
                } else {

                    System.out.println("Usuário não encontrado!");
                }
                    Console.pausar(scanner);

                break;

            case 4:

                System.out.println("Digite o CPF:");
                cpf = scanner.nextLine();
                System.out.println("Digite o título do livro:");
                titulo = scanner.nextLine();

                usuario = biblioteca.buscarUsuario(cpf);
                livro = biblioteca.buscarLivro(titulo);

                if(usuario != null) {
                    if(livro != null) {

                        usuario.devolverLivro(livro);
                    } else {

                        System.out.println("Livro não encontrado!");
                    }
                } else {

                    System.out.println("Usuário não encontrado!");
                }
                    Console.pausar(scanner);
                break;

            case 5:

                biblioteca.listarLivros();
                Console.pausar(scanner);

                break;

            case 6:

                biblioteca.listarUsuarios();
                Console.pausar(scanner);
                break;

            case 7:

                System.out.println("Digite o título do livro:");
                titulo = scanner.nextLine();

                livro = biblioteca.buscarLivro(titulo);

                if (livro != null) {
                    livro.mostrarInformacoes();
                } else {
                    System.out.println("Livro não encontrado");
                }

                Console.pausar(scanner);

                break;

            case 8:

                System.out.println("Digite o CPF:");
                cpf = scanner.nextLine();

                usuario = biblioteca.buscarUsuario(cpf);

                if (usuario != null) {
                    usuario.mostrarInfo();
                } else {
                    System.out.println("Usuário não encontrado");
                }
                  Console.pausar(scanner);
                break;

            case 9:

                System.out.println("Encerrando...");
                break menu;

            default:

                System.out.println("Opção inválida, tente novamente");
                continue;

        }
      }
        scanner.close();
    }
}