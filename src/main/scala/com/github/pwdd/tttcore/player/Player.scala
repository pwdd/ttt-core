package com.github.pwdd.tttcore.player

abstract class Player {
  val marker: Symbol
  val isAI: Boolean

  def getSpot(board: List[Symbol]): Int
}
