class Point(val x: Int, val y: Int) { 
    def equals(other: Point): Boolean =
        this.x == other.x && this.y == other.y
}

val p1 = new Point(1,2)
val p2 = new Point(1,2)
p1 equals p2

val p2a: Any = p2
p2 equals p2a

var hashSet: Set[Point] = new collection.immutable.HashSet
hashSet += p1
hashSet contains p2

// -----------
class Point(val x: Int, val y: Int) { 
  override def equals(other: Any) = other match {
    case that: Point => this.x == that.x && this.y == that.y
    case _ => false
  }
}

val p1 = new Point(1,2)
val p2 = new Point(1,2)
p1 equals p2

var hashSet: Set[Point] = new collection.immutable.HashSet
hashSet += p1
hashSet contains p2

// -------------------
class Point(val x: Int, val y: Int) {
  override def hashCode = (x, y).##
  override def equals(other: Any) = other match {
    case that: Point => this.x == that.x && this.y == that.y
    case _ => false
  }
}

val p1 = new Point(1,2)
val p2 = new Point(1,2)
p1 equals p2

var hashSet: Set[Point] = new collection.immutable.HashSet
hashSet += p1
hashSet contains p2

// -------------
class ColoredPoint(x: Int, y: Int, val color: Color.Value)
    extends Point(x, y) { 
  // Проблема: нарушена транзитивность equals
  override def equals(other: Any) = other match {
    case that: ColoredPoint =>
      (this.color == that.color) && super.equals(that)
    case that: Point =>
      that equals this
    case _ =>
      false
  }
}

val redp = new ColoredPoint(1, 2, Color.Red)
val bluep = new ColoredPoint(1, 2, Color.Blue)

redp == p
p == bluep
redp == bluep

// Технически состоятельный, но не удовлетворяющий нас метод equals
class Point(val x: Int, val y: Int) {
  override def hashCode = (x, y).##
  override def equals(other: Any) = other match {
    case that: Point =>
      this.x == that.x && this.y == that.y &&
      this.getClass == that.getClass
    case _ => false
  }
}

// -----------------------
class ColoredPoint(x: Int, y: Int, val color: Color.Value)
    extends Point(x, y) {
 
  override def equals(other: Any) = other match {
    case that: ColoredPoint =>
      (this.color == that.color) && super.equals(that)
    case _ => false
  }
}

val pAnon = new Point(1, 1) { override val y = 2 }

p equals pAnon // false

// -----------
// def canEqual(other: Any): Boolean
class Point(val x: Int, val y: Int) {
  override def hashCode = (x, y).##
  override def equals(other: Any) = other match {
    case that: Point =>
      (that canEqual this) &&
      (this.x == that.x) && (this.y == that.y)
    case _ =>
     false
  }
  def canEqual(other: Any) = other.isInstanceOf[Point]
}

class ColoredPoint(x: Int, y: Int, val color: Color.Value)
    extends Point(x, y) {
 
  override def hashCode = (super.hashCode, color).##
  override def equals(other: Any) = other match {
    case that: ColoredPoint =>
      (that canEqual this) &&
      super.equals(that) && this.color == that.color
    case _ =>
      false
  }
  override def canEqual(other: Any) =
    other.isInstanceOf[ColoredPoint]
}


// =============
import scala.language.implicitConversions

class Rational(n: Int, d: Int) {

  require(d != 0)

  private val g = gcd(n.abs, d.abs)
  val numer = n / g
  val denom = d / g
  def this(n: Int) = this(n, 1)

  def add(that: Rational): Rational =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  def + (that: Rational): Rational = 
    this.add(that)

  def * (that: Rational): Rational =
    new Rational(numer * that.numer, denom * that.denom) 

  override def toString = numer + "/" + denom

  // implicit def intToRational(x: Int) = new Rational(x)

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}

implicit def intToRational(x: Int) = new Rational(x)

val x = new Rational(2,3)

2 * x

// ======================
for (i <- 0 until b.length) 
     | println(s"$i: ${b(i)}")
0: 1
1: 3
2: 4
3: 2
4: 4

for (i <- 0 until (b.length, 2) ) 
  println(s"$i: ${b(i)}")
0: 1
2: 4
4: 4

for (i <- 0 until (b.length, 2) by -1 ) 
  println(s"$i: ${b(i)}")

for (i <- 0 until b.length by -1 ) 
  println(s"$i: ${b(i)}")

for (i <- b.indices) 
  println(s"$i: ${b(i)}")

// ----------------------
val a = Array(2, 3, 5, 7, 11)
val result = for (elem <- a) yield 2 * elem
// результат: Array(4, 6, 10, 14, 22)

for (elem <- a if a % 2 == 0) yield 2 * elem

// Примечание. Ту же задачу можно решить иначе:
a.filter(_ % 2 == 0).map(2 * _)
// или даже
a.filter { _ % 2 == 0 } map { 2 * _ }

// =============
import scala.annotation.tailrec
class Util {
  @tailrec def sum2(xs: Seq[Int], partial: BigInt): BigInt =
    if (xs.isEmpty) partial else sum2(xs.tail, xs.head + partial)
}

import scala.annotation.tailrec
object Util {
  @tailrec final def sum2(xs: Seq[Int], partial: BigInt): BigInt =
    if (xs.isEmpty) partial else sum2(xs.tail, xs.head + partial)
}

Util.sum2(1 to 1000000, 0)

