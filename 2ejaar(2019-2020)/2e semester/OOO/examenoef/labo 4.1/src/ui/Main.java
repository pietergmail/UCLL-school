package ui;

import domain.Account;
import domain.Auditor;
import domain.Bank;
import domain.Logger;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Bank bank = new Bank();
        Auditor a = new Auditor(bank);
        Logger l = new Logger(bank);

        Account a1 = new Account(1,100);
        Account a2 = new Account(2,200);
        bank.addAccount(a1);
        bank.addAccount(a2);

        bank.storten(a1,200);
        bank.afhalen(a1,200);
    }
}
