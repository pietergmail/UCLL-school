package domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    private final boolean[][] verbindingsMatrix;
    public static final int infty = Integer.MAX_VALUE;

    public Graph(int[][] matrix) {
        if (!isGeldigeVerbindingsMatrix(matrix))
            throw new IllegalArgumentException("No valid nabijheidsmatrix");

        this.verbindingsMatrix = new boolean[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix.length; j++)
                this.verbindingsMatrix[i][j] = matrix[i][j] == 1;
    }

    private boolean isGeldigeVerbindingsMatrix(int[][] matrix) {
        // als de matrix niet vierkant is of null
        if (matrix == null || matrix.length != matrix[0].length)
            return false;
        // Verbindingsmatrix moet overal 0 zijn op de diagonaal
        for (int i = 0; i < matrix.length; i++)
            if (matrix[i][i] != 0)
                return false;
        //Het is een niet gerichte graaf dus rij-kolom moet gelijk zijn aan kolom-rij
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix.length; j++)
                if (matrix[i][j] != 0 && matrix[i][j] != 1)
                    return false;
        return true;
    }

    private boolean rechtstreekseVerbinding(int van, int tot) {
        //System.out.println("verbinding van "+van+" tot "+tot+"?");
        return this.getVerbindingsMatrix()[van - 1][tot - 1];
    }
    private int[] findAncestors(int start, int destination) {
        int aantalKnopen = this.getAantalKnopen();//new int met aantal knopen in
        int[] ancestors = new int[aantalKnopen];//nieuwe array ancestors met aantalknopen in
        initArray(ancestors, infty);//maak een array vol met de waarde infy
        Queue<Integer> queue = new LinkedList<>();//linkedlist Queue wordt gemaakt
        queue.add(start);//voeg start toe aan de linked list
        ancestors[start - 1] = 0;//0 wordt op de start vna de ancestors arraylist gezet
        int huidig = queue.remove();//de waarde huidig neemt de volgende waarde aan
        while (huidig != destination) {
            //System.out.println("huidig = "+huidig);
            //zoek alle nog niet bezochte knooppunten vanuit huidig
            for (int i = 1; i <= aantalKnopen; i++) {
                if (rechtstreekseVerbinding(huidig, i) && (ancestors[i - 1] == infty)) {
                //System.out.println("ja");
                //voeg knoop i toe aan queue
                    queue.add(i);
                    //duid aan dat huidig de ouder is van i in ancestormatrix
                    ancestors[i - 1] = huidig;
                }
            }
            //voorste element van queue wordt nieuwe huidige knoop
            if (!queue.isEmpty()) {//al er nog iets in de queue zit moet hij verwijderd wordt
                huidig = queue.remove(); //of .poll() wat geen exception gooit
            } else {
            //queue is leeg, stop maar
                break;
            }
        }
        return ancestors;
    }

    private int getAantalKnopen() {
        return this.verbindingsMatrix.length;
    }

    public boolean[][] getVerbindingsMatrix() {
        return verbindingsMatrix;
    }
    private void initArray(int[] array, int value) {
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

    //methode om tussenliggende resultaat te kunnen schrijven naar het scherm
    public String geefAncestors(int start, int destination) {
        String res = "Ancestors van "+start+" naar "+destination+":\n";
        int[] ancestors = this.findAncestors(start, destination);
        for (int a=0; a<ancestors.length; a++)
            res += ancestors[a]!=infty ? ancestors[a]:"infty"+" ";

        return res;
    }

}
        
