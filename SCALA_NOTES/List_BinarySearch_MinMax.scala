

package fpinscala.datastructures

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x,xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x,xs) => x * product(xs)
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  val example = Cons(1, Cons(2, Cons(3, Nil)))
  val example2 = List(1,2,3)
  val total = sum(example)
}

val x = List(1,2,3,4,5) match {
  case Cons(x, Cons(2, Cons(4, _))) => x
  case Nil => 42
  case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
  case Cons(h, t) => h + List.sum(t)
  case _ => 101
}

def tail[T](l: List[T]) = l match {
  case Nil => Nil
  case Cons(x, xs) => xs
} 

tail(List(1,2,3,4,5))
// ----------------

val hellW = new Thread(new Runnable {
  def run() {
    println("HeW")
  }
}).start()

// ---------------

def prLis[T](l: List[T]) = {
  l.toString
}


// ------------

def search8(l: List[Int], target: Int) = {
  @annotation.tailrec 
  def recursion(low: Int, high: Int): Option[Int] = (low + high) / 2 match {
    case _ if high < low => None 
    case mid if l(mid) > target => recursion( low, mid - 1 )      
    case mid if l(mid) < target => recursion( mid + 1, high )
    case mid => Some(mid)
  } 
  recursion(0,l.size - 1)
}

search8(List(6), 6) 
search8(List(1, 3, 4, 6, 8, 9, 11), 6) 
search8(List(1, 3, 4, 6, 8, 9, 11), 1) 
search8(List(1, 3, 4, 6, 8, 9, 11), 11)
search8(List(1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 634), 144) 
search8(List(1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377), 21) 
search8(List(1, 3, 4, 6, 8, 9, 11), 7) 
search8(List(1, 3, 4, 6, 8, 9, 11), 0) 
search8(List(1, 3, 4, 6, 8, 9, 11), 13)
search8(List(), 1) 

// -------------
def search2( l: List[Int], target: Int ) = {
  @annotation.tailrec
  def recursion( mid: Int, list: List[Int] ): Option[Int] =  list match {
    case Nil => None 
    case tar::Nil if tar == target => {
      print(mid + ", ")
      Some(mid)
    }
    case ls => {
        val(lows,highs) = ls.splitAt(mid) 
        if (ls(mid)>target) 
          recursion( lows.size / 2, lows)
        else 
          recursion( highs.size / 2, highs)
       }
  }
  recursion( l.size / 2, l);
}

search2(List(1, 3, 4, 6, 8, 9, 11), 6)

// -------------------------
def find2(list: List[Int], toFind: Int) = {
  @annotation.tailrec
  def recFind(list: List[Int], midInd: Int): Option[Int] = list match {
    case targ :: Nil 
      if targ == toFind => Some(midInd)
    case Nil => None
    case listToExamine: List[Int] => {
      val (first, last) = list.splitAt(midInd)
      if( listToExamine(midInd) < toFind ) 
        recFind(last, last.length / 2)
      else 
        recFind(first, first.length / 2)
    }
  }
}


def search1( l: List[Int], target: Int) = {
  @annotation.tailrec
  def recursion( mid: Int, list: List[Int] ): Option[Int] =  list match {
    case tar :: Nil if tar == target => Some(tar)
    case Nil => None 
    case ls => {
        val (lows, highs) = ls.splitAt(mid) 
        if (ls(mid) > target) 
          recursion( lows.size /2, lows)
        else 
          recursion( highs.size / 2, highs)
       }
  }
  recursion( l.size / 2, l)
}

search1(List(6), 6) 
search1(List(1, 3, 4, 6, 8, 9, 11), 6) 
search1(List(1, 3, 4, 6, 8, 9, 11), 1) 
search1(List(1, 3, 4, 6, 8, 9, 11), 11)
search1(List(1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 634), 144) 
search1(List(1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377), 21) 
search1(List(1, 3, 4, 6, 8, 9, 11), 7) 
search1(List(1, 3, 4, 6, 8, 9, 11), 0) 
search1(List(1, 3, 4, 6, 8, 9, 11), 13)
search1(List(), 1) 

// -------------------
def search3(target:Int, l:List[Int]) = {
  def recursion(mid:Int, list:List[Int]): Option[Int] =  list match {
    case tar::Nil if tar == target => Some(tar)
    case tar::Nil => None 
    case ls => {
        val(lows,highs) = ls.splitAt(mid) 
        if (ls(mid)>target) 
          recursion((lows.size)/2, lows)
        else 
          recursion((highs.size)/2, highs)
       }
  }
  recursion((l.size)/2, l);
}

// ------------------------

def flattenCust(list: List[Any]): List[Int] = {
  var newList: List[Int] = Nil

  for(item <- list) {
    if(item.isInstanseOf[Int]) {
      newList = item :: newList
    } else if (item.isInstanseOf[List[Int]]) {
      flattenCust(item)
    }
  }
  newList
}


def sumReq(ints: List[Int]): Int = ints match { 
    case Nil => 0
    case x :: tail => 
      a : newList 
      sumReq(tail)
}


List(List(1, 1), 2, List(3, List(5, 8)))

val newList: List[Int] = Nil
list match {
  case Nil => acc
  case a: Int => 
  case a :: tail => sumAcc(tail, a : newList)
}



def sum2(list: List[Int]): Int = {
  @tailrec
  def sumAcc(list: List[Int], acc: Int) = {
    list match {
      case Nil => acc
      case a :: tail => sumAcc(tail, acc + x)
    }
  }
  sumAcc(list, 0)
}

// ---------------------

def sumReq(ints: List[Int]): Int = ints match { 
    case Nil => 0
    case x :: tail => x + sumReq(tail)
}


def sum2(ints: List[Int]): Int = {
@tailrec
def sumAccumulator(ints: List[Int], accum: Int): Int = {
  print(accum + ", ")
  ints match {
    case Nil => accum
    case x :: tail => 
      print(accum + "; ")
      sumAccumulator(tail, accum + x)
  }
}
sumAccumulator(ints, 0)
}
sum2(List(1,2,3,4,5))


def sum2(list: List[Int]): Int = {
  @tailrec
  def sumAcc(list: List[Int], acc: Int) = {
    list match {
      case Nil => acc
      case a :: tail => sumAcc(tail, acc + x)
    }
  }
  sumAcc(list, 0)
}


def sum3(list: List[Int]): Int = {
  @tailrec
  def sumAcc(list: List[Int], acc: Int) = {
    list match {
      case Nil => acc
      case x :: tail => sumAcc(tail, acc + x) 
    }
  }
  sumAcc(list, 0)
}


// ----------


"Hello".map(_.toLong).product
"%04X".format('ä'.toInt)

// ----------------------
val countdoun1 = (n: Int) => 
    (0 to n).reverse.foreach(println)

// ---------------

def sign3(item: Int): Int = item match {
    case (item > 0) => 1
    case (item < 0) => -1
    case (item == 0) => 0
}


def sign5(item: Int): Int = {
    if (item > 0) 1
    else if (item < 0) -1
    else 0
}

def sign6(item: Int): Int = {
    if (item > 0) 1
    if (item < 0) -1
    else 0
}

def sign7(item: Int): Int = {
    if (item.isWhole) 0 
    if (item > 0) (1)
    if (item < 0) (-1)
}

def sign8(item: Int): Int = {
    if (item.isWhole) 0 else ()
    if (item > 0) (1) else ()
}
