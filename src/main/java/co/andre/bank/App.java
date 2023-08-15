package co.andre.bank;

import java.util.List;
import java.util.Scanner;

public class App {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank santander = new Bank("0001");
        //           CB = CRIAR CONTA
        //           E = SAIR (EXIT)

         while (true) {
            System.out.println("O que você deseja fazer ? Digite: (CB) para criar uma conta. ; Digite: (E) para sair do menu de criação de conta. ");
            String op = scanner.nextLine();

            if (op.equals("CB")) {
                System.out.println("Digite o seu nome: ");
                String name = scanner.nextLine();
                Account account = santander.generateAccount(name);
                santander.insertAccount(account);

                operateAccount(account);
            } else if (op.equals("E")) {
                break;
            } else {
                System.out.println("O valor digitado não é correspondente, o programa será encerrado.");
            }
         }

        List<Account> accountList = santander.getAccounts();
        for (Account cc : accountList) {
            System.out.println(cc);
        }
        santander.outputTotal();
    }

    static void operateAccount(Account account) {
        Scanner scanner = new Scanner(System.in);
        //            D = DEPOSITO
        //            S = SAQUE
        //            E = SAIR (EXIT)

        while (true) {
            String quizOperation = " O que deseja fazer ? Digite: (D) para depositar.; Digite: (S) para sacar.; Digite: (C) para consultar o valor da conta.;Digite: (E) para sair da conta.";
            System.out.println(quizOperation);
            String op = scanner.nextLine();

            if (op.equals("C")) {
                double valueConsult = account.getBalance();
                System.out.print("O valor da sua conta atualmente é: " + valueConsult + " .");
            } else if (op.equals("D")) {
                System.out.println("Qual valor você deseja depositar?");
                double value = scanner.nextDouble();
                account.deposit(value);
                System.out.println("O valor " + value + " foi depositado.");
            } else if (op.equals("S")) {
                System.out.println("Qual valor você deseja sacar?");
                double value = scanner.nextDouble();

                if(value < account.getBalance()){
                    account.withDraw(value);
                    System.out.println("O valor " + value + " foi sacado.");
                } else {
                    System.out.println("Erro, não foi possível sacar o valor: " + value + " , saldo insuficiente.");
                }

            } else if (op.equals("E")) {
                System.out.println("Programa encerrado.");
                break;
            } else {
                System.out.println("O valor digitado não é correspondente, o programa será encerrado.");
                break;
            }

            scanner = new Scanner(System.in);

        }
    }

}
