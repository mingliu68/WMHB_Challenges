package WhiteBoarding_w4;


// Write a method that takes a String as an argument, which contains the representation of an integer, 
// and return the primitive int value of the represented number.

// Example:
// "234" -> 234

public class StringToInt {
    public static void main(String[] args) {
        System.out.println(getIntValue("52234"));
    }


    public static int getIntValue(String str) {
        if(str.length() ==  1) {
            return Character.getNumericValue(str.charAt(0));
        }
        int result = Character.getNumericValue(str.charAt(0));
        for(int i = 1; i < str.length(); i++) {
                result *= 10;
                result += Character.getNumericValue(str.charAt(i));
        }
        return result;
    }
}
