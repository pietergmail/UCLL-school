import java.util.ArrayList;
import java.util.List;

public class Recursie {


    // Oefening 1: n-de Fibonacci-getal

    public static int fibonacci(int getal) {
        if (getal <= 0) throw new IllegalArgumentException("Getal moet groger dan 0 zijn.");
        if (getal == 1 || getal == 2) {
            return 1;
        }

        return fibonacci(getal - 1) + fibonacci(getal - 2);
    }

    // Oefening 2 : som van cijfers

    public static int somVanCijfers(int getal) {

        if (getal < 0) {
            getal *= -1;
        }
        if (getal == 0) {
            return 0;
        }
        int sum = getal % 10;
        return sum + somVanCijfers(getal / 10);
    }

    // Oefening 3: keer een string om
    public static String keerOm(String s) {
        if (s == null) {
            throw new IllegalArgumentException("string mag niet null zijn.");
        }
        if (s.length() <= 1) {
            return s;
        }
        return keerOm(s.substring(1)) + s.charAt(0);
    }

    //oefening 4: countX

    public static int countX(String s) {
        if (s == null) throw new IllegalArgumentException("String mag niet leeg zijn.");
        if (s.length() == 0) return 0;
        if (s.charAt(0) == 'x') {
            s = s.substring(1);
            return 1 + countX(s);
        } else {
            s = s.substring(1);
            return countX(s);
        }
    }

    //oefening 5 : countHi
    public static int countHi(String s) {
        if (s == null) throw new IllegalArgumentException("String mag niet leeg zijn.");
        if (s.length() == 1) return 0;
        if ((s.charAt(0) == 'h' || s.charAt(0) == 'H') && s.charAt(1) == 'i') {
            s = s.substring(1);
            return 1 + countHi(s);
        } else {
            s = s.substring(1);
            return countHi(s);
        }
    }

    // oefening 6
    public static String changeXY(String s) {
        if (s == null) throw new IllegalArgumentException("String mag niet leeg zijn.");
        if (s.length() == 0) return "";
        if (s.charAt(0) == 'x') {
            s = s.substring(1);
            return 'y' + changeXY(s);
        } else {
            char temp = s.charAt(0);
            s = s.substring(1);
            return temp + changeXY(s);
        }
    }

    // oefening 7

    public static String changePi(String s) {
        if (s == null) throw new IllegalArgumentException("String mag niet leeg zijn.");
        if (s.length() == 1) return s;
        if (s.charAt(0) == 'p' && s.charAt(1) == 'i') {
            s = s.substring(2);
            return "3.14" + changePi(s);
        } else {
            char temp = s.charAt(0);
            s = s.substring(1);
            return temp + changePi(s);
        }
    }

    // oefening 8:
    public static int tweelog(int getal) {
        if (getal <= 0) throw new IllegalArgumentException("Getal mag niet negatief zijn.");
        if (getal == 1) return 0;
        return tweelog(getal / 2) + 1;
    }

    // oefening 9;
    public static double findMaximum(List<Double> lijst) {
        if (lijst == null) throw new IllegalArgumentException("lijst is null");
        if (lijst.size() == 0) throw new IllegalArgumentException("Lijst is leeg.");

        if (lijst.size() == 1) return lijst.get(0);

        Double max = Math.max(lijst.get(0), lijst.get(1));
        if (max.equals(lijst.get(0))) {
            lijst.remove(1);
            return findMaximum(lijst);
        } else {
            lijst.remove(0);
            return findMaximum(lijst);
        }
    }

    // oefening 10;
    public static ArrayList<String> findSubstrings(String string) {
        if (string == null)
            throw new IllegalArgumentException();
        ArrayList<String> res = new ArrayList<String>();
        if (string.length() <= 1) { //ook de lege string telt mee!
            res.add(string);
            return res;
        } else {
            res.add(string.substring(0, 1));
            ArrayList<String> res2 = findSubstrings(string.substring(1));
            res.addAll(res2);
            for (String s : res2) {
                res.add(string.charAt(0) + s);
            }
            return res;
        }
    }
}