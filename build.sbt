enablePlugins(JavaServerAppPackaging)

organization  := "com.example"

version       := "0.1"

scalaVersion  := "2.11.7"
val Json4sVersion = "3.2.11"
resolvers ++= Seq("Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
                  "Spray Repository"    at "http://repo.spray.io")

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  
  val akkaV = "2.4.0"
  val akka_httpV = "2.0-M2"
  val sprayV = "1.3.3"
  
  Seq(
    "com.typesafe.akka"   %% "akka-actor"    	        % akkaV,
    "com.typesafe.akka"   %% "akka-stream-experimental" % akka_httpV,
    "com.typesafe.akka"   %% "akka-http-experimental"   % akka_httpV,
    "com.typesafe.akka"   %% "akka-http-spray-json-experimental" % akka_httpV,
    "com.typesafe.akka"   %% "akka-http-core-experimental" % akka_httpV,
    "com.typesafe.akka"   %% "akka-http-testkit-experimental" % akka_httpV,
    "com.typesafe.akka"   %% "akka-slf4j"      % akkaV,
    "ch.qos.logback"      %  "logback-classic" % "1.1.2",
    "com.typesafe.akka"   %%  "akka-testkit"   % akkaV   % "test",
    "org.specs2"          %%  "specs2-core"    % "3.6.6" % "test"
  )
}

Revolver.settings

mainClass in Global := Some("com.example.Main")

jarName in assembly := "ex.jar"