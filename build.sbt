name := """sigacad"""
organization := "ues"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.11"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  "org.postgresql" % "postgresql" % "9.4.1212"
)



lazy val myProject = (project in file("."))
  .enablePlugins(PlayJava, PlayEbean)