package codewars;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class RegexpString {

    public static void main(String[] args) {
        printIsogram("Dermatoglyphics", true);
        printIsogram("isogram", true);
        printIsogram("moose", false);
        printIsogram("isIsogram", false);
        printIsogram("aba", false);
        printIsogram("moOse", true);
        printIsogram("thumbscrewjapingly", true);
        printIsogram("", true);
        printIsogram("saad", false);
        printIsogram("aad", false);
        System.out.println(Pattern.matches(".*a+a.*", "saad"));

        RegexpString.isIsogram("moOse");
//        System.out.println(isIsogram("aaabbaa"));
    }

    public static boolean isIsogram(String str) {
        if(str.equals("")) return true;
        String[] arr = str.toLowerCase().split("");
//        for (String ch : arr) {
//            System.out.print(ch + ", ");
//        }
        Set<String> set = new HashSet<String>(Arrays.asList(arr));
        if(arr.length == set.size()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isIsogram2(String str) {
        if(str.equals("")) return true;
        boolean answ = false;
        for(char ch : str.toCharArray()) {
            if(Pattern.matches("$.*" + ch + "+.*" + ch + "+.*", str) ||
                    Pattern.matches("$.*" + ch + "+" + ch + ".*", str)) {
                return false;
            } else {
                return true;
            }
//            answ = Pattern.matches(".*$" + ch + "+.*" + ch + "+.*", str);
//            answ = !Pattern.matches(".*a+.*a.+.*", str);
//            answ = !Pattern.matches(".*" + ch + "+.*" + ch + "+.*", str) ||
//                    !Pattern.matches(".*" + ch + "+" + ch + ".*", str);
        }
        return answ;
    }

    static void printIsogram(String str, boolean shouldBe) {
        System.out.println("Word: " + str + ": " + isIsogram(str) + " - should be - " + shouldBe);
    }

}
