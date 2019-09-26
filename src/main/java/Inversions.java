import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Число пар индексов для которых A[i] > A[j]
 * Колличество инверсий в массиве
 */

class Inversions {

	private int[] mergeSort(int[] a) {
		if( a.length  == 1) return a;
		int n = a.length;
		int m = n / 2;
		int[] left = new int[m];
		int[] right = new int[n - m];

		System.arraycopy(a, 0, left, 0, m);
		System.arraycopy(a, m, right, 0, n - m);
//		printArray(left);
//		printArray(right);

		left = mergeSort(left);
		right = mergeSort(right);
		return merge(left, right);
	}

	int count = 0;

	private int[] merge(int[] a, int[] b) {
		int i = 0;
		int j = 0;
		int[] res = new int[a.length + b.length];

		for (int k = 0; k <	res.length; k++) {
			if(j == b.length || (i < a.length && a[i] <= b[j])) {
				res[k] = a[i];
				i++;
			} else {
//				count++;
				count += a.length - i;
				res[k] = b[j];
				j++;
			}
		}
		return res;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Inversions inv = new Inversions();
		
		long before = System.currentTimeMillis();	
		inv.run();
    long after = System.currentTimeMillis();

    System.out.println("Time :" + (after - before) + " mSec");
	}

	void run() throws FileNotFoundException, IOException {
		String filePath = "input1.txt";
		String filePath2 = "input.txt";
//		Scanner input2 = new Scanner(new File(filePath));

		BufferedReader input = new BufferedReader(new FileReader(filePath));
		int n = Integer.parseInt(input.readLine());
		String[] tokens = input.readLine().split(" ");

		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(tokens[i]);
		}


/*		int n = input.nextInt();
//		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = input.nextInt();
		}*/
//		printArray(a);

		int[] sortedA = mergeSort(a);
//		printArray(sortedA);
		Util.printS(Util.isSortedRight(sortedA) + "");

		Util.printS(count + "");
//		Arrays.sort(a);
//		printS(isSortedRight(a) + "");
	}

}