
organization := "com.example"
version      := "0.1.0-SNAPSHOT"
name := "JavaAlgorithms"

javacOptions in (Compile, compile) ++= Seq("-source", "1.8", "-target", "1.8", "-g:lines")

// https://mvnrepository.com/artifact/junit/junit
libraryDependencies += "junit" % "junit" % "4.12" % Test


crossPaths := false // drop off Scala suffix from artifact names.
autoScalaLibrary := false // exclude scala-library from dependencies