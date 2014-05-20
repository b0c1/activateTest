name := "activateTest"

resolvers ++= Seq(
  "Activate repository" at "http://fwbrasil.net/maven",
  Opts.resolver.sonatypeSnapshots,
  Opts.resolver.sonatypeReleases,
  "Clojars Repository" at "http://clojars.org/repo",
  "Conjars Repository" at "http://conjars.org/repo"
)

libraryDependencies ++= Seq(
  "net.fwbrasil" %% "activate-jdbc-async" % "1.5-SNAPSHOT" exclude("log4j", "log4j"),
  "junit" % "junit" % "4.11",
  "org.scalatest" %% "scalatest" % "2.1.0",
  "com.h2database" % "h2" % "1.3.175"
)

version := "1.0"
    