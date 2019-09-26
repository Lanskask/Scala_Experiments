
// -----------
If u,v are in the interval (-1,1), show that (1-u)(1-v) > 0 and thus (u+v)/(1 + uv) < 1.
// -----------
// Example: average


// Given a collection of integers, compute the average
val sum = reduce(collection, _ + _)
val length = reduce(map(collection, (x:Int) => 1), _ + _)
sum/length
// This includes two reductions. Is there a solution using a single reduce?

""" => """
// Use pairs that compute sum and length at once
f((sum1,len1), (sum2, len2)) = (sum1 + sum1, len1 + len2)
Function f is associative because addition is associative.
// Solution is then:
val (sum, length) = reduce(map(collection, (x:Int) => (x,1)), f)
sum/length

// ---------------
reduce( map(a, power(abs(_), p)), _ + _)

// -----------------
// Observe: can use a list to describe the ordering of elements of a tree
def toList[A](t: Tree[A]): List[A] = t match {
	case Leaf(v) => List(v)
	case Node(l, r) => toList[A](l) ++ toList[A](r) }

// Suppose we also have tree map:
def map[A,B](t: Tree[A], f : A => B): Tree[B] = t match {
	case Leaf(v) => Leaf(f(v))
	case Node(l, r) => Node(map[A,B](l, f), map[A,B](r, f)) }

// Can you express toList using map and reduce?
toList(t) == reduce(map(t, List(_)), _ ++ _)

// -------------

sealed abstract class Tree[A]
case class Leaf[A](value: A) extends Tree[A]
case class Node[A](left: Tree[A], right: Tree[A]) extends Tree[A]

def reduce[A](t: Tree[A], f : (A,A) => A): A = t match {
	case Leaf(v) => v
	case Node(l, r) => f(reduce[A](l, f), reduce[A](r, f)) // Node -> f
}

def tree = Node(Leaf(1), Node(Leaf(3), Leaf(8)))
def fMinus = (x:Int,y:Int) => x - y
def res = reduce[Int](tree, fMinus) 
