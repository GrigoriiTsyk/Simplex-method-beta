package grigorii.tsykarev;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try{
            File file = new File(".src/main/resources/in.txt");

            FileInputStream input = new FileInputStream(file);



            input.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}