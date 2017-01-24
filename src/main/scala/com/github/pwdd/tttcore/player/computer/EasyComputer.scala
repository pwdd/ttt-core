package com.github.pwdd.tttcore.player.computer

import scala.util.Random
import com.github.pwdd.tttcore.Board

case class EasyComputer(marker: Symbol) extends com.github.pwdd.tttcore.player.Player {
  val isAI = true

  def getSpot(board: List[Symbol]): Int = {
    val spots = Board.availableSpots(board)
    Random.shuffle(spots).head
  }
}
