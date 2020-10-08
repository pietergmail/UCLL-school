package domain;

import java.lang.reflect.Constructor;

public class CodeFactory {
    public CodeFactory(){

    }

    public static CodeStrategy makeCode(String type, Object... args){
        CodeStrategy instance = null;
        Class <?> [] arg = new Class[args.length];
        int tel = 0;
        for (Object object:args){
            arg[tel++] = object.getClass();
        }
        try{
            CodeType codeType = CodeType.valueOf(type);
            Class<?> clazz = Class.forName(codeType.getKlasseNaam());
            Constructor<?> constructor = clazz.getConstructor(arg);

            instance = (CodeStrategy)constructor.newInstance(args);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return instance;
    }
}
