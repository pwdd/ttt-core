package com.github.pwdd.ttt.messenger

import org.scalatest.FunSuite
import com.github.pwdd.ttt.Board

class MessengerSuite extends FunSuite {
  val x: Symbol = Board.firstPlayer
  val o: Symbol = Board.secondPlayer
  val e: Symbol = Board.emptySpot

  val messenger = new English

  test("printBoard: returns a string version of a 3x3 board") {
    val separator = "\n---|---|---\n"
    assert(messenger.strBoard(List(
      x, o, x,
      o, x, o,
      x, o, x))  ===

      "\n" +
        " x | o | x " +
        separator +
        " o | x | o " +
        separator +
        " x | o | x " +
        "\n")
  }

  test("printBoard: returns a string version of a 4x4 board") {
    val separator = "\n---|---|---|---\n"
    assert(messenger.strBoard(List(
      x, o, x, o,
      x, o, x, o,
      o, x, o, x,
      o, x, o, x
    )) ===

      "\n" +
        " x | o | x | o " +
        separator +
        " x | o | x | o " +
        separator +
        " o | x | o | x " +
        separator +
        " o | x | o | x " +
        "\n"
    )
  }
}
