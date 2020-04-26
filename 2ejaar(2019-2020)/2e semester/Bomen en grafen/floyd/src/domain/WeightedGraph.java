package domain;

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


    private int getAantalKnopen() {
        return gewichtenMatrix.length;
    }

    public int[][] findDistances() {//gaat door de hele matrix en noteerd de kortste weg tussen alle punten op de matrix, bepaald ook de P-matrix
        int[][] path = new int[getAantalKnopen()][getAantalKnopen()];
        double[][] distanceMatrix = this.gewichtenMatrix.clone();
        int aantal = gewichtenMatrix.length;//lengte van de gewichtsmatrix
        for (int k = 0; k < aantal; k++){
            for (int i = 0; i < aantal; i++){
                for (int j = 0; j < aantal; j++){
                    if (distanceMatrix[i][k] + distanceMatrix[k][j] < distanceMatrix[i][j]){
                        distanceMatrix[i][j] = distanceMatrix[i][k] + distanceMatrix[k][j];
                        path[i][j] = k + 1;
                    }
                }
            }
        }

		return path;
	}

	public List<Integer> getShortestPath(int van, int tot, int[][] path) {//bepaald kortste pad tussen 2 matrix
		List<Integer> res = new ArrayList<>();
		if (van == tot){//kortste pad gevonden
		    return res;
        }else{//kortste pad is niet gevonde
		    int via = path[van - 1][tot - 1];
		    if (via == 0){//van en tot liggen naast elkaar
		        res.add(van);
		        res.add(tot);
            } else {
		        res = getShortestPath(van, via, path);
		        res.remove(res.size() - 1);
		        res.addAll(getShortestPath(via, tot, path));
            }
        }
		return res;

	}

	public int berekenLengte(List<Integer> pad) {
		int som = 0;
		int aantalKnopen = pad.size();
		int huidigeKnoop, volgendeKnoop;
		for (int i = 0; i < aantalKnopen - 1; i++){
		    huidigeKnoop = pad.get(i);
		    volgendeKnoop = pad.get(i + 1);
		    som += this.gewichtenMatrix[huidigeKnoop - 1][volgendeKnoop - 1];
        }
		return som;
	}

}
