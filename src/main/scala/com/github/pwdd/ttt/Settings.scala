package com.github.pwdd.ttt

import com.github.pwdd.ttt.messenger.Messenger
import com.github.pwdd.ttt.player.Player

trait Settings {
  def messenger: Messenger
  def validation = Validation
  def gameType(): String
  def defineComputerLevel(marker: Symbol, first: Boolean): Player
  def getOpponentType(gameType: String): Player
  def getFirstPlayer(gameType: String): Player
  def getBoardDimension: Int
}
