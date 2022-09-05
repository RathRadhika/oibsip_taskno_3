package com.company;
import java.util.HashMap;
import java.util.Map;

public class AtmImplement implements AtmInterface{
    Map<Double, String> history = new HashMap<>();

    @Override
    public void viewAmount(double accntAmnt[], int index) {
        System.out.println(accntAmnt[index]+" present in the account.");
    }

    @Override
    public void withdraw(double withdrawAmnt, double []accntAmnt, int index) {
        if(withdrawAmnt>accntAmnt[index]){
            System.out.println("Insufficient amount in the account.");
        }
        else{
            history.put(withdrawAmnt, "Withdrawed");
            System.out.println(withdrawAmnt+" has been withdrawned.");
            accntAmnt[index] = accntAmnt[index] - withdrawAmnt;
            viewAmount(accntAmnt, index);


        }

    }

    @Override
    public void deposit(double depositAmnt, double []accntAmnt, int index) {
        history.put(depositAmnt, " Deposited");
        System.out.println(depositAmnt+ " has been deposited.");
        viewAmount(accntAmnt, index);
    }
    @Override
    public void transfer(double transferAmnt, double []accntAmnt, int index1, int index2){
        if(transferAmnt>accntAmnt[index1]){
            System.out.println("Insufficient amount.");
        }
        else{
            history.put(transferAmnt, "AMOUNT TRANSFERED" );
            System.out.println(transferAmnt+" has been transfered Successfully.");
            accntAmnt[index1] = accntAmnt[index1] - transferAmnt;
            accntAmnt[index2] = accntAmnt[index2] + transferAmnt;
            viewAmount(accntAmnt, index2);
        }
    }

    @Override
    public void transcationHistory() {
        for(Map.Entry<Double, String>e:history.entrySet()){
            System.out.println(e.getKey()+" "+e.getValue());
        }
    }
}
