val ScalatraVersion = "2.8.2"

ThisBuild / scalaVersion := "2.13.9"
ThisBuild / organization := "com.gaguena"

lazy val hello = (project in file("."))
  .settings(
    name := "sproducts",
    version := "0.1.0-SNAPSHOT",
    libraryDependencies ++= Seq(
      "org.scalatra" %% "scalatra" % ScalatraVersion,
      "org.scalatra" %% "scalatra-scalatest" % ScalatraVersion % "test",
      "ch.qos.logback" % "logback-classic" % "1.2.3" % "runtime",
      "org.eclipse.jetty" % "jetty-webapp" % "9.4.43.v20210629" % "container",
      "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
      "org.scalatra" %% "scalatra-json" % "2.8.2",
      "org.json4s" %% "json4s-jackson" % "4.0.1",
      "com.typesafe.slick" %% "slick" % "3.3.2",
      "com.typesafe.slick" %% "slick-hikaricp" % "3.3.2",
      "com.mchange" % "c3p0" % "0.9.5.2",
      "org.postgresql" % "postgresql" % "42.5.1"
    ),
  )

enablePlugins(JettyPlugin)
