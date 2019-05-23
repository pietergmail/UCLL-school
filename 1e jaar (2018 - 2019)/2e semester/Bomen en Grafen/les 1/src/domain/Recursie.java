package domain;

public class Recursie{


    public static int fibonacci(int getal) {
        if (getal <= 0) {
            throw new IllegalArgumentException("het getal moet positief zijn.");
        }
        if (getal <= 2) {
            return 1;
        } else {
            return fibonacci(getal - 2) + fibonacci(getal - 1);
        }
    }

    public static int somVanCijfers(int getal){
        if(getal < 0){
            getal = getal * -1;
        }
        String getals = getal + "";
        if (getals.length() == 1){
            return getal;
        }else{
            return Integer.parseInt(getals.substring(0, 1)) + somVanCijfers(Integer.parseInt(getals.substring(1, getals.length())));
        }
    }

    public static String keerOm(String s){
        if (s == null){
            throw new IllegalArgumentException("s can't be null");
        } else {
            if (s.length() <= 1){
                return s;
            } else {
                return s.substring(s.length() - 1, s.length()) + keerOm(s.substring(0, s.length() -1))
            }
        }
    }
}
