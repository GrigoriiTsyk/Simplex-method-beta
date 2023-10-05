package grigorii.tsykarev;

public class Digit {
    private int numerator, denominator;
    private String dig;
    private boolean isDig = false;

    public Digit(String str) {
        toDigit(str);
        if(isDig)
            dig = str;
    }

    private boolean isInteger(String str) {
        try {
            int number = Integer.valueOf(str);

            return true;
        } catch (NumberFormatException e) {
            System.out.println("Invalid integer input");

            return false;
        }
    }

    private boolean toFraction(String str) {
        String[] subStr = str.split("/");

        if (subStr.length != 1) {
            if (isInteger(subStr[0])) {
                try {
                    numerator = Integer.valueOf(subStr[0]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid integer input");

                    return false;
                }
            } else return false;
            if (isInteger(subStr[1])) {
                try {
                    denominator = Integer.valueOf(subStr[1]);

                    if (denominator == 0) {
                        System.out.println("denominator can't = 0!");

                        return false;
                    } else {
                        isDig = true;

                        return true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid integer input");

                    return false;
                }
            } else return false;
        } else return false;
    }

    public void toDigit(String str) {
        if (isInteger(str)) {
            try {
                numerator = Integer.valueOf(str);
                denominator = 1;
                isDig = true;
            } catch (NumberFormatException e) {
                //System.out.println("Invalid integer input");
            }
        } else {
            if (!toFraction(str)) {
                System.out.println("This string is not a digit or fraction!");
            }
        }
    }
    public boolean isDigit(){return isDig;}
    public String getDigit(){return dig;}
    public int getNumerator(){return numerator;}
    public int getDenominator(){return denominator;}
    private void makeDig(){
        if(denominator == 1)
            dig = String.valueOf(numerator);
        if(denominator != 1)
            dig = String.valueOf(numerator) + "/" + String.valueOf(denominator);
    }
    public void sum(Digit target){
        if(denominator != target.getDenominator()){
            denominator *= target.getDenominator();
            numerator *= target.getDenominator();
        }

        numerator += target.getNumerator();

        makeDig();
    }
    public void sum(int target){
        Digit digit = new Digit(String.valueOf(target));

        if(denominator != digit.getDenominator()){
            denominator *= digit.getDenominator();
            numerator *= digit.getDenominator();
        }

        numerator += digit.getNumerator();

        makeDig();
    }
    public void multiply(Digit target){
        numerator *= target.getNumerator();
        denominator *= target.getDenominator();

        makeDig();
    }
    public void multiply(int target){
        numerator *= target;

        makeDig();
    }
    public void divide(Digit target){
        numerator *= target.getDenominator();
        denominator *= target.getNumerator();

        makeDig();
    }
    public void divide(int target){
        if(target != 0){
            denominator *= target;
        }
        else
            System.out.println("Can't divide by 0!");

        makeDig();
    }
}