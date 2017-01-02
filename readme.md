# Tic Tac Toe &mdash; readme

About the [game and how to play](https://en.wikipedia.org/wiki/Tic-tac-toe)

## About this library:

  First player is `x` and second, `o`

  ### Options:
  
  #### Board
  
  The board is represented as a `List[Symbol]`. A valid move is an index available in that list.
  
  The game can be played in a 3x3 or a 4x4 board
  
  #### Players
  
  It can be played by an user against another user or against the computer (see [levels of difficult](#levels-of-difficulty)).
  
  The game can also be played by computer against computer.
  
  ### Levels of difficulty:
  
  #### Easy
  
  `getSpot` returns a random but valid (a spot that is not taken and is within the range of the board dimension) integer
  
  #### Hard (unbeatable)
  
  It uses [Negamax with Alpha Beta Pruning](https://en.wikipedia.org/wiki/Negamax#Negamax_with_alpha_beta_pruning) to generate the best position for the computer player
  

## Asking for input

It is necessary to extend the trait `Prompt`, implement the method `prompt` and define a `View` object. 

As an example, if the game is going to be played in the console, `prompt` could be: 

```scala
import com.github.pwdd.ttt.{Prompt, View}
import scala.io.StdIn.readLine

object MyPrompt extends Prompt {
  def view: View = ???
  def prompt(message: String): String = readLine("Enter a number: ")
}
```

### Valid input

  `User` `getSpot` accepts numbers from 1 to 9, so that the board positions can be represented in a user friendly way, instead of using the index from 0

## Displaying the game

Implement the `View` trait. It has to methods, both returning `Unit`:

- `printMessage(message: String)`, to output the messages and the board
- `delay(duration: Int)`. This method takes the `duration` in miliseconds and is used when the game is computer x computer, so that there is a delay time between moves. The default is set to 0 ms.

Example: displaying the game in the console

```scala
import com.github.pwdd.ttt.View

object MyView extends View {
  def printMessage(message: String): Unit  = print(message)
  def delay(duration: Int): Unit = Thread.sleep(1000)
}
```

## Adding messages and translations

The default messages are in English, but it is possible to add new ones or translate the original messages by extending `Messenger`.

It uses the `Validation` object in order to ask for valid inputs.
