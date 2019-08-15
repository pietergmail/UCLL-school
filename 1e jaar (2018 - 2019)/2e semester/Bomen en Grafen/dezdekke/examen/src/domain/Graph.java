package domain;

import java.util.ArrayList;
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

    private int getAantalKnopen() {
        return this.verbindingsMatrix.length;
    }

    private int[] findAncestors(int start, int destination) {// nummering van
        // start-knoop
        // (1..aantal_knopen)
        // naar
        // eindKnoop
        // (destination)
        int[] ancestors = new int[this.getAantalKnopen()];
        initArray(ancestors, infty);

        Queue<Integer> queue = new LinkedList<>();
        // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Queue.html
        queue.add(start);
        ancestors[start - 1] = 0;
        int current = queue.remove() -1;
        // LOOPEN OVER DE RIJ VAN NU TE ONDERZOEKEN KNOOP
        for (int col = 0 ; col < verbindingsMatrix[current].length ; col++){
            if (verbindingsMatrix[current][col]) {
                if (ancestors[col] == infty){
                    queue.add(col+1);
                    ancestors[col] = current + 1;
                }
            }
            if (col == verbindingsMatrix[current].length-1 && !queue.isEmpty()){
                current = queue.remove() - 1;
                col = 0;
            }
        }

        return ancestors;
    }

    public List<Integer> findPath(int start, int destination) {
        if (start <= 0 || start > this.getAantalKnopen() || destination <= 0 || destination > this.getAantalKnopen())
            throw new IllegalArgumentException();

        int[] ancestors = this.findAncestors(start, destination);
        List<Integer> path = new LinkedList<>();
        int current = destination-1;

        while (current != -1 && ancestors[current] != infty){
            path.add(0, current+1);
            current = ancestors[current] - 1;
        }

        if (current != -1 && ancestors[current] == start){
            path.add(0, start);
        }

        return path;

    }

    private void initArray(int[] array, int value) {
        for (int i = 0; i < array.length; i++)
            array[i] = value;
    }


    // methode om tussenliggend resultaat te kunnen schrijven naar het scherm
    public String geefAncestors(int start, int destination) {
        String res = "Ancestors van " + start + " naar " + destination + ":\n";
        int[] ancestors = this.findAncestors(start, destination);
        for (int a = 0; a < ancestors.length; a++)
            res += ancestors[a] != infty ? ancestors[a] : "infty" + " ";

        return res;
    }
    public ArrayList<Double> verdeel(int i, double bedrag){
        ArrayList<Double> result = new ArrayList<>();
        int[] algedaan = findAncestors(i,0);
        initArray(algedaan, infty);

        bedrag=bedrag/2;
        result.add(bedrag);

        int length = verbindingsMatrix.length;
        int aantal = 0;
        ArrayList<Integer> index  = new ArrayList<>();
        result.add(bedrag/2);
        for(int p = 0; p < length; p++){ // elke persoon itereren
            bedrag=bedrag/2; // bedrag halveren
            for(int j = 0; j < length; j++){// elke persoon itereren
                if(verbindingsMatrix[i][j] == true && algedaan[j] != 0){ // als persoon verbonden is met 2e persoon
                    index.add(j); // mensen onthouden
                    algedaan[j] = 0;
                    aantal++; // aantal mensen onthouden
                }
            }
            for(i = 0; i < index.size(); i++){
                result.add(i,bedrag/aantal);
            }
        }
        return result;
    }

}
