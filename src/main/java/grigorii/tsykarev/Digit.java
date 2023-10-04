package grigorii.tsykarev;

public class Digit {
    private float numerator, denominator;
    //private char[] dig;
    private boolean isDig = false;
    public Digit(String str){
        if (isInteger(str)){
            try{
                numerator = Integer.valueOf(str);
                denominator = 1;
                isDig = true;
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid integer input");
            }
        }
        else{
            if(!toFraction(str)){
                System.out.println("This string is not a digit or fraction!");
            }

        }
    }

    private boolean isInteger(String str){
        try{
            int number = Integer.valueOf(str);

            return true;
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid integer input");

            return false;
        }
    }

    private boolean toFraction(String str){
        String[] subStr = str.split("/");

        if(subStr.length != 1){
            if(isInteger(subStr[0])){
                try{
                    numerator = Integer.valueOf(subStr[0]);
                }
                catch (NumberFormatException e) {
                    System.out.println("Invalid integer input");

                    return false;
                }
            }
            else return false;
            if(isInteger(subStr[1])){
                try{
                    denominator = Integer.valueOf(subStr[1]);

                    if(denominator == 0){
                        System.out.println("denominator can't = 0!");

                        return false;
                    }
                    else{
                        isDig = true;

                        return true;
                    }
                }
                catch (NumberFormatException e) {
                    System.out.println("Invalid integer input");

                    return false;
                }
            }
            else return false;
        }
        else return false;
    }
    public boolean isDigit(){return isDig;}
}
