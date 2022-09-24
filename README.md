# Chessington

A chess exercise.

Copyright © 2017 Softwire - All Rights Reserved

## Requirements

JDK from Bellsoft Liberica 17.x, which comes with JavaFX library.

## Objective

Exercise coding with tests. Write code that passes a test, write tests that are missing, refactor, repeat. 

## Implement functionality

Go through the tests and fix the ones that are failing by implementing the missing functionality.

1. Identify a failing test.
2. Identify the functionality (usually a _method_ that is failing) under test.
3. Go to that method and write code with the missing functionality.

## Code organisation

The code is organised in the following way:


In package `training.chessington.model.pieces`:

- `public final class Move`
  - Represents a movement for a piece.
  - This class has two properties:
    - Coordinates from;
    - Coordinates to;
    - The idea is to create a move by providing these 2 coordinates.
- `public final class Coordinates`
  - (Row,Column) coordinates on the board. The origin of the board (0,0) is at the top left. 
- `interface Piece`
  - Every piece in the game implements this interface. The interface has `enum PieceType`.
- `abstract class AbstractPiece`
  - Abstract class that implements `Piece` interface.
  - It is extended by classes `Bishop`,`King`,`Knight`,`Pawn`,`Queen`,`Rook`
- `Board`
  - Class that represents a board. 
- `final class Coordinates`
  - Represents a position in the board. 
  - Constructor `Coordinates(int row, int column)`
  - method `public Coordinates plus(int rowDiff, int colDiff)`
    - Returns a new Coordinates object adding `rowDiff` to this row and `colDiff` to this column.
    - Note that `rowDiff` and `colDiff` can be negative, decreasing row or column respectively.
- `class Game`
- `public final class Move`
  - Represents a movement in the board from one `Coordinates` to another. 
- `enum PlayerColour`
  - `WHITE` or `BLACK`

## Task implement `getAllowedMoves`

From `git cherry-pick red-1` we receive some new tests. The tests below are correct, they are expecting (correctly) the game to behave in a certain way, but the game isn't finished. So, the tests are failing. The tests are:

- In class PawnTest:
  - `whitePawnCanMoveUpOneSquare`
  - `blackPawnCanMoveDownOneSquare`

Looking at `whitePawnCanMoveUpOneSquare` one can see that`getAllowedMoves` has a problem. It is failing to return the expected `List<Move>` object. In fact, the method is empty and needs implementation. The same applies to `blackPawnCanMoveDownOneSquare`.

Continuing implementing `getAllowedMoves` method using tests from `git cherry-pick red-2` up to `git cherry-pick red-2`.

