package domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    private final boolean[][] verbindingsMatrix;
    public static final int infty = Integer.MAX_VALUE;

    public Graph(int[][] matrix) {
        if (!isGeldigeVerbindingsMatrix(matrix))
            throw new IllegalArgumentException("No valid verbindingsmatrix");

        this.verbindingsMatrix = new boolean[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix.length; j++)
                this.verbindingsMatrix[i][j] = matrix[i][j] == 1;
    }

    private boolean isGeldigeVerbindingsMatrix(int[][] matrix) {
        if (matrix == null || matrix.length != matrix[0].length)
            return false;

        for (int i = 0; i < matrix.length; i++)
            if (matrix[i][i] != 0)
                return false;

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix.length; j++)
                if (matrix[i][j] != 0 && matrix[i][j] != 1)
                    return false;
        return true;
    }

    private boolean rechtstreekseverbinding(int van, int tot){
        return this.getVerbindingsMatrix() [van - 1][tot - 1];
    }

    private int getAantalKnopen() {
        return this.verbindingsMatrix.length;
    }

    private int[] findAncestors(int start, int destination) {// nummering van
        // start-knoop
        // (1..aantal_knopen)
        // naar
        // eindKnoop
        // (destination)
        int aantalknopen = this.getAantalKnopen();
        int[] ancestors = new int[this.getAantalKnopen()];
        initArray(ancestors, infty);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        ancestors[start - 1] = 0;
        int huidig = queue.remove();
        while (huidig != destination){
            for (int i = 1; i<= aantalknopen; i++){
                if (rechtstreekseverbinding(huidig, i) && (ancestors[i - 1] == infty)){
                    queue.add(i);
                    ancestors[i - 1] =  huidig;
                }
            }
            if (!queue.isEmpty()){
                huidig = queue.remove();
            }else{
                break;
            }
        }
        return ancestors;
    }

    private boolean[][] getVerbindingsMatrix(){return verbindingsMatrix;}

    private void initArray(int[] array, int value){
        for (int i = 0; i < array.length; i++)
            array[i] = value;
    }

    public List<Integer> findPath(int start, int destination) {
        if (start <= 0 || start > this.getAantalKnopen() || destination <= 0 ||
                destination > this.getAantalKnopen())//exception check
            throw new IllegalArgumentException();
        int[] ancestors = this.findAncestors(start, destination);//vind de ancestors van de waardes
        List<Integer> path = new LinkedList<>();//new list genaamd path
        int ouder = ancestors[destination - 1];//ouder is eentje boven de destination
        while (ouder != 0 && ouder != infty) {//zolang de ouder bestaat
            path.add(0, destination);//add deze aan het pad
            destination = ouder;//verander de destination naar ouder
            ouder = ancestors[destination - 1];//nieuew ouder een hoger
        }
        if (ouder == 0) {//einde bereikt
            path.add(0,destination);
        }
        return path;
    }
    // methode om tussenliggend resultaat te kunnen schrijven naar het scherm
    public String geefAncestors(int start, int destination) {
        String res = "Ancestors van " + start + " naar " + destination + ":\n";
        int[] ancestors = this.findAncestors(start, destination);
        for (int a = 0; a < ancestors.length; a++)
            res += ancestors[a] != infty ? ancestors[a] : "infty" + " ";

        return res;
    }


}
