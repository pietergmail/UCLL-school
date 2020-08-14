package domain;

public class CodeContext {
    private CodeStrategy cb;
    public CodeContext(CodeStrategy codeStrategy){
        this.cb = codeStrategy;
    }

    public String encode(String message){
        return cb.encode(message);
    }

    public String decode(String message){
        return cb.decode(message);
    }

    @Override
    public String toString(){
        return cb.toString();
    }
}
