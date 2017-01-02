package com.github.pwdd.ttt

trait Prompt {
  def view: View
  def prompt(message: String): String

  def getUserChoice(messageAsk: String, messageInvalid: String, validation: (String) => Boolean): String = {

    val userChoice = prompt(messageAsk)

    if (validation(userChoice)) {
      userChoice
    }
    else {
      view.printMessage(messageInvalid)
      getUserChoice(messageAsk, messageInvalid, validation)
    }
  }
}
