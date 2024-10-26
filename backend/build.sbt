val ScalatraVersion = "3.1.0"
val SttpVersion = "3.10.1"

name := "example-app"

version := "0.1.0-SNAPSHOT"

scalaVersion := "3.3.4"

lazy val rootProject = project
  .in(file("."))
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatra" %% "scalatra-jakarta" % ScalatraVersion,
      "org.scalatra"   %% "scalatra-json-jakarta" % ScalatraVersion,
      "jakarta.servlet" % "jakarta.servlet-api"   % "6.0.0" % "provided",
      "org.eclipse.jetty" % "jetty-server" % "11.0.15",
      "org.slf4j" % "slf4j-api" % "2.0.9",
      "ch.qos.logback" % "logback-classic" % "1.4.11",
    )
  )
  .aggregate(openapi)

lazy val openapi = project.in(file("openapi-generated"))
  .enablePlugins(OpenApiGeneratorPlugin)
  .settings(
    openApiInputSpec := "../openapi.yml",
    openApiConfigFile := "openapi-config.yml",
    openApiValidateSpec := SettingDisabled,
    openApiGenerateModelTests := SettingEnabled,
    openApiIgnoreFileOverride := "./openapi-ignore-file",
    libraryDependencies ++= Seq(
      "com.softwaremill.sttp.client3" %% "core" % SttpVersion,
      "com.softwaremill.sttp.client3" %% "json4s" % SttpVersion,
      "org.json4s" %% "json4s-jackson" % "3.6.8",
      ),
  )



