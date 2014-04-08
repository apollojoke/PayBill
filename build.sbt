name := "PayBill"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "org.json" % "json" % "20140107",
  "org.mongodb" % "mongo-java-driver" % "2.12.0-rc3",
  "net.vz.mongodb.jackson" %% "play-mongo-jackson-mapper" % "1.1.0"
)

//libraryDependencies += "org.json" % "json" % "20140107"

play.Project.playJavaSettings
