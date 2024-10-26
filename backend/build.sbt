val ScalatraVersion = "3.1.0"

organization := "com.example"

name := "example-app"

version := "0.1.0-SNAPSHOT"

scalaVersion := "3.3.4"

libraryDependencies ++= Seq(
  "org.scalatra" %% "scalatra-jakarta" % ScalatraVersion,
  "org.scalatra"   %% "scalatra-json-jakarta" % ScalatraVersion,
  "jakarta.servlet" % "jakarta.servlet-api"   % "6.0.0" % "provided",
  "org.eclipse.jetty" % "jetty-server" % "11.0.15",
  "org.slf4j" % "slf4j-api" % "2.0.9",
  "ch.qos.logback" % "logback-classic" % "1.4.11"
) 
