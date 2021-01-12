import sbt._


object Dependencies {

  object Versions {
    val zio         = "1.0.3"
    val refined     = "0.9.17"
  }

  val zio         = "dev.zio"       %% "zio"              % Versions.zio
  val allZioCore = Seq(zio)

  val zioTest         = "dev.zio" %% "zio-test"        % Versions.zio
  val zioTestSbt      = "dev.zio" %% "zio-test-sbt"    % Versions.zio % Test
  val allZioTest = Seq(zioTest, zioTestSbt)

  val refinedCore = "eu.timepit" %% "refined"      % Versions.refined
  val allRefined  = Seq(refinedCore)
}

