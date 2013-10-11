name := "play-auto-reload"

organization := "com.sazze"

scalaVersion := "2.9.2"

version := "0.0.1-SNAPSHOT"

sbtPlugin := true

libraryDependencies ++= Seq("org.scalaj" %% "scalaj-http" % "0.3.10")

logLevel := Level.Debug

publishTo <<= (version) { version: String =>
   val scalasbt = "http://repo.scala-sbt.org/scalasbt/"
   val (name, url) = if (version.contains("-SNAPSHOT"))
     ("sbt-plugin-snapshots", scalasbt+"sbt-plugin-snapshots")
   else
     ("sbt-plugin-releases", scalasbt+"sbt-plugin-releases")
   Some(Resolver.url(name, new URL(url))(Resolver.ivyStylePatterns))
}

publishMavenStyle := false

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <url>http://github.com/sazze/play-auto-reload</url>
  <licenses>
    <license>
      <name>MIT License"</name>
      <url>http://opensource.org/licenses/MIT</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:sazze/play-auto-reload.git</url>
    <connection>scm:git:git@github.com:sazze/play-auto-reload.git</connection>
    <developerConnection>scm:git:https://github.com/webjars/webjars-play.git</developerConnection>
  </scm>
  <developers>
    <developer>
      <id>smitt04</id>
      <name>Kevin Smithson</name>
      <email>ksmithson@sazze.com</email>
    </developer>
  </developers>
)