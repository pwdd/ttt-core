package com.github.pwdd.ttt.messenger

abstract class Messenger {
  val invalidMove: String
  val chooseGameType: String
  val invalidGameType: String
  val chooseBoardDimension: String
  val invalidBoardDimension: String
  val draw: String
  val invalidComputerLevel: String

  val validation = com.github.pwdd.ttt.Validation

  val humanXHuman: String = validation.validGameTypes('humanXHuman)
  val humanXComputer: String = validation.validGameTypes('humanXComputer)
  val computerXComputer: String = validation.validGameTypes('computerXComputer)

  val threeByThree: String = validation.validBoardDimensions('threeByThree)
  val fourByFour: String = validation.validBoardDimensions('fourByFour)

  val english: String = validation.validLanguages('english)
  val spanish: String = validation.validLanguages('spanish)
  val portuguese: String = validation.validLanguages('portuguese)

  val easy: String = validation.validComputerTypes('easy)
  val hard: String = validation.validComputerTypes('hard)

  val boardSize = com.github.pwdd.ttt.Board.size _

  def computerLevel(first: Boolean): String

  def chooseANumber(boardLength: Int): String

  def currentPlayerIs(player: Symbol): String

  def win(winner: Option[Symbol], position: List[Int]): String

  def strBoard(board: List[Symbol]): String = {
    val pipe = "|"
    val dashes = "---"
    val separator = "\n" + List.fill(boardSize(board))(dashes).mkString(pipe) + "\n"

    def symbolToStr(marker: Symbol): String = {
      if (marker == com.github.pwdd.ttt.Board.emptySpot) "   "
      else " " + marker.name + " "
    }

    def buildStrBoard(board: List[String]): Any = {
      val breakLines = board.grouped(boardSize(board)).toList.map(_.mkString(pipe))
      breakLines.mkString(separator)
    }

    "\n" + buildStrBoard(board.map(symbolToStr)).toString + "\n"
  }
}