package domain;

public class DennisCode implements CodeStrategy {
codeContext c = new codeContext("Caesarcode",5);
codeContext c2 = new codeContext("Spiegeling");

    @Override
    public String encode(String m) {
        return c2.encode(c.encode(m));
    }

    @Override
    public String decode(String m) {
        return c2.decode(c.decode(m));
    }
}
