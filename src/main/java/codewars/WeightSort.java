package codewars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class WeightSort implements Comparable<WeightSort> {
    String weiStr;
    int weiInt;

    WeightSort(String weiStr) {
        this.weiStr = weiStr;
        this.weiInt = strToIntByWeight(weiStr);
    }

    static public String orderWeight(String initStr) {
        List<WeightSort> list = new ArrayList<>();
        String[] splited = initStr.split(" ");

        for(String item: splited) {
            list.add(new WeightSort(item));
        }
        Collections.sort(list);

        StringBuilder answ = new StringBuilder();
        for(WeightSort w: list) answ.append(w.weiStr + " ");
        return  answ.toString().trim();
    }

    static int strToIntByWeight(String str) {
        int sum = 0;
        for(char ch: str.toCharArray()) {
            sum += Integer.parseInt(ch + "");
        }
        return sum;
    }

    @Override
    public int compareTo(WeightSort wToComp) {
        WeightSort compWeight = ((WeightSort) wToComp);
        if(this.weiInt - compWeight.weiInt == 0) {
            return -compWeight.weiStr.compareTo(weiStr);
        }
        return this.weiInt - compWeight.weiInt;
    }

}