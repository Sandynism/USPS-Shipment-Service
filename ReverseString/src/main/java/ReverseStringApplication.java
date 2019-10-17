import java.util.HashMap;
import java.util.Map;

public class ReverseStringApplication {
    //question from 1 on 1 interview
    public static String reverseString(String text) {
        char letter[] = text.toCharArray();

        String reverse = "";

        for (int i = letter.length - 1; i >= 0; i--) {
            reverse += letter[i];
        }

        return reverse;
    }

    //cognizant exam question #15
    public static char maxOccurences(String text) {

        HashMap<Character, Integer> countMap = new HashMap<>();

        char[] cArray = text.toCharArray();

        for (char c : cArray) {
            if (countMap.containsKey(c)) {
                countMap.put(c, countMap.get(c) + 1);
            } else {
                countMap.put(c, 1);
            }
        }

        Integer maxCount = 0;
        char maxLetter = 'a';

        for (Map.Entry entry : countMap.entrySet()) {
            String value = entry.getValue().toString();
            Integer numValue = Integer.parseInt(value);
//            System.out.println(entry.getKey());

            if (numValue > maxCount) {
                maxCount = numValue;
                maxLetter = entry.getKey().toString().charAt(0);
            }
        }
        return maxLetter;
    }


    public static void main(String[] args) {
        System.out.println("helloworld (reversed): " + reverseString("helloworld"));

        System.out.println("aaabbbccc: " + maxOccurences("aaabbbccc"));
        System.out.println("helloworld: " + maxOccurences("helloworld"));
        System.out.println("abcdefghijklmnopqrstuvwxyz: " + maxOccurences("abcdefghijklmnopqrstuvwxyz"));

        //hash map sorts them so it would still fail depending on some test cases
        System.out.println("helloammar: " + maxOccurences("helloammar"));
        System.out.println("cccbbbaaa: " + maxOccurences("cccbbbaaa"));

    }

}
