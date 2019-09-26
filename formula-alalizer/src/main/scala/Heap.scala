import scala.collection.mutable.ArrayBuffer

class Heap {
  var H = ArrayBuffer[Int]()

//	var rank: Int
//	var isEmpty: Boolean
  var size = 0
  var maxSize = Int.MaxValue

  // def parrent(i: Int) = Math.floor(i/2).toInt
  // def leftCh(i: Int) = 2*i
  // def rightCh(i: Int) = 2*i + 1
  
  def parrent(i: Int) = Math.floor((i-1)/2).toInt
	def leftCh(i: Int) = 2*i + 1
	def rightCh(i: Int) = 2*i + 2

	def getTop = H.head

	def insert(x: Int) = {
//    if(size == maxSize) fail("Max size reached")
    if(H.isEmpty) H += x
    size += 1
    H(size - 1) = x
    shiftUp(x)
  }

	def remove(i: Int) = {
    H(i) = Int.MaxValue + 1
    shiftUp(i)
    extractMax()
  }

	def extractMax() = {
    val result = H(0)
    H(0) = H(size)
    size -= 1
    shiftDown(0)
    result
  }

	def shiftUp(i: Int) = {
    var j = i
    while(j > 0 && H(parrent(j)) > H(j)) {
      swap(parrent(j), j)
      j = parrent(j)
    }
  }

  // check this
	def shiftDown(i: Int): Unit = {
    var maxInd = i
    var l = leftCh(i)
    if(l <= size && H(l) > H(maxInd) )
      maxInd = l
    var r = rightCh(i)
    if(r <= size && H(r) > H(maxInd) )
      maxInd = r
    if (i != maxInd)
      swap(i, maxInd)
      shiftDown(maxInd)
  }

  def changeRank(i: Int, prior: Int) = {
    var oldPrior = H(i)
    H(i) = prior
    if(prior > oldPrior)
      shiftUp(i)
    else
      shiftDown(i)
  }

	def buildHeap(ar: ArrayBuffer[Int]) = {
    var n = ar.length
    size = n
    for (i <- (n/2).floor.toInt to 1 by -1)
      shiftDown(i)
  }

  def swap(i: Int, j: Int): Unit = {
    val tmp = H(j)
    H(j) = H(i)
    H(i) = tmp
  }

  def heapSort(arr: ArrayBuffer[Int]): Unit = {
    var n = arr.length
    for(i <- 0 until n)
      this.insert(arr(i))
    for(i <- n until 0 by -1)
      arr(i) = extractMax()
  }

}

object Heap extends Heap with App {
  val arr = ArrayBuffer(4,7,2,9,1,5)

  arr.foreach(x => print(s"$x, "))
  heapSort(arr)
  arr.foreach(x => print(s"$x, "))
  //  buildHeap(arr)
  H.foreach(println)
}
