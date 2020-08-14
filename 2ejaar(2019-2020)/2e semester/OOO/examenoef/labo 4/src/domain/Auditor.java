package domain;

import java.time.LocalDateTime;

public class Auditor implements Observer{
    private Bank bank;

    public Auditor(Bank b){
        this.bank = b;
        bank.registerObserver(Events.NEW, this);
    }
    @Override
    public void update(Events e) {
        Account a = (Account) bank.getNewest();
        System.out.println("Nieuwe rekening geopend op datum " + LocalDateTime.now());
    }
}
