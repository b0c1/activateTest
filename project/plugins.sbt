logLevel := Level.Warn

scalacOptions ++= Seq("-unchecked", "-deprecation")

resolvers ++= Seq(
  "public" at "http://repo1.maven.org/maven2/",
  "less is" at "http://repo.lessis.me",
  "coda" at "http://repo.codahale.com",
  "typesafe" at "http://repo.typesafe.com/typesafe/repo/",
  "Sonatype releases" at "https://oss.sonatype.org/content/repositories/releases/",
  "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/",
  "Web plugin repo" at "http://siasia.github.com/maven2",
  "scct-github-repository" at "http://mtkopone.github.com/scct/maven-repo"
)

addSbtPlugin("de.johoop" % "jacoco4sbt" % "2.1.4")

addSbtPlugin("me.lessis" % "ls-sbt" % "0.1.2")

addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.3.2")

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.5.2")

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.2.0")

addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.7.4")

addSbtPlugin("com.earldouglas" % "xsbt-web-plugin" % "0.7.0")

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.11.1")

addSbtPlugin("com.sksamuel.scoverage" %% "sbt-scoverage" % "0.95.7")


