import Dependencies._

lazy val commonSettings = inThisBuild(
    Seq(
      scalaVersion := "2.13.1",
      scalacOptions += "-Ymacro-annotations",
      addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.10.3"),
      addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1")
    )
)

lazy val root = project
  .in(file("."))
  .settings(commonSettings)
  .settings(
    name := "zio-test-refined",
    organization := "io.tuliplogic",
    scalaVersion := "2.13.1",
    libraryDependencies ++= (allZioCore ++ allZioTest),
    testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")

  )
