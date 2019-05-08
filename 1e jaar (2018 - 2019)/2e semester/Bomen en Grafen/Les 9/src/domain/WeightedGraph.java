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
        int[][] path = new int[this.gewichtenMatrix.length][this.gewichtenMatrix.length];

        double[][] D = this.gewichtenMatrix.clone();
        for (int i = 0; i < D.length; i++){
            D[i] = D[i].clone();
        }
        int aantal = gewichtenMatrix.length;
        for (int k = 0; k < aantal; k++){
            for (int i = 0; i < aantal; i++){
                for (int j = 0; j < aantal; j++){
                    if (D[i][k] + D[k][j] < D[i][j]){
                        D[i][j] = D[i][k];
                        path[i][k] = k + 1;
                    }
                }
            }
        }

		return path;
	}

	public List<Integer> getShortestPath(int i, int j, int[][] path) {
		List<Integer> res = new ArrayList<>();

		// oefening 2.4

		return res;

	}

	public int berekenLengte(List<Integer> pad) {
		int som = 0;
	
		// oefening 2.5
		
		return som;
	}

}
