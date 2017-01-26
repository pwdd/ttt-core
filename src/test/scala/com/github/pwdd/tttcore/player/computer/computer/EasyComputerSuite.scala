package com.github.pwdd.tttcore.player.computer

import org.scalatest.FunSuite
import com.github.pwdd.tttcore.{Board, Settings}

class EasyComputerSuite extends FunSuite {
  private val x = Settings.firstPlayer
  private val e = Board.emptySpot
  private val computer = new EasyComputer(x)

  test("getSpot: returns an index of an available spot") {
    val board = Board.newBoard(9)
    assert(Board.availableSpots(board) contains computer.getSpot(board))
  }

  test("getSpot: returns an index of an available spot in a board with some spots taken") {
    val board = List(
      x, e, e,
      e, e, e,
      e, e, e)
    val spots = Board.availableSpots(board)
    val spot = computer.getSpot(board)
    assert(spots contains spot)
    assert(spot !== 0)
  }
}
