
val request = 4
def index { 
	implicit request: Int => {
		print(2 + request)
	}
}

def index2 { implicit request => 
		print(2 + request)
}

Array("paper", "rock", "paper", "scissors")
	.par.fold("")(play)

def play(a: String, b: String): String = List(a, b).sorted match {
	case List("paper", "scissors") => "scissors"
	case List("paper", "rock") => "paper"
	case List("rock", "scissors") => "rock"
	case List(a, b) if a == b => a
	case List("", b) => b
}