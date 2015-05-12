name := "spray-json-annotation"

organization := "io.github.morgaroth"

version := "0.4.2"

scalaVersion := "2.11.6"

crossScalaVersions := Seq("2.10.5", "2.11.6")

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"
)

libraryDependencies <+= (scalaVersion)("org.scala-lang" % "scala-reflect" % _)

libraryDependencies ++= (
  if (scalaVersion.value.startsWith("2.10")) List("org.scalamacros" %% "quasiquotes" % "2.0.1")
  else Nil
)

libraryDependencies ++= Seq(
  "io.spray" %% "spray-json" % "1.3.2" % Test,
  "org.specs2" %% "specs2" % "2.3.13" % Test
)

unmanagedSourceDirectories in Compile <+= (sourceDirectory in Compile, scalaBinaryVersion){
  (sourceDir, version) => sourceDir / (if (version.startsWith("2.10")) "scala_2.10" else "scala_2.11")
}

addCompilerPlugin("org.scalamacros" % "paradise" % "2.0.1" cross CrossVersion.full)

scalacOptions := Seq(
  "-encoding", "utf8",
  "-feature",
  "-unchecked",
  "-deprecation",
  "-target:jvm-1.6",
  "-language:_",
  "-Ywarn-dead-code",
  "-Xlog-reflective-calls"
)

// publishing:

sonatypeSettings

publishArtifact in Test := false

pomExtra := githubPom(name.value,"Mateusz Jaje","Morgaroth")

publishTo := publishRepoForVersion(version.value)

// Do not include log4jdbc as a dependency.
pomPostProcess := PackagingHelpers.removeTestOrSourceDependencies