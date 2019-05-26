package domain;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {
	private final double[][] gewichtenMatrix;
	public final static double infty = Double.POSITIVE_INFINITY;

    public WeightedGraph(double[][] matrix) {
        if (!isGeldigeGewichtenmatrix(matrix))
            throw new IllegalArgumentException("No valid gewichtenmatrix");
        this.gewichtenMatrix = matrix;
    }

    private boolean isGeldigeGewichtenmatrix(double[][] matrix) {
        return matrix != null && matrix.length == matrix[0].length;
    }

    private int getAantalKnopen() {
        return gewichtenMatrix.length;
    }

    public int[][] findDistances() {
        int[][] path = new int[getAantalKnopen()][getAantalKnopen()];
        double[][] distanceMatrix = this.gewichtenMatrix.clone();

        for (int i = 0; i < distanceMatrix.length; i++){
            distanceMatrix[i] = distanceMatrix[i].clone();
        }
        int aantal = gewichtenMatrix.length;
        for(int k = 0; k < aantal; k++){
            for (int i = 0; i < aantal; i++){
                for (int j = 0; j < aantal; j++){
                    if (distanceMatrix[i][k] + distanceMatrix[k][j] < distanceMatrix[i][j]){
                        distanceMatrix[i][j] = distanceMatrix[i][k] + distanceMatrix[k][j];
                        path[i][j] = k + 1;
                    }
                }
            }
        }

		// oefening 2.3

		return path;
	}

    public List<Integer> getShortestPath(int van, int tot, int[][] P) {
        List<Integer> pad = new ArrayList<>();
        if (van == tot) {
            return pad;
        } else {
            int via = P[van - 1][tot - 1]; if (via == 0){
                pad.add(van);
                pad.add(tot); } else {
                pad = getShortestPath(van, via, P);
                pad.remove(pad.size() - 1); //anders dubbel
                pad.addAll(getShortestPath(via, tot, P));
            }
        }

        return pad;

    }

	public int berekenLengte(List<Integer> pad) {
		int som = 0;
	    int aantalKnopen = pad.size();
	    int huidigeKnoop, volgendeKnoop;
	    for(int i = 0; i < aantalKnopen - 1; i++){
	        huidigeKnoop = pad.get(i);
	        volgendeKnoop = pad.get(i + 1);
	        som += this.gewichtenMatrix[huidigeKnoop - 1][volgendeKnoop - 1];
        }
		return som;
	}

}
