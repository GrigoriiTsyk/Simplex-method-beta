package grigorii.tsykarev;

import java.util.ArrayList;

public class Gauss {
    private ArrayList<ArrayList<Digit>> matrix = new ArrayList<ArrayList<Digit>>();
    public Gauss(){}
    public Gauss(ArrayList<ArrayList<Digit>> matrix){
        this.matrix = matrix;
    }

    public void identityMatrix (ArrayList<Integer> indexis){
        if(indexis.size() == 0){
            for(int i = 0; i < matrix.size() - 1; i++){
                Digit bearingEl = matrix.get(i).get(i);
                int colSize = matrix.get(0).size();

                for(int j = 0; j < colSize; j++)
                    matrix.get(i).get(j).divide(bearingEl);
                for(int j = i + 1; j < matrix.size() - 1; j++){
                    for(int k = 0; k < colSize; k++){
                        
                    }
                }
            }
        }
    }
}
