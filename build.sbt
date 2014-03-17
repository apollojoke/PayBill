name := "PayBill"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "org.json" % "json" % "20140107"
)
//libraryDependencies += "org.json" % "json" % "20140107"

play.Project.playJavaSettings
