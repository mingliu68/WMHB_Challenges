package WhiteBoarding_w3;
// 1
// 11
// 21
// 1211
// 111221
// 312211


public class SeeAndSay {
    

    public static void main(String[] args) {

        System.out.println(seeAndSay(4));
    }

    public static String seeAndSay(int n) {
        if(n == 1) return "1";

        String str = seeAndSay(n-1);
        
        Character prev = str.charAt(0);
        int count = 1;
        String result = "";

        for(int i = 1; i < str.length();i++) {
            if(str.charAt(i) == prev) {
                count++;
            } else {
                result += String.valueOf(count) + prev;
                prev = str.charAt(i);
                count = 1;
            }
        }

        result += String.valueOf(count) + prev;
        

        return result;
    }
}