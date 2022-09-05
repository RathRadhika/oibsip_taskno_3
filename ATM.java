package com.company;
import java.util.Scanner;

public class ATM {
    public static void main(String []args){
        AtmInterface atm = new AtmImplement();
        int accntNum[] = {45678, 12345, 78901, 98765, 90876};
        double accntpin[] = {456732, 678987, 234543, 456765, 789456, 123908};
        double accntAmnt[] = {90000, 78900, 34000, 98700, 23000, 78000};
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Account Number:- ");
        int num = in.nextInt();
        System.out.println("Enter Account Pin:- ");
        double pin = in.nextDouble();
        int a=-1;
        for(int i=0;i<accntNum.length;i++){
            if(num==accntNum[i]){
                a=i;
                break;
            }
        }
        if(a ==-1){
            System.out.println("Invalid account number.");
            System.exit(0);
        }
        if(pin==accntpin[a]){
            while(true){
                System.out.println();
                System.out.println("1. Transcation History\n2. Withdraw\n3. Deposit\n4. Transfer\n5. Quit");
                System.out.println("Enter Your choice:- ");
                int choice  = in.nextInt();

                if(choice == 1){
                    atm.transcationHistory();
                }
                else if(choice == 2){
                    System.out.println("Enter the amount to withdraw:- ");
                    double withdrawAmount = in.nextDouble();
                    atm.withdraw(withdrawAmount, accntAmnt, a);
                }
                else if(choice == 3){
                    System.out.println("Enter the amount to be deposited:- ");
                    double depositAmount = in.nextDouble();
                    atm.deposit(depositAmount, accntAmnt, a);
                }
                else if(choice == 4){
                    int index2 = -1;
                    System.out.println("Enter account number you want to transfer amount:- ");
                    double transferNumber = in.nextDouble();
                    for(int j=0;j<accntNum.length;j++){
                        if(transferNumber==accntNum[j]){
                            index2 = j;
                            break;
                        }
                    }
                    if(index2==a){
                        System.out.println("You cannot transfer amount to your own account...INVALID ACTION.");
                        System.exit(0);
                    }
                    if(index2==-1){
                        System.out.println("Account is not present in the bank..");
                        System.exit(0);
                    }

                    System.out.println("Amount of money you want to transfer:- ");
                    double transferAmount = in.nextDouble();
                    atm.transfer(transferAmount, accntAmnt, a, index2);
                }
                else if(choice == 5){
                    System.out.println("THANK YOU...");
                    System.exit(0);
                }
                else{
                    System.out.println("User Input not correct");
                }
            }
        }
        else{
            System.out.println("Pin is not correct.");
            System.exit(0);
        }

    }
}
