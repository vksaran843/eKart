name := "eKart"

version := "0.1"

resolvers+=Resolver.mavenLocal

EclipseKeys.preTasks := Seq(compile in Compile)
EclipseKeys.projectFlavor:= EclipseProjectFlavor.Java
EclipseKeys.createSrc := EclipseCreateSrc.ValueSet(EclipseCreateSrc.ManagedClasses,EclipseCreateSrc.ManagedResources)



lazy val commonSettings = Seq(
	version :="2.6.0",
	autoScalaLibrary:=false,
	scalaVersion:="2.12.3",
	
	libraryDependencies ++=Seq(
	ws,
	guice,
	javaCore,
	evolutions,
	javaJdbc,
	javaJpa,
	javaWs,
	"com.h2database" % "h2" % "1.4.196"
	
	)
)

lazy val root = (project in file(".")).
		settings(commonSettings: _*).
		enablePlugins(PlayJava,PlayEbean)
		enablePlugins(JavaAppPackaging)
		enablePlugins(UniversalPlugin)
		enablePlugins(JavaServerAppPackaging)

