package com.github.pwdd.tttcore

object Board {
  val emptySpot = '_

  def size(board: List[Any]): Int = Math.sqrt(board.length).toInt

  def length(size: Int): Int = size * size

  def indexes(length: Int): List[Int] = (0 until length).toList

  def rows(boardIndexes: List[Int], size: Int): List[List[Int]] = boardIndexes.grouped(size).toList

  def columns(rows: List[List[Int]]): List[List[Int]] = rows.transpose

  def diagonals(rows: List[List[Int]], size: Int): List[List[Int]] = {
    val forward = (0 until size).toList
    val backward = forward.reverse

    def makeDiagonal(indexes: List[Int]): List[Int] = {
      indexes.zipWithIndex.map{ case(el, i) => rows(i)(el) }
    }

    List(makeDiagonal(forward), makeDiagonal(backward))
  }

  def center(length: Int): Int = {
    val center = length / 2
    if (length % 2 != 0) center
    else center - 2
  }

  def newBoard(length: Int): List[Symbol] = List.fill(length)(emptySpot)

  def move(board: List[Symbol], marker: Symbol, spot: Int): List[Symbol] = {
    board.updated(spot, marker)
  }

  def isFull(board: List[Symbol]): Boolean = !board.contains(emptySpot)

  def isEmpty(board: List[Symbol]): Boolean = board == newBoard(board.length)

  def isSpotAvailable(board: List[Symbol], spot: Int): Boolean = board(spot) == emptySpot

  def availableSpots(board: List[Symbol]): List[Int] = {
    board.zipWithIndex.collect{ case(e, i) if e == emptySpot => i }
  }
}