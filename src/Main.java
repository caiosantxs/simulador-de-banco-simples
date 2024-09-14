import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Pessoa pessoa = null;
        ContaBancaria contaBancaria = null;
        int opcao = 0;

        while (opcao != 3) {
            System.out.println("Menu:");
            System.out.println("[1] - Cadastrar cliente");
            System.out.println("[2] - Realizar operção");
            System.out.println("[3] - Sair");
            System.out.print(" Opção: \n> ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Cadastrar cliente");
                    System.out.print(" Nome: ");
                    String nome = sc.next();
                    System.out.print(" Cpf: ");
                    String cpf = sc.next();
                    System.out.print(" Número da conta: ");
                    int numero = sc.nextInt();
                    System.out.print(" Agência: ");
                    String agencia = sc.next();

                    pessoa = new Pessoa(nome, cpf);
                    contaBancaria = new ContaBancaria(numero, 0.0, agencia);
                    break;
                case 2:
                    if (pessoa == null || contaBancaria == null) {
                        System.out.println("É necessário cadastrar um cliente primeiro.");
                        break;
                    } else {
                        System.out.println("Escolha que operação deseja realizar: ");
                        System.out.println("[1] - Consultar saldo");
                        System.out.println("[2] - Depositar saldo ");
                        System.out.println("[3] - Sacar saldo");
                        System.out.print(" Opção: \n> ");
                        int opcao2 = sc.nextInt();
                        switch (opcao2) {
                            case 1:
                                contaBancaria.consultarSaldo();
                                break;
                            case 2:
                                System.out.println("Insira o valor que deseja depositar: ");
                                double valor = sc.nextDouble();
                                contaBancaria.depositar(valor);
                                break;

                            case 3:
                                System.out.println("Insira o valor que deseja sacar: ");
                                double valor2 = sc.nextDouble();
                                contaBancaria.sacar(valor2);
                                break;

                        }

                    }
                    break;
                case 3:
                    System.out.println("Saindo do menu...");
                    break;
            }


        }
    }
}