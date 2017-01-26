package com.github.pwdd.tttcore.player.computer

import org.scalatest.FunSuite
import com.github.pwdd.tttcore.{Board, Settings}

class NegamaxSuite extends FunSuite {
  val e: Symbol = Board.emptySpot
  val x: Symbol = Settings.firstPlayer
  val o: Symbol = Settings.secondPlayer
  val negamax = new Negamax

  test("score: returns 0 if game will end in a tie") {
    val board = List(
      o, o, x,
      x, x, e,
      o, o, x)
    assert(negamax.score(board, o, x, 2) === 0)
  }

  test("score: returns 99 if current player will win") {
    val board = List(
      o, o, e,
      x, x, o,
      x, o, x)
    assert(negamax.score(board, o, x, 0) === 99)
  }

  test("score: returns -98 if current player will win") {
    val board = List(
      x, o, x,
      x, x, o,
      e, o, e)
    assert(negamax.score(board, o, x, 0) === -98)
  }
}
