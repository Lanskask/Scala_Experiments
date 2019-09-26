object Demo1 extends App {
	def f: Int = 
		try {
			0
		} catch {
			case _: Error => 1
		} finally {
			/*return*/ "A"
		}

	val x: Any = 
		try {
			0
		} finally {
			/*return*/ "A" // error
		}

	val x2 = try {
		0				   // print at second
	} finally {
		println("finally") // print at first
	}

	println(x2)

	val x3 = try {
		// throw new Error   // print at second
	} finally {
		println("finally") // print at first
	}

	// println(x3) 

	// treis with returns
	// return 1
	def f0: Int = try {
		return 0
	} finally {
		return 1
	}
	
	// return 1
	def f1: Int = try {
		throw new Error
	} finally {
		return 1
	}

	// println(f0)
	// println(f1)

	// tries with return Error
	// Error
	def f2: Int = try {
		0
	} finally {
		throw new Error
	}
	
	// Error
	def f3: Int = try {
		throw new RuntimeException
	} finally {
		throw new Error
	}

	f1
	f0
} 
 