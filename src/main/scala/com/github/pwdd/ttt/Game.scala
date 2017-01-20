package com.github.pwdd.ttt

class Game(val settings: Settings, val view: View) {
  private val firstPlayer = Board.firstPlayer

  def play(waitTime: Int = 0): Unit = {
    val game = new Loop(settings.messenger, view)

    val gameType = settings.gameType()

    val currentPlayer = settings.getFirstPlayer(gameType)

    val opponent = settings.getOpponentType(gameType)

    val boardDimension = settings.getBoardDimension

    val board = Board.newBoard(Board.length(boardDimension))

    view.printMessage(settings.messenger.currentPlayerIs(firstPlayer))
    view.printMessage(settings.messenger.strBoard(board))

    game.gameLoop(board, currentPlayer, opponent, settings.messenger, waitTime)
  }
}
