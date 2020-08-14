package domain;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Bank implements Subject {
    private HashMap<Integer, Account> accounts;
    private ArrayList<Observer> observersList = new ArrayList<>();
    private HashMap<Events, ArrayList<Observer>> observers;
    private Account newest = new Account(0, 0);
    private Events type;

    public Bank(){
        accounts = new HashMap<>();
        observers = new HashMap<>();
        observers.put(Events.NEW, new ArrayList<Observer>());
        observers.put(Events.AFHALEN, new ArrayList<Observer>());
        observers.put(Events.STORTEN, new ArrayList<Observer>());
    }

    public void addAccount(Account a){
        accounts.put(a.getIndex(), a);
        newest = a;
        notifyObservers(Events.NEW);
    }

    public HashMap getAccounts(){return this.accounts;}
    public Account getAccount(int index){return accounts.get(index);}
    public void deleteAccount(int index){accounts.remove(index);}

    public Account getNewest(){return newest;}

    @Override
    public void registerObserver(Events e, Observer o) {
        observers.get(e).add(o);
    }

    @Override
    public void removeObserver(Events e, Observer o) {
        observers.get(e).remove(o);
    }

    @Override
    public void notifyObservers(Events e) {
        for (Observer o: observers.get(e)) {
            o.update(e);
        }
    }

    public void storten(Account a,double saldo){
        Account account = accounts.get(a.getIndex());
        if(account == null){
            System.out.println("rekening niet gevonden");
        }
        else{
            account.storten(saldo);
            newest = account;
            notifyObservers(type.STORTEN);
        }
    }
    public void storten(int a,double saldo){
        Account account = accounts.get(a);
        if(account == null){
            System.out.println("rekening niet gevonden");
        }
        else{
            account.storten(saldo);
            newest = account;
            notifyObservers(type.STORTEN);
        }
    }
    public void afhalen(int a,double saldo){
        Account account = accounts.get(a);
        if(account == null){
            System.out.println("rekening niet gevonden");
        }
        if (account.getSaldo() < saldo){
            System.out.println("niet genoeg geld op de rekening");
        }
        else{
            account.afhalen(saldo);
            newest = account;
            notifyObservers(type.AFHALEN);
        }
    }
    public void afhalen(Account a,double saldo){
        Account account = accounts.get(a.getIndex());
        if(account == null){
            System.out.println("rekening niet gevonden");
        }else{
            if (account.getSaldo() < saldo){
                System.out.println("niet genoeg geld op de rekening");
            }
            else{
                account.afhalen(saldo);
                newest = account;
                notifyObservers(type.AFHALEN);
            }}

    }
}
