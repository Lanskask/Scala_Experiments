object Demo1 extends App {
	println(f0)
	println(f1)

	def f0: Int = try {
		return 0
	} finally {
		return 1
	}

	def f1: Int = try {
		throw new Error
	} finally {
		return 1
	}

} 
