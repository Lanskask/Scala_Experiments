organization in ThisBuild := "ru.smurtazin"
version in ThisBuild := "1.0-SNAPSHOT"

// the Scala version that will be used for cross-compiled libraries
scalaVersion in ThisBuild := "2.12.8"

val macwire = "com.softwaremill.macwire" %% "macros" % "2.3.0" % "provided"
val scalaTest = "org.scalatest" %% "scalatest" % "3.0.4" % Test

lazy val `lagom-task-scheduler` = (project in file("."))
  .aggregate(`lagom-task-scheduler-api`, `lagom-task-scheduler-impl`, `lagom-task-scheduler-stream-api`, `lagom-task-scheduler-stream-impl`)

lazy val `lagom-task-scheduler-api` = (project in file("lagom-task-scheduler-api"))
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslApi
    )
  )

lazy val `lagom-task-scheduler-impl` = (project in file("lagom-task-scheduler-impl"))
  .enablePlugins(LagomScala)
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslPersistenceCassandra,
      lagomScaladslKafkaBroker,
      lagomScaladslTestKit,
      macwire,
      scalaTest
    )
  )
  .settings(lagomForkedTestSettings)
  .dependsOn(`lagom-task-scheduler-api`)

lazy val `lagom-task-scheduler-stream-api` = (project in file("lagom-task-scheduler-stream-api"))
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslApi
    )
  )

lazy val `lagom-task-scheduler-stream-impl` = (project in file("lagom-task-scheduler-stream-impl"))
  .enablePlugins(LagomScala)
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslTestKit,
      macwire,
      scalaTest
    )
  )
  .dependsOn(`lagom-task-scheduler-stream-api`, `lagom-task-scheduler-api`)
