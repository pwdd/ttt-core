name := "ttt"

version := "0.0.1"

isSnapshot := false

publishMavenStyle := true

scalaVersion := "2.12.1"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test"

publishMavenStyle := true

publishArtifact in Test := false

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

pomIncludeRepository := { _ => false }

sonatypeProfileName := "pwdd"

pomExtra in Global := (
  <url>https://github.com/pwdd/ttt</url>
    <licenses>
      <license>
        <name>MIT License</name>
        <url>https://opensource.org/licenses/mit-license.php</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:pwdd/ttt.git</url>
      <connection>scm:git@github.com:pwdd/ttt.git</connection>
    </scm>
    <developers>
      <developer>
        <id>pwdd</id>
        <name>pwdd</name>
        <url>https://github.com/pwdd</url>
      </developer>
    </developers>)