/*
Дана строка, например "aafbaaaaffc"
Вывести для каждого символа в ней максимальное количество непрерывных повторений
этого символа в строке. Для данной строки, например, результат будет:
a:4
b:1
f:2
c:1
*/

import java.util.HashMap;
import java.util.Map;

public class StrToMap {

    HashMap<Character, Integer> makeMap2(String str) {

        if(str.length() == 0) return new HashMap<>(); // if empty

        HashMap<Character, Integer> map = new HashMap<>();

        boolean changed;

        map.put(str.charAt(0), 1); // put first
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(str.charAt(i) != str.charAt(i - 1)) {  // check changed
                changed = true;
            } else {
                changed = false;
            }

            if(!map.containsKey(ch))  // add if not contains
                map.put(ch, 1);

            if(changed) { // if changed - add previous char entity if prev char.count > char.count in map
                if(count > map.get(str.charAt(i - 1)))
                    map.put(str.charAt(i - 1), count);
                count = 1;
            } else { // if not changed - inc count
                count++;
            }

            if(count > map.get(ch)) // add new info about this char | Need for adding last char
                map.put(ch, count);
        }
        return map;
    }

    // Run
    void run() {
        String str1 = "aafbaaaaffc";
        String str2 = "aaaabbbccaaaaaaa";
        String str3 = "";
        String str4 = "a";
        String str5 = "abcdefg";

        print2(str1);
        print2(str2);
        print2(str3);
        print2(str4);
        print2(str5);
    }

    // Main
    public static void main(String[] args) {
        StrToMap stm = new StrToMap();
        stm.run();
    }

    // Utils
    void print2(String str) {
        System.out.println("Str: " + str);
        printMap(makeMap2(str));
        System.out.println("\n");
    }

    void printMap(HashMap<Character, Integer> map) {
        if(map.isEmpty()) {
            System.out.println("Map is empty");
            return;
        }
        for (Map.Entry ent : map.entrySet()) {
            System.out.print(ent.getKey() + ": " + ent.getValue() + ", ");
        }
    }
}
