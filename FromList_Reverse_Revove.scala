
// 'Adj. Open', 'Adj. High', 'Adj. Low', 'Adj. Close',	'Adj. Volume'

def insert(x, xs): List[Int] = xs match {
	case List() => List(x)
	case y :: ys => if (x < y) x :: xs else y :: insert(x, ys)  
}


def init2(xs: List[Int]): List[Int] = xs match {
	case List(x) => Nil
	case y :: ys => y :: init2(ys) 
}

def reverse2(xs: List[Int]): List[Int] = xs match {
	case List() => Nil
	case y :: ys => reverse2(ys) ++ List(y)
}

def removeAt[T](n: Int, xs: List[Int]): List[Int] = xs match {
	case xs if xs.length > n => xs
	case y :: ys if y == xs(n) 
	case y :: ys if  
}


def sum5(f: Int => Int, a: Int, b: Int): Int = 
	if(a > b) 0 else f(a) + sum5(f, a + 1, b)