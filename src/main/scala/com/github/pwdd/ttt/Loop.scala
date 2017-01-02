package com.github.pwdd.ttt

import com.github.pwdd.ttt.messenger._
import com.github.pwdd.ttt.player._

class Loop(val messenger: Messenger, val view: View) {
  def gameLoop(board: List[Symbol],
               currentPlayer: Player,
               opponent: Player,
               messenger: Messenger,
               waitTime: Int = 0): Unit = {

    val spot = currentPlayer.getSpot(board)
    val newBoard = Board.move(board, currentPlayer.marker, spot)

    def delay() = if (isComputerXComputer(currentPlayer, opponent)) view.delay(waitTime)

    def finalMsg(board: List[Symbol]): Unit = board match {
      case b if EvalGame.isDraw(b) => view.printMessage(messenger.draw)
      case _ => view.printMessage(messenger.win(EvalGame.winnerMarker(board), EvalGame.winCombo(board)))
    }

    if (EvalGame.gameOver(newBoard)) {
      delay()
      view.printMessage(messenger.strBoard(newBoard))
      finalMsg(newBoard)
    } else {
      delay()
      view.printMessage(messenger.currentPlayerIs(opponent.marker))
      view.printMessage(messenger.strBoard(newBoard))
      gameLoop(newBoard, opponent, currentPlayer, messenger, waitTime)
    }
  }

  private def isComputerXComputer(firstPlayer: Player, secondPlayer: Player): Boolean = {
    firstPlayer.isAI && secondPlayer.isAI
  }
}
