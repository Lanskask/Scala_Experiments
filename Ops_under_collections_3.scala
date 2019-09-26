FlatSpecLike BeforeAndAfterAll MustMatches


def product(ds: List[Double]): Double = ds match {
	case Nil => 1.0
	case Cons(x, xs) => x * product(xs)
}


List(Map("a" -> "b", "c" -> "d"), Map("d" -> "e"))