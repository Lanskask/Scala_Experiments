import java.util.Arrays;

public class Util {

    static void printArray(int[] a) {
        System.out.println(Arrays.toString(a));
    }

    static void printS(String str) {
        System.out.println(str);
    }

    static boolean isSortedRight(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            if(a[i+1] < a[i]) return false;
        }
        return true;
    }

    static int[] swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
        return arr;
    }
}
