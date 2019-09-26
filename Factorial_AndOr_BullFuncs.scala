

def gcd(a: Int, b: Int): Int = 
	if(b == 0) a else gcd(b, a % b)

@annotation.tailrec
def factorial(n: Int, acc: Int): Int = 
	// if(n == 0) 1 else n * factorial(n - 1)
	if(n == 0) acc else factorial(n - 1, acc * n)



// --------------
def and2(x: Boolean, y: Boolean): Boolean = if(x) if (y) true else false else false


def and(x:Boolean,y: =>Boolean) = if(x) y else false


assert(and(true, true) == true)
assert(and(true, false) == false)
assert(and(false, true) == false)
assert(and(false, false) == false)

def or(x: Boolean, y: Boolean): Boolean = {
	if(x) true
	else 
		if (y) true
		else false
}


true || e --> true
false || e --> e
def or(x:Boolean,y: =>Boolean) = if(x) true else y



assert(or(true, true) == true)
assert(or(true, false) == true)
assert(or(false, true) == true)
assert(or(false, false) == false)
