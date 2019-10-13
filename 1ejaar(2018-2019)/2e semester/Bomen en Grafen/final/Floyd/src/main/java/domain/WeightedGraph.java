package main.java.domain;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {
	private final double[][] gewichtenMatrix;
	public final static double infty = Double.POSITIVE_INFINITY;

	public WeightedGraph(double[][] matrix) {//maakt nieuwe gewichtmatrix aan op basis van de double matrix
		if (matrix == null || matrix.length != matrix[0].length)
			throw new IllegalArgumentException("No valid gewichtenmatrix");
		this.gewichtenMatrix = matrix;
	}

	public int[][] findDistances() {//bepaalt de pointermatrix
		int[][] path = new int[this.gewichtenMatrix.length][this.gewichtenMatrix.length];//nieuwe vierkante matrix genaamd path
		double[][] D = this.gewichtenMatrix.clone();//nieuwe matrix clone van gewichtenmatrix
		int aantal = gewichtenMatrix.length;//aantal is lengte gewichtmatrix
		for (int k = 0; k < aantal; k++) {//ga door de lengte
			for (int i = 0; i < aantal; i++) {//ga door de lengtenog eens
				for (int j = 0; j < aantal; j++) {//ga door de lengte nog eens
					if (D[i][k] + D[k][j] < D[i][j]) {//bepaalt pointermatrix (als deze korter is dan de huidige waarde)
						D[i][j] = D[i][k] + D[k][j];//vervang de huidige waarde door nieuwe waarde
						path[i][j] = k + 1;//wordt in het pad opgeslagen
					}
				}
			}
		}
		// oefening 2.3
		return path;
	}

	public List<Integer> getShortestPath(int van, int tot, int[][] P) {//bepaalt kortste pad geeft van tot en een matrix mee
		List<Integer> pad = new ArrayList<>();//nieuwe arraylist genaamt pad
		if (van == tot) {//kortste pad gevonden
			return pad;
		} else {//pad is niet gevonden
			int via = P[van - 1][tot - 1];
			if (via == 0){//afstand tussen twee is nul
				pad.add(van);//voeg van toe
				pad.add(tot);//voeg tot toe
			}
			else {//geen rechtstreekse verbinding tussen van en tot
				pad = getShortestPath(van, via, P);//herhalen tot er een kort pad is gevonden
				pad.remove(pad.size() - 1); //anders dubbel
				pad.addAll(getShortestPath(via, tot, P));//voeg alles toe aan pad
			}
		}

		return pad;

	}

	public int berekenLengte(List<Integer> pad) {//
		int som = 0;//som wordt gedeclareerd
		int aantalKnopen = pad.size();//aantal knopen is de grote van het pad
		int huidigeKnoop, volgendeKnoop;//declaratie twee knopen
		for (int i = 0; i < aantalKnopen - 1; i++) {//doorloopt alle knopen van het pad
			huidigeKnoop = pad.get(i);//eerste knoop
			volgendeKnoop = pad.get(i + 1);//volgende knoop
			som += this.gewichtenMatrix[huidigeKnoop - 1][volgendeKnoop - 1];//bepaal gewicht van deze knoop en tel hem erbij op
		}
		return som;
	
		// oefening 2.5
	}

}
