package domain;

public class Logger implements Observer{
    Bank bank;

    public Logger(Bank b){
        this.bank = b;
        bank.registerObserver(Events.NEW, this);
        bank.registerObserver(Events.AFHALEN, this);
        bank.registerObserver(Events.STORTEN, this);
    }

    @Override
    public void update(Events e) {
        Account a = (Account) bank.getNewest();
        if(e.toString().equals("NEW"))
            System.out.println(" nummer: " + a.getIndex() + " new total:" + bank.getAccounts().size());
        else
            System.out.println(" nummer: " + a.getIndex() + " new total:" + a.getSaldo());

    }
}
