package WhiteBoarding_w10;

// Write a recursive function that returns the binary representation of an integer.

// e.g. input(17), Output: 10001

// base 2 numerical


public class BinaryInt {
     
    public static void main(String[] args) {
        System.out.println(getBinary(17));
        System.out.println(getBinary(18));
        System.out.println(getBinary(19));
        System.out.println(getBinary(68));

    }

    public static String getBinary(int n) {

        int power = 0;

        while(true) {
            if((int)Math.pow(2, power) > n)  {
                power--;
                break;
            }
            power++;
        }

        return helper(n, power);
        
    }

    public static String helper(int n, int power) {
        if(power == 0) return "";
        if (n == 0) return "";
        if (n == 1) return "1";
        if (n == 2) return "10";
        if (n == 3) return "11";

        int remainder = (int)Math.pow(2, power) <= n ? n - (int)Math.pow(2, power) : n;

        String base = (int)Math.pow(2, power) <= n ? "1" + "0".repeat(power) : "";
        String recurBase = helper(remainder, power-1);
        
        return !base.equals("") ? base.substring(0, base.length() - recurBase.length()) + recurBase : recurBase;

    }    
}
