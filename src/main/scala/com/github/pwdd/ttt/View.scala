package com.github.pwdd.ttt

abstract class View {
  def printMessage(message: String): Unit
  def delay(duration: Int): Unit = Thread.sleep(duration)
}
