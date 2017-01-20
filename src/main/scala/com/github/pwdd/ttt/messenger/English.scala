package com.github.pwdd.ttt.messenger

class English extends Messenger {
  val invalidMove = "\nYour choice is not valid. \n"

  val chooseGameType: String =
    "What kind of game would you like to play?\n\n" +
      humanXHuman +
      ". Human vs Human\n" +
      humanXComputer +
      ". Human vs Computer\n" +
      computerXComputer +
      ". Computer vs Computer\n\n" +
      "Please enter the correspondent number: "

  val invalidGameType = "\nThere is no such a game. \n"

  val chooseBoardDimension: String =
    "Choose the dimension of the board:\n\n" +
      "3 x 3\n" +
      "4 x 4\n\n" +
      "Please enter '" + threeByThree +
      "' or '" + fourByFour + "': "

  val invalidBoardDimension = "\nThere is no board with that dimension. \n"

  val draw = "The game tied!\n"

  val invalidComputerLevel = "There is no such computer player\n"

  def computerLevel(first: Boolean): String = {
    val choices =
      easy +
        ". easy\n" +
        hard +
        ". unbeatable\n\n"

    val order = if (first) "First" else "Second"

    order + " computer player can be \n\n" + choices + "Please enter the correspondent number: "
  }

  def chooseANumber(boardLength: Int): String = "Please enter a number from 1 to " + boardLength + ": "

  def currentPlayerIs(player: Symbol): String = "\nCurrent player is '" + player.name + "'"

  def win(winner: Option[Symbol], position: List[Int]): String = {
    val indexToUserFriendlyNumbers = position.map(_ + 1)
    val posToStr = indexToUserFriendlyNumbers.mkString(", ")

    winner match {
      case Some(marker) => "Player '" + marker.name + "' won on positions " + posToStr + "\n"
      case _ => ""
    }
  }

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
