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
  "ch.qos.logback" % "logback-classic" % "1.4.11",

  "com.softwaremill.sttp.client3" %% "core" % "3.8.0",
  "com.softwaremill.sttp.client3" %% "circe" % "3.8.0",
  "io.circe" %% "circe-generic" % "0.14.3"
) 

lazy val generated = project.in(file("generated"))
  .enablePlugins(OpenApiGeneratorPlugin)
  .settings(
    openApiInputSpec := "../openapi.yml",
    openApiConfigFile := "openapi-config.yml",
    openApiValidateSpec := SettingDisabled,
    openApiGenerateModelTests := SettingEnabled,
    openApiIgnoreFileOverride := s"${baseDirectory.in(ThisBuild).value.getPath}/openapi-ignore-file",
  )



