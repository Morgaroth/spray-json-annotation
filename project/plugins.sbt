resolvers += Classpaths.sbtPluginReleases

resolvers ++= Seq(
  "Sonatype OSS Releases" at "http://oss.sonatype.org/content/repositories/releases/"
)

addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.0.1")

addSbtPlugin("org.scoverage" % "sbt-coveralls" % "1.0.0.BETA1")

addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "0.2.1")

addSbtPlugin("com.jsuereth" % "sbt-pgp" % "1.0.0")

addSbtPlugin("io.github.morgaroth" % "sbt-sonatype-utils" % "0.2")