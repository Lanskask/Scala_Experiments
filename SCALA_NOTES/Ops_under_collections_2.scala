
Narrow dependencies
  map
  mapValues
  flatMap
  filter
  mapPartitions
  mapPartitionsWithIndex

Wide dependencies
  cogroup
  groupWith
  join
  leftOuterJoin
  rightOuterJoin
  groupByKey
  reduceByKey
  combineByKey
  distinct
  intersection
  repartition
  coalesce

// ---------------------
// You can also figure out whether a shuffle has been planned/executed via:
// 1. The return type of certain transformations, e.g.,
org.apache.spark.rdd.RDD[(String, Int)]= ShuffledRDD[366]
// 2. Using function toDebugString to see its execution plan:
  .toDebugString 

// ---------
// Operations that might cause a shuffle
cogroup
groupWith
join
leftOuterJoin
rightOuterJoin
groupByKey
reduceByKey
combineByKey
distinct
intersection
repartition
coalesce 

// ---------------
// Partitioning Data Using Transformations
// Operations on Pair RD Ds that hold to ( and propagate) a partitioner:
cogroup
groupWith
Join
leftOuterJoin
rightOuterJoin
groupByKey
reduceByKey
foldByKey
combineByKey
partitionBy
sort
mapValues // (if parent has a partitioner)
flatMapValues // (if parent has a partitioner)
filter // (if parent has a partitioner)

All other operations will produce a result without a partitioner.

// -----------------
val purchasesPerMonth =
purchasesRdd.map(p => (p.customerld, (1, p.price))) // Pair ROD
  .reduceByKey( 
  /*(a,b) => */ 
    (a,b) => (a._1 + b._1, a._2 + b._2)
  ) //? 

//
case class CFFPurchase(customerid: Int, destination: String, price: Double)

val purchasesRdd: RDD[CFFPurchaseJ] = sc.textFile()
val purchasesPerMonth = purchasesRdd.map(item => (item.customerid, item.price))
  .groupByKey()
  // .map(p => (p._1, (p._2.size, p._2.sum))) // also could be possible
  .mapValues(
    (a,b) => (a._1 + b._1, a._2 + b._2)
  )

// ----------------
// Pair ROD Transformation: reduceByKey
// Example: Let's use eventsRdd from the previous example to calculate the total budget per organizer of all of their organized events.
case class Event(organizer: String, name: String, budget: Int)

val eventsRdd = sc.parallelize( ... )
  .map(
    event=> (event.organizer, event.budget)
  )
val budgetsRdd = eventsRdd.reduceByKey(_+_)
budgetsRdd.collect().foreach(println)
// (Prime Sound, 42000)
// (Sportorg, 36400)
// (Innotech, 320000)
// (Association Bal€lec, 50000) 

// ----------
reduceByKey
mapValues

// ------
case class Event(organizer: String, name: String, budget: Int)
val eventsRdd = sc.parallelize( ... )
.map(event => (event.organizer, event.budget))
val groupedRdd = eventsRdd.groupByKey() 

// -----------------

val ages = List(2, 52, 44, 23, 17, 14, 12, 82, 51, 64)
val grouped = ages.groupBy { age =>
  if (age >= 18 && age < 65) "adult"
  else if (age < 18) "child"
  else "senior"
}

// -------------

case class Taco(kind: String, price: Double)

val tacoOrder = 
  List(
    Taco("Carn1", 2.25),
    Taco("Carn2", 1.75),
    Taco("Carn3", 2.50),
    Taco("Carn4", 2.00)
  )

val cost tacoOrder.foldLeft(0.0)((sum, taco) => sum + taco.price)
// ---------

val lastYearsLogs: RDD[String] = ...
val numOfErrorLogs = lastYearsLogs.filter(
  lg => lg.contains("2016-12") && lg.contains("error")
).count()