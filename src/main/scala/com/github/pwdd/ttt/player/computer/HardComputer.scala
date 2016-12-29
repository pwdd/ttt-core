package com.github.pwdd.ttt.player.computer

import com.github.pwdd.ttt.EvalGame
import com.github.pwdd.ttt.Board

class HardComputer(val marker: Symbol) extends com.github.pwdd.ttt.player.Player {
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
