package WhiteBoarding_w10;
  
// Write a recursive function to check whether a given number is a palindrome.
// Constraint: Do not convert from int to String. Instead use mathematical manipulation.

public class NumberPalindrome {
    public static void main(String[] args) {

        System.out.println(isPalindrome(1234));
        System.out.println(isPalindrome(654321));
        System.out.println(isPalindrome(54321));
        System.out.println(isPalindrome(31213));
        System.out.println(isPalindrome(156521));




    }

    public static Boolean isPalindrome(int n) {
        if(n / 10 == 0) return true;

        int length = 0;
        int counter = 1; 
        while(counter <= n) {
            length ++;
            counter *= 10;
        }
        counter /= 10;
        
        if((n / counter) == (n % 10)) {

            n = n % counter;
            n /= 10;
            return isPalindrome(n);
        } else {
            return false;
        }
    }
}
