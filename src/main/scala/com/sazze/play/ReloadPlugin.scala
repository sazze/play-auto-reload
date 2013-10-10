package com.sazze.play

import sbt._
import Keys._
import scalaj.http.Http

object ReloadPlugin extends Plugin {

  // TODO: Add Settings

  def loadServer() {
      Http("http://127.0.0.1:9002/").asString
  }

  val compileTask = (compile in Compile, baseDirectory, state) mapR { (a, dir, state) =>
    loadServer()
  }

  val serverReload = TaskKey[Unit]("server-reload")

  val playAssetsDirectories = SettingKey[Seq[File]]("play-assets-directories")

  override lazy val projectSettings = super.projectSettings ++ Seq(
    watchSources <++= playAssetsDirectories map { dirs =>
      for {
        dir <- dirs
        file <- (dir.*** --- dir).get
      } yield file
    },
    watchSources <++= baseDirectory map { path => ((path / "app/assets") ** "*").get },
    ReloadPlugin.serverReload <<= ReloadPlugin.compileTask.triggeredBy(compile in Compile)
  )
}