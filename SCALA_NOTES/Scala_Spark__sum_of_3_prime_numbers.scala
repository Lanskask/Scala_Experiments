def isPrime(n: Int): Boolean = {
  if (n <= 1) false
  else if (n == 2) true
  else !(2 until n).exists(x => n % x == 0)
}

// ---------

import java.util.Date

class Exp1 {

	val date = new Date(System.currentTimeMillis)
	
	def main(args/*и что то ещё*/) {
		println(s"${date.getDay}.${date.getMonth}.${date.getYear}")
	}
}


val epoch = System.currentTimeMillis
val date = new Date(epoch)


// -----------------------

Всё:
https://github.com/Lanskask?tab=repositories

Со Scala:
https://github.com/Lanskask/Scala_Experiments
https://github.com/Lanskask/Spark_Scala
https://github.com/Lanskask/Play_Experiments
https://github.com/Lanskask/Akka_Experiments

// ---------------------

val string1 = """[
		{
			"age": 10,
			"name": "andy",
			"birthday": "13-12-2014"
		}, {
			"age": 10,
			"name": "andy",
			"birthday": "13-12-2014"
		}
]"""

val json = JSON.parse(string1)

// ----------------------
В scala используя библиотеку spark заполнить массив из 1000 простых чисел
посчитать сумму тех из них которые оканчиваются на 3

(1 to 1000).par.filter(isPrime).filter(x => x.toString.reverse(0) == "3").foldLeft(_ + _)

def isPrime(n: Int): Boolean = {
  if (n <= 1) false
  else if (n == 2) true
  else !(2 until n).exists(x => n % x == 0)
}

// ------------
sc.parallelize((1 to 100)).toDF.filter(isPrime _).collect().foreach(x => print(s"$x, "))

sc.parallelize((1 to 100)).toDS.filter(x => isPrime(x)).where()

sc.parallelize((1 to 1000)).toDS.filter(x => isPrime(x)).where($"value".like("%3")).reduce(_ + _)

