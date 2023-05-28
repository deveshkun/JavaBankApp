import javax.swing.plaf.synth.SynthTextAreaUI;
import java.awt.*;
import java.sql.SQLSyntaxErrorException;
import java.util.Scanner;

public class Bank_App {
    public static void main(String arg[]){
        BankAcc obj1 = new BankAcc("XYZ","BA0001");
        obj1.showmenu();
    }
}

class BankAcc
{
    int balance;
    int prev_tranx;
    String customid;
    String customname;

    BankAcc(String cname,String cid)
    {
        customname = cname;
        customid = cid;
    }

    void deposite(int amount)
    {
        if (amount != 0){
            balance = balance + amount;
            prev_tranx = amount;
        }
    }

    void withdraw(int amount)
    {
        if (amount != 0) {
            balance = balance - amount;
            prev_tranx = -amount; //"-" because we are withdrawing
        }
    }

    void getprevtrnx()
    {
        if (prev_tranx>0){
            System.out.printf("Deposited %d",prev_tranx);
        }
        else if (prev_tranx<0){
            System.out.printf("Redeemed %d",Math.abs(prev_tranx)); // gives positive value
        }
        else {
            System.out.println("No Transection Occured");
        }
    }

    void showmenu()
    {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome " + customname);
        System.out.println("Your Customer ID is -> "+ customid);
        System.out.println("\n");
        System.out.println("A -> Check balance");
        System.out.println("B -> Deposite");
        System.out.println("C -> Withdraw");
        System.out.println("D -> Previous Tranxx");
        System.out.println("E -> Exit");

        do {
            System.out.println("------------------------xxxxxxxxxxxxxxxxx------------------------\n");
            System.out.print("Enter an Option -> ");
            option = scanner.next().charAt(0);
            System.out.println("\n");


            switch (option)
            {
                case 'A':
                    System.out.println("--------------------------------");
                    System.out.println("Baance -> "+balance);
                    System.out.println("--------------------------------");
                    break;

                case 'B':
                    System.out.println("--------------------------------");
                    System.out.print("Enter the amount to deposite -> ");
                    int x = scanner.nextInt();
                    deposite(x);
                    System.out.println("\n");
                    break;

                case 'C':
                    System.out.println("--------------------------------");
                    System.out.print("Enter amount to withdraw -> ");
                    int y = scanner.nextInt();
                    withdraw(y);
                    System.out.println("\n");
                    break;

                case 'D':
                    System.out.println("--------------------------------");
                    getprevtrnx();
                    System.out.println("\n");
                    break;

                case 'E':
                    System.out.println("--------------------------------");
                    break;

                default:
                    System.out.println("Invaid Input");
                    break;
            }
        }while (option != 'E');
        System.out.println("Thank You ^^");

    }
}
