package example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MostFreqNumInArr {
    public static void main(String[] args) {
        MostFreqNumInArr mfr = new MostFreqNumInArr();
        mfr.run();
    }

    Map<Integer, Integer> cache = new HashMap<>();

    int[] arr = {1,3,2,3,2,1};

    void run() {
        System.out.println("mFr(arr): " + mFr(arr));
    }

    ArrayList<Integer> list = new ArrayList<>();

    int mFr(int[] arr) {
        if (arr.length == 0)
            return -1;
        if(arr.length == 1)
            return arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(!cache.containsKey(i)) {
                cache.put(i, 1);
            } else if(cache.containsKey(i)) {
                cache.replace(i, cache.get(i) + 1);
            }
        }
//        cache.i
//        int max = cache.get(cache.keySet()..size()-1);
        for (Map.Entry<Integer, Integer> ent: cache.entrySet()){
            list.add(ent.getValue());
        }
        return 0;
    }

}
