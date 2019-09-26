


// Function wich returns other function
def sum(f: Int => Int/*fun 1*/): (Int, Int) => Int /*fun 2*/ = {
	def sumF(a: Int, b: Int): Int = {
		if( a > b) 0
		else f(a) + sumF(a + 1, b)
	}
	sumF
}

// Upper can be rewritten as following: 
def sum(f: Int => Int)(a: Int, b: Int): Int = 
	if (a > b) 0 else f(a) + sum(f)(a + 1, b)


def sumInts = sum(x => x)
def sumCubes = sum(x => x * x * x)

def cube(x: Int) = x * x * x 
// It can be used in such way =>
sum(cube)(1,5)


// ===================
def product(f: Int => Int)(a: Int, b: Int): Int = 
	if (a > b) 0 else f(a) * product(f)(a + 1, b)


def product(f: Int => Int)(a: Int, b: Int): Int = 
	if ( a > b ) 1 else f(a) * product(a + 1, b)

def fact(a: Int) = product((x => x)(1, a)


def product(f: Int => Int)
			(f2: (Int, Int) => Int)
			(a: Int, b: Int, c: Int): Int = 
	if (a > b) c else f2(f(a), product(f)(f2)(a + 1, b, c))

def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)
			(a: Int, b: Int): Int = 
	if (a > b) zero else combine(f(a), mapReduce(f, combine)(a + 1, b, zero))


def product2 = mapReduce(f, (x, y) => (x * y), 1)(a, b)