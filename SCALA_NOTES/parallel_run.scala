

def run(p: Int) = {
	val taskSupport = new collectiong.parallel.ForkJoinTaskSupport(
			new scala.concurrent.forkjoin.ForkjoinPool(p))
	val strings = (0 until size).map(_.toString)
	val time = standartConfig measure {
		val parallelized = string.par
		parallelized.tasksupport = taskSupport
		parallelized.aggregete(  new ConcBuffer[String])(_ += _, _ combine _).result
	} 
}