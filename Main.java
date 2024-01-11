import java.util.*;
import java.io.*;

class ATM {
    String name;
    int balance, acc;

    public ATM(String name, int balance) {
        this.name = name;
        this.balance = balance;

        Set<Integer> s = new HashSet<Integer>();
        Random rand = new Random();
        int max = 999999, min = 200000;

        acc = rand.nextInt(max - min + 1) + min;
        while (s.contains(acc) == true) {
            acc = rand.nextInt(max - min + 1) + min;
        }
        s.add(acc);
        System.out.println("Your account number is : " + acc);
    }

    public void Info() {
        System.out.println("Account Holder Name : " + this.name);
        System.out.println("Account Number : " + acc);
    }

    public void Deposit(int deposit_amount) {
        balance += deposit_amount;
    }

    public void Withdraw(int Withdraw_amount) {
        if (balance >= Withdraw_amount) {
            balance -= Withdraw_amount;
            System.out.println("Collect your money");
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void Balance() {
        System.out.println("Your balance amount is " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<ATM> list = new ArrayList<ATM>();

        LOOP: while (true) {
            System.out.println("-------BANK-------" + "\n" + "Choose..." + "\n" + "1...SignUp" + "\n" + "2...LogIn"
                    + "\n" + "3...Exit");
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("-----SignUp-----");
                    System.out.println("Enter your name : ");
                    in.nextLine();
                    String name = in.nextLine();

                    System.out.println("Your Account ID is : " + (1 + list.size()));

                    ATM obj = new ATM(name, 0);
                    list.add(obj);

                    break;
                case 2:
                    System.out.println("-----LogIn-----");
                    System.out.println("Enter your Account ID : ");
                    int id = in.nextInt();

                    if (id <= list.size()) {
                        list.get(id - 1).Info();
                        loop: while (true) {
                            System.out.println("-------ATM-------" + "\n" + "Choose... " + "1...Deposit "
                                    + "2...Withdraw " + "3...Balance " + "4...Exit");
                            int ch = in.nextInt();
                            switch (ch) {
                                case 1:
                                    System.out.println("Enter amount : ");
                                    int deposit_amount = in.nextInt();
                                    list.get(id - 1).Deposit(deposit_amount);
                                    break;
                                case 2:
                                    System.out.println("Enter amount : ");
                                    int Withdraw_amount = in.nextInt();
                                    list.get(id - 1).Withdraw(Withdraw_amount);
                                    break;
                                case 3:
                                    list.get(id - 1).Balance();
                                    break;
                                case 4:
                                    break loop;

                                default:
                                    System.out.println("Invalid Input");
                            }
                        }
                    } else
                        System.out.println("Account ID doesn't exit");

                    break;

                case 3:
                    break LOOP;

                default:
                    System.out.println("Invalid Input");

            }

        }
    }

}
