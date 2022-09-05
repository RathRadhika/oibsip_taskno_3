package com.company;

public interface AtmInterface {
    public void viewAmount(double accntAmnt[], int index);
    public void withdraw(double withdrawAmnt, double []accntAmnt, int index);
    public void deposit(double depositAmnt, double []accntAmnt, int index);
    public void transfer(double transferAmnt, double []accntAmnt, int index1, int index2);
    public void transcationHistory();
}
