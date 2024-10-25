val ScalatraVersion = "3.1.0"

organization := "com.example"

name := "example-app"

version := "0.1.0-SNAPSHOT"

scalaVersion := "3.3.4"

libraryDependencies ++= Seq(
  "org.scalatra" %% "scalatra" % ScalatraVersion,
  "org.scalatra" %% "scalatra-swagger" % ScalatraVersion,
  "org.scalatra" %% "scalatra-jakarta" % ScalatraVersion,
  "org.scalatra"   %% "scalatra-json-jakarta" % ScalatraVersion,
  "jakarta.servlet" % "jakarta.servlet-api"   % "6.0.0" % "provided"
) 

enablePlugins(JettyPlugin)
