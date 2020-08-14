package ui;

import domain.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        //Code c = new Code( new Caesarcode());
        //System.out.println(c.encode("dit is zeer geheim!"));
        //System.out.println(c.decode(c.encode("dit is zeer geheim!")));

        //Code c2 = new Code(new Spiegeling());
        //System.out.println(c2.encode("dit is zeer geheim!"));
        //System.out.println(c2.decode(c2.encode("dit is zeer geheim!")));
        codeContext c = new codeContext("RandomCypherAdapter", new RandomCypher());
        System.out.println(c.encode("ok"));
        System.out.println(c.decode(c.encode("ok")));
        //CodeLauncher c = new CodeLauncher();

    }
}
