package com.github.pwdd.tttcore.player.computer

import com.github.pwdd.tttcore.EvalGame
import com.github.pwdd.tttcore.Board

case class HardComputer(marker: Symbol) extends com.github.pwdd.tttcore.player.Player {
  val isAI = true

  def getSpot(board: List[Symbol]): Int = {
    val currentPlayerMarker = EvalGame.currentPlayerMarker(board)
    val opponentMarker = EvalGame.opponentMarker(currentPlayerMarker)
    val depth = 0

    if (Board.isEmpty(board)) {
      Board.center(board.length)
    } else {
      search(board, currentPlayerMarker, opponentMarker, depth)
    }
  }

  private def search(board: List[Symbol], currentPlayerMarker: Symbol, opponentMarker: Symbol, depth: Int) = {
    val search = new Negamax
    search.score(board, currentPlayerMarker, opponentMarker, depth)
    search.bestMove
  }
}
