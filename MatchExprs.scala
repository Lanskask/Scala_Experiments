


object MatchExprs extends App {
	def mat(ch: String): Unit = ch match {
		case ch if ch != "" =>
			println("ch != \"\"")
		case ch if ch.isEmpty =>
			println("ch == \"\"")
		case _ => 
			println("some other")
	}

	mat("")
}