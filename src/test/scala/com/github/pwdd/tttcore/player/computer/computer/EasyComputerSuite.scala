package com.github.pwdd.tttcore.player.computer

import org.scalatest.FunSuite

import com.github.pwdd.tttcore.Board

class EasyComputerSuite extends FunSuite {
  val x = Board.firstPlayer
  val e = Board.emptySpot
  val computer = new EasyComputer(x)

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