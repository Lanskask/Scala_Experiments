package example;

class Hello {
	public static void main(String[] args) {
		Hello hel = new Hello();
		// hel.run1();
		long startT = System.currentTimeMillis();

		hel.testGcd();
		
		long endT = System.currentTimeMillis();
		System.out.println(endT - startT + " ms");
	}

	void run1() {
		System.out.println("3 | 4 = " + (3 | 4));

		for(int i = 0; i < 10; i++) {
			System.out.println(i + " & 1 = " + (i & 1));
		}
	}

	void testGcd() {
		System.out.println("gcd(3,6): " + gcd(3,6));
		System.out.println("gcd(12,6): " + gcd(12,6));
		System.out.println("gcd(35*12,35): " + gcd(35*12,35));
		System.out.println("gcd(35*12,35): " + gcd(1234 * 35235,35 * 35235));

	}
	int gcd(int a, int b) {
		System.out.println(a + " " + b);
		if(a == 0) return b;
		if(b == 0) return a;
		if(a >= b) {
			return gcd(a % b, b);
		} else {
			return gcd(a, b % a);
		}
	}

	int gcd2(int a, int b) {
		int res = 0;
		for (int i = 1; i <= Math.max(a,b); i++ ) {
			if(a % i == 0 && b % i == 0) 
				res = Math.max(res, i);
		}
		return res;
	}


}
