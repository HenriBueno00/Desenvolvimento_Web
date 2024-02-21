import java.util.Scanner;

public class ClassificadorDeIdades {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita a idade do usuário
        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();

        // Classifica a idade em uma categoria
        String categoria;
        if (idade < 0) {
            categoria = "Idade inválida";
        } else if (idade < 12) {
            categoria = "Criança";
        } else if (idade <= 18) {
            categoria = "Adolescente";
        } else if (idade <= 60) {
            categoria = "Adulto";
        } else {
            categoria = "Idoso";
        }

        // Exibe a categoria da idade
        System.out.println("Sua categoria é: " + categoria);
    }
}
