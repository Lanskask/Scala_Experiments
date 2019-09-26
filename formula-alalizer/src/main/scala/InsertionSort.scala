

/*
 * СДЕЛАНО !!!!!! И РАБОТАЕТ !!!!!!!
 */
import scala.collection.mutable.ArrayBuffer

object InsertionSort extends App {

	val ar = ArrayBuffer(0,4,7,-3,11,20,5)
  val N = ar.length

  printAr(ar); println
  sorting(ar); println
  printAr(ar)

  def sorting(ar: ArrayBuffer[Int]) = {
    for(i <- 0 to N - 1) {
      val minInd = findMin(ar, i)
      if( ar(i) != ar(minInd)) // нужно если минимальный уже найден и находится на этом i
        swap(i, minInd)
      printAr(ar)
    }
  }

  def findMin(ar: ArrayBuffer[Int], since: Int): Int = {
    var min = since

  	for ( i <- since to (N - 1)) {
  			if(ar(i) < ar(min))
					min = i
  	}
    min
  }

	def swap(i: Int, j: Int) {
		val tmp = this.ar(i)
		ar(i) = ar(j)
		ar(j) = tmp
	}

	def printAr(ar: ArrayBuffer[Int]) = {
		ar.foreach(el => print(s"$el, "))
		println
	}

}
