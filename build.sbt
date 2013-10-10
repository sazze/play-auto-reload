name := "play-auto-reload"

organization := "com.sazze"

scalaVersion := "2.9.2"

version := "0.0.1-SNAPSHOT"

sbtPlugin := true

libraryDependencies ++= Seq("org.scalaj" %% "scalaj-http" % "0.3.10")

libraryDependencies ++= Seq("net.databinder" %% "unfiltered-netty-websockets" % "0.6.8")


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
      <id>ksmithson</id>
      <name>Kevin Smithson</name>
      <email>ksmithson@sazze.com</email>
    </developer>
  </developers>
)