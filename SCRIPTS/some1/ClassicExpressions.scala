object Demo3 extends App {
	val x1 = List(0,1,2) filter {_ > 0} map {_ * 2}
	println(x1)

	def f1(x: Array[Int]): Array[Int] = for (k <- x) yield k * k
	def f2(x: Array[Int]): Array[Int] = x map {k => k*k}

	// Functional literal
	val x2 = (k: Int) => k + 1
	val x3: ((Int, Int) => Int) => 
			(Int => (Int => Int)) =
		f => x => y => f(x, y)

	// Incremention
	val x5 = (k: Int) => 1 + k
	val x6: Int => Int = k => 1 + k
	val x7: Int => Int = 1 + _
	val x8: Int => Int = 1 +
} 
