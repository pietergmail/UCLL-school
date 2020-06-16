package domain;

import java.util.ArrayList;

public class Graph {
	private final int[][] gewichtenMatrix;
    private final int inf = Integer.MAX_VALUE;

	public Graph(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
			throw new IllegalArgumentException();
		}

		this.gewichtenMatrix = matrix.clone();
	}

    private int getAantalKnopen() {
        return gewichtenMatrix.length;
    }


    private int[][] initMatrixDijkstra(int vanKnoop) {
        int[][] res = new int[this.gewichtenMatrix.length + 1][this.gewichtenMatrix.length];
        // laatste rij is rij met kortste lengtes vanuit vanKnoop
        // oefening 3.3
        for (int i = 0; i < getAantalKnopen(); i++) {
            for (int j = 0; j < getAantalKnopen(); j++)//doorloop hele matrix
                res[i][j] = gewichtenMatrix[i][j] != inf ? gewichtenMatrix[i][j] : 0;//vervang het door i j of 0 als het glijk is aan inf
            res[getAantalKnopen()][i] = inf;//vervang onderste lijn door infs
        }
        for (int i = 0; i <= getAantalKnopen(); i++) {//verwijder alles vanuit huidige knoop (buiten knoop zelf)
            res[i][vanKnoop - 1] = 0;
        }
        return res;//return de res matrix
    }

	public int[][] Dijkstra(int vanKnoop) {
		int[][] res = initMatrixDijkstra(vanKnoop);
		
		System.out.println("Initiele matrix: \n");
		printIntMatrix(res);

		for (int i = 0; i < getAantalKnopen() - 1; i++){
		    //zoek nieuwe minimale afstand
		    int min = inf;
		    int[] knopenpaar = {inf, inf};
		    for (int j = 0; j < getAantalKnopen(); j++){
                // als knoop k+1 nog niet gevonden is,
                // als er een verbinding is tussen knoop j+1 en knoop k+1
                // en als de verbinding tussen deze knopen korter is
                // dan het minimum tot nog toe
		        if (res[getAantalKnopen()][j] != inf){
		            for (int k = 0; k < getAantalKnopen(); k++){
                        if (res[getAantalKnopen()][k] == inf && res[j][k] != 0 &&
                                res[getAantalKnopen()][j] + res[j][k] < min){
                            //onthoud (index van) dit knopenpaar en hun minimum
                            knopenpaar[0] = j;
                            knopenpaar[1] = k;
                            min = res[getAantalKnopen()][j] + res[j][k];
                        }
                    }
                }
            }
            if (knopenpaar[0] != inf && knopenpaar[1] != inf){
                //nieuwe minimum
                res[getAantalKnopen()][knopenpaar[1]] = min;
                for (int j = 0; j < getAantalKnopen() - 1; j++){
                    //kolom op nul zetten, maar niet op plaats die het minimum aanlevert
                    if (j != knopenpaar[0]){
                        res[j][knopenpaar[1]] = 0;
                    }
                }
            }
        }



		return res;
	}

	private ArrayList<Integer> vindPad(int vanKnoop, int naarKnoop, int[][] res) {
		ArrayList<Integer> pad = new ArrayList<>();

		pad.add(naarKnoop);
		//zolang het niet bij naar knoop is
		while(naarKnoop != vanKnoop){
		    int k = 1;
		    //zolang het niet nul is of het kleiner is dan aantal knopen
		    while (k - 1 < getAantalKnopen() && res[k - 1][naarKnoop - 1] == 0)
		        k++;
		    pad.add(0, k);//voeg k toe
		    naarKnoop = k;//K wordt de nieuwe knoop waar naartoe wordt gezocht
        }
		return pad;
	}

	public String berekenPaden(int vanKnoop) {
        String uit = "";
        int[][] res = this.Dijkstra(vanKnoop);

        System.out.println("Resulterende matrix: \n");
        printIntMatrix(res);

        for (int i = 0; i < getAantalKnopen(); i++) {
            if ((i + 1) != vanKnoop) {
                if (res[getAantalKnopen()][i] == Integer.MAX_VALUE) {
                    uit += "Er is geen pad van " + vanKnoop + " naar " + (i + 1) + "\n";
                } else {
                    uit += "Kortste afstand van " + vanKnoop + " naar " + (i + 1) + " = " + res[getAantalKnopen()][i] + "\n";
                    uit += "via ";

                    int j = (i + 1);
                    ArrayList<Integer> pad = vindPad(vanKnoop, j, res);
                    uit += pad + "\n";
                }
            }
        }

		return uit;
	}
	
	private static void printIntMatrix(int[][] matrix) {
		String result ="";
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				result += (matrix[i][j] == Integer.MAX_VALUE ? "inf" : matrix[i][j]) + "\t";
			}
			result += "\n";
		}
		result += "\n";
		
		System.out.println(result);		
	}

}
