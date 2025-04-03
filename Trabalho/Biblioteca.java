
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
	private ArrayList<Livro> livros;
	public Biblioteca() {
		livros=new ArrayList<>();
	}
	public void adicionarLivro(Livro livro) {
		livros.add(livro);
		System.out.println("Livro adicionado!");
	}
	public void consultarLivros() {
		if (livros.isEmpty()) {
			System.out.println("Nao ha livros cadastrados!");
		}else{	
			for (Livro livro: livros) {
				livro.mostrarInformacoes();
			}
		}
}
	public void apagarLivro(String titulo) {
		for (int i=0; i<livros.size(); i++) {
			if (livros.get(i).getTitulo().equalsIgnoreCase(titulo)) {
				livros.remove(i);
				System.out.println("Livro removido!");
				return;
			}
		}
		System.out.println("Livro nao encontrado");
	}

	public static void main(String[] args) {
		Biblioteca biblioteca=new Biblioteca();
			Scanner scanner=new Scanner(System.in);
		int opcao;
	
		do {
			System.out.println("\n--- Sistema de Biblioteca");
			System.out.println("1. Adicionar livro");
			System.out.println("2. Consultar livros");
			System.out.println("3. Apagar livro");
			System.out.println("4. Sair");
			System.out.print("Escolha uma opção: ");
			
			opcao= scanner.nextInt();
			scanner.nextLine();

		switch (opcao) {
		case 1:
			System.out.print("Digite o título do livro: ");
			String titulo=scanner.nextLine();
			System.out.print("Digite o autor do livro: ");
			String autor=scanner.nextLine();
			System.out.print("Digite o ano de publicação: ");

			int ano=scanner.nextInt();
			scanner.nextLine();
			
			Livro livro=new Livro (titulo, autor, ano);
			biblioteca.adicionarLivro (livro);
			break;

			case 2:
			biblioteca.consultarLivros();
			break;

			case 3:
			System.out.print("Digite o título do livro a ser removido: ");
			String tituloRemover=scanner.nextLine();
			biblioteca.apagarLivro (tituloRemover);
		    break;

			case 4:
			System.out.println("Saindo do sistema...");
			break;

			default:

			System.out.println("Opção invalida. Tente novamente.");
		}

		}while (opcao !=4);
		scanner.close();
	}	
}