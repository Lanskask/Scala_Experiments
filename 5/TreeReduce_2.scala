

def prepend[A](x: A, t: Tree[A]): Tree[A] = t match {
	case Leaf(v) => Node(Leaf(x), Leaf(v))
	case Node(l, r) => Node(prepend(x, l), r)
}

// scanLeft on trees
def scanLeft[A](t: Tree[A], a0: A, f: (A,A) => A): Tree[A] = {
	val tRes = upsweep(t, f)
	val scan1 = downsweep(tRes, a0, f)
	prepend(a0, scan1)
}

// ------------
def downsweep[A](t: TreeRes[A], a0: A, f : (A,A) => A): Tree[A] = t match {
	case LeafRes(a) => Leaf(f(a0, a))
	case NodeRes(l, _, r) => {
		val (tL, tR) = parallel(downsweep[A](l, a0, f),
		downsweep[A](r, f(a0, l.res), f))
		Node(tL, tR) 
	} 
}

// Parallel reduce that preserves the computation tree (upsweep)
def upsweep[A](t: Tree[A], f: (A,A) => A): TreeRes[A] = t match {
	case Leaf(v) => LeafRes(v)
	case Node(l, r) => {
		val (tL, tR) = parallel(upsweep(l, f), upsweep(r, f))
		NodeRes(tL, f(tL.res, tR.res), tR)
	}
}

// -------------

def reduceRes[A](t: Tree[A], f: (A,A) => A): TreeRes[A] = t match {
	case Leaf(v) => LeafRes(v)
	case Node(l, r) => {
		val (tL, tR) = (reduceRes(l, f), reduceRes(r, f))
		NodeRes(tL, f(tL.res, tR.res), tR)
	}
}


//// Tree definitions
// Trees storing our input collection only have values in leaves:
sealed abstract class Tree[A]
case class Leaf[A](a: A) extends Tree[A]
case class Node[A](l: Tree[A], r: Tree[A] ) extends Tree[A]

// Trees storing intermediate values also have ( res ) values in nodes:
sealed abstract class TreeRes[A] { val res: A }

case class LeafRes[A](
	override val res: A
) extends TreeRes[A]

case class NodeRes[A](
	l: TreeRes[A],
	override val res: A,
	r: TreeRes[A]
) extends TreeRes[A]

// -------------
def scanLeft[A](inp: Array[A], a0: A, f: (A,A) => A, out: Array[A]) = {
	
	val fi = { (i:Int,v:A) => reduceSeg1(inp, 0, i, a0, f) }
	
	mapSeg(inp, 0, inp.length, fi, out)
	
	val last = inp.length - 1
	
	out(last + 1) = f(out(last), inp(last))
}

def reduceSeg1[A](
	inp: Array[A], 
	left: Int, 
	right: Int,
	a0: Int, 
	f: (A,A) => A
): A

def mapSeg[A,B](
	inp: Array[A], 
	left: Int, 
	right: Int,
	fi : (Int,A) => B,
	out: Array[B]
): Unit

// ---------------

def scanLeft[A](
	inp: Array[A],
	a0: A, f: (A,A) => A,
	out: Array[A]
): Unit = {
		out(0)= a0
		var a= a0
		var i= 0
		
		while (i < inp.length) {
			a= f(a,inp(i))
			i= i + 1
			out(i)= a
		}
	}

// ------------


def f(u: Double, v: Double): Double =
  (u + v)/(1.0 + u*v)

def err(lst:List[Double]): Double =
  lst.reduceLeft(f) - lst.reduceRight(f)

def testAssoc: Double = {
  val r = new scala.util.Random
  val lst = List.fill(400)(r.nextDouble*0.002)
  err(lst)  
}

