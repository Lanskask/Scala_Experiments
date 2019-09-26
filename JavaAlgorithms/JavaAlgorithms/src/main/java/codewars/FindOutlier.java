package codewars;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindOutlier {
    public static void main(String[] args) {

    }

    static int find(int[] integers){
        if(Arrays.stream(integers).filter(x -> x % 2 == 0).count() == 1) {
            return Arrays.stream(integers).filter(x -> x % 2 == 0).findAny().getAsInt();
        } else { // oddNums
            return Arrays.stream(integers).filter(x -> x % 2 != 0).findAny().getAsInt();
        }
    }
}
