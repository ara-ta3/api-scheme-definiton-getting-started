val ScalatraVersion = "3.1.0"
val SttpVersion = "3.10.1"

name := "example-app"

version := "0.1.0"

scalaVersion := "2.13.15"


lazy val rootProject = project
  .in(file("."))
  .settings(
    libraryDependencies ++= Seq(
      "org.scalatra" %% "scalatra-jakarta" % ScalatraVersion,
      "org.scalatra"   %% "scalatra-json-jakarta" % ScalatraVersion,
      "jakarta.servlet" % "jakarta.servlet-api"   % "6.0.0" % "provided",
      "org.json4s" %% "json4s-jackson" % "4.0.6",
      "org.eclipse.jetty" % "jetty-server" % "11.0.15",
      "org.slf4j" % "slf4j-api" % "2.0.9",
      "ch.qos.logback" % "logback-classic" % "1.4.11",

    ),
    excludeDependencies ++= Seq(
      "openapi" % "openapi_3",
      "openapi" % "openapi_2.13"
    )
  )
  .dependsOn(openapi)

lazy val openapi = project.in(file("openapi-generated"))
  .enablePlugins(OpenApiGeneratorPlugin)
  .settings(
    openApiGeneratorName := "scalatra",
    openApiOutputDir := "openapi-generated",
    openApiInputSpec := "../openapi.yml",
    openApiModelPackage := "com.example.api.model",
    openApiValidateSpec := SettingDisabled,
    openApiGenerateModelTests := SettingEnabled,
    openApiIgnoreFileOverride := "./openapi-ignore-file",
  )



