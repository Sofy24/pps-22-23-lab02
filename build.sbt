scalaVersion := "3.2.2"

lazy val root = (project in file ("."))
  .settings(
      name := "pps-code-a",
        libraryDependencies += "com.github.sbt" % "junit-interface" % "0.13.2" % Test
  )