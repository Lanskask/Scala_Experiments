
object BinarySearch {

  def find( l: List[Int], target: Int ) = {
    @annotation.tailrec 
    def recursion ( low: Int, high: Int ): Option[Int] = ( low + high ) / 2 match {
      case _ if high < low => None 
      case mid if l(mid) > target => recursion( low, mid - 1 )      
      case mid if l(mid) < target => recursion( mid + 1, high )
      case mid => Some(mid)
    } 
    recursion( 0, l.size - 1 )
  }

  /*def find(list: List[Int], valToFind: Int) = {
    @annotation.tailrec
    def recFind(list: List[Int], midInd: Int): Option[Int] = list match {
      case Nil => None
      case targToExem::Nil
        if targToExem == valToFind => Some(midInd)
      case listToExem: List[Int] => {
        val (first, last) = listToExem.splitAt(midInd)
        if (listToExem(midInd) < valToFind)
          recFind(first, first.length / 2)
        else
          recFind(last, last.length / 2)
      }
    }
  }*/

}