package com.github.pwdd.ttt

trait View {
  def printMessage(message: String): Unit
  def delay(duration: Int): Unit
}
