package com.github.pwdd.ttt.player

import com.github.pwdd.ttt.messenger.Messenger
import com.github.pwdd.ttt.{Prompt, Validation, View}

case class User(marker: Symbol, messenger: Messenger, view: View, prompt: Prompt) extends Player {
  val isAI = false

  def getSpot(board: List[Symbol]): Int = {
    val invalidMessage = messenger.invalidMove

    val input = prompt.getUserChoice(messenger.chooseANumber(board.length), invalidMessage, isNumericString)

    def inputToNumber: Int = input.toInt - 1

    if (Validation.isValidMove(board, inputToNumber)) {
      inputToNumber
    }
    else {
      view.printMessage(invalidMessage)
      getSpot(board)
    }
  }

  private def isNumericString(input: String): Boolean = {

    def isNumber: Boolean = input.matches("^\\d*$")

    def isEmptyStr: Boolean = input == ""

    !isEmptyStr && isNumber
  }
}