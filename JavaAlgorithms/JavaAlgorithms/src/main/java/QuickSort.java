import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        QuickSort qs = new QuickSort();
        qs.run();
        long after = System.currentTimeMillis();

        System.out.println("Time :" + (after - before) + " mSec");
    }

    void run() {
        int n = 10;
        int[] arr = generate(n);
        Util.printArray(arr);
        Util.printArray(
            sort(arr, 0, n-1)
        );
    }

    int[] sort(int[] arr, int start, int end) {
        if(start >= end) return arr;

        int i = start;
        int j = end;

        int p = (i + j) / 2;
//        System.out.println(p);
        while(i < j) {
            while( (i < p) && (arr[i] <= arr[p])) i++;
            while( (j > p) && (arr[j] >= arr[p])) j--;

            if(i < j) {
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
                if(i == p) p = j;
                else if(j == p) p = i;
            }
        }

        sort(arr, start, p);
        sort(arr, p + 1, end);

        return arr;
    }

    int[] generate(int n) {
        Random r = new Random();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = r.nextInt(n);
        }
        return res;
    }
}
