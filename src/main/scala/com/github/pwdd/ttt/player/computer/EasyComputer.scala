package com.github.pwdd.ttt.player.computer

import scala.util.Random
import com.github.pwdd.ttt.Board

class EasyComputer(val marker: Symbol) extends com.github.pwdd.ttt.player.Player {
  val isAI = true

  def getSpot(board: List[Symbol]): Int = {
    val spots = Board.availableSpots(board)
    Random.shuffle(spots).head
  }
}
