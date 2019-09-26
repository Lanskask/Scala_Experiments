
Operation complexity for sequences can vary.
▶ mutable linked lists – O(1) prepend and append, O(n) insertion
▶ functional (cons) lists – O(1) prepend operations, everything else O(n)
▶ array lists – amortized O(1) append, O(1) random accesss, otherwise O(n)

// -----------
You are given the trait `Traversable[T]`:
```scala
trait Traversable[T] {
  def foreach(f: T => Unit): Unit
  def newBuilder: Builder[T, Traversable[T]]
  def filter(p: T => Boolean): Traversable[T] = ???
}
```

Your task is to complete the `filter` method - replace `???` with the correct statement:
```scala
def filter(p: T => Boolean): Traversable[T] = {
  val b = newBuilder
  // ???
  for (x <- this) if (p(x)) b += x
  b.result
}
```

Note: Use x as the variable name.



// -------------
You are given the following trait called `Splitter[T]`:
```scala
trait Splitter[T] {
  def split: Seq[Splitter[T]]
  def remaining: Int
}
```

Your task is to complete the `fold` method on this trait:
```scala
def fold(z: T)(f: (T, T) => T): T = {
  if (remaining < threshold) foldLeft(z)(f)
  else {
    // val children: Seq[Task[T]] = ???
    val children: Seq[Task[T]] = for (child <- split ) yield task { child.fold(z)(f)}
    children.map(_.join()).foldLeft(z)(f)
  }
}
```

You may use the `task` construct for this purpose.

When traversing or mapping the sequence returned by `split`, make sure you refer to each individual splitter with the identifier `child`. Also, make sure you use proper whitespace.

// ----------
You are given the following trait called `Iterator[T]`. The trait has an abstract `next` and `hasNext` methods, and an implementation of `foldLeft`. When `foldLeft` is called, it is supposed to use `next` and `hasNext` methods to drain the elements and produce the result.
```scala
trait Iterator[T] {
  def hasNext: Boolean
  def next(): T
  def foldLeft[S](z: S)(f: (S, T) => S): S = ???
}
```


Your task is to implement `foldLeft`. Concretely - implement the line that contains `???`.
```scala
def foldLeft[S](z: S)(f: (S, T) => S): S = {
  var result = z
  // if(seq.hasNext) f(z, seq.next) else z
  if(seq.hasNext) result = f(z, seq.next) 
  result
}
```




// -----------
val graph = mutable.Map[Int, Int]() ++= (0 until 100000).map(i => (i, i + 1))
graph(graph.size - 1) = 0
for ((k, v) <- graph.par) graph(k) = graph(v)
val violation = graph.find({ case (i, v) => v != (i + 2) % graph.size })
println(s”violation: $violation”)

// -------------

ConcurentSkipListSet

// ▶ Traversable[T] – collection of elements with type T, with operations implemented using foreach
// ▶ Iterable[T] – collection of elements with type T, with operations implemented using iterator
// ▶ Seq[T] – an ordered sequence of elements with type T
// ▶ Set[T] – a set of elements with type T (no duplicates)
// ▶ Map[K, V] – a map of keys with type K associated with values of type V (no duplicate keys)

// --------------------
val isVowel = Set('A', 'E', 'I', 'O', 'U')
Array('E', 'P', 'F', 'L').par.fold(0)((count, c) => if (isVowel(c)) count + 1 else count)

// The foldLeft operation is more expressive than fold. Sanity check:
def fold(z: A)(op: (A, A) => A): A = foldLeft[A](z)(op)

Array('E', 'P', 'F', 'L').par.aggregate(0)(
	(count, c) => if (isVowel(c)) count + 1 else count,
	_ + _
)