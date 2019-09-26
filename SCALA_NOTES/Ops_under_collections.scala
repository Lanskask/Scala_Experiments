

val keyValues = List((3,"Me"),(1,"Thi"),(2,"Se"),(3,"ssa"),(1,"sisA"),(3,"ge:"),(3,"-)"),(2,"ere"),(2,"t"))

val keyValuesDS = keyValues.toDS

keyValuesDS.groupByKey( p => p._1 ).mapGroups( (k,vs) => (k, vs.foldleft("")((acc,p) => ace + p._2 ) )).show()

// red u ceByKey?
// C ha l lenge :
// E mulate the semantics of red u ceByKey on a Dataset using Dataset operations
// presented so far. Assume we'd have the following data set :
// Do..�se.+- t c l �, str<j1
val keyValues = List((3,"Me"),(1,"Thi"),(2,"Se"),(3,"ssa"),(1,"sisA"),(3,"ge:"),(3,"-)"),(2,"ere"),(2,"t"))
val keyValuesDS= keyValues.toDS

// --- +......_

keyValuesDS.groupByKey(p=>p._1).mapGroups((k,vs)=>(k,vs.foldleft("")((acc,p)=>ace+p._2)))

// -----------
// Example :
// Let ' s assume we have the following data set representing all of the posts 
// in a busy open source community ' s Discourse forum.

case class Post(authorID: Int, subforum: String, li kes: Int, date: String)
val postsDF = ... // DataFrame of Posts

// Let ' s say we would like to tally up each authors ' posts per subforum, and then
// rank the authors with the most posts per subforum.

import org.apache.spark.sql.functions._
val rankedDF =
	postsDF.groupBy( $"authorID", $"subforum")
	.agg(count( $"authorID")) // new DF wi th columns authorID, subforum, count(authorID)
	.orderBy( $"subforum", $"count(authorID)".desc)