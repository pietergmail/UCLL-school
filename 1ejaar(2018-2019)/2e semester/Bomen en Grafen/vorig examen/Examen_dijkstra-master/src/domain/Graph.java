package domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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


	private void initArray(int[] array, int value){
		for(int i =0; i < array.length; i++){
			array[i] = value;
		}
	}


	public int[] Dijkstra(int vanKnoop) {
		int[] ancestor = new int[this.getAantalKnopen()];
		int[] distances = new int[this.getAantalKnopen()]; //afstand
		initArray(ancestor, inf);
		initArray(distances, inf);

		Queue<Integer> q = new LinkedList<Integer>();

		q.add(vanKnoop);
		ancestor[vanKnoop-1] = -1;
		distances[vanKnoop-1] = 0;

		while (!q.isEmpty()){
			int knoop = q.poll();
			for(int i = 0; i<this.getAantalKnopen(); i++){
				if(gewichtenMatrix[knoop-1][i] > 0 && gewichtenMatrix[knoop-1][i] != inf){
					int tussenknoop = i;
					int alt = distances[knoop-1] + gewichtenMatrix[knoop-1][i];
					if(alt < distances[tussenknoop]){
						q.add(tussenknoop+1);
						ancestor[tussenknoop] = knoop;
						distances[tussenknoop] = alt;

					}
				}
			}
		}

		return ancestor;
	}

	public String geefAncestors(int start){
		String res = "Ancestor matrix als pad start in " + start + ":\n";
		int[] ancestors = this.Dijkstra(start);
		for(int a=0; a<ancestors.length; a++ ){
			res += ancestors[a]!=inf?ancestors[a]:"niet bereikbaar";
			res += " ";
		}
		return res;
	}


}
