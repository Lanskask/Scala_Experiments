package example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FibonHashMap {

    private static final int MOD = (int) (1e9+7);

    Map<Integer, BigInteger> cache2 = new HashMap<>();
    List<BigInteger> cache3 = new ArrayList<>();
    {
        cache3.add(BigInteger.ZERO);
        cache3.add(BigInteger.ONE);
    }

    List<Integer> cache = new ArrayList<>();
    {
        cache.add(0);
        cache.add(1);
    }


    int cnt;

    private int fibonachi(int n) {
        int a = 0; int b = 1;
        for(int i = 0; i < n; i++) {
            int c = (a + b) % MOD;
            a = b; b = c;
        }
        return a;
    }
    // 911435502
    // 911435502

    private int fibonachi_(int n) {
        for (int i = cache.size(); i <= n; i++) {
           int res = (cache.get(i-1) + cache.get(i-2)) % MOD;
           cache.add(res);
        }
        return cache.get(n);
    }

    private int fibonachi1(int n) {
        cnt++;
        if(n < 2)
            return n;
        return n + fibonachi1(n-2) + fibonachi1(n - 1);
    }

    private BigInteger fibonachi3(int n) {
        for (int i = cache3.size(); i <= n; i++) {
           BigInteger res = cache3.get(i-1).add(cache3.get(i-2));
           cache3.add(res);
        }
        return cache3.get(n);
    }

    private BigInteger fibonachi2(int n) {
        cnt++;
        if(n < 2)
            return BigInteger.valueOf(n);
        if(cache2.containsKey(n))
            return cache2.get(n);
        else {
            for(int i = 2; i <= n; i ++) {
                BigInteger res = fibonachi2(i-1).add( fibonachi2(i - 2));
                cache2.put(i, res);
            }
            return cache2.get(n);
        }
//        return fibonachi(n-2) + fibonachi(n - 1);
    }

    void run(int n) {
        System.out.println("fib(" + n + ") = " + fibonachi(n));
        System.out.println(cnt + " calls");
    }

    public static void main(String[] args) {
//        FibonHashMap fib = new FibonHashMap();
//        for (int i = 0; i < 100; i++) {
            long startT = System.currentTimeMillis();

            new FibonHashMap().run(100000);

            long endT = System.currentTimeMillis();
            System.out.println(endT - startT + " ms");
//        }

    }
}
