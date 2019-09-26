import scala.concurrent.duration._

import java.time._
import scala.concurrent._
import ExecutionContext.Implicits.global

val r = scala.util.Random
def random() = {
	r.nextInt
}

val future1 = Future { Thread.sleep(100)
	if (random() < 0.5) throw new Exception
	1
}

val future2 = Future { Thread.sleep(100)
	if (random() < 0.5) throw new Exception
	2
}

val combined = 
	for ( n1 <- future1; n2 <- future2 if n1 != n2) yield n1 + n2

combined onSuccess {
	case v => println(s"The answer is $v")
}

combined onFailure {
	case ex => println(ex.getMessage)
}

combined.onComplete {
	case Success() => println(s"The answer is SOMESDSDGASG")
	case Failure() => println("SOMESDSDGASG")
}