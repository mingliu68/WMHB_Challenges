package SatChallenge_1;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(7);
        list.add(-2);
        list.add(-5);
        list.add(10);
        System.out.println(sortArray(list));

        System.out.println(wordSearch("See spot run.", "spot r")); 
        System.out.println(wordSearch("Quick brown fox", "lazy dog"));
        System.out.println(caesarCipher("dog", 5));
        System.out.println(caesarCipher("hello", 28));
        System.out.println(caesarCipherNew("dog", 5));
        System.out.println(caesarCipherNew("hello", 28));
        checkString("See spot run", "spot r");
        checkString("Quick brown fox", "lazy dog");
    }


    // sorting using selection sort
    public static ArrayList<Integer> sortArray(ArrayList<Integer> list) {
        for(int i = 0; i < list.size(); i++) {
            // minimum item index
            int min = i;
            for(int j = i+1; j < list.size(); j++) {
                if(list.get(j) < list.get(min)) {
                    min = j;
                } 
            }
            if (i != min) {
                int temp = list.get(i);
                list.set(i, list.get(min));
                list.set(min, temp);
            }
        }
        return list;
    }

    // using java substring for comparison
    public static boolean wordSearch(String phrase, String word) {
        for(int i = 0; i <= phrase.length() - word.length(); i++) {
            if(phrase.charAt(i) == (word.charAt(0))) {
                if(phrase.substring( i , i + word.length() ).equals(word)) {
                    return true;
                }
            }
        }
        return false;
    }

    // using ascii values
    public static String caesarCipher(String word, int shift) {
        // ascii a 97, z 122
        // a 1, z 26 with addition of base 96
        String result = "";
        int ascii = -1;
        for(int i = 0; i < word.length(); i++) {
            ascii = (int)word.charAt(i);
            // System.out.println("origin: " + ascii + ", shifted: " + (ascii + shift));
            // System.out.println(96 + ((ascii + shift) % 122));
            int finalAscii = ascii + shift > 122 ? 96 + ((ascii + shift) % 122) : (ascii + shift) ;
            result += (char)(finalAscii);
        } 
        return result;
    }




/////////////////////////////////// End of Challenge ////////////////////////////////////









    // instructor solution
    public static String caesarCipherNew(String plaintext, int shift) {
        String output = "";
        for(char c: plaintext.toCharArray()) {
            output += (char)((((c - 'a') + shift) % 26 ) + 'a');
        }
        return output;
    }









    // classmate solution... wront solution as it will produce yes even when it's false
    public static void checkString(String a,String b) {
        a=a.replaceAll("\s","");
        b=b.replaceAll("\s", "");
        System.out.println(a);
        a=a.replaceAll(b," ");
        String[] arrayA = a.split(" ");
        System.out.println(arrayA);
        if (arrayA.length>1){
            System.out.println("Yes");
        }

        else{
            System.out.println("No");
        };
    }

}

        // int i = 0;

// while(i < word.length()) {
        //     ascii = (int)word.charAt(i);
        //     // System.out.println("origin: " + ascii + ", shifted: " + (ascii + shift));
        //     // System.out.println(96 + ((ascii + shift) % 122));
        //     int finalAscii = ascii + shift > 122 ? 96 + ((ascii + shift) % 122) : (ascii + shift) ;
        //     result += (char)(finalAscii);
        //     i++;
        // }

        // both Dog and Cat extends from Animal

        // Cat c = new Cat();
        // Dog d = new Dog();
        // ArrayList<Animal> pets = new ArrayList<>();