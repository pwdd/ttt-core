package com.github.pwdd.ttt

import com.github.pwdd.ttt.messenger.Messenger

class Game(val messenger: Messenger, val prompt: Prompt, val view: View) {
  private val validation = Validation
  private val isFirst = true
  private val firstPlayer = Board.firstPlayer
  private val secondPlayer = Board.secondPlayer

  def play(waitTime: Int = 0): Unit = {
    val gameLoop = new Loop(messenger, view)
    val gameType = prompt.getUserChoice(messenger.chooseGameType, messenger.invalidGameType, validation.isValidGameType)

    val game = new Loop(messenger, view)

    def defineComputer(marker: Symbol, isFirst: Boolean) = {
      val easy = validation.validComputerTypes('easy)
      val choice = prompt.getUserChoice(
      messenger.computerLevel(isFirst),
      messenger.invalidComputerLevel,
      validation.isValidComputerType)
      if (choice == easy) player.computer.EasyComputer(marker)
      else player.computer.HardComputer(marker)
  }

    def getOpponent: player.Player = {
      val humanXHuman = validation.validGameTypes('humanXHuman)
      gameType match {
        case bothHuman if gameType == humanXHuman => player.User(secondPlayer, messenger, view, prompt)
        case _ => defineComputer(secondPlayer, !isFirst)
      }
    }

    def getFirstPlayer: player.Player = gameType match {
      case cxc if gameType == validation.validGameTypes('computerXComputer) => defineComputer(firstPlayer, isFirst)
      case _ => player.User(firstPlayer, messenger, view, prompt)
    }

    val currentPlayer = getFirstPlayer

    val opponent = getOpponent

    val boardDimension = prompt.getUserChoice(
      messenger.chooseBoardDimension,
      messenger.invalidBoardDimension,
      Validation.isValidBoardDimension)

    val board = Board.newBoard(Board.length(boardDimension.toInt))

    view.printMessage(messenger.currentPlayerIs(firstPlayer))
    view.printMessage(messenger.strBoard(board))

    game.gameLoop(board, currentPlayer, opponent, messenger, waitTime)
  }
}
