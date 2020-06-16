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
        //als matrix niet viierkant is of niet bestaand
        if (matrix == null || matrix.length != matrix[0].length)
            return false;
        //verbindingsmatrix moet overal 0 zijn op de diagonaal
        for (int i = 0; i < matrix.length; i++)
            if (matrix[i][i] != 0)
                return false;
        //het is een niet gerichte graaf dus rij-kolom moet gelijk zijn aan kolom-rij
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix.length; j++)
                if (matrix[i][j] != 0 && matrix[i][j] != 1)
                    return false;
        return true;
    }

    private int getAantalKnopen() {
        assert this.verbindingsMatrix != null;
        return this.verbindingsMatrix.length;
    }

    private boolean rechtstreekseVerbinding(int van, int tot){
        return this.getVerbindingsMatrix()[van - 1][tot - 1];
    }

    private boolean[][] getVerbindingsMatrix() {
        return verbindingsMatrix;
    }

    private int[] findAncestors(int start, int destination) {// nummering van
        // start-knoop
        int aantalknopen = this.getAantalKnopen();//new int met aantal knopen
        int[] ancestors = new int[aantalknopen];//nieuwe array ancestors met aantalknopen in
        initArray(ancestors, infty);//maak een array vol met de waarde infty
        Queue<Integer> queue = new LinkedList<>();//linkedlist Queue wordt gemaakt
        queue.add(start);//voeg start toe aan de linked list
        ancestors[start - 1] = 0;//0 wordt op de start van de ancestors arraylist gezet
        int huidig = queue.remove();//de waarde huidig neemt de volgende waarde aan
        while (huidig != destination) {
            //zoek alle nog niet bezochte knooppunten vanuit huidig
            for (int i = 1; i <= aantalknopen; i++) {
                //voeg toe als er een rechstreeks verbinding is
                if (rechtstreekseVerbinding(huidig, i) && (ancestors[i - 1] == infty)) {
                    //voeg knoop i toe aan de queue
                    queue.add(i);
                    //duid aan dat huidig de ouder is van i in ancestormatrix
                    ancestors[i - 1] = huidig;
                }
            }
            if (!queue.isEmpty()) {//queue moet leeg zijn
                huidig = queue.remove();
            } else {
                break;
            }
        }
        return ancestors;
    }

    public List<Integer> findPath(int start, int destination) {
        if (start <= 0 || start > this.getAantalKnopen() ||
                destination <= 0 ||
                destination > this.getAantalKnopen())
            throw new IllegalArgumentException();
        int[] ancestors = this.findAncestors(start, destination);//vind de ancestors van de waardes
        List<Integer> path = new LinkedList<>();
        int ouder = ancestors[destination - 1];//ouder bepalen
        while (ouder != 0 && ouder != infty){//zolang de ouder bestaat
            path.add(0, destination);//toevoegen aan pad
            destination = ouder;//verander destination naar ouder
            ouder = ancestors[destination - 1];//nieuw ouder en hoger
        }
        if (ouder == 0){//einde bereikt
            path.add(0, destination);
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


}
