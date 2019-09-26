package Search

object BinarySearch extends App {
	// 						0,1,2,3,4,5,6,7, 8,
	val A = Array(3,5,7,8,9,11,13,15) // N = 8

	def find(ar: Array[Int], i: Int, j: Int, num: Int): Int = {
		val N = ar.slice(i,j).length
		val nAr = ar.slice(i,j) // REMOVE
		val pivotInd = i + (N/2).floor.toInt
		println(s"N: $N; pivotInd: $pivotInd; ar(pivotInd): ${ar(pivotInd)}; ar.slice(i,j): ${nAr}")

		ar(pivotInd) match { // a - current pivot element
			case a if num == a => pivotInd
			case a if num < a => find(ar, i, pivotInd, num)
			case a if num > a => find(ar, pivotInd, j, num)
		}
	}

	println(find(A, 0, A.length, 5))
	println(find(A, 0, A.length, 7))
	// println(find(A, 0, A.length, 15))
	println(find(A, 0, A.length, 3))
	println(find(A, 0, A.length, 11))
}