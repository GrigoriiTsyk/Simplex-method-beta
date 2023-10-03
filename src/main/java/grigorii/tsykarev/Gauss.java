package grigorii.tsykarev;

import java.util.ArrayList;

public class Gauss {
    private ArrayList<ArrayList<Float>> matrix = new ArrayList<ArrayList<Float>>();
    public Gauss(){}
    public Gauss(ArrayList<ArrayList<Float>> matrix){
        this.matrix = matrix;
    }

    public ArrayList<ArrayList<Float>> identityMatrix (){
        return this.matrix;
    }
}
