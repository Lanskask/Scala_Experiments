import scala.collection.mutable.ArrayBuffer



//sealed abstract class Heap[Int]
//case class Leaf(rank: Int) extends Heap[Int]
case class Node(var rank: Int, var left: Node, var right: Node)

object HeapExprs extends App {
	val arr = ArrayBuffer(4,7,2,9,1,5)

  println(s"Init Array: $arr")
  val resultHeap = buildHeap(arr)
  println(s"Max: ${getMax(resultHeap).rank}")
  println(s"Result Array: ${buildResultArr(resultHeap)}")

  def buildHeap(arr: ArrayBuffer[Int]): ArrayBuffer[Node] = {
    var nodesArr = ArrayBuffer[Node]()

    if(nodesArr.isEmpty) nodesArr += Node(arr(0), null, null)

    for(i <- 1 until arr.length ) {
      var j = i
      var parentToFill = nodesArr(getParInd(i))
      var newNode = Node(arr(i), null, null)

      if(parentToFill.left == null) {
        parentToFill.left = newNode
      } else if(parentToFill.right == null) {
        parentToFill.right = newNode
      }

      nodesArr += newNode

      // swaping ranks of Nodes if parrent rank < child rank
      while(j > 1 && nodesArr(getParInd(j)).rank > nodesArr(j).rank) {
        swapNodesRanks(nodesArr(getParInd(j)), nodesArr(j))
        j = getParInd(j)
      }

      //      if(parentToFill.rank < newNode.rank) {
      //        swapNodesRanks(parentToFill, newNode)
      //      }
    }

    def swapNodesRanks(lastNode: Node, newNode: Node): Unit = {
      var tmp = lastNode.rank
      lastNode.rank = newNode.rank
      newNode.rank = tmp
    }

    nodesArr
  }

  def seedUp(): Unit = {

  }


  def getMax(nodesArr: ArrayBuffer[Node]): Node = {
    nodesArr.head
  }

  def buildResultArr(nodesArr: ArrayBuffer[Node]): ArrayBuffer[Int] = {

    var newArr = ArrayBuffer[Int]()
    nodesArr.foreach(node => newArr += node.rank)

    newArr
  }

  def getParInd(i: Int): Int = {
    (i/2).floor.toInt
  }

  // using indexes
  def buildHeap2(ar: ArrayBuffer[Node]) = {
    val N = ar.length

    def swap(a: Int, b: Int): Unit = {
      var tmp = ar(b)
      ar(b) = ar(a)
      ar(a) = tmp
    }

    for(i <- 0 until N ) {
      if(ar(i).left.rank > ar(i).rank) {
        swap(2*i, i)
      } else if(ar(i).left.rank > ar(i).rank) {
        swap(2*i + 1, i)
      }
    }
  }

}
