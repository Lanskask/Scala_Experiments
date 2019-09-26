



// -----------------------------

val figs = List[Figure]()

figs.forall()

case class Figure(x: Int, )


case class Queen(x: Int)

// -----------------


val allCells = List(C(0,0), C(0,1), C(0,2), C(1,0), C(1,1), C(1,2), C(2,0), C(2,1), C(2,2))

import

val allPermutations = ArrayBuffer[List[List[C]]]()

var allPermutations = List[List[List[C]]]()

allCells.combinations(3).foreach(x => allPermutations = allPermutations ++ x.permutations.toList)


allCells.combinations(3).foreach(x => x.permutations.mkString(", "))


// allCells.combinations(3).foreach(x => allPermutations += x.permutations.toList)
// allCells.combinations(3).foreach(x => x.permutations.toList.filter(x => scanList(x)).size)


// ----------------------

Utils.allCells(n,m).combinations(figs.size).toList.filter(x => scanList(x)).size

// --------------------
List(C(0,0), C(0,1), C(0,2), C(1,0), C(1,1), C(1,2), C(2,0), C(2,1), C(2,2)).combinations(3).toList.filter(x => scanList(x))


val list1 = List(C(0,0), C(0,1), C(0,2))
val list2 = List(C(0,0), C(1,1), C(2,2))

def scanList(list: List[C]): Boolean = {
	list.forall(x => isSafe(x, list diff List(x)))
}

def isSafe(fig: C, others: List[C]): Boolean = {
  others forall(!isAttackedForRook(fig, _))
}

def isAttackedForRook(r1: C, r2: C): Boolean = {
  r1.x == r2.x || r1.y == r2.y
}


// -------------------------
List(Coordinate(0,0), Coordinate(0,1), Coordinate(0,2), Coordinate(1,0), Coordinate(1,1), Coordinate(1,2), Coordinate(2,0), Coordinate(2,1), Coordinate(2,2)).combinations(3)


List(C(0,0), C(0,1), C(0,2))
	.combinations(2)
	.forall{
		case List(c1,c2) => 
			c1.x != c2.x 	&& 
			c1.y != c2.y
	}

List(C(0,0), C(0,1), C(0,2)).forall((a, b) => a.x == b.x || a.y == b.y)


------------------
case class C(x: Int, y: Int)

case class Figure(coord: C, sign: String)

val rook1 = Figure(coord, "R")

case class Coordinate(x: Int, y: Int)

---------------------------

object Base {
	case class Arb

	def sezE = _n * _m
}

class Base(_n: Int, _m: Int) {

}

// ---------------
case class Board(_n: Int, _m: Int) {
  import Circle._
  def area: Double = calculateArea(radius)


}

case class C(var x: Int, var y: Int) 

object Board {
	case class Queen(var coord: C)

  private def calculateArea(radius: Double): Double = Pi * pow(radius, 2.0)
}

// --------------------------

C(1,2), C(3,2), C(2,3), C(2,1)


// ---------
ArrayBuffer(Coordinate(1,0), Coordinate(3,0), Coordinate(0,1), Coordinate(4,1), Coordinate(0,3), Coordinate(4,3), Coordinate(1,4), Coordinate(3,4)) diff ArrayBuffer(Coordinate(3,4), Coordinate(4,3), Coordinate(4,1), Coordinate(3,0), Coordinate(1,0), Coordinate(0,1), Coordinate(0,3), Coordinate(1,4))

ArrayBuffer(Coordinate(0,0), Coordinate(2,0), Coordinate(4,0), Coordinate(1,1), Coordinate(2,1), Coordinate(3,1), Coordinate(0,2), Coordinate(1,2), Coordinate(3,2), Coordinate(4,2), Coordinate(1,3), Coordinate(2,3), Coordinate(4,3), Coordinate(0,4), Coordinate(2,4), Coordinate(4,4)) diff ArrayBuffer(Coordinate(0,0), Coordinate(2,0), Coordinate(4,0), Coordinate(1,1), Coordinate(2,1), Coordinate(3,1), Coordinate(0,2), Coordinate(1,2), Coordinate(3,2), Coordinate(4,2), Coordinate(1,3), Coordinate(2,3), Coordinate(3,3), Coordinate(0,4), Coordinate(2,4), Coordinate(4,4))

// ---------------

for(i <- 0 until n) {
  println(s"$i, $i")
}

for(i <- 0 until n) {
  println(s"$i, ${n - i - 1}")
}


val (n, m) = (5, 5)
val (x, y) = (2,2)
for(i <- x + 1 until n; j <- y + 1 until m) {
    println(s"$i, $j")
}

Coordinate(0,0), Coordinate(1,0), Coordinate(3,0), Coordinate(4,0), Coordinate(0,1), Coordinate(1,1), Coordinate(3,1), Coordinate(4,1), Coordinate(0,3), Coordinate(1,3), Coordinate(3,3), Coordinate(4,3), Coordinate(0,4), Coordinate(1,4), Coordinate(3,4), Coordinate(4,4)) 

Coordinate(0,0), Coordinate(4,0), Coordinate(1,1), Coordinate(3,1), Coordinate(1,3), Coordinate(3,3), Coordinate(0,4), Coordinate(4,4))


// ------------------

Coordinate(2,2), Coordinate(2,2), Coordinate(3,2), 
Coordinate(4,2), Coordinate(2,3), Coordinate(2,4))


Coordinate(2,0), Coordinate(2,1), Coordinate(0,2), Coordinate(1,2), 
Coordinate(3,2), Coordinate(4,2), Coordinate(2,3), Coordinate(2,4))


C(2,0), C(2,1), C(2,3), C(2,4), // UpD
C(0,2), C(1,2), C(3,2), C(4,2) // LeftRight

C(3,3), C(4,4), 
C(3,1), C(4,0), 
C(1,1), C(0,0), 
C(1,3), C(0,4)


ArrayBuffer(Coordinate(2,2), Coordinate(3,2), Coordinate(4,2), Coordinate(2,2), Coordinate(2,3), Coordinate(2,4), Coordinate(2,2), Coordinate(3,2), Coordinate(4,2), Coordinate(2,3), Coordinate(3,3), Coordinate(4,3), Coordinate(2,4), Coordinate(3,4), Coordinate(4,4)) 

did not equal 

ArraySeq(Coordinate(0,0), Coordinate(2,0), Coordinate(4,0), Coordinate(1,1), Coordinate(2,1), Coordinate(3,1), Coordinate(0,2), Coordinate(1,2), Coordinate(3,2), Coordinate(4,2), Coordinate(1,3), Coordinate(2,3), Coordinate(4,3), Coordinate(0,4), Coordinate(2,4), Coordinate(4,4))



C(0,0), C(2,0), C(4,0), 
C(1,1), C(2,1), C(3,1), 
C(0,2), C(1,2), C(3,2), C(4,2), 
C(1,3), C(2,3), C(3,3), 
C(0,4), C(2,4), C(4,4)
// ------------

(Coordinate(3,4), Coordinate(4,3), Coordinate(4,1), Coordinate(3,0), Coordinate(1,0), Coordinate(0,1), Coordinate(0,3), Coordinate(1,4))


mutable.ArraySeq(
	Coordinate(1,4), Coordinate(3,4), Coordinate(4,3), Coordinate(4,1), 
		Coordinate(3,0), Coordinate(1,0), Coordinate(0,1), Coordinate(0,4)
)

case class Coordinate(x: Int, y: Int)
import scala.collection.mutable

val coords1 = mutable.ArraySeq(	Coordinate(1,4), Coordinate(3,4), Coordinate(4,3), Coordinate(4,1) )
val coords2 = Seq(	Coordinate(1,4), Coordinate(3,4), Coordinate(4,3), Coordinate(4,1) )

val coords3 = Seq(	Coordinate(1,4), Coordinate(-3,4), Coordinate(4,-3), Coordinate(4,1) )


ArraySeq(Coordinate(0,1), Coordinate(0,4), Coordinate(1,4), Coordinate(1,0), Coordinate(3,4), Coordinate(3,0), Coordinate(4,3), Coordinate(4,1))

ArraySeq(Coordinate(0,1), Coordinate(0,3), Coordinate(1,0), Coordinate(1,4), Coordinate(3,4), Coordinate(3,0), Coordinate(4,3), Coordinate(4,1)) 

did not equal 

ArraySeq(Coordinate(0,1), --Coordinate(0,4), Coordinate(1,4), Coordinate(1,0), Coordinate(3,4), Coordinate(3,0), Coordinate(4,3), Coordinate(4,1))
// -------------------

Queen
Rook // Башня
Bishop // слон
Knight // Конь
King 

Coordinate
Figure

FigureNotFoundException
ImpossibleMovementException
OccupiedWayException



case class Bishop extends Figure {
	override val priority = 3
} // слон
case class Knight extends Figure {
	override val priority = 3
} // Конь
case class King extends Figure {
	override val priority = 3
}
