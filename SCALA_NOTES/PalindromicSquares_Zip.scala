abstract class Person(val name: String) {
	val id: Int
}

class Person(val name: String) {
	val id: Int = _
}

val alien = new Person("Fred") {
	def greeting = "Greetings, Earthling! My name is Fred."
}

class Person2(val name: String) {
	def description = ???
}

// -------------
val prices = List(5.0, 20.0, 9.95)
val quantities = List(10, 2, 1)

prices zip quantities
res0: List[(Double, Int)] = List((5.0,10), (20.0,2), (9.95,1))

(prices zip quantities) map {p => p._1 * p._2}
res1: List[Double] = List(50.0, 40.0, 9.95)

(prices zip quantities) map {p => p._1 * p._2} sum
res2: Double = 99.95


// ------------

// много квадратов, пока не найдет десять палиндромов, после чего вычисления остановятся.
val palindromicSquares = (1 to 1000000).view.map(x => x * x).filter(x => x.toString == x.toString.reverse)
palindromicSquares.take(10).mkString(", ")