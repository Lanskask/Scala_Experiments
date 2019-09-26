


"""Functions are 
	contrvariant 
		in their argument types 
and 
	covariant 
		in their result type
"""

package scala 
trait Function[-T, +U] {
	def apply(x: T): U
}