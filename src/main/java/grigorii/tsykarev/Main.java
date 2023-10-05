package grigorii.tsykarev;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String buf = "";

        ArrayList<ArrayList<Digit>> matrix = new ArrayList<ArrayList<Digit>>();


        try{
            File file = new File("src/main/resources/in.txt");

            FileInputStream input = new FileInputStream(file);

            try{
                int reader;

                while ((reader = input.read()) != -1)
                    buf += (char)reader;

                int lines, cols;

                String[] subBuf = buf.split(" ");

                lines = Integer.valueOf(subBuf[0]);
                cols = Integer.valueOf(subBuf[1]);

                int index = 2;

                boolean isMatrix = false;

                for(int i = 0; i < lines; i++) {
                    matrix.add(i, new ArrayList<Digit>());

                    for (int j = 0; j < cols; j++) {
                        Digit dig = new Digit(subBuf[index]);

                        if (dig.isDigit()) {
                            isMatrix = true;

                            matrix.get(i).add(j, dig);

                            index++;
                        }
                        else {
                            isMatrix = false;

                            break;
                        }
                    }

                    if(!isMatrix){
                        System.out.println("Iforamtion in file can't be added to matrix!");

                        break;
                    }
                }
                Gauss gauss = new Gauss(matrix);
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
            }

            /*for(int i = 0; i < matrix.size(); i++) {
                for (int j = 0; j < matrix.get(i).size(); j++) {
                    String str = String.format("%s ", matrix.get(i).get(j).getDigit());

                    System.out.print(str);
                }

                System.out.println();
            }*/

            input.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
