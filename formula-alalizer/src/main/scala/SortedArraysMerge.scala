
/*
 * СЛИЯНИЕ ДВУХ ОТСОРТИРОВАННЫХ МАССИВОВ
 *  !!!!!!!!!! СДЕЛАЛ !!!!!!!!! РАБОТАЕТ
 */

import scala.collection.mutable.ArrayBuffer

object SortedArraysMerge extends App {

  val ar1 = Array(4,5,10,11)
  val ar2 = Array(-2,-1,0,1,3,6)
  val N1 = ar1.length
  val N2 = ar2.length

  var ar3 = ArrayBuffer[Int]()

  printAr(ar3)
  mergeArrays(ar1, ar2)
  printAr(ar3)

  def mergeArrays(ar1: Array[Int], ar2: Array[Int]) = {
    var i = 0; var j = 0

    while ( i < N1 && j < N2) {
      if( ar1(i) < ar2(j) ) {
        ar3 = ar3 :+ ar1(i)
        i += 1
      } else {
        ar3 = ar3 :+ ar2(j)
        j += 1
      }
    }
    if( i == N1 )
      ar3 = ar3 ++ ar2.drop(j)
    if( j == N2 )
      ar3 = ar3 ++ ar1.drop(i)
  }

  def printAr(ar: ArrayBuffer[Int]): Unit = ar.foreach(item => print(s"$item, "))

}
