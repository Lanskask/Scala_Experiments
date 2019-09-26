import org.scalameter._

val time = measure { (0 until 1000000).toArray }

val time = withWarmer(new Warmer.Default) measure { (0 until 1000000).toArray }


val time = config(
	Key.exec.minWarmupRunt -> 20,
	Key.exec.maxWarmupRunt -> 60,
	Key.verbose -> true
)	withWarmer(new Warmer.Default) measure { (0 until 1000000).toArray }

withMeasurer(new Measurer.MemoryFootprint) measure { (0 until 1000000).toArray }



// ▶ Measurer.Default – plain running time
// ▶ IgnoringGC – running time without GC pauses
// ▶ OutlierElimination – removes statistical outliers
// ▶ MemoryFootprint – memory footprint of an object
// ▶ GarbageCollectionCycles – total number of GC pauses
// ▶ newer ScalaMeter versions can also measure method invocation
// counts and boxing counts