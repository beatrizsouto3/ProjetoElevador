import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Elevador elevador = new Elevador();

        System.out.println("- - - - - - - - - - - - - - - - -");
        System.out.println("Inicializando Sistema de Elevador");
        System.out.println("- - - - - - - - - - - - - - - - -");
        System.out.print("Informe o total de andares (incluindo térreo como 0): ");
        int totalAndares = scanner.nextInt();
        System.out.print("Informe a capacidade máxima do elevador: ");
        int capacidadeMax = scanner.nextInt();
        
        elevador.inicializa(totalAndares, capacidadeMax);
        
        int opcao;
        do {
            System.out.println("\n              Menu:");
            System.out.println("---------------------------------");
            System.out.println("1 - Entrar pessoa");
            System.out.println("2 - Sair pessoa");
            System.out.println("3 - Subir um andar");
            System.out.println("4 - Descer um andar");
            System.out.println("5 - Deslocar para andar específico");
            System.out.println("6 - Ver andar atual");
            System.out.println("7 - Ver quantidade de pessoas");
            System.out.println("0 - Sair do sistema");
            System.out.println("---------------------------------");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();

            System.out.print("\033[H\033[2J");
            
            switch (opcao) {
                case 1:
                    if (elevador.entrarPessoas()) {
                        System.out.println("Uma Pessoa entrou.");
                    } else {
                        System.out.println("Elevador está cheio.");
                    }
                    break;
                case 2:
                    if (elevador.sairPessoas()) {
                        System.out.println("Uma Pessoa saiu.");
                    } else {
                        System.out.println("Elevador está vazio.");
                    }
                    break;
                case 3:
                    if (elevador.subir()) {
                        System.out.println("Subiu para o andar " + elevador.getAndarAtual());
                    } else {
                        System.out.println("Já está no último andar.");
                    }
                    break;
                case 4:
                    if (elevador.descer()) {
                        System.out.println("Desceu para o andar " + elevador.getAndarAtual());
                    } else {
                        System.out.println("Já está no térreo.");
                    }
                    break;
                case 5:
                    System.out.print("Para qual andar deseja ir? ");
                    int andar = scanner.nextInt();
                    if (elevador.getAndarAtual() == andar) {
                        System.out.println("Você já está nesse andar.");
                    } else if (andar < 0 || andar > totalAndares) {
                        System.out.println("Andar inválido. O prédio tem apenas " + totalAndares + " andares.");
                    } else {
                        elevador.deslocar(andar);
                    }
                    break;
                case 6:
                    System.out.println("Andar atual: " + elevador.getAndarAtual());
                    break;
                case 7:
                    System.out.println("Quantidade de pessoas: " + elevador.getQtdPessoas());
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
        
        scanner.close();
    }
}