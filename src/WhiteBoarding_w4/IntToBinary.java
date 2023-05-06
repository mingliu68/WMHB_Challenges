package WhiteBoarding_w4;

// Write a method that takes an integer as an argument, and returns a String containing the binary 
// representation of that number.

// Example:
// 2  -> "10"
// 6  -> "110"
// 13 -> "1101"

public class IntToBinary {
    public static void main(String[] args) {
        System.out.println(getBinary(2));
        System.out.println(getBinary(6));
        System.out.println(getBinary(13));
        System.out.println(getBinary(68));
    }

    public static String getBinary(int n) {
        // power of 2
        // 2^0 is 1, 2^1 is 10, 2^2 is 100, 2^3 is 1000 ...
        // find the highest power 
        if(n == 0) return "";
        if(n == 1) return "1";
        if(n == 2) return "10";
        

        int power = 0;
        int base = 1;
        int remainder = n;
        while(Math.pow(2, power+1) <= n){
            power++;
            base *= 10;
        }
        remainder = n - (int)(Math.pow(2, power));
        String baseStr = String.valueOf(base);
        String remainderStr = getBinary(remainder);
        return baseStr.substring(0, baseStr.length() - remainderStr.length()) + remainderStr;
     
    }

  
}
