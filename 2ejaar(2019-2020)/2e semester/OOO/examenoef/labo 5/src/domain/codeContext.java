package domain;

public class codeContext {
    private CodeStrategy cb;

    public codeContext(String s){cb = CodeFactory.makeCode(s);}
    public codeContext(String s, Object... args){cb = CodeFactory.makeCode(s, args);}

    public String encode(String m){return cb.encode(m);}

    public String decode(String m){return cb.decode(m);}

    @Override
    public String toString(){return cb.toString();}
}
